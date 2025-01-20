package project.restapichat.domain.Member.member.dto.request;

import lombok.Data;

@Data
public class MemberRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
