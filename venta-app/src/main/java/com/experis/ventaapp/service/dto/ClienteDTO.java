package com.experis.ventaapp.service.dto;

import java.io.Serializable; 
import lombok.Data;

@Data
public class ClienteDTO implements Serializable{
		  
	private static final long serialVersionUID = -9807309035903996L;
	private Long id;  
  	private String nombres; 
  	private String apellidos; 
  	private String dni; 
  	private String telefono; 
  	private String email; 

}
