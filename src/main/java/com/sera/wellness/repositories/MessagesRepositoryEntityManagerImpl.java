package com.sera.wellness.repositories;

import com.sera.wellness.models.Message;
import com.sera.wellness.models.User;
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
public class MessagesRepositoryEntityManagerImpl implements MessagesRepository {
  @PersistenceContext
  private EntityManager em;
  @Override
  public List<Message> getMessagesByDialogIdOrderByCreationTime(Long id) {
    return em.createQuery("SELECT m FROM Message m WHERE m.dialog.id = :id ORDER BY m.creationTime").setParameter("id", id).getResultList();
  }

  @Override
  public void save(Message model) {
    em.persist(model);
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public void update(Message model) {

  }

  @Override
  public Optional<Message> findOne(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Message> findAll() {
    return null;
  }
}
