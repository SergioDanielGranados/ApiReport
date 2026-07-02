package org.report.dto;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Data tranfer objetc  de Busqueda de Reporte Orders.
 *
 * @author SDGA
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSearchParams  implements Serializable {

  private String orderRef;
  private String orderStatus;
  private String storeName;

}
