package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.RegionBean;

public interface RegionService {
	List<RegionBean> getAllRegions();

	RegionBean findRegionByid(RegionBean region) throws NoSuchElementException;

	boolean saveRegion(RegionBean region);

	boolean updateRegion(RegionBean region);

	boolean deleteRegion(RegionBean region);
}
