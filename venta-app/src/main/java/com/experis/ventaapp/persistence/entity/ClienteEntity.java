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
@Table(name = "cliente")
public class ClienteEntity implements Serializable{
		  
	private static final long serialVersionUID = -2170897015344177815L;

		@Id
	  	@Column(name = "ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	  
	  	@NotNull(message = "Nombre del cliente es requerido")
	  	@Column(name = "NOMBRES")
	  	private String nombres;
	  	
	  	@NotNull(message = "Apellido del cliente es requerido") 
	  	@Column(name = "APELLIDOS")
	  	private String apellidos;
	  	
	  	@NotNull(message = "DNI del cliente es requerido") 
	  	@Column(name = "DNI")
	  	private String dni;

	  	@Column(name = "TELEFONO")
	  	private String telefono;

	  	@Column(name = "EMAIL")
	  	private String email; 

}
