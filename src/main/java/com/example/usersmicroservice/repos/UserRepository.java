package com.example.usersmicroservice.repos;

import com.example.usersmicroservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
