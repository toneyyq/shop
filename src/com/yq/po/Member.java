package com.yq.po;

import java.util.Date;

public class Member {
	private Integer memberID;
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private Double memberAmount;
	private String memberStatus;
	private Date createDate;

	public Member() {
		super();
	}
	
	public Member(String memberName, String memberPassword, String memberEmail, Double memberAmount,
			String memberStatus, Date createDate) {
		super();
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberAmount = memberAmount;
		this.memberStatus = memberStatus;
		this.createDate = createDate;
	}

	public Member(Integer memberID, String memberName, String memberPassword, String memberEmail, Double memberAmount,
			String memberStatus) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberAmount = memberAmount;
		this.memberStatus = memberStatus;
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

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Double getMemberAmount() {
		return memberAmount;
	}

	public void setMemberAmount(Double memberAmount) {
		this.memberAmount = memberAmount;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberName=" + memberName + ", memberPassword=" + memberPassword
				+ ", memberEmail=" + memberEmail + ", memberAmount=" + memberAmount + ", memberStatus=" + memberStatus
				+ ", createDate=" + createDate + "]";
	}
	
	

}
