package com.sera.wellness.services;

import com.sera.wellness.forms.ArticleAddForm;
import com.sera.wellness.forms.CommentForm;
import com.sera.wellness.models.Article;
import com.sera.wellness.models.User;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    public List<Article> getAll();
    public Article getArticle(Long id);
    public void addArticle(ArticleAddForm form, User user);
    public Boolean addFavoriteArticle(Long articleId,User user);
    public void addComment(CommentForm commentForm,Long userId);
    public Short getUsersGrade(Long userId,Long articleId);
    public void evaluate(Long userId,Long articleId,Short grade);
    public Float getAvgGrade(Long articleId);
    public List<Article> convertImgToNormal(List<Article> articles);
}
