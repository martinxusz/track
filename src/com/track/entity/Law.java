package com.track.entity;

import java.util.Date;

/**
 * Law entity. @author MyEclipse Persistence Tools
 */

public class Law implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private Date ldate;
	private String organ;

	// Constructors

	/** default constructor */
	public Law() {
	}

	/** full constructor */
	public Law(String title, String content, Date ldate, String organ) {
		this.title = title;
		this.content = content;
		this.ldate = ldate;
		this.organ = organ;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getLdate() {
		return this.ldate;
	}

	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}

	public String getOrgan() {
		return this.organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

}