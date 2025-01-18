package project.restapichat.domain.article.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.article.article.entity.Article;
import project.restapichat.domain.article.article.repository.ArticleRepository;
import project.restapichat.domain.article.articleComment.entity.ArticleComment;
import project.restapichat.global.rsData.RsData;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public RsData<Article> write(Long memberId, String title, String content) {
        Article article = Article.builder()
                .author(Member.builder().id(memberId).build())
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);

        return RsData.of("200", "게시글 작성", article);
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    @Transactional // 자동으로 처리
    public void modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);

        articleRepository.save(article);
    }

    @Transactional
    public void modifyComment(ArticleComment comment, String commentBody) {
        comment.setBody(commentBody);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Page<Article> search(List<String> kwTypes, String kw, Pageable pageable) {
        // 수정 : return articleRepository.findAll(pageable);
        return articleRepository.search(kwTypes, kw, pageable);
    }
}
