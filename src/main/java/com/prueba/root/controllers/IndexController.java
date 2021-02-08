package com.prueba.root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba.root.repository.ProductoImplement;

@Controller
public class IndexController {
	
	@Autowired
	private ProductoImplement implement;

	@RequestMapping(value="/")
	public String index(Model model) {
		model.addAttribute("productos", implement.findAll());
		return "index";
	}
	
	
}
