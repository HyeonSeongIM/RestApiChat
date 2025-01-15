package project.restapichat.domain.article.article.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.article.articleComment.entity.ArticleComment;
import project.restapichat.domain.article.articleTag.entity.ArticleTag;
import project.restapichat.global.jpa.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @ToString.Exclude
    private List<ArticleComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<ArticleTag> tags = new ArrayList<>();

    public void addTags(String... tagContents){
        for (String tagContent : tagContents){
            addTag(tagContent);
        }
    }

    public void addTag(String tagContent){
        ArticleTag articleTag = ArticleTag.builder()
                .article(this)
                .content(tagContent).build();
        tags.add(articleTag);
    }

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

    public String getTagsStr() {
        String tagsStr = tags
                .stream()
                .map(ArticleTag::getContent)
                .collect(Collectors.joining(" #"));

        if(tagsStr.isBlank()){
            return "";
        }

        return "#"+tagsStr;
    }
}

