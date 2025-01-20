package project.restapichat.domain.Member.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.Member.member.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member signUp(String username, String password){
        Member member = Member.of(username, password);

        memberRepository.save(member);

        return member;
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Member getMember(String username) {
        return memberRepository.findByUsername(username);
    }
}
