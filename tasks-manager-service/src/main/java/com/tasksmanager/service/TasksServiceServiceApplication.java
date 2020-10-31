package com.tasksmanager.service;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Tasks manager service application.
 *
 * @author SIE
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.tasksmanager.data.repository")
@EntityScan(basePackages = "com.tasksmanager.data.model")
public class TasksServiceServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TasksServiceServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TasksServiceServiceApplication.class, args);
    }

    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }
}
