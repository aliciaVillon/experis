package com.experis.ventaapp.persistence.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; 
import com.experis.ventaapp.persistence.entity.ProductoEntity; 
 
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{

}
