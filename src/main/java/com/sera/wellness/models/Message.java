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
@Entity(name = "Message")
@Table(name = "messages")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;
  private String text;
  private LocalDateTime creationTime;

  @ManyToOne
  @JoinColumn(name = "id_dialog")
  private Dialog dialog;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User user;
}
