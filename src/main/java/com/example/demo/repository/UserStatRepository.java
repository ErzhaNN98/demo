package com.example.demo.repository;

import com.example.demo.model.UserStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserStatRepository extends JpaRepository<UserStat, Integer> {

    @Query(value = "select us FROM UserStat us where us.userId = ?1")
    UserStat findByUserId(Integer userId);
}
