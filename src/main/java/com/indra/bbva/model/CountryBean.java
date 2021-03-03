package com.indra.bbva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class CountryBean {
	@Id
	@Column(name = "COUNTRY_ID")
	private String countryId;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@Column(name = "REGION_ID")
	private Integer regionId;

	public CountryBean() {
	}

	public CountryBean(String countryId) {
		this.countryId = countryId;
	}

	public CountryBean(String countryName, Integer regionId) {
		this.countryName = countryName;
		this.regionId = regionId;
	}

	public CountryBean(String countryId, String countryName, Integer regionId) {
		this.countryId = countryId;
		this.countryName = countryName;
		this.regionId = regionId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegion_id(Integer regionId) {
		this.regionId = regionId;
	}

	@Override
	public String toString() {
		return "Countries: [ countryId: " + countryId + ", countryName: " + countryName + ", regionId: " + regionId
				+ " ]";
	}
}
