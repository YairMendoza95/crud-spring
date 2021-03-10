package com.indra.bbva.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.RolBean;
import com.indra.bbva.model.UsuarioBean;
import com.indra.bbva.repository.UsuarioRepository;
import com.indra.bbva.service.RolService;
import com.indra.bbva.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolService rolService;

	@Override
	public List<UsuarioBean> getAllUsers() {
		try {
			return (List<UsuarioBean>) usuarioRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los registros");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UsuarioBean findUserByid(UsuarioBean user) throws NoSuchElementException {
		try {
			return usuarioRepository.findById(user.getNombreUsuario()).get();
		} catch (Exception e) {
			System.out.println("Error al encontrar el registro");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveUser(UsuarioBean user) {
		try {
			RolBean rol;
			if (usuarioRepository.count() > 0) {
				rol = new RolBean(user.getNombreUsuario(), "USER");
			} else {
				rol = new RolBean(user.getNombreUsuario(), "ADMIN");
			}
			usuarioRepository.save(user);
			rolService.saveRole(rol);
			return true;
		} catch (Exception e) {
			System.out.println("Error al guardar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(UsuarioBean user) {
		try {
			if (usuarioRepository.findById(user.getNombreUsuario()).isPresent()) {
				usuarioRepository.save(user);
				return true;
			} else {
				System.out.println("No se encontró el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(UsuarioBean user) {
		try {
			if (usuarioRepository.findById(user.getNombreUsuario()).isPresent()) {
				usuarioRepository.delete(user);
				return true;
			} else {
				System.out.println("No se encontró el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioBean user = usuarioRepository.findByNombreUsuario(username);
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));

		UserDetails detail = new User(user.getNombreUsuario(), user.getClave(), roles);
		return detail;
	}
}
