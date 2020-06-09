package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserReposiroty extends JpaRepository<User, Integer> {

    @Query(value = "select u from User u where u.login = ?1")
    User findByLogin(String login);
}
