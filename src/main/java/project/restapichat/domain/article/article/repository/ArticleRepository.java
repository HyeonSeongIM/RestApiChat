package project.restapichat.domain.article.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.restapichat.domain.article.article.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
