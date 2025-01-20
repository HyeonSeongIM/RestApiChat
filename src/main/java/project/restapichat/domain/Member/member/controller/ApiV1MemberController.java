package project.restapichat.domain.Member.member.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.restapichat.domain.Member.member.dto.request.MemberRequest;
import project.restapichat.domain.Member.member.dto.response.MemberResponse;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.Member.member.service.MemberService;
import project.restapichat.global.jwt.JwtProvider;
import project.restapichat.global.rsData.RsData;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class ApiV1MemberController {
    private final MemberService memberService;
    private final JwtProvider jwtProvider;

    @PostMapping("/signup")
    public RsData<String> signup(@Valid @RequestBody MemberRequest memberRequest) {
        Member member = memberService.signUp(memberRequest.getUsername(), memberRequest.getPassword());
        return RsData.of("200", "회원가입에 성공하였습니다.", member.getUsername());
    }

    /**
     * httpservlet 안에 객체가 다양한데 쿠키를 제어하는 객체가 존재함
     * 그래서 쿠키 안에 토큰을 넣어서 전달 가능
     * @param memberRequest
     * @param response
     * @return
     */
    @PostMapping("/login")
    public RsData<String> login(@Valid @RequestBody MemberRequest memberRequest,
                                HttpServletResponse response) {
        Member member = memberService.getMember(memberRequest.getUsername());

        // 토큰 생성
        String token = jwtProvider.genAccessToken(member);

//        // 응답 데이터에 accessToken 이름으로 발급
//        response.addCookie(new Cookie("token", token));

        // 보안관련 보완
        Cookie cookie = new Cookie("accessToken", token);
        cookie.setHttpOnly(true); // Http 요청 받을 때만 함. 수정 삭제 불가능.
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        return RsData.of("200", "로그인에 성공", token);
    }

    @GetMapping("/logout")
    public void logout() {
        System.out.println("logout");
    }

    @GetMapping("/me")
    public RsData<MemberResponse> me(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        String accessToken = "";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("accessToken")) {
                accessToken = cookie.getValue();
            }
        }

        Map<String, Object> claims = jwtProvider.getClaims(accessToken);
        String username = (String) claims.get("username");

        Member member = memberService.getMember(username);

        return RsData.of("200", "회원정보 조회", new MemberResponse(member));

    }
}