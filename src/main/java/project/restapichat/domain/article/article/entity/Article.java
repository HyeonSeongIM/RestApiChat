package project.restapichat.domain.article.article.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.article.articleComment.entity.ArticleComment;
import project.restapichat.global.jpa.BaseEntity;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ArticleComment> comments = new ArrayList<>();

    public void addComment(Member memberAuthor, String commentBody) {
        ArticleComment articleComment = ArticleComment.builder()
                .article(this)
                .author(memberAuthor)
                .body(commentBody)
                .build();

        comments.add(articleComment);

    }

    public void removeComment(ArticleComment articleComment) {
        comments.remove(articleComment);
    }
}

