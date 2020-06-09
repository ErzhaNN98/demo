package com.example.demo.Controller;

import com.example.demo.model.LogInfo;
import com.example.demo.service.LogInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logInfo")
public class LogInfoController {

    private LogInfoService logInfoService;

    public LogInfoController(LogInfoService logInfoService) { this.logInfoService = logInfoService; }

    @PostMapping("/create")
    public String create(@RequestBody String userId){
        LogInfo logInfo = new LogInfo(Integer.parseInt(userId), "Success", new Date());
        logInfoService.create(logInfo);
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
