package com.sera.wellness.repositories;

import com.sera.wellness.models.Message;
import com.sera.wellness.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MessagesRepository extends CRUDRepository<Message>{
  List<Message> getMessagesByDialogIdOrderByCreationTime(Long id);
}
