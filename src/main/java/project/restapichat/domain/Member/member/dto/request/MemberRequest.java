package project.restapichat.domain.Member.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MemberRequest
{
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
