package com.example.quartz.demo.config;

import com.example.quartz.demo.job.SampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

public class SchedulerConfiguration {
    public static class SimpleJobConfigure {
        // 创建任务实例
        @Bean
        public JobDetail sampleJobDetail() {
            return JobBuilder.newJob(SampleJob.class)
                    .withIdentity("sampleJob")
                    .usingJobData("name", "niit")  // 传递参数
                    .storeDurably()  // 没有 Trigger 关联的时候任务是否被保留，还没 Trigger指向它，需要设为 true ，
                    .build();
        }

        // 创建触发器
        @Bean
        public Trigger sampleJobTrigger() {
            // 简单的调度计划的构造器
            SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(2) // 频率
                    .repeatForever(); // 次数
            // Trigger 构造器
            return TriggerBuilder.newTrigger()
                    .forJob(sampleJobDetail()) // 设置 Job
                    .withIdentity("sampleTrigger") // 设置触发器名称
                    .withSchedule(builder) // 设置调度器
                    .build();
        }
    }

}
