package com.taskmanager.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.taskmanager.core.entity")
@EnableJpaRepositories(basePackages = "com.taskmanager.core.repository")
public class DatabaseConfig {
}
