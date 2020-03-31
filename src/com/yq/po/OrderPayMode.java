package com.yq.po;

public class OrderPayMode {
	private Integer payID;
	private String payContent;
	private String payDesc;

	public OrderPayMode() {
		super();
	}

	public OrderPayMode(String payContent, String payDesc) {
		super();
		this.payContent = payContent;
		this.payDesc = payDesc;
	}

	public OrderPayMode(Integer payID, String payContent, String payDesc) {
		super();
		this.payID = payID;
		this.payContent = payContent;
		this.payDesc = payDesc;
	}

	public Integer getPayID() {
		return payID;
	}

	public void setPayID(Integer payID) {
		this.payID = payID;
	}

	public String getPayContent() {
		return payContent;
	}

	public void setPayContent(String payContent) {
		this.payContent = payContent;
	}

	public String getPayDesc() {
		return payDesc;
	}

	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}

	@Override
	public String toString() {
		return "OrderPayMode [payID=" + payID + ", payContent=" + payContent + ", payDesc=" + payDesc + "]";
	}
	
	

}
