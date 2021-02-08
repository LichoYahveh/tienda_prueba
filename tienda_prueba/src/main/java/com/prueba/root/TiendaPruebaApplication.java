package com.prueba.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prueba.root.entity.Producto;
import com.prueba.root.entity.Usuario;
import com.prueba.root.repository.ProductoImplement;
import com.prueba.root.repository.UsuarioImplement;

@SpringBootApplication
public class TiendaPruebaApplication implements CommandLineRunner{

	@Autowired
	private UsuarioImplement usuarioImplement;
	
	@Autowired
	private ProductoImplement productoImplement;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TiendaPruebaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Se encripta la clave del usuario
		String clave = passEncoder.encode("12345");
		
		// Objeto con datos a guardar
		Usuario u = new Usuario();
		u.setUsuario("ADMIN");
		u.setClave(clave);
		u.setCorreo("admin@gmail.com");
		u.setEstado("A");
		u.setRol("ROLE_ADMIN");
		// Se procede a guardar los datos del usuario
		usuarioImplement.save(u);

		// Objeto con datos a guardar
		Producto p1 = new Producto();
		p1.setCodigo("11111");
		p1.setNombre("VASO DC 100G");
		p1.setCantidad(500);
		p1.setPvp(3.85);
		p1.setEstado("A");
		// Se procede a guardar los datos del usuario
		productoImplement.save(p1);

		// Objeto con datos a guardar
		Producto p2 = new Producto();
		p2.setCodigo("2222");
		p2.setNombre("VASO DC 200G");
		p2.setCantidad(500);
		p2.setPvp(3.85);
		p2.setEstado("A");
		// Se procede a guardar los datos del usuario
		productoImplement.save(p2);

		// Objeto con datos a guardar
		Producto p3 = new Producto();
		p3.setCodigo("3333");
		p3.setNombre("VASO DC 150G");
		p3.setCantidad(500);
		p3.setPvp(3.85);
		p3.setEstado("A");
		// Se procede a guardar los datos del usuario
		productoImplement.save(p3);

		// Objeto con datos a guardar
		Producto p4 = new Producto();
		p4.setCodigo("4444");
		p4.setNombre("VASO MARVEL 150G");
		p4.setCantidad(500);
		p4.setPvp(3.90);
		p4.setEstado("A");
		// Se procede a guardar los datos del usuario
		productoImplement.save(p4);

		// Objeto con datos a guardar
		Producto p5 = new Producto();
		p5.setCodigo("5555");
		p5.setNombre("VASO MARVEL 100G");
		p5.setCantidad(500);
		p5.setPvp(1.90);
		p5.setEstado("A");
		// Se procede a guardar los datos del usuario
		productoImplement.save(p5);

		// Objeto con datos a guardar
		Producto p6 = new Producto();
		p6.setCodigo("666");
		p6.setNombre("VASO MARVEL 120G");
		p6.setCantidad(500);
		p6.setPvp(2.10);
		p6.setEstado("A");
		// Se procede a guardar los datos del usuario
		productoImplement.save(p6);

		// Objeto con datos a guardar
		Producto p7 = new Producto();
		p7.setCodigo("777");
		p7.setNombre("CAMISETA MARVEL VS DC");
		p7.setCantidad(500);
		p7.setPvp(9.10);
		p7.setEstado("A");
		// Se procede a guardar los datos del usuario
		productoImplement.save(p7);
		
	}

}
