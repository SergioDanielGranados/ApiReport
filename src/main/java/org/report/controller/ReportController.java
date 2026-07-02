package org.report.controller;

import lombok.extern.slf4j.Slf4j;
import org.report.busisness.ProducerService;
import org.report.dto.ItemSearch;
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
public class ReportController {

  private final ProducerService producerService;


  @Autowired
  private ReportController(ProducerService producerService) {
    this.producerService = producerService;
  }

  /**
   * Reporte Items.
   *
   * @param s Parametro de busqueda Reporte Items.
   * @return NO_CONTENT
   */
  @PostMapping("/item")
  public  Mono<ResponseEntity<Void>>reportItem(@Validated @RequestBody ItemSearch s) {
    log.info("Inicia Creacion Reporte Item {} ", s);
    producerService.sendReportItem(s);
    return Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT));
  }

  /**
   * Reporte Orden.
   *
   * @param params  Reporte Orden parametros de busqueda.
   * @return NO_CONTENT
   */
  @PostMapping("/order")
  public  Mono<ResponseEntity<Void>> reporOrder(@Validated @RequestBody OrderSearchParams params) {
    log.info("Inicia Creacion Reporte Orders {} ", params);
    producerService.sendReportOrder(params);
    return Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT));
  }

  /**
   * Suma dos números enteros.
   *
   * @param s Parametro para desencadenar la busqueda de Usuarios para el reporte Usuarios Ordes
   * @return NO_CONTENT
   */
  @PostMapping("/users")
  public  Mono<ResponseEntity<Void>>reportUSer(@Validated @RequestBody String s) {
    log.info("Inicia Creacion Reporte Users {} ", s);
    producerService.sendReporUsers(s);
    return Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT));
  }

}
