package com.example.quartz.demo.job;

import com.example.quartz.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ScheduledJob1 implements Job {
    @Autowired
    DemoService demoService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Scheduled job1 运行, demoService 为： {} ......", demoService);
    }
}