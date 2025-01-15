package project.restapichat.domain.article.articleComment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.restapichat.domain.article.articleComment.entity.ArticleComment;

import java.util.List;

@Repository
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
    List<ArticleComment> findByArticleId(Long id);

    List<ArticleComment> findByAuthorId(Long id);

}
