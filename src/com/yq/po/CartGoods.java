package com.yq.po;

public class CartGoods {
	private Integer cartID;
	private Integer goodsID;
	private Integer memberID;
	private Integer goodsCount;

	@Override
	public String toString() {
		return "CartGoods [cartID=" + cartID + ", goodsID=" + goodsID + ", memberID=" + memberID + ", goodsCount="
				+ goodsCount + "]";
	}

	public CartGoods(Integer goodsID, Integer memberID, Integer goodsCount) {
		super();
		this.goodsID = goodsID;
		this.memberID = memberID;
		this.goodsCount = goodsCount;
	}

	public CartGoods() {
		super();
	}

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}

	public Integer getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

}
