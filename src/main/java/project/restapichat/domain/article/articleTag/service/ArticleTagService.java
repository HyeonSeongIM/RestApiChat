package project.restapichat.domain.article.articleTag.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.restapichat.domain.article.articleTag.entity.ArticleTag;
import project.restapichat.domain.article.articleTag.repository.ArticleTagRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {
    private final ArticleTagRepository articleTagRepository;

    public List<ArticleTag> findByAuthorId(Long authorId) {
        return articleTagRepository.findByArticle_authorId(authorId);
    }

    public List<ArticleTag> findByAuthorUsername(String username) {
        return articleTagRepository.findByArticle_authorUsername(username);
    }
}
