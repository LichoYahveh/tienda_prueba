package com.prueba.root.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.root.entity.Producto;

@Repository
public class ProductoImplement {
	
	/*@PersistenceContext
	private EntityManager entity;*/
	@Autowired
	private ProductoRepository repository;

	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Transactional
	public void save(Producto p) {
		// TODO Auto-generated method stub
		repository.save(p);
	}

	public Producto findByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return repository.findByCodigo(codigo);
	}	
	
}
