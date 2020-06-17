package me.zeph.spring.jpa.example.springjpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="company_id")
  private List<User> users;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ceo_id")
  private User ceo;

}
