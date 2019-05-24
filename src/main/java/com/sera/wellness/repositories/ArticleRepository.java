package com.sera.wellness.repositories;

import com.sera.wellness.models.Article;

public interface ArticleRepository extends CRUDRepository<Article> {
    public void evaluate(Long userId,Long articleId,Short grade);
    public void revaluate(Long userId,Long articleId,Short grade);
    public Short getUsersGrade(Long userId,Long articleId);
    public Float getAvgGrade(Long articleId);
}
