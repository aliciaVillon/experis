package com.experis.ventaapp.service.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@JsonPropertyOrder(value = {"id","nombres","apellidos","dni","telefono"})
public class ClienteDTO implements Serializable{
		  
	private static final long serialVersionUID = -9807309035903996L;
	private Long id;  
  	private String nombres; 
  	private String apellidos; 
  	private String dni; 
  	private String telefono; 
  	private String email; 

}
