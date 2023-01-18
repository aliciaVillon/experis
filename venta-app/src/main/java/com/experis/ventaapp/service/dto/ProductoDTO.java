package com.experis.ventaapp.service.dto;

import java.io.Serializable;  
import lombok.Data;

@Data
public class ProductoDTO implements Serializable{
		  
	private static final long serialVersionUID = -5263135935752033027L;
	private Long id; 
  	private String nombre;  
  	private Double precio;

}
