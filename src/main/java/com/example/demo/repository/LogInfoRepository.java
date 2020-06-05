package com.example.demo.repository;

import com.example.demo.model.LogInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInfoRepository extends JpaRepository<LogInfo, Integer> {
}
