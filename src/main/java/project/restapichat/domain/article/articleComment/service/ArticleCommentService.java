package project.restapichat.domain.article.articleComment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.restapichat.domain.article.articleComment.entity.ArticleComment;
import project.restapichat.domain.article.articleComment.repository.ArticleCommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;

    public List<ArticleComment> findByAuthorId(Long id){
        return articleCommentRepository.findByAuthorId(id);
    }
}
