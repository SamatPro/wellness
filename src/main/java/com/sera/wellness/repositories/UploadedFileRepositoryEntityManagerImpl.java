package com.sera.wellness.repositories;

import com.sera.wellness.models.UploadedFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadedFileRepositoryEntityManagerImpl implements UploadedFileRepository {
  @PersistenceContext
  private EntityManager em;

  @Override
  @Transactional
  public void save(UploadedFile model) {
    em.persist(model);
    em.flush();
  }

  @Override
  @Transactional
  public void delete(Long id) {

  }

  @Override
  @Transactional
  public void update(UploadedFile model) {

  }

  @Override
  public Optional<UploadedFile> findOne(Long id) {
    return Optional.empty();
  }

  @Override
  public List<UploadedFile> findAll() {
    return null;
  }
}
