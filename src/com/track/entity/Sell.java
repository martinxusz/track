package com.track.entity;

import java.util.Date;

/**
 * Sell entity. @author MyEclipse Persistence Tools
 */

public class Sell implements java.io.Serializable {

	// Fields

	private Integer id;
	private Date sdate;
	private String trackId;
	private String person;
	private Integer uid;
	private String name;
	private Date recordtime;
	private String address;

	// Constructors

	/** default constructor */
	public Sell() {
	}

	/** full constructor */
	public Sell(Date sdate, String trackId, String person, Integer uid,
			String name, Date recordtime, String address) {
		this.sdate = sdate;
		this.trackId = trackId;
		this.person = person;
		this.uid = uid;
		this.name = name;
		this.recordtime = recordtime;
		this.address = address;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSdate() {
		return this.sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public String getTrackId() {
		return this.trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRecordtime() {
		return this.recordtime;
	}

	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}