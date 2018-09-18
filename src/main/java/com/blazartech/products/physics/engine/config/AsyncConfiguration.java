/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.config;

import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 *
 * @author AAR1069
 */
@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {
    
    private static final Logger logger = LoggerFactory.getLogger(AsyncConfiguration.class);

    @Value("${blazartech.physicsEngine.incrementService.threadCount}")
    private int minSize;

    @Value("${blazartech.physicsEngine.incrementService.threadCount}")
    private int maxSize;

    @Value("${blazartech.physicsEngine.incrementService.queueCount}")
    private int queueSize;

    @Value("${blazartech.physicsEngine.incrementService.threadPrefix}")
    private String threadPrefix;

    @Override
    @Bean(destroyMethod = "shutdown")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(minSize);
        executor.setMaxPoolSize(maxSize);
        executor.setQueueCapacity(queueSize);
        executor.setThreadNamePrefix(threadPrefix);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> logger.error("Uncaught async error", ex);
    }

}
