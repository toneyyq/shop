package com.yq.po;

import java.util.Date;

public class OrderInfo {
	private Integer orderID;
	private Integer memberID;
	private Integer goodsID;
	private Integer goodsCount;
	private Integer id;//µÿ÷∑id
	private Double orderAmount;
	private String orderPay;
	private Integer orderInvoice;
	private String orderCarry;
	private String orderRemark;
	private String orderStatus;
	private Date createDate;
	public OrderInfo() {
		super();
	}
	public OrderInfo(Integer memberID, Integer goodsID, Integer goodsCount, Integer id, Double orderAmount,
			String orderPay, Integer orderInvoice, String orderCarry, String orderRemark, String orderStatus,
			Date createDate) {
		super();
		this.memberID = memberID;
		this.goodsID = goodsID;
		this.goodsCount = goodsCount;
		this.id = id;
		this.orderAmount = orderAmount;
		this.orderPay = orderPay;
		this.orderInvoice = orderInvoice;
		this.orderCarry = orderCarry;
		this.orderRemark = orderRemark;
		this.orderStatus = orderStatus;
		this.createDate = createDate;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public Integer getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderPay() {
		return orderPay;
	}
	public void setOrderPay(String orderPay) {
		this.orderPay = orderPay;
	}
	public Integer getOrderInvoice() {
		return orderInvoice;
	}
	public void setOrderInvoice(Integer orderInvoice) {
		this.orderInvoice = orderInvoice;
	}
	public String getOrderCarry() {
		return orderCarry;
	}
	public void setOrderCarry(String orderCarry) {
		this.orderCarry = orderCarry;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "OrderInfo [orderID=" + orderID + ", memberID=" + memberID + ", goodsID=" + goodsID + ", goodsCount="
				+ goodsCount + ", id=" + id + ", orderAmount=" + orderAmount + ", orderPay=" + orderPay
				+ ", orderInvoice=" + orderInvoice + ", orderCarry=" + orderCarry + ", orderRemark=" + orderRemark
				+ ", orderStatus=" + orderStatus + ", createDate=" + createDate + "]";
	}

	
	
	

}
