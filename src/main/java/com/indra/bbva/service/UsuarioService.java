package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.UsuarioBean;

public interface UsuarioService {
	List<UsuarioBean> getAllUsers();

	UsuarioBean findUserByid(UsuarioBean user) throws NoSuchElementException;

	boolean saveUser(UsuarioBean user);

	boolean updateUser(UsuarioBean user);

	boolean deleteUser(UsuarioBean user);
}
