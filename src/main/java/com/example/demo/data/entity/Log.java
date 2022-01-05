package com.example.demo.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "logs", schema = "public", catalog = "")
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String logDescription;
    private String logTime;
    private String logDate;

    public Log(String logDescription, String logTime, String logDate, long id) {
        this.id = id;
        this.logDescription = logDescription;
        this.logTime = logTime;
        this.logDate = logDate;
    }

    public Log(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logDescription='" + logDescription + '\'' +
                ", logTime='" + logTime + '\'' +
                ", logDate='" + logDate + '\'' +
                ", logId='" + id + '\'' +
                '}';
    }
}