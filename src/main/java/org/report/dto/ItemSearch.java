/**
 *  Prueba liverpoool  ejecutada pr Sergio Granados
 */
package org.report.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Data tranfer objet  de Busqueda de Reporte Items.
 *
 * @author SDGA
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemSearch implements Serializable {

  private String search;

}
