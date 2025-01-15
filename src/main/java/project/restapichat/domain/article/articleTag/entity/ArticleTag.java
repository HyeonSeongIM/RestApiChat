package project.restapichat.domain.article.articleTag.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import project.restapichat.domain.article.article.entity.Article;
import project.restapichat.global.jpa.BaseEntity;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTag extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    private String content;
}
