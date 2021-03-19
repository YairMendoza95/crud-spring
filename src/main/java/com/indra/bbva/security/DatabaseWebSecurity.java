package com.indra.bbva.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	String queryAuth = "SELECT NOMBREUSUARIO, ROL FROM ROLES WHERE NOMBREUSUARIO =?";
	String query = "SELECT NOMBREUSUARIO, CLAVE,  ACTIVO  FROM USUARIOS WHERE NOMBREUSUARIO=?";

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()).usersByUsernameQuery(query)
				.authoritiesByUsernameQuery(queryAuth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/static/**", "/imgs/**").permitAll()
				.antMatchers("/login", "/signup", "/error", "/", "/register").permitAll().antMatchers("/")
				.hasAnyAuthority("ADMIN", "USER").antMatchers("/editar/**", "/eliminar/**", "/usuarios/**")
				.hasAnyAuthority("ADMIN").anyRequest().authenticated().and().exceptionHandling()
				.accessDeniedPage("/403").and().formLogin().loginPage("/login").failureUrl("/error").permitAll().and()
				.logout().permitAll();
	}
}
