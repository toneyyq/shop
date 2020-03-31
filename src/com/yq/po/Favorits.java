package com.yq.po;

public class Favorits {
	private Integer id;
	private Integer memberID;
	private Integer goodsID;

	public Favorits() {
		super();
	}

	public Favorits( Integer memberID, Integer goodsID) {
		super();
		
		this.memberID = memberID;
		this.goodsID = goodsID;
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

	public Integer getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}

	@Override
	public String toString() {
		return "Favorits [id=" + id + ", memberID=" + memberID + ", goodsID=" + goodsID + "]";
	}
	

}
