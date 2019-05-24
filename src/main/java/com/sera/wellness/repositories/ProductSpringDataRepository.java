package com.sera.wellness.repositories;
import com.sera.wellness.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductSpringDataRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.user.id = ?1 OR  p.user IS NULL")
    List<Product> findAllToUser(Long userId);
    @Query("select p from Product p where p.user.id = ?1")
    List<Product> findAllPersonalByUserId(Long userId);
    @Query("select p from Product p where p.user IS NULL")
    List<Product> findAllCommonProducts();
}
