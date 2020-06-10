package com.example.demo.Controller;

import com.example.demo.model.UserStat;
import com.example.demo.service.UserStatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userStat")
public class UserStatController {

    private UserStatService userStatService;

    public UserStatController(UserStatService userStatService) { this.userStatService = userStatService; }
    @PostMapping("/something")
    public void something(@RequestBody UserStat userStat) {
        userStatService.create(userStat);
    }

    @PostMapping("/check")
    public String check(@RequestBody String userIdStr) {
        Integer userId = Integer.parseInt(userIdStr);
        UserStat userStat = userStatService.findByUserId(userId);
        if (userStat == null || !userStat.getSuccess()) {
            return "";
        }
        return "Success";
    }
}
