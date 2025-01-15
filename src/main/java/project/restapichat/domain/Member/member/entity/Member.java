package project.restapichat.domain.Member.member.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import project.restapichat.global.jpa.BaseEntity;

@Entity
@Getter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    private String username;

    private String password;
}