package com.indra.bbva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.indra.bbva.repository.RolRepository;
import com.indra.bbva.repository.UsuarioRepository;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RolRepository rolRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		usuarioRepository.findAll().forEach(System.out::println);
	}
}
