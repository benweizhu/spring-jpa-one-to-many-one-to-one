package me.zeph.spring.jpa.example.springjpaoneton.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@NoArgsConstructor
public class User {

  @Id
  private long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

}
