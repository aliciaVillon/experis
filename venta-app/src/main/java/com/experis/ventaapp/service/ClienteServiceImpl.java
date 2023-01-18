package com.experis.ventaapp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; 
import com.experis.ventaapp.persistence.entity.ClienteEntity; 
import com.experis.ventaapp.persistence.repository.ClienteRepository;
import com.experis.ventaapp.service.dto.ClienteDTO;
import com.experis.ventaapp.service.dto.ClienteDTOResponse;
import com.experis.ventaapp.service.exception.ServiceException;
import com.experis.ventaapp.service.service.ClienteService;
import com.fasterxml.jackson.databind.json.JsonMapper;
 
@Service
public class ClienteServiceImpl implements ClienteService{
 
	private ClienteRepository clienteRepository;
	private JsonMapper jsonMapper;
	private RestTemplate 	restTemplate;
	
	
	public ClienteServiceImpl(	ClienteRepository clienteRepository,
								JsonMapper jsonMapper
									) {
		super();
		this.clienteRepository = clienteRepository;
		this.jsonMapper=jsonMapper;
	}

	@Override
	public List<ClienteDTO> findByLike(ClienteDTO t) throws ServiceException {
		try {
			List<ClienteEntity> lstClienteEntity= clienteRepository.findAll();
			return lstClienteEntity.stream().map(e -> this.getClienteDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Optional<ClienteDTO> findById(Long id) throws ServiceException {
		try {
			//log.info("id "+pedidoDTO.getId());
			Optional<ClienteEntity> rClienteEntity= this.clienteRepository.findById(id);
			if (rClienteEntity.isPresent()) { 

				 return Optional.of(this.getClienteDTO(rClienteEntity.get()));
			}
			//log.info("empty... ");
			return Optional.empty();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	// Mappers
	private ClienteDTO getClienteDTO(ClienteEntity e) {
		return jsonMapper.convertValue(e, ClienteDTO.class);
	}
	
	private ClienteEntity getClienteEntity(ClienteDTO d) {
		return jsonMapper.convertValue(d, ClienteEntity.class);
	}

	@Override
	public ClienteDTO save(ClienteDTO t) throws ServiceException {
		return this.getClienteDTO(this.clienteRepository.save(this.getClienteEntity(t)));
	}

 

	@Override
	public void deleteById(Long id) throws ServiceException {
		// TODO Auto-generated method stub 
	}

	@Override
	public void update(ClienteDTO t, Long id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<ClienteDTO> findByIdObject(ClienteDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public ClienteDTO findByIdCliente(Long id) { 
			
			// Plan A
			ResponseEntity<ClienteDTOResponse> rEClienteDTO=restTemplate.getForEntity("/cliente/"+id, ClienteDTOResponse.class);
			
			if (!Objects.isNull(rEClienteDTO)) {
				return rEClienteDTO.getBody().getData();
			}
			return getClienteDTO();  
	}
	
	private ClienteDTO getClienteDTO() {
		return ClienteDTO.
					builder().
					id(0L)
					.nombres("Cliente por definir")
					.apellidos("")
					.build();
		// Plan B
		/*
		return circuitBreaker.run(() -> {
					
				// Ok
			},
				throwable -> //Error
				// Plan C
			);
		*/
	}
}
