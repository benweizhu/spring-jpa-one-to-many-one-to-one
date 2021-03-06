package me.zeph.spring.jpa.example.springjpaoneton.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  private long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

}
