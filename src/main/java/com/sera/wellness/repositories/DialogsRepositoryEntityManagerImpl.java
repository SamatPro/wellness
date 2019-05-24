package com.sera.wellness.repositories;

import com.sera.wellness.models.Dialog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DialogsRepositoryEntityManagerImpl implements DialogsRepository {
  @PersistenceContext
  private EntityManager em;
  @Override
  public void save(Dialog model) {

  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public void update(Dialog model) {

  }

  @Override
  public Optional<Dialog> findOne(Long id) {
    return Optional.ofNullable(em.find(Dialog.class, id));
  }

  @Override
  public List<Dialog> findAll() {
    return null;
  }
}
