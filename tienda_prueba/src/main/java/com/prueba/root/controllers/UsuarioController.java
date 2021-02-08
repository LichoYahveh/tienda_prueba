package com.prueba.root.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.prueba.root.entity.Usuario;
import com.prueba.root.repository.UsuarioImplement;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioImplement usuario;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@RequestMapping(value = "/principal")
	public String index() {
		return "principal_clientes";
	}

	@GetMapping(value = "/listado")
	public @ResponseBody List<Usuario> listado(Model model) {
		System.out.println("consultando lista de usuarios");
		return usuario.findAll();
	}

	@PostMapping("/save")
	public @ResponseBody String save(@RequestBody Map<String, Object> request) {
		try {
			String user = request.get("usuario").toString();
			String clave = request.get("clave").toString();
			String correo = request.get("correo").toString();
			String rol = request.get("tipo").toString();

			if (user.length() > 0 && clave.length() > 0 && correo.length() > 0 && rol.length() > 0) {
				// Se valida si el usuario existe
				Usuario u1 = usuario.findByUser(user);
				if (u1 != null) {
					return "{\"mensaje\":\"Nombre de Usuario Existente\"}";
				}
				//Se encripta la clave del usuario
				clave = passEncoder.encode(clave);
				
				// Objeto con datos a guardar
				Usuario u = new Usuario();
				u.setUsuario(user);
				u.setClave(clave);
				u.setCorreo(correo);
				u.setEstado("A");
				u.setRol(rol);
				// Se procede a guardar los datos del usuario
				usuario.save(u);
				// Validamos si el ingreso ha sido exitoso
				Usuario u2 = usuario.findByUser(user);
				if (u2 != null) {
					return "{\"mensaje\":\"Usuario Ingresado\"}";
				}
			}
			return "{\"mensaje\":\"Usuario no Ingresado\"}";

		} catch (Exception e) {
			return "{\"mensaje\":\"Error en la Operación\"}";
		}
	}

}
