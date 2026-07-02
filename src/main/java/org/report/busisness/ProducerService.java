package org.report.busisness;


import lombok.extern.slf4j.Slf4j;
import org.report.RabbitMQ.ItemMqConfig;
import org.report.RabbitMQ.OrderMqConfig;
import org.report.RabbitMQ.ReportUserMqConfig;
import org.report.dto.ItemSearch;
import org.report.dto.OrderSearchParams;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;
/**
 * Clase de ejemplo para demostración de Javadoc.
 *
 * @author Tu Nombre
 * @version 1.0
 */
@Slf4j
@Service
public class ProducerService {


  private RabbitTemplate rabbitTemplate;
  private final ObjectMapper ojectMapper ;

  @Autowired
  public ProducerService(RabbitTemplate rabbitTemplate, ObjectMapper ojectMapper) {
    this.rabbitTemplate = rabbitTemplate;
    this.ojectMapper = ojectMapper;
  }

  /**
   * Envio para Repórte Item.
   *
   * @param message Mensaje.
   */
  public void sendReportItem(ItemSearch message) {
    String params = ojectMapper.writeValueAsString(message);
    rabbitTemplate.convertAndSend(
        ItemMqConfig.ITEM_EXCHANGE_NAME,
        ItemMqConfig.ITEM_ROUTING_KEY,
        params
    );
    log.info("Mensaje Enviado Report Item  {} ",message);
  }

  /**
   * Reporte Orders.
   *
   * @param orderSearchParams Parametros de busqueda para Reporte Orders.
   */
  public void sendReportOrder(OrderSearchParams orderSearchParams) {

    String params = ojectMapper.writeValueAsString(orderSearchParams);

    rabbitTemplate.convertAndSend(
        OrderMqConfig.ORDER_EXCHANGE_NAME,
        OrderMqConfig.ORDER_ROUTING_KEY,
        params
    );
    log.info("Mensaje Enviado Report Order  {} ",params);
  }

  /**
   * Reporte Usuarios Orders.
   *
   * @param message Parametros de busqueda Usuarios.
   */
  public void sendReporUsers(String message) {
    rabbitTemplate.convertAndSend(
        ReportUserMqConfig.USER_EXCHANGE_NAME,
        ReportUserMqConfig.USER_ROUTING_KEY,
        message
    );
    log.info("Mensaje Enviado Report Users {} ",message);
  }

}
