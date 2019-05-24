package com.sera.wellness.repositories;

import com.sera.wellness.models.EatenProduct;
import com.sera.wellness.models.Product;
import com.sera.wellness.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface EatenProductSpringDataRepository extends JpaRepository<EatenProduct,Long> {
    //boolean existsByProductAndUserAndDate(Product product, User user, Date date);
    @Query("SELECT ep FROM EatenProduct ep WHERE ep.user = :user AND ep.product = :product AND ep.date = :date")
    EatenProduct findByProductAndUserAndDate(@Param("product") Product product, @Param("user") User user,@Param("date") Date date);
    @Query("SELECT ep FROM EatenProduct ep WHERE ep.user = :user AND ep.date =:date")
    List<EatenProduct> findAllByUser(@Param("user") User user, @Param("date") Date date);
}
