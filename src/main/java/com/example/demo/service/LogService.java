package com.example.demo.service;

import com.example.demo.data.entity.Log;
import java.util.List;

public interface LogService {
    List<Log> getLog();
    Log getLog(long id);
    Log create(Log log);
    void deleteLog(long id);
}