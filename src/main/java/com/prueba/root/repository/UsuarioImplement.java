package com.prueba.root.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.root.entity.Usuario;

@Repository
public class UsuarioImplement {
	
	/*@PersistenceContext
	private EntityManager entity;*/
	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Transactional
	public void save(Usuario u) {
		// TODO Auto-generated method stub
		repository.save(u);
	}

	public Usuario findByUser(String username) {
		// TODO Auto-generated method stub
		return repository.findByUser(username);
	}

	
	
}
