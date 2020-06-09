package com.example.demo.service;

import com.example.demo.model.LogInfo;
import com.example.demo.repository.LogInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInfoService {
    @Autowired
    private final LogInfoRepository logInfoRepository;

    public LogInfoService(LogInfoRepository logInfoRepository) {
        this.logInfoRepository = logInfoRepository;
    }

    public void create(LogInfo logInfo) {
        logInfoRepository.save(logInfo);
    }

    public List<LogInfo> getByUserId(Integer userId) {
        return logInfoRepository.findByUserId(userId);
    }

    public List<LogInfo> findAll() {
        return logInfoRepository.findAll();
    }
}
