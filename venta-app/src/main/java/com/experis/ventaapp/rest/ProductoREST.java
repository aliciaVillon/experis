package com.experis.ventaapp.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experis.ventaapp.service.dto.ClienteDTO;
import com.experis.ventaapp.service.dto.ProductoDTO;
import com.experis.ventaapp.service.service.ProductoService;

import lombok.extern.slf4j.Slf4j; 

import java.util.List;

import static com.experis.ventaapp.commons.GlobalConstants.COD_MSG_EXITO;
import static com.experis.ventaapp.commons.GlobalConstants.MSG_CONSULTA_EXITO;
import static com.experis.ventaapp.commons.GlobalConstants.MSG_REGISTRO_EXITO;


@Slf4j
@RestController
@RequestMapping("/producto")
public class ProductoREST {

	private ProductoService productoService;

	public ProductoREST(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}

 
	 
	@GetMapping
	public ResponseEntity<Response>  findByLike(){
		try {
			List<ProductoDTO> lstProductoDTO= this.productoService.findByLike(null);
			if (lstProductoDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_MSG_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(lstProductoDTO)
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}
	 
	/*
	@GetMapping
	public List<ProductoDTO>  findByLike() throws ServiceException{
		return this.productoService.findByLike(null);
	}*/
	
	@PostMapping
	public ResponseEntity<Response>  save(@RequestBody ProductoDTO  productoDTO){
		try {
			ProductoDTO rProductoDTO=  this.productoService.save(productoDTO);
			 
			if (rProductoDTO==null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_MSG_EXITO).message(MSG_REGISTRO_EXITO).build())
					.data(rProductoDTO)
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}
}
