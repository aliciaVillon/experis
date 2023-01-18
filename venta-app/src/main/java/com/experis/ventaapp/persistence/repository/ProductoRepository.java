package com.experis.ventaapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.experis.ventaapp.persistence.entity.ProductoEntity; 
 
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{

}
