package project.restapichat.domain.article.article.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.restapichat.domain.article.article.entity.Article;

import java.util.List;
public interface ArticleRepositoryCustom {
    Page<Article> search(List<String> kwTypes, String kw, Pageable pageable);
}
