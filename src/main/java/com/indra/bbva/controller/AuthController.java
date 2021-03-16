package com.indra.bbva.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/login")
	public String login(Principal principal) {
		if (principal != null) {
			return "redirect:/";
		}
		return "auth/login";
	}

	@GetMapping("/error")
	public String error() {
		return "";
	}

	@GetMapping("/register")
	public String register() {

		return "auth/register";
	}
}
