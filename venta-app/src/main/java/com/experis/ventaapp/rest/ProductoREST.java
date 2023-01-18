package com.experis.ventaapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experis.ventaapp.persistence.entity.ProductoEntity;
import com.experis.ventaapp.service.dto.ProductoDTO;
import com.experis.ventaapp.service.exception.ServiceException;
import com.experis.ventaapp.service.service.ProductoService;

import lombok.extern.slf4j.Slf4j; 

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<Response>  findById(@PathVariable Long id){
		try {
			Optional<ProductoDTO> rProductoDTO= this.productoService.findById(id);
			if (rProductoDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_MSG_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(rProductoDTO.get())
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}
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
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		 	try {
				this.productoService.deleteById(id);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return ResponseEntity.noContent().build();
	    }
	 

		@PutMapping("/{id}")
		public ResponseEntity<?> editar(@Valid @RequestBody ProductoDTO  productoDTO, BindingResult result, @PathVariable Long id){
		 
			try {
				Optional<ProductoDTO> rProductoDTO= this.productoService.findById(id);
				
				if(!rProductoDTO.isPresent()) {
					return ResponseEntity.notFound().build();
				}
				ProductoDTO productoDTODb = rProductoDTO.get();
				productoDTODb.setNombre(productoDTO.getNombre());
				productoDTODb.setPrecio(productoDTO.getPrecio());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ResponseEntity.noContent().build();
		}
}
