package com.example.demo.Controller;

import com.example.demo.model.LogInfo;
import com.example.demo.model.LogInfoRequest;
import com.example.demo.model.UserStat;
import com.example.demo.service.LogInfoService;
import com.example.demo.service.UserStatService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logInfo")
public class LogInfoController {

    private LogInfoService logInfoService;
    private UserStatService userStatService;

    public LogInfoController(LogInfoService logInfoService, UserStatService userStatService) {
        this.logInfoService = logInfoService;
        this.userStatService = userStatService;
    }

    @PostMapping("/create")
    public String create(@RequestBody String params){
        Gson gson = new Gson();
        LogInfoRequest userStatRequest = gson.fromJson(params, LogInfoRequest.class);
        System.out.println(userStatRequest.getUserId() + " " + userStatRequest.getLog());
        LogInfo logInfo = new LogInfo(userStatRequest.getUserId(), userStatRequest.getLog(), new Date());
        logInfoService.create(logInfo);
        UserStat userStat = userStatService.findByUserId(userStatRequest.getUserId());
        if (userStat != null) {
            userStat.setSuccess(null);
            userStatService.create(userStat);
        }
        return logInfo.toString();
    }

    @PostMapping("/get-by-user")
    public String getByUser(@RequestBody String userIdStr) {
        Integer userId = Integer.parseInt(userIdStr);
        List<LogInfo> logInfoList = logInfoService.getByUserId(userId);
        return logInfoList.toString();
    }

    @GetMapping("/check")
    public List<LogInfo> findAll() {
        return logInfoService.findAll();
    }
}
