package com.crescendo.app.core.components;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "followup")
public class FollowUp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FOLLOWUP_ID", unique = true, nullable = false, length = 8)
	private int followUpId;
	
	@Column(name="FOLLOWUP_DATE", length = 12)
	private Date followUpDate;
	
	@Column(name="NEXT_FOLLOWUP_DATE", length = 31)
	private Date nextFollowUpDate;
	
	@Column(name="REMARKS", length = 50)
	private String remarks;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ENQUIRY_ID", nullable = false)
	private Enquiry enquiries;

	
	public int getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(int followUpId) {
		this.followUpId = followUpId;
	}

	public Date getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Date getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(Date nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public FollowUp() {
		super();
	}

	/*
	 * public FollowUp(Date followUpDate, Date nextFollowUpDate, String remarks) {
	 * super(); this.followUpDate = followUpDate; this.nextFollowUpDate =
	 * nextFollowUpDate; this.remarks = remarks; }
	 */

	
	
	public Enquiry getEnquiries() {
		return enquiries;
	}

	public FollowUp(int followUpId, Date followUpDate, Date nextFollowUpDate, String remarks, Enquiry enquiries) {
		super();
		this.followUpId = followUpId;
		this.followUpDate = followUpDate;
		this.nextFollowUpDate = nextFollowUpDate;
		this.remarks = remarks;
		this.enquiries = enquiries;
	}

	public void setEnquiries(Enquiry enquiries) {
		this.enquiries = enquiries;
	}

	@Override
	public String toString() {
		return "FollowUp [followUpId=" + followUpId + ", followUpDate=" + followUpDate + ", nextFollowUpDate="
				+ nextFollowUpDate + ", remarks=" + remarks + ", enquiries=" + enquiries + "]";
	}
	
	

}
