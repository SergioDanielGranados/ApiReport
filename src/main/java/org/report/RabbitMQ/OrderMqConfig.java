package org.report.RabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * OrderMqConfig
 *
 * @author SDGA
 * @version 1.0
 */
@Configuration
public class OrderMqConfig {

  public static final String ORDER_EXCHANGE_NAME = "order-report-exchange";
  public static final String ORDER_QUEUE_NAME = "order-report-queue";
  public static final String ORDER_ROUTING_KEY = "order-report-routing-key";

  /**
   * orderQueue
   *
   * @return Queue
   */
  @Bean
  public Queue orderQueue() {
    return new Queue(ORDER_QUEUE_NAME, true);
  }
  /**
   * orderExchange
   *
   * @return TopicExchange
   */
  @Bean
  public TopicExchange orderExchange() {
    return new TopicExchange(ORDER_EXCHANGE_NAME);
  }
  /**
   * orderBinding
   *
   * @return Binding
   */
  @Bean
  public Binding orderBinding() {
    return BindingBuilder
        .bind(orderQueue())
        .to(orderExchange())
        .with(ORDER_ROUTING_KEY);
  }

}
