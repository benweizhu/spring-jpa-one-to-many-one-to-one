package me.zeph.spring.jpa.example.springjpa.repository;

import me.zeph.spring.jpa.example.springjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
