package com.indra.bbva.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.bbva.model.UsuarioBean;
import com.indra.bbva.service.UsuarioService;

@Controller
public class AuthController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	private final static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@GetMapping("/login")
	public String login(Principal principal, Model model) {
		if (principal != null) {
			return "redirect:/";
		}
		model.addAttribute("title", "Inicio de sesión");
		return "auth/login";
	}

	@GetMapping("/error")
	public String error() {
		return "";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Crear cuenta");
		return "auth/register";
	}

	@PostMapping("/register")
	public String register(UsuarioBean usuario, RedirectAttributes attribute) {
		String mensaje = "";
		usuario.setClave(bcrypt.encode(usuario.getClave()));
		usuario.setActivo(1);
		LOG.info(usuario.toString());
		try {
			if (usuarioService.saveUser(usuario)) {
				mensaje = "Usuario creado";
				attribute.addFlashAttribute("msj", mensaje);
				return "redirect:/login";
			} else {
				mensaje = "No se pudo crear el usuario";
				attribute.addFlashAttribute("msj", mensaje);
				return "redirect:/register";
			}
		} catch (Exception e) {
			return "./commons/error";
		}
	}
}
