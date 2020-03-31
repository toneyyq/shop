package com.yq.po;

public class Area {
	private String areaCode;
	private String area;
	private String cityCode;

	public Area() {
		super();
	}

	public Area(String area, String cityCode) {
		super();
		this.area = area;
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Override
	public String toString() {
		return "Area [areaCode=" + areaCode + ", area=" + area + ", cityCode=" + cityCode + "]";
	}

}
