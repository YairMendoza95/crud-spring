package com.indra.bbva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
public class LocationBean {
	@Id
	@GeneratedValue(generator = "secuenciaP")
	@SequenceGenerator(name = "secuenciaP", sequenceName = "LOCATIONS_SEQ", allocationSize = 100)
	@Column(name = "LOCATION_ID")
	private int locationId;

	@Column(name = "STREET_ADDRESS")
	private String streetAddress;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE_PROVINCE")
	private String stateProvince;

	@Column(name = "COUNTRY_ID")
	private String countryId;

	public LocationBean() {
		// TODO Auto-generated constructor stub
	}

	public LocationBean(int locationId) {
		this.locationId = locationId;
	}

	public LocationBean(String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}

	public LocationBean(int locationId, String streetAddress, String postalCode, String city, String stateProvince,
			String countryId) {
		this.locationId = locationId;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountry_id(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "Locations: [ locationId: " + locationId + ", streetAddress: " + streetAddress + ", postalCode: "
				+ postalCode + ", city: " + city + ", stateProvince: " + stateProvince + ", countryId: " + countryId
				+ " ]";
	}
}
