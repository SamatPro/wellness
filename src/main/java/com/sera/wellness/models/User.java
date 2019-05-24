package com.sera.wellness.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"createdArticles", "favoriteArticles", "friends", "dialogs", "messages", "comments"})
@Entity(name = "User")
@Table(name = "simple_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean sex;
    private String email;
    private String hashPassword;
    private Boolean consentToReceiveEmails;
    private Integer age;
    private Integer weight, growth, purposeWeight;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Article> createdArticles;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "favorite_article",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "article_id") }
    )
    private List<Article> favoriteArticles;

    private String photoSrc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "friends",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "friend_id") }
    )
    private List<User> friends;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_dialogs",
            joinColumns = { @JoinColumn(name = "id_user", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id_dialog", referencedColumnName = "id") }
    )
    private List<Dialog> dialogs;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return hashPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(Long id, String firstName, String lastName, String photoSrc) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoSrc = photoSrc;
    }
}
