package com.github.shizuyaaishima.menu.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.shizuyaaishima.menu")
@EntityScan(basePackages = "com.github.shizuyaaishima.menu.entity")
@EnableJpaRepositories(basePackages = "com.github.shizuyaaishima.menu.repository")
public class MenuSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuSampleApplication.class, args);
    }
} 