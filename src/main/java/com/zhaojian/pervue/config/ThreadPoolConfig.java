package com.zhaojian.pervue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

//@Configuration
//@EnableAsync
public class ThreadPoolConfig {

    @Bean
    public TaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置线程的核心数量
        executor.setCorePoolSize(5);
        //设置线程的最大数量
        executor.setMaxPoolSize(10);
        //设置队列容量
        executor.setQueueCapacity(20);
        //设置线程的活哟时间
        executor.setKeepAliveSeconds(60);
        //指定线程池中，线程名称是什么开头
        executor.setThreadNamePrefix("Java7D_");
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程池的关闭策略 当线程池中所有的线程关闭后，进行关闭线程池。
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
