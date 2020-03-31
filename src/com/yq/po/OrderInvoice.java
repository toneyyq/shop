package com.yq.po;

public class OrderInvoice {
	private Integer invoiceID;
	private String invoiceTitle;
	private String invoiceContent;
	private Double invoiceAmount;
	private Integer orderID;

	public OrderInvoice() {
		super();
	}

	public OrderInvoice(String invoiceTitle, String invoiceContent, Double invoiceAmount, Integer orderID) {
		super();
		this.invoiceTitle = invoiceTitle;
		this.invoiceContent = invoiceContent;
		this.invoiceAmount = invoiceAmount;
		this.orderID = orderID;
	}

	public OrderInvoice(Integer invoiceID, String invoiceTitle, String invoiceContent, Double invoiceAmount,
			Integer orderID) {
		super();
		this.invoiceID = invoiceID;
		this.invoiceTitle = invoiceTitle;
		this.invoiceContent = invoiceContent;
		this.invoiceAmount = invoiceAmount;
		this.orderID = orderID;
	}

	public Integer getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Integer invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return "OrderInvoice [invoiceID=" + invoiceID + ", invoiceTitle=" + invoiceTitle + ", invoiceContent="
				+ invoiceContent + ", invoiceAmount=" + invoiceAmount + ", orderID=" + orderID + "]";
	}
	

}
