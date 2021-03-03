package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.LocationBean;

public interface LocationService {
	List<LocationBean> getAllLocations();

	LocationBean findLocationByid(LocationBean location) throws NoSuchElementException;

	boolean saveLocation(LocationBean location);

	boolean updateLocations(LocationBean location);

	boolean deleteLocations(LocationBean location);
}
