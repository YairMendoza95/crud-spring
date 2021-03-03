package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.RegionBean;
import com.indra.bbva.repository.RegionRepository;
import com.indra.bbva.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private final RegionRepository regionRepository;

	public RegionServiceImpl(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;
	}

	@Override
	public List<RegionBean> getAllRegions() {
		try {
			return (List<RegionBean>) regionRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar las regiones");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RegionBean findRegionByid(RegionBean region) throws NoSuchElementException {
		try {
			return regionRepository.findById(region.getRegionId()).get();
		} catch (Exception e) {
			System.out.println("Error al consultar el registro");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveRegion(RegionBean region) {
		try {
			regionRepository.save(region);
			return true;
		} catch (Exception e) {
			System.out.println("Error al ingresar el regsitro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRegion(RegionBean region) {
		try {
			if (regionRepository.findById(region.getRegionId()).isPresent()) {
				regionRepository.save(region);
				return true;
			} else {
				System.out.println("El registro no se encuentró");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteRegion(RegionBean region) {
		try {
			if (regionRepository.findById(region.getRegionId()).isPresent()) {
				regionRepository.deleteById(region.getRegionId());
				return true;
			} else {
				System.out.println("El registro no se encuentra");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar el regitro");
			e.printStackTrace();
			return false;
		}
	}

}
