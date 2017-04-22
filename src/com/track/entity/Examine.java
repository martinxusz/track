package com.track.entity;

import java.util.Date;

/**
 * Examine entity. @author MyEclipse Persistence Tools
 */

public class Examine implements java.io.Serializable {

	// Fields

	private Integer id;
	private String person;
	private String address;
	private Date audit;
	private Integer result;
	private String standard;

	// Constructors

	/** default constructor */
	public Examine() {
	}

	/** full constructor */
	public Examine(String person, String address, Date audit, Integer result,
			String standard) {
		this.person = person;
		this.address = address;
		this.audit = audit;
		this.result = result;
		this.standard = standard;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getAudit() {
		return this.audit;
	}

	public void setAudit(Date audit) {
		this.audit = audit;
	}

	public Integer getResult() {
		return this.result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

}