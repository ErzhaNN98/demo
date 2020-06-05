package com.example.demo.repository;

import com.example.demo.model.UserStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatRepository extends JpaRepository<UserStat, Integer> {
}
