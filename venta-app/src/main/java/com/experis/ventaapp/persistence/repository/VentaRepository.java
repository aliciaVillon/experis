package com.experis.ventaapp.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.experis.ventaapp.persistence.entity.VentaEntity; 

@Repository
public interface VentaRepository  extends JpaRepository<VentaEntity, Long>{

	@Query("select p from VentaEntity p")
	List<VentaEntity> getAll();
	
}
