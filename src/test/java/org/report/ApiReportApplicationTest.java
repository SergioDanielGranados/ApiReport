package org.report;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiReportApplicationTest {

  @Test
  void mainMethodStartsApplication() {
    String[] args = {};
    ApiReportApplication .main(args);
  }


  @Test
  void MapperApplication() {
    ApiReportApplication app = new ApiReportApplication();
    Assertions.assertNotNull(app.objectMapper());
  }

}
