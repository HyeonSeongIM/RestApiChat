package project.restapichat.domain.article.article.controller;


import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.restapichat.domain.article.article.entity.Article;
import project.restapichat.domain.article.article.service.ArticleService;
import project.restapichat.global.rsData.RsData;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<Article> getArticles() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    private Article getArticle(@PathVariable("id") Long id) {
        return articleService.findById(id).get();
    }

    @PostMapping
    public RsData writeArticle(@RequestBody Article article) {
        return articleService.write(article.getAuthor().getId(), article.getTitle(), article.getContent());
    }

    @PatchMapping("/{id}")
    public void updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
        this.articleService.modify(article, article.getTitle(), article.getContent());
    }

    @DeleteMapping({"/{id}"})
    public void deleteArticle(@PathVariable("id") Long id) {
        this.articleService.delete(id);
    }

}
