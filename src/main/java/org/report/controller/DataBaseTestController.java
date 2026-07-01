package org.report.controller;

import lombok.extern.slf4j.Slf4j;
import org.report.busisness.ProducerService;
import org.report.dto.OrderSearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Clase de ejemplo para demostración de Javadoc.
 *
 * @author Tu Nombre
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/report")
public class DataBaseTestController {

  private final ProducerService producerService;

  /**
   * Suma dos números enteros.
   *
   * @param producerService El segundo número a sumar.
   * @return La suma de ambos números.
   */
  @Autowired
  private DataBaseTestController(ProducerService producerService) {
    this.producerService = producerService;
  }

  @PostMapping("/item")
  public  Mono<ResponseEntity<Void>>createUser(@Validated @RequestBody String s) {
    log.info("Inicia Creacion Reporte Item {} ", s);
    producerService.sendReportItem(s);
    return Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT));
  }


  @PostMapping("/order")
  public  Mono<ResponseEntity<Void>>createUser(@Validated @RequestBody OrderSearchParams params) {
    log.info("Inicia Creacion Reporte Orders {} ", params);
    producerService.sendReportOrder(params);
    return Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT));
  }

}
