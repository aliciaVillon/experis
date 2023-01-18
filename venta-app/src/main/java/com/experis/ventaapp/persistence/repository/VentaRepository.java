package com.experis.ventaapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.experis.ventaapp.persistence.entity.VentaEntity; 

@Repository
public interface VentaRepository  extends JpaRepository<VentaEntity, Long>{


}
