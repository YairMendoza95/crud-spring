package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.LocationBean;
import com.indra.bbva.repository.LocationRepository;
import com.indra.bbva.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private final LocationRepository locationRepository;

	public LocationServiceImpl(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public List<LocationBean> getAllLocations() {
		try {
			return (List<LocationBean>) locationRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los registros");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LocationBean findLocationByid(LocationBean location) throws NoSuchElementException {
		try {
			return locationRepository.findById(location.getLocationId()).get();
		} catch (NoSuchElementException e) {
			System.out.println("No existe el registro");
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println("Error al consultar el registro");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveLocation(LocationBean location) {
		try {
			locationRepository.save(location);
			return true;
		} catch (Exception e) {
			System.out.println("Error al insertar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateLocations(LocationBean location) {
		try {
			if (locationRepository.findById(location.getLocationId()).isPresent()) {
				locationRepository.save(location);
				return true;
			} else {
				System.out.println("No se encontro el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteLocations(LocationBean location) {
		try {
			if (locationRepository.findById(location.getLocationId()).isPresent()) {
				locationRepository.deleteById(location.getLocationId());
				return true;
			} else {
				System.out.println("no se encontro el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar el registro");
			e.printStackTrace();
			return false;
		}
	}
}
