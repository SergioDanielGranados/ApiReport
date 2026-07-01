package org.report.busisness;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.report.RabbitMQ.ItemMqConfig;

@Slf4j
@Service
public class ProducerService {


  private RabbitTemplate rabbitTemplate;

  @Autowired
  public ProducerService(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendReportItem(String message) {
    rabbitTemplate.convertAndSend(
        ItemMqConfig.ITEM_EXCHANGE_NAME,
        ItemMqConfig.ITEM_ROUTING_KEY,
        message
    );
    log.info("Mensaje Enviado Report Item  {} ",message);
  }

}
