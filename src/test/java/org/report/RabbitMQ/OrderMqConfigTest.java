package org.report.RabbitMQ;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class OrderMqConfigTest {

  @Test
  public void configTest(){

    OrderMqConfig config = new OrderMqConfig();

    assertNotNull(config.orderQueue());
    assertNotNull(config.orderExchange());
    assertNotNull(config.orderBinding());
  }

}
