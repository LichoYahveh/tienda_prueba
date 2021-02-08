package com.prueba.root.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prueba.root.entity.Producto;
import com.prueba.root.repository.ProductoImplement;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoImplement implement;

	@RequestMapping(value="/principal")
	public String index() {
		return "principal_productos";
	}

	@GetMapping(value = "/listado")
	public @ResponseBody List<Producto> listado(Model model) {
		return implement.findAll();
	}

	@PostMapping("/save")
	public @ResponseBody String save(@RequestBody Map<String, Object> request) {
		try {
			String codigo 	= request.get("codigo").toString();
			String nombre 	= request.get("nombre").toString();
			String cantidad = request.get("cantidad").toString();
			String pvp 		= request.get("pvp").toString();

			if (codigo.length() > 0 && nombre.length() > 0 && cantidad.length() > 0 && pvp.length() > 0) {
				// Se valida si el usuario existe
				Producto u1 = implement.findByCodigo(codigo);
				if (u1 != null) {
					return "{\"mensaje\":\"Código Existente\"}";
				}				
				// Objeto con datos a guardar
				Producto p = new Producto();
				p.setCodigo(codigo);
				p.setNombre(nombre);
				p.setCantidad(Integer.parseInt(cantidad));
				p.setPvp(Double.parseDouble(pvp));
				p.setEstado("A");
				// Se procede a guardar los datos del usuario
				implement.save(p);
				// Validamos si el ingreso ha sido exitoso
				Producto u2 = implement.findByCodigo(codigo);
				if (u2 != null) {
					return "{\"mensaje\":\"Producto Ingresado\"}";
				}
			}
			return "{\"mensaje\":\"Producto no Ingresado\"}";

		} catch (Exception e) {
			return "{\"mensaje\":\"Error en la Operación\"}";
		}
	}
}
