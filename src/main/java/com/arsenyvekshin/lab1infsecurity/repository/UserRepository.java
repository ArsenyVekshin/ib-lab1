package com.arsenyvekshin.lab1infsecurity.repository;

import com.arsenyvekshin.lab1infsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String login);
}
