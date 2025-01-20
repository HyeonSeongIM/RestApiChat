package project.restapichat.domain.Member.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import project.restapichat.global.jpa.BaseEntity;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    public static Member of(String username, String password) {
        return Member.builder()
                .username(username)
                .password(password).build();
    }
}