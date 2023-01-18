package com.experis.ventaapp.service.dto;

import java.util.List;
 
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@JsonPropertyOrder(value = {"id","idCliente","fecha"})
public class VentaDTO {
  
	private Long id; 
	private Long idCliente; 
	private String fecha;
/*	private ClienteDTO cliente;
	private List<VentaDetalleDTO> ventaItems;
*/	
}
