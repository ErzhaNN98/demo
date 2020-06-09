package com.example.demo.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Table(name = "log_info")
@Entity
public class LogInfo {

    public LogInfo(Integer userId, String log, Date createTime) {
        this.userId = userId;
        this.log = log;
        this.createTime = createTime;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "log")
    private String log;

    @Column(name = "create_time")
    private Date createTime;

    /*
     * Getters & Setters
     */

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getLog() { return log; }
    public void setLog(String log) { this.log = log; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public LogInfo() { super(); }

    /*
     * Entity Basics
     */

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == null || this.getClass() != obj.getClass()) {
            return false;
        }

        LogInfo logInfo = (LogInfo) obj;
        return Objects.equals(id, logInfo.getId());

    }

    @Override
    public String toString() {
        SimpleDateFormat changeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String createTimeStr = changeFormat.format(createTime);
        return "{" + log +
                "," + createTimeStr +
                "}";
    }
}
