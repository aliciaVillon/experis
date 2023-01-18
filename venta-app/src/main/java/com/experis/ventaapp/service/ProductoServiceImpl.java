package com.experis.ventaapp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.experis.ventaapp.persistence.entity.ProductoEntity;
import com.experis.ventaapp.persistence.repository.ProductoRepository;
import com.experis.ventaapp.service.dto.ProductoDTO;
import com.experis.ventaapp.service.exception.ServiceException;
import com.experis.ventaapp.service.service.ProductoService;
import com.fasterxml.jackson.databind.json.JsonMapper; 

@Service
public class ProductoServiceImpl implements ProductoService{
 
	private ProductoRepository productoRepository;
	private JsonMapper jsonMapper;
	
	public ProductoServiceImpl(	ProductoRepository productoRepository,
								JsonMapper jsonMapper
									) {
		super();
		this.productoRepository = productoRepository;
		this.jsonMapper=jsonMapper;
	}

	@Override
	public List<ProductoDTO> findByLike(ProductoDTO t) throws ServiceException {
		try {
			List<ProductoEntity> lstProductoEntity= productoRepository.findAll();
			return lstProductoEntity.stream().map(e -> this.getProductoDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Optional<ProductoDTO> findById(Long id) throws ServiceException {
		try {
			//log.info("id "+pedidoDTO.getId());
			Optional<ProductoEntity> pedidoEntity= this.productoRepository.findById(id);
			if (pedidoEntity.isPresent()) { 

				 return Optional.of(this.getProductoDTO(pedidoEntity.get()));
			}
			//log.info("empty... ");
			return Optional.empty();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	// Mappers
	private ProductoDTO getProductoDTO(ProductoEntity e) {
		return jsonMapper.convertValue(e, ProductoDTO.class);
	}
	
	private ProductoEntity getProductoEntity(ProductoDTO d) {
		return jsonMapper.convertValue(d, ProductoEntity.class);
	}

	@Override
	public ProductoDTO save(ProductoDTO t) throws ServiceException {
		return this.getProductoDTO(this.productoRepository.save(this.getProductoEntity(t)));
	}

	@Override
	public void update(ProductoDTO t, Long id) throws ServiceException {
	    Optional<ProductoEntity> optionalTask = this.productoRepository.findById(id);
	    if (optionalTask.isEmpty()) {
	        //throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
	    } 
	    this.productoRepository.save(this.getProductoEntity(t));
	}
		
		 

	@Override
   public void deleteById(Long id) {
    Optional<ProductoEntity> optionalTask = this.productoRepository.findById(id);
    if (optionalTask.isEmpty()) {
        //throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
    } 
    this.productoRepository.deleteById(id);
}
}
