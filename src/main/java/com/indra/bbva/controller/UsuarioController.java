package com.indra.bbva.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.bbva.model.UsuarioBean;
import com.indra.bbva.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	private final static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@GetMapping("/")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.getAllUsers());
		return "users/usuarios";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") String id) {
		return "";
	}

	@PostMapping("/guardar")
	public String guardar(UsuarioBean user) {
		return "";
	}
}
