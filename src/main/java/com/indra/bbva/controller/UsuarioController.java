package com.indra.bbva.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.indra.bbva.model.UsuarioBean;
import com.indra.bbva.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	private final static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.getAllUsers());
		return "users/usuarios";
	}

	@PostMapping("/usuarios/nuevo")
	public String agregarUsuario(UsuarioBean usuario) {
		usuario.setActivo(1);
		try {
			if (usuarioService.saveUser(usuario))
				return "redirect:/usuarios";
			else {
				return "./commons/error";
			}
		} catch (Exception e) {
			return "./commons/error";
		}
	}

}
