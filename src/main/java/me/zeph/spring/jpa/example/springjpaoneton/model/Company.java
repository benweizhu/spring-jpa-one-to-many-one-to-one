package me.zeph.spring.jpa.example.springjpaoneton.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
public class Company {

  @Id
  private long id;

  private String name;

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
  private List<User> users = new ArrayList<>();

  public void addUser(User user) {
    user.setCompany(this);
    users.add(user);
  }
}
