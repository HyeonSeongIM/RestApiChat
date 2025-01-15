package project.restapichat.domain.article.articleComment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.article.article.entity.Article;
import project.restapichat.global.jpa.BaseEntity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ArticleComment extends BaseEntity {
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;


}
