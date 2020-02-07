package me.zeph.spring.jpa.example.springjpaoneton.repository;

import me.zeph.spring.jpa.example.springjpaoneton.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
