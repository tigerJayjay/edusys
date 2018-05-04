package org.student.web;

import org.es.config.SpringJsonConfig;
import org.es.config.SpringMybatisConfig;
import org.es.config.SpringShiroConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@Import(value={SpringMybatisConfig.class,SpringShiroConfig.class,SpringJsonConfig.class})
public class SpringContextApplication{
    public static void main(String[] args) {
        SpringApplication.run(SpringContextApplication.class, args);
    }
}