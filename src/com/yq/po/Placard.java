package com.yq.po;

import java.util.Date;

public class Placard {
	private Integer placardID;
	private String placardTitle;
	private String placardContent;
	private Date issueDate;
	private Date expireDate;

	public Placard() {
		super();
	}

	public Placard(Integer placardID, String placardTitle, String placardContent, Date issueDate, Date expireDate,
			String updater, Date updateDate) {
		super();
		this.placardID = placardID;
		this.placardTitle = placardTitle;
		this.placardContent = placardContent;
		this.issueDate = issueDate;
		this.expireDate = expireDate;
	}

	public Placard(String placardTitle, String placardContent, Date issueDate, Date expireDate) {
		super();
		this.placardTitle = placardTitle;
		this.placardContent = placardContent;
		this.issueDate = issueDate;
		this.expireDate = expireDate;
	}

	public Placard(Integer placardID, String placardTitle, String placardContent, Date issueDate, Date expireDate) {
		super();
		this.placardID = placardID;
		this.placardTitle = placardTitle;
		this.placardContent = placardContent;
		this.issueDate = issueDate;
		this.expireDate = expireDate;
	}

	public Integer getPlacardID() {
		return placardID;
	}

	public void setPlacardID(Integer placardID) {
		this.placardID = placardID;
	}

	public String getPlacardTitle() {
		return placardTitle;
	}

	public void setPlacardTitle(String placardTitle) {
		this.placardTitle = placardTitle;
	}

	public String getPlacardContent() {
		return placardContent;
	}

	public void setPlacardContent(String placardContent) {
		this.placardContent = placardContent;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "Placard [placardID=" + placardID + ", placardTitle=" + placardTitle + ", placardContent="
				+ placardContent + ", issueDate=" + issueDate + ", expireDate=" + expireDate + "]";
	}
	
	

}
