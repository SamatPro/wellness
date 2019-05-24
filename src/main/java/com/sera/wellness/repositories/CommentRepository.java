package com.sera.wellness.repositories;

import com.sera.wellness.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
//    @Query("SELECT c FROM Comment c WHERE c.article = :articleId")
//    public List<Comment> findAllByArticle(@Param("articleId") Long articleId);

    public Comment findByArticleIdAndUserId(Long articleId,Long userId);

}
