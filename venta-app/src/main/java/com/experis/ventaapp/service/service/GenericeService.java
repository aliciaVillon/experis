package com.experis.ventaapp.service.service;

import java.util.List;
import java.util.Optional;

import com.experis.ventaapp.service.exception.ServiceException;
 
public interface GenericeService<T> {
	
	List<T> findByLike(T t) throws ServiceException;
	
	Optional<T> findById(Long id)throws ServiceException;
	
	T save(T t) throws ServiceException;
	
	T update(T t) throws ServiceException;

}
