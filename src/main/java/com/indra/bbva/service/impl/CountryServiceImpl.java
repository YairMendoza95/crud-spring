package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.CountryBean;
import com.indra.bbva.repository.CountryRepository;
import com.indra.bbva.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private final CountryRepository countryRepository;

	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@Override
	public List<CountryBean> getAllCountries() {
		try {
			return (List<CountryBean>) countryRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los países");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CountryBean findCountryByid(CountryBean country) throws NoSuchElementException {
		try {
			return countryRepository.findById(country.getCountryId()).get();
		} catch (Exception e) {
			System.out.println("Error al encontrar el registro");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveCountry(CountryBean country) {
		try {
			countryRepository.save(country);
			return true;
		} catch (Exception e) {
			System.out.println("Error al insertar el país");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCountry(CountryBean country) {
		try {
			if (countryRepository.findById(country.getCountryId()).isPresent()) {
				countryRepository.save(country);
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
	public boolean deleteCountry(CountryBean country) {
		try {
			if (countryRepository.findById(country.getCountryId()).isPresent()) {
				countryRepository.deleteById(country.getCountryId());
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
