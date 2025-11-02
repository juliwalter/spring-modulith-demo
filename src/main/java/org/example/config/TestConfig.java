package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author julianwalter
 */
@Configuration
public class TestConfig {
    @Bean
    public MyTestService testService() {
        return new MyTestService();
    }

    public static class MyTestService {

    }
}
