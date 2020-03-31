package com.yq.po;

public class City {
	private String provinceCode;
	private String cityCode;
	private String city;

	public City() {
		super();
	}

	

	public City(String provinceCode, String city) {
		super();
		this.provinceCode = provinceCode;
		this.city = city;
	}



	public String getProvinceCode() {
		return provinceCode;
	}



	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}



	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	@Override
	public String toString() {
		return "City [provinceCode=" + provinceCode + ", cityCode=" + cityCode + ", city=" + city + "]";
	}

	
	

}
