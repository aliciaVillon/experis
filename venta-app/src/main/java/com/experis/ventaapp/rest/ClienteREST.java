package com.experis.ventaapp.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experis.ventaapp.rest.util.Message;
import com.experis.ventaapp.rest.util.Response;
import com.experis.ventaapp.service.dto.ClienteDTO;
import com.experis.ventaapp.service.service.ClienteService; 
import lombok.extern.slf4j.Slf4j; 
import java.util.List;
import java.util.Optional;

import static com.experis.ventaapp.commons.GlobalConstants.COD_MSG_EXITO;
import static com.experis.ventaapp.commons.GlobalConstants.MSG_CONSULTA_EXITO;
import static com.experis.ventaapp.commons.GlobalConstants.MSG_REGISTRO_EXITO;

@Slf4j
@RestController
@RequestMapping("/cliente")
public class ClienteREST {

	private ClienteService clienteService;

	public ClienteREST(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

	@GetMapping
	public ResponseEntity<Response>  findByLike(){
		try {
			List<ClienteDTO> lstClienteDTO= this.clienteService.findByLike(null);
			if (lstClienteDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_MSG_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(lstClienteDTO)
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response>  findById(@PathVariable Long id){
		try {
			Optional<ClienteDTO> optClienteDTO= this.clienteService.findById(id);
			if (optClienteDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_MSG_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(optClienteDTO.get())
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}

	
	@PostMapping
	public ResponseEntity<Response>  save(@RequestBody ClienteDTO clienteDTO){
		try {
			ClienteDTO rClienteDTO=  this.clienteService.save(clienteDTO);
			 
			if (rClienteDTO==null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_MSG_EXITO).message(MSG_REGISTRO_EXITO).build())
					.data(rClienteDTO)
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}
	


}
