package project.restapichat.domain.Member.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.restapichat.domain.Member.member.dto.request.MemberRequest;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.Member.member.service.MemberService;
import project.restapichat.global.rsData.RsData;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class ApiV1MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public RsData<String> signup(@Valid @RequestBody MemberRequest memberRequest) {
        Member member = memberService.signUp(memberRequest.getUsername(), memberRequest.getPassword());
        return RsData.of("200", "회원가입에 성공하였습니다.", member.getUsername());
    }

    @PostMapping("/login")
    public void login() {
        System.out.println("login");
    }

    @GetMapping("/logout")
    public void logout() {
        System.out.println("logout");
    }

    @GetMapping("/me")
    public void me() {
        System.out.println("me");
    }
}