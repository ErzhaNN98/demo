package com.example.demo.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Entity
public class UserSession {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "last_ping_time")
    private Date lastPingTime;

    @Column(name = "create_time")
    private Date createTime;

    /*
     * Getters & Setters
     */

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Date getLastPingTime() { return lastPingTime; }
    public void setLastPingTime(Date lastPingTime) { this.lastPingTime = lastPingTime; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    /*
     * Entity Basics
     */

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
