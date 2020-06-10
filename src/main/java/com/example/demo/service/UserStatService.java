package com.example.demo.service;

import com.example.demo.model.UserStat;
import com.example.demo.repository.UserStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatService {
    @Autowired
    private final UserStatRepository userStatRepository;

    public UserStatService(UserStatRepository userStatRepository) {
        this.userStatRepository = userStatRepository;
    }

    public void create(UserStat userStat) {
        userStatRepository.save(userStat);
    }

    public UserStat findByUserId(Integer userId) {
        return userStatRepository.findByUserId(userId);
    }
}
