package org.report.controller;


import org.junit.jupiter.api.Test;
import org.report.busisness.ProducerService;
import org.report.dto.ItemSearch;
import org.report.dto.OrderSearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(controllers = ReportController.class)
public class ReportControllerTest {

  @Autowired
  private WebTestClient webTestClient;
  @MockitoBean
  private ProducerService producerService ;

  @Test
  public void sendReporUsersTest(){
    ItemSearch mensaje = new ItemSearch("mensaje");


    webTestClient.post()
        .uri("/report/item")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(mensaje) // Enviamos el payload del producto
        .exchange() // Ejecuta la petición
        .expectStatus().isNoContent()// Verifica el HTTP status 201 Created
        .expectBody() ;
  }

  @Test
  public void sendReporUserssTest(){
    ItemSearch mensaje = new ItemSearch("mensaje");


    webTestClient.post()
        .uri("/report/users")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(mensaje.getSearch()) // Enviamos el payload del producto
        .exchange() // Ejecuta la petición
        .expectStatus().isNoContent()// Verifica el HTTP status 201 Created
        .expectBody();
  }

  @Test
  public void sendReporOrdesTest(){
        OrderSearchParams mensaje = new OrderSearchParams("mensaje","mensaje","mensaje");

    webTestClient.post()
        .uri("/report/order")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(mensaje) // Enviamos el payload del producto
        .exchange() // Ejecuta la petición
        .expectStatus().isNoContent()// Verifica el HTTP status 201 Created
        .expectBody();
  }



}
