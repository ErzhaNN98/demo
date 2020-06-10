package com.example.demo.model;

public class LogInfoRequest {

    private Integer userId;
    private String log;

    /*
     * Getters & Setters
     */

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getLog() { return log; }
    public void setLog(String log) { this.log = log; }

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
