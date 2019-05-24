package com.sera.wellness.services;

import com.sera.wellness.forms.ArticleAddForm;
import com.sera.wellness.forms.CommentForm;
import com.sera.wellness.models.Article;
import com.sera.wellness.models.Comment;
import com.sera.wellness.models.UploadedFile;
import com.sera.wellness.models.User;
import com.sera.wellness.repositories.ArticleRepository;
import com.sera.wellness.repositories.CommentRepository;
import com.sera.wellness.repositories.UserRepository;
import com.sera.wellness.utils.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private Environment environment;

    public List<Article> convertImgToNormal(List<Article> articles) {
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.getMainImg() != null) {
                if (!article.getMainImg().getFileName().contains("/uploads")) {
                    article.getMainImg().setFileName("/uploads/" + article.getMainImg().getFileName());
                }
            }
        }
        return articles;
    }

    public List<Article> getAll() {
        List<Article> articles = articleRepository.findAll();
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.getMainImg() != null) {
                if (!article.getMainImg().getFileName().contains("/uploads")) {
                    article.getMainImg().setFileName("/uploads/" + article.getMainImg().getFileName());
                }
            }
        }
        return articles;
    }

    public Article getArticle(Long id) {
        Optional<Article> articleCandidate = articleRepository.findOne(id);
        if (articleCandidate.isPresent()) {
            Article article = articleCandidate.get();
            if (article.getMainImg() != null) {
                if (!article.getMainImg().getFileName().contains("/uploads")) {
                    article.getMainImg().setFileName("/uploads/" + article.getMainImg().getFileName());
                }
            }
            return article;
        } else {
            throw new IllegalArgumentException("Такой статьи не существует.");
        }
    }

    public void addArticle(ArticleAddForm form, User user) {
        Article article = Article.builder()
                .title(form.getTitle())
                .text(form.getText())
                .user(user)
                .build();
        if (form.getFile() == null || form.getFile().isEmpty()) {
            throw new IllegalArgumentException("empty file");
        }
        String[] tmp = form.getFile().getOriginalFilename().split("\\.");
        String type = tmp[tmp.length - 1];
        String fileName = StuffService.generateUniqueFileNameForUsersUploads("imgarticles", user.getId())
                + "." + type;
        File file = new File(environment.getProperty("path.uploads") + fileName);
        System.out.println(file.getAbsolutePath().toString());
        try {
            if (file.createNewFile()) {
                Files.write(file.toPath(), form.getFile().getBytes());
                article.setMainImg(UploadedFile.builder().fileName(fileName).build());
            } else {
                throw new IllegalArgumentException("error of creating new unique file name");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        articleRepository.save(article);
    }

    @Override
    public Boolean addFavoriteArticle(Long articleId, User user) {
        if (user.getFavoriteArticles().contains(Article.builder().id(articleId).build())) {
            user.getFavoriteArticles().remove(Article.builder().id(articleId).build());
            userRepository.update(user);
            return false;
        }
        user.getFavoriteArticles().add(articleRepository.findOne(articleId).get());
        userRepository.update(user);
        return true;
    }

    @Override
    public void addComment(CommentForm commentForm, Long userId) {
        commentRepository.save(Comment.builder()
                .article(Article.builder().id(commentForm.getArticleId()).build())
                .text(commentForm.getText())
                .user(User.builder().id(userId).build())
                .build());
    }

    @Override
    public void evaluate(Long userId, Long articleId, Short grade) {
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Grade's range is {1,5}");
        }
        if (articleRepository.getUsersGrade(userId, articleId) == null) {
            articleRepository.evaluate(userId, articleId, grade);
        } else {
            articleRepository.revaluate(userId, articleId, grade);
        }
    }

    @Override
    public Short getUsersGrade(Long userId, Long articleId) {
        return articleRepository.getUsersGrade(userId, articleId);
    }

    @Override
    public Float getAvgGrade(Long articleId) {
        return articleRepository.getAvgGrade(articleId);
    }


}
