package com.yq.po;


public class GoodsType {
	private Integer typeID;
	private String typeName;
	private String typeDesc;
	private String isLeaf;
	private Integer parentID;

	public GoodsType() {
		super();
	}

	

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	

	@Override
	public String toString() {
		return "GoodsType [typeID=" + typeID + ", typeName=" + typeName + ", typeDesc=" + typeDesc + ", isLeaf="
				+ isLeaf + ", parentID=" + parentID + "]";
	}

}
