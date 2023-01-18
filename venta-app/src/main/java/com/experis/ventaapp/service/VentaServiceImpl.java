package com.experis.ventaapp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.experis.ventaapp.persistence.entity.VentaEntity;
import com.experis.ventaapp.persistence.repository.VentaRepository;
import com.experis.ventaapp.service.dto.VentaDTO;
import com.experis.ventaapp.service.exception.ServiceException;
import com.experis.ventaapp.service.service.ClienteService;
import com.experis.ventaapp.service.service.VentaService;
import com.fasterxml.jackson.databind.json.JsonMapper; 

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private JsonMapper 			jsonMapper;

	@Autowired
	private VentaRepository 	ventaRepository;
	
	@Autowired
	private ClienteService	 	clienteService;

	@Override
	public List<VentaDTO> findByLike(VentaDTO VentaDTO) throws ServiceException {
		try {
			List<VentaEntity> lstClienteEntity= ventaRepository.findAll();
			return lstClienteEntity.stream().map(e -> this.getVentaDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	// API Composite
	
	@Override
	public Optional<VentaDTO> findByIdObject(VentaDTO VentaDTO) throws ServiceException {
		try {
			//log.info("id "+VentaDTO.getId());
			Optional<VentaEntity> VentaEntity= this.ventaRepository.findById(VentaDTO.getId());
			if (VentaEntity.isPresent()) {
				//log.info("isPresent... "+VentaEntity.get());
				
				VentaDTO oVentaDTO=this.getVentaDTO(VentaEntity.get());
				if (!Objects.isNull(oVentaDTO)) {
					//oVentaDTO.setCliente(clienteService.findByIdCliente(oVentaDTO.getIdCliente())); 
				}

				 return Optional.of(oVentaDTO);
			}
			//log.info("empty... ");
			return Optional.empty();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

 
	// Mappers

	private VentaDTO getVentaDTO(VentaEntity VentaEntity) {
		return jsonMapper.convertValue(VentaEntity, VentaDTO.class);
	}

	private VentaEntity getVentaEntity(VentaDTO d) {
		return jsonMapper.convertValue(d, VentaEntity.class);
	}

	@Override
	public Optional<VentaDTO> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


 
	@Override
	public void update(VentaDTO t, Long id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public VentaDTO save(VentaDTO t) throws ServiceException {
		return this.getVentaDTO(this.ventaRepository.save(this.getVentaEntity(t)));
	}

}
