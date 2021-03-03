package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.CountryBean;

public interface CountryService {
	List<CountryBean> getAllCountries();

	CountryBean findCountryByid(CountryBean country) throws NoSuchElementException;

	boolean saveCountry(CountryBean contry);

	boolean updateCountry(CountryBean country);

	boolean deleteCountry(CountryBean country);
}
