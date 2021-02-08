package com.prueba.root.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.root.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.usuario = ?1")
	public Usuario findByUser(String username);
	
}
