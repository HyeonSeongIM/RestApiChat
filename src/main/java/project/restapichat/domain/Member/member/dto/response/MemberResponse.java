package project.restapichat.domain.Member.member.dto.response;

import project.restapichat.domain.Member.member.entity.Member;

public class MemberResponse {
    Long id;
    String username;
    String password;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.password = member.getPassword();
    }
}
