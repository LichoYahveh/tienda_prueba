package com.prueba.root.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@PostMapping(value = "/index")
	public String index(Model model, HttpServletRequest request) {
		String valorPago = request.getParameter("valorPago");
		model.addAttribute("total", valorPago);
		return "principal_pagos";
	}
	
}
