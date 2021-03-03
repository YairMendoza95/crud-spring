package com.indra.bbva.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.bbva.model.CountryBean;

public interface CountryRepository extends CrudRepository<CountryBean, String> {

}
