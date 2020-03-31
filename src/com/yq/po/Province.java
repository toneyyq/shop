package com.yq.po;

public class Province {
	private String provinceCode;
	private String province;

	public Province() {
		super();
	}

	public Province(String provinceCode, String province) {
		super();
		this.provinceCode = provinceCode;
		this.province = province;
	}

	public Province(String province) {
		super();
		this.province = province;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Province [provinceCode=" + provinceCode + ", province=" + province + "]";
	}

}
