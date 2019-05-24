package com.sera.wellness.repositories;

import com.sera.wellness.models.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRepositoryEntityManagerImpl implements ArticleRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(Article model) {
        em.persist(model);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        em.remove(Article.builder().id(id).build());
    }

    @Override
    @Transactional
    public void update(Article model) {
        em.merge(model);
    }

    @Override
    public Optional<Article> findOne(Long id) {
        Article article = em.find(Article.class, id);
        return Optional.ofNullable(article);
    }

    @Override
    public List<Article> findAll() {
        return  em.createQuery("SELECT a FROM Article a").getResultList();
    }
    @Override
    @Transactional
    public void evaluate(Long userId,Long articleId,Short grade) {
        Query query = em.createNativeQuery("insert into grades(user_id, article_id, grade) values (:user_id, :article_id, :grade)");
        query.setParameter("user_id",userId);
        query.setParameter("article_id",articleId);
        query.setParameter("grade",grade);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void revaluate(Long userId, Long articleId, Short grade) {
        Query query = em.createNativeQuery("update grades set grade = :grade WHERE user_id = :user_id AND article_id = :article_id ");
        query.setParameter("user_id",userId);
        query.setParameter("article_id",articleId);
        query.setParameter("grade",grade);
        query.executeUpdate();
    }

    @Override
    public Short getUsersGrade(Long userId, Long articleId) {
        Query query = em.createNativeQuery("select grade from grades where article_id=:article_id and user_id=:user_id");
        query.setParameter("article_id",articleId);
        query.setParameter("user_id",userId);
        try {
            return (Short) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Float getAvgGrade(Long articleId) {
        Query query = em.createNativeQuery("select avg(grade) from grades where article_id=:id");
        query.setParameter("id",articleId);
        Number number = (Number) query.getSingleResult();

       return number == null ? null : number.floatValue();
    }
}
