package me.zeph.spring.jpa.example.springjpaoneton.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {

  @Id
  private long id;

  private String name;

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
  private List<User> users = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ceo_id")
  private User ceo;

  public void addUser(User user) {
    user.setCompany(this);
    users.add(user);
  }
}
