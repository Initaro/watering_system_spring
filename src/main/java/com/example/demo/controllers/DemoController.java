package com.example.demo.controllers;

import com.example.demo.data.entity.Log;
import com.example.demo.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/logs")
public class DemoController {

    private final LogService logsService;

    public DemoController(LogService logsService) {
        this.logsService = logsService;
    }

    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    public List<Log> getLogs() {
        return logsService.getLog();
    }

    @RequestMapping(value = "/search_logs", method = RequestMethod.GET)
    public Log getLogsByDescription(@PathVariable("id") long id) {
        return logsService.getLog(id);
    }

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String check() {
        return "works";
    }

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logsService.create(log);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLog(@PathVariable long id) {
        logsService.deleteLog(id);
    }

    @RequestMapping(value = "/testLog", method = RequestMethod.GET)
    @ResponseBody
    public String getTestLogs() {
        return "[\n" +
                "    {\n" +
                "        \"logDescription\": \"error\",\n" +
                "        \"logTime\": \"12:40\",\n" +
                "        \"logDate\": \"11.04\",\n" +
                "        \"logId\": \"1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"logDescription\": \"warning\",\n" +
                "        \"logTime\": \"18:00\",\n" +
                "        \"logDate\": \"15.04\",\n" +
                "        \"logId\": \"2\"\n" +
                "    }\n" +
                "]";
    }

    public LogService getLogsService() {
        return logsService;
    }

}