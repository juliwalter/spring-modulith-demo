package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Spring configuration class to enable asynchronous method execution.
 * <p>
 * Uses CGLIB-based proxies to allow {@link org.springframework.scheduling.annotation.Async @Async}
 * methods on classes that do not implement an interface. Provides an {@link java.util.concurrent.Executor}
 * bean used for executing async tasks.
 *
 * @author julianwalter
 */
@Configuration
@EnableAsync(proxyTargetClass = true)
public class AsyncConfig {

    /**
     * Creates and exposes a thread pool executor for asynchronous task execution.
     * <p>
     * Currently uses a cached thread pool. This executor will be used by any
     * {@link org.springframework.scheduling.annotation.Async @Async} annotated methods.
     *
     * @return an {@link Executor} for async task execution
     */
    @Bean
    public Executor taskExecutor() {
        return Executors.newCachedThreadPool();
    }
}
