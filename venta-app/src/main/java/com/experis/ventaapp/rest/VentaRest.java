package com.experis.ventaapp.rest;

import static com.experis.ventaapp.commons.GlobalConstants.COD_MSG_EXITO;
import static com.experis.ventaapp.commons.GlobalConstants.MSG_REGISTRO_EXITO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.experis.ventaapp.rest.util.Message;
import com.experis.ventaapp.rest.util.Response;
import com.experis.ventaapp.service.dto.ProductoDTO;
import com.experis.ventaapp.service.dto.VentaDTO;
import com.experis.ventaapp.service.exception.ServiceException;
import com.experis.ventaapp.service.service.VentaService;

import lombok.extern.slf4j.Slf4j; 

@Slf4j
@RestController
@RequestMapping("/venta")
public class VentaRest {

	@Autowired
	private VentaService	ventaService;
	
	
	@GetMapping
	public ResponseEntity<?> findLike(@RequestParam(name = "nombre", defaultValue = "") String nombre){
		try {
			return ResponseEntity.ok(ventaService.findByLike(null));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		
		try {
			return ResponseEntity.ok(ventaService.findByIdObject(VentaDTO.builder().id(id).build()).get());
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@PostMapping
	public ResponseEntity<Response>  save(@RequestBody VentaDTO  productoDTO){
		try {
			VentaDTO rProductoDTO=  this.ventaService.save(productoDTO);
			 
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
	
/*	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated VentaDTO VentaDTO){
	log.info("pedidos comando [{}]",VentaDTO);
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(VentaDTO));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	*/
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Validated VentaDTO ventaDTO){
		
		return null;
	};
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		return null;
	};
	 
	
}
