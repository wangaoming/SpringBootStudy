package com.example.quartz.demo.job;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalTime;

@Setter
@Slf4j
public class SampleJob extends QuartzJobBean {
    private String name;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        log.info("正在执行 {} 任务，时间为 {}", this.name, LocalTime.now().withNano(0));
    }
}