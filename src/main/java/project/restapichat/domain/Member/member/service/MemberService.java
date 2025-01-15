package project.restapichat.domain.Member.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.Member.member.repository.MemberRepository;
import project.restapichat.global.rsData.RsData;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public RsData<Member> join(String username, String password){
        Member member = Member.builder().username(username).password(password).build();

        Member savedMember = memberRepository.save(member);

        return RsData.of("200", "회원가입 성공", savedMember);
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}
