package org.report.RabbitMQ;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemMqConfigTest {

  @Test
  public void configTest(){

    ItemMqConfig config = new ItemMqConfig();

    assertNotNull(config.itemQueue());
    assertNotNull(config.itemExchange());
    assertNotNull(config.itemBinding());
  }

}
