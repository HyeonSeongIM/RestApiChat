package project.restapichat.domain.article.article.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.global.jpa.BaseEntity;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseEntity {

    private String title;

    private String content;

    @ManyToOne
    private Member author;

}

