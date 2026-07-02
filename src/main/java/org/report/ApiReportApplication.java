package org.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tools.jackson.databind.ObjectMapper;


@SpringBootApplication
@ComponentScan(basePackages = "org.report")
public class ApiReportApplication {

  public static void main(String[] args) {
    SpringApplication
        .run(ApiReportApplication.class, args);
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
