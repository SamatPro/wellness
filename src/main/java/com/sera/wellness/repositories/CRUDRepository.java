package com.sera.wellness.repositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {
    void save(T model);
    void delete(Long id);
    void update(T model);
    Optional<T> findOne(Long id);
    List<T> findAll();
}
