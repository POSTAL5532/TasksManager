package com.tasksmanager.api;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Tasks manager service application.
 *
 * @author SIE
 */
@SpringBootApplication
@ComponentScan({"com.tasksmanager.service", "com.tasksmanager.api"})
@EntityScan(basePackages = "com.tasksmanager.service.model")
@EnableJpaRepositories(basePackages = "com.tasksmanager.service.repository")
public class TasksManagerApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TasksManagerApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TasksManagerApiApplication.class, args);
    }

    /**
     * Hibernate 5 validation
     */
    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }

    /**
     * Auth password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

