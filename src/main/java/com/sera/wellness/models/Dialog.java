package com.sera.wellness.models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Dialog")
@Table(name = "dialog")
public class Dialog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;
  private String name;
  private LocalDateTime creationTime;

  @ManyToMany(mappedBy = "dialogs")
  private List<User> users;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "dialog")
  private List<Message> messages;
}
