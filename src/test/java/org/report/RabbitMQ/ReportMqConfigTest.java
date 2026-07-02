package org.report.RabbitMQ;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


public class ReportMqConfigTest {

  @Test
  public void configTest(){

    ReportUserMqConfig config = new ReportUserMqConfig();

    assertNotNull(config.userQueue());
    assertNotNull(config.userExchange());
    assertNotNull(config.userBinding());
  }

}
