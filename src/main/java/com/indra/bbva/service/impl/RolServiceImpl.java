package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.RolBean;
import com.indra.bbva.repository.RolRepository;
import com.indra.bbva.service.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepossitory;

	@Override
	public List<RolBean> getAllRoles() {
		try {
			return (List<RolBean>) rolRepossitory.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los registros");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RolBean findRoleByid(RolBean role) throws NoSuchElementException {
		try {
			return rolRepossitory.findById(role.getNombreUsuario()).get();
		} catch (Exception e) {
			System.out.println("Error al encontrar el registro");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveRole(RolBean role) {
		try {
			rolRepossitory.save(role);
			return true;
		} catch (Exception e) {
			System.out.println("Error al guardar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRole(RolBean role) {
		try {
			if (rolRepossitory.findById(role.getNombreUsuario()).isPresent()) {
				rolRepossitory.save(role);
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
	public boolean deleteRole(RolBean role) {
		try {
			if (rolRepossitory.findById(role.getNombreUsuario()).isPresent()) {
				rolRepossitory.delete(role);
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

}
