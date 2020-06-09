package com.example.demo.repository;

import com.example.demo.model.LogInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogInfoRepository extends JpaRepository<LogInfo, Integer> {

    @Query(value = "select li from LogInfo li where li.userId = ?1")
    List<LogInfo> findByUserId(Integer userId);
}
