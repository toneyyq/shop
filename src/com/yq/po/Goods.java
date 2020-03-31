package com.yq.po;

public class Goods {
	private Integer goodsID;
	private String goodsName;
	private String goodsIntroduce;
	private Double goodsNormalPrice;
	private Double goodsMemberPrice;
	private String typeCode;
	private Integer goodsNumber;
	private String isSale;
	private String isValid;
	private String goodsPicture;

	public Goods() {
		super();
	}

	public Goods(Integer goodsID, String goodsName, String goodsIntroduce, Double goodsNormalPrice,
			Double goodsMemberPrice, String typeCode, Integer goodsNumber, String isSale, String isValid,
			String goodsPicture) {
		super();
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.goodsIntroduce = goodsIntroduce;
		this.goodsNormalPrice = goodsNormalPrice;
		this.goodsMemberPrice = goodsMemberPrice;
		this.typeCode = typeCode;
		this.goodsNumber = goodsNumber;
		this.isSale = isSale;
		this.isValid = isValid;
		this.goodsPicture = goodsPicture;

	}

	public Goods(String goodsName, String goodsIntroduce, Double goodsNormalPrice, Double goodsMemberPrice,
			String typeCode, Integer goodsNumber, String isSale, String isValid, String goodsPicture) {
		super();
		this.goodsName = goodsName;
		this.goodsIntroduce = goodsIntroduce;
		this.goodsNormalPrice = goodsNormalPrice;
		this.goodsMemberPrice = goodsMemberPrice;
		this.typeCode = typeCode;
		this.goodsNumber = goodsNumber;
		this.isSale = isSale;
		this.isValid = isValid;
		this.goodsPicture = goodsPicture;

	}

	public Integer getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}

	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}

	public Double getGoodsNormalPrice() {
		return goodsNormalPrice;
	}

	public void setGoodsNormalPrice(Double goodsNormalPrice) {
		this.goodsNormalPrice = goodsNormalPrice;
	}

	public Double getGoodsMemberPrice() {
		return goodsMemberPrice;
	}

	public void setGoodsMemberPrice(Double goodsMemberPrice) {
		this.goodsMemberPrice = goodsMemberPrice;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getIsSale() {
		return isSale;
	}

	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getGoodsPicture() {
		return goodsPicture;
	}

	public void setGoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}

	@Override
	public String toString() {
		return "Goods [goodsID=" + goodsID + ", goodsName=" + goodsName + ", goodsIntroduce=" + goodsIntroduce
				+ ", goodsNormalPrice=" + goodsNormalPrice + ", goodsMemberPrice=" + goodsMemberPrice + ", typeCode="
				+ typeCode + ", goodsNumber=" + goodsNumber + ", isSale=" + isSale + ", isValid=" + isValid
				+ ", goodsPicture=" + goodsPicture + "]";
	}
	

}
