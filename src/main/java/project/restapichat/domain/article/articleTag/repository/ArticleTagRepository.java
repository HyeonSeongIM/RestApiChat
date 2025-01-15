package project.restapichat.domain.article.articleTag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.restapichat.domain.article.articleTag.entity.ArticleTag;

import java.util.List;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
    List<ArticleTag> findByArticle_authorId(Long id);
    List<ArticleTag> findByArticle_authorUsername(String username);
}
