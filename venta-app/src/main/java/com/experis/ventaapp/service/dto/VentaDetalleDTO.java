package com.experis.ventaapp.service.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
@JsonPropertyOrder(value = {"id","idVenta","idProducto","cantidad"})
public class VentaDetalleDTO extends GenericDTO{
  
	private Long id; 
	private Long idVenta; 
	private Long idProducto; 
	private ProductoDTO producto;
	private VentaDTO venta;
	private int cantidad;
}
