package com.track.entity;

import java.util.Date;

/**
 * Pick entity. @author MyEclipse Persistence Tools
 */

public class Pick implements java.io.Serializable {

	// Fields

	private Integer id;
	private String picker;
	private Date pdate;
	private String address;
	private String note;
	private Integer uid;
	private String checker;
	private String standard;
	private Integer grade;
	private String content;
	private String trackId;
	private String name;

	// Constructors

	/** default constructor */
	public Pick() {
	}

	/** full constructor */
	public Pick(String picker, Date pdate, String address, String note,
			Integer uid, String checker, String standard, Integer grade,
			String content, String trackId, String name) {
		this.picker = picker;
		this.pdate = pdate;
		this.address = address;
		this.note = note;
		this.uid = uid;
		this.checker = checker;
		this.standard = standard;
		this.grade = grade;
		this.content = content;
		this.trackId = trackId;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPicker() {
		return this.picker;
	}

	public void setPicker(String picker) {
		this.picker = picker;
	}

	public Date getPdate() {
		return this.pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTrackId() {
		return this.trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}