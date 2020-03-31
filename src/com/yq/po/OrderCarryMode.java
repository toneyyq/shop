package com.yq.po;

public class OrderCarryMode {
	private Integer carryID;
	private String carryContent;
	private String carryDay;
	private String carryDesc;

	public OrderCarryMode() {
		super();
	}

	public OrderCarryMode(String carryContent, String carryDay, String carryDesc) {
		super();
		this.carryContent = carryContent;
		this.carryDay = carryDay;
		this.carryDesc = carryDesc;
	}

	public OrderCarryMode(Integer carryID, String carryContent, String carryDay, String carryDesc) {
		super();
		this.carryID = carryID;
		this.carryContent = carryContent;
		this.carryDay = carryDay;
		this.carryDesc = carryDesc;
	}

	public Integer getCarryID() {
		return carryID;
	}

	public void setCarryID(Integer carryID) {
		this.carryID = carryID;
	}

	public String getCarryContent() {
		return carryContent;
	}

	public void setCarryContent(String carryContent) {
		this.carryContent = carryContent;
	}

	public String getCarryDay() {
		return carryDay;
	}

	public void setCarryDay(String carryDay) {
		this.carryDay = carryDay;
	}

	public String getCarryDesc() {
		return carryDesc;
	}

	public void setCarryDesc(String carryDesc) {
		this.carryDesc = carryDesc;
	}

	@Override
	public String toString() {
		return "OrderCarryMode [carryID=" + carryID + ", carryContent=" + carryContent + ", carryDay=" + carryDay
				+ ", carryDesc=" + carryDesc + "]";
	}
	
	

}
