package com.track.entity;

import java.util.Date;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer id;
	private String trackId;
	private String number;
	private String producer;
	private String name;
	private String manager;
	private String otime;
	private String note;
	private Integer uid;
	private Date recordtime;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(String trackId, String number, String producer, String name,
			String manager, String otime, String note, Integer uid,
			Date recordtime) {
		this.trackId = trackId;
		this.number = number;
		this.producer = producer;
		this.name = name;
		this.manager = manager;
		this.otime = otime;
		this.note = note;
		this.uid = uid;
		this.recordtime = recordtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTrackId() {
		return this.trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getOtime() {
		return this.otime;
	}

	public void setOtime(String otime) {
		this.otime = otime;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Date getRecordtime() {
		return this.recordtime;
	}

	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}

}