package com.experis.ventaapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "detalleVenta")
public class VentaDetalleEntity implements Serializable{
		   
		private static final long serialVersionUID = 904202428069814207L;

		@Id
	  	@Column(name = "ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	  
	  	@NotNull()
	  	@Column(name = "ID_VENTA")
	  	private Long idVenta; 
	  	
		@NotNull()
	  	@Column(name = "ID_PRODUCTO")
	  	private Long idProducto; 
		
	  	@NotNull()
	  	@Column(name = "CANTIDAD")
	  	private int cantidad;


}
