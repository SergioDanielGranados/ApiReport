package org.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "org.report")
public class ApiReportApplication {

  public static void main(String[] args) {
    SpringApplication
        .run(ApiReportApplication.class, args);
  }

}
