package project.restapichat.global.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.global.util.Ut;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    /**
     * 시크릿 키 가져오기
     */
    @Value("${custom.jwt.secretKey}")
    private String secretKeyOrigin;

    @Value("${custom.accessToken.expirationSeconds}")
    private int expirationSeconds;

    /**
     * 중복 사용 하기 위해 선언
     */
    private SecretKey cachedSecretKey;

    /**
     * 없다면 생성, 있다면 그대로
     * @return
     */
    public SecretKey getSecretKey() {
        if(cachedSecretKey == null) {
            cachedSecretKey = cachedSecretKey = _getSecretKey();
        }
        return cachedSecretKey;
    }

    /**
     * 시크릿 키 가공
     * 키 가져오기 메서드
     * @return
     */
    private SecretKey _getSecretKey() {
        String keyBase64Encoded = Base64.getEncoder().encodeToString(secretKeyOrigin.getBytes());
        return Keys.hmacShaKeyFor(keyBase64Encoded.getBytes());
    }

    /**
     * 중복 로직 분리
     * 어쎄스랑 리프레쉬
     */
    public String genToken(Member member, int seconds) {
        // 토큰 형태를 맵 형식으로 받는다.
        Map<String, Object> claims = new HashMap<>();

        // 맵에 값을 넣기
        claims.put("id", member.getId());
        claims.put("username", member.getUsername());

        // 토큰 시간 설정
        long now = new Date().getTime();
        Date accessTokenExpiresIn = new Date(now + 1000L * seconds);

        // 빌더
        return Jwts.builder()
                .claim("body", Ut.json.toStr(claims))
                .setExpiration(accessTokenExpiresIn)
                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    /**
     * Access 토큰 생성
     */
    public String genAccessToken(Member member){
        return genToken(member, expirationSeconds);

    }


    /**
     * Refresh 토큰 생성
     * @return
     */
    public String genRefreshToken(Member member){
        return genToken(member, 60*60*24*365*1);

    }

    // 클레임 정보 받아오기
    public Map<String, Object> getClaims(String token) {
        String body = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("body", String.class);
        return Ut.toMap(body);
    }

}
