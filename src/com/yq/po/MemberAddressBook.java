package com.yq.po;


public class MemberAddressBook {
	private Integer id;
	private Integer memberID;
	private String memberName;
	private String memberAddress;
	private String provinceCode;
	private String cityCode;
	private String areaCode;
	private String tatus;
	private String memberTelephone;

	public MemberAddressBook() {
		super();
	}

	public MemberAddressBook(Integer memberID, String memberName, String memberAddress, String provinceCode,
			String cityCode, String areaCode, String tatus, String memberTelephone) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.provinceCode = provinceCode;
		this.cityCode = cityCode;
		this.areaCode = areaCode;
		this.tatus = tatus;
		this.memberTelephone = memberTelephone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
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

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getTatus() {
		return tatus;
	}

	public void setTatus(String tatus) {
		this.tatus = tatus;
	}

	public String getMemberTelephone() {
		return memberTelephone;
	}

	public void setMemberTelephone(String memberTelephone) {
		this.memberTelephone = memberTelephone;
	}

	@Override
	public String toString() {
		return "MemberAddressBook [id=" + id + ", memberID=" + memberID + ", memberName=" + memberName
				+ ", memberAddress=" + memberAddress + ", provinceCode=" + provinceCode + ", cityCode=" + cityCode
				+ ", areaCode=" + areaCode + ", tatus=" + tatus + ", memberTelephone=" + memberTelephone + "]";
	}
	
	
	

}
