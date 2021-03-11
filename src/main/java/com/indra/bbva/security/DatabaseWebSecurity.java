package com.indra.bbva.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.indra.bbva.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private UsuarioService usuarioService;
	String queryAuth = "SELECT NOMBREUSUARIO, ROL FROM ROLES WHERE NOMBREUSUARIO =?";
	String query = "SELECT NOMBREUSUARIO, CLAVE,  ACTIVO  FROM USUARIOS WHERE NOMBREUSUARIO=?";

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query)
				.authoritiesByUsernameQuery(queryAuth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// Recursos estaticos sin autorizacion
				.antMatchers("/static/**", "/imagenes/**").permitAll()
				// Vistas publicas sin autorizacion/autenticacion
				.antMatchers("/**").permitAll().antMatchers("/guardar", "/usuarios/**")
				.hasAnyAuthority("ADMIN", "admin", "Admin")
				// URL que requieran autorizacion/autenticacion
				.anyRequest().authenticated()
				// login sin autorizacion/autenticacion
				.and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}
}
