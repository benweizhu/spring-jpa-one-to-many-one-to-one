package me.zeph.spring.jpa.example.springjpa.repository;

import me.zeph.spring.jpa.example.springjpa.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
  Optional<Company> findByUsersName(String name);
}
