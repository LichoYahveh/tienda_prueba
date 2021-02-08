package com.prueba.root.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.root.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	@Query("select u from Producto u where u.codigo = ?1")
	public Producto findByCodigo(String username);
	
}
