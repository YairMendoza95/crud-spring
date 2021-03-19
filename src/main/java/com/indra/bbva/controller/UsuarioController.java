package com.indra.bbva.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.bbva.model.RolBean;
import com.indra.bbva.model.UsuarioBean;
import com.indra.bbva.service.RolService;
import com.indra.bbva.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RolService rolService;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	private final static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("usuarios", usuarioService.getAllUsers());
		model.addAttribute("title", "Usuarios");
		return "users/usuarios";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") String id, Model model) {
		UsuarioBean user = usuarioService.findUserByid(new UsuarioBean(id));

		model.addAttribute("title", "Editar usuario");
		model.addAttribute("user", user);

		return "users/edit_user";
	}

	@GetMapping("/crear")
	public String crear(UsuarioBean user, Model model) {
		model.addAttribute("title", "Crear usuario");
		return "users/add_user_auth";
	}

	@PostMapping("/guardar")
	public String guardar(UsuarioBean user, RolBean rol, RedirectAttributes attributes) {
		user.setClave(bcrypt.encode(user.getClave()));
		if (usuarioService.updateUser(user) && rolService.updateRole(rol)) {
			attributes.addFlashAttribute("msj", "Usuario actualizado");
			return "redirect:/usuarios";
		} else {
			attributes.addFlashAttribute("msj", "Usuario no actilizado");
			return "redirect:/usuarios";
		}
	}

	@PostMapping("/nuevo")
	public String nuevo(UsuarioBean user, RolBean rol, RedirectAttributes attributes) {
		user.setClave(bcrypt.encode(user.getClave()));
		if (usuarioService.saveUser(user) && rolService.saveRole(rol)) {
			attributes.addFlashAttribute("msj", "Usuario actualizado");
			return "redirect:/usuarios";
		} else {
			attributes.addFlashAttribute("msj", "Usuario no actilizado");
			return "redirect:/usuarios";
		}
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") String id, Model model) {
		rolService.deleteRole(new RolBean(id));
		usuarioService.deleteUser(new UsuarioBean(id));
		return "redirect:/usuarios";
	}
}
