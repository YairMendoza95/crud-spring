package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.RolBean;

public interface RolService {
	List<RolBean> getAllRoles();

	RolBean findRoleByid(RolBean role) throws NoSuchElementException;

	boolean saveRole(RolBean role);

	boolean updateRole(RolBean role);

	boolean deleteRole(RolBean role);
}
