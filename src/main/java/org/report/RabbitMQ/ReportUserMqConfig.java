/**
 *  Prueba liverpoool  ejecutada pr Sergio Granados
 */
package org.report.RabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * ReportUserMqConfig
 *
 * @author SDGA
 * @version 1.0
 */
@Configuration
public class ReportUserMqConfig {

  public static final String USER_EXCHANGE_NAME = "user-report-exchange";
  public static final String USER_QUEUE_NAME = "user-report-queue";
  public static final String USER_ROUTING_KEY = "user-report-routing-key";
  /**
   * itemQueue
   *
   * @return userQueue
   */
  @Bean
  public Queue userQueue() {
    return new Queue(USER_QUEUE_NAME, true);
  }
  /**
   * TopicExchange
   *
   * @return userExchange
   */
  @Bean
  public TopicExchange userExchange() {
    return new TopicExchange(USER_EXCHANGE_NAME);
  }
  /**
   * ItemBinding
   *
   * @return userBinding
   */
  @Bean
  public Binding userBinding() {
    return BindingBuilder
        .bind(userQueue())
        .to(userExchange())
        .with(USER_ROUTING_KEY);
  }

}
