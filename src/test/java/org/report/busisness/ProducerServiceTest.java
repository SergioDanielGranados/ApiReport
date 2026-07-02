package org.report.busisness;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.report.RabbitMQ.ItemMqConfig;
import org.report.RabbitMQ.OrderMqConfig;
import org.report.RabbitMQ.ReportUserMqConfig;
import org.report.dto.ItemSearch;
import org.report.dto.OrderSearchParams;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import tools.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class ProducerServiceTest {

  @Mock
  private RabbitTemplate rabbitTemplate;

  @Mock
  private ObjectMapper ojectMapper ;

  @InjectMocks
  private ProducerService producerService;

  @Test
  public void sendReporUsersTest(){

    String exchange = "order-exchange";
    String routingKey = "order.created";
    String orderPayload = "{\"id\": 101, \"status\": \"NEW\"}";

    producerService.sendReporUsers(orderPayload);

    verify(rabbitTemplate).convertAndSend(ReportUserMqConfig.USER_EXCHANGE_NAME,
        ReportUserMqConfig.USER_ROUTING_KEY,orderPayload);
  }

  @Test
  public void sendReporItemTest(){

    String exchange = "order-exchange";
    String routingKey = "order.created";
    String orderPayload = "{\"id\": 101, \"status\": \"NEW\"}";

    String result = "{\"search\": \"mensaje\"}";

    ItemSearch message = new ItemSearch("mensaje");

    when(ojectMapper.writeValueAsString(message)).thenReturn(result);

    producerService.sendReportItem(message);

    verify(rabbitTemplate).convertAndSend(        ItemMqConfig.ITEM_EXCHANGE_NAME,
        ItemMqConfig.ITEM_ROUTING_KEY,result);
  }


  @Test
  public void sendReporOrdersTest(){

    String exchange = "order-exchange";
    String routingKey = "order.created";
    String orderPayload = "{\"id\": 101, \"status\": \"NEW\"}";


    OrderSearchParams message = new OrderSearchParams("mensaje","mensaje","mensaje");

    ObjectMapper ob = new ObjectMapper();

    String result = ob.writeValueAsString(message);
    when(ojectMapper.writeValueAsString(message)).thenReturn(result);

    producerService.sendReportOrder(message);

    verify(rabbitTemplate).convertAndSend(OrderMqConfig.ORDER_EXCHANGE_NAME,
        OrderMqConfig.ORDER_ROUTING_KEY,result);
  }

}
