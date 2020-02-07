package me.zeph.spring.jpa.example.springjpaoneton.repository;

import me.zeph.spring.jpa.example.springjpaoneton.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
