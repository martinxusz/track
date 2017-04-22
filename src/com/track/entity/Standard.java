package com.track.entity;

/**
 * Standard entity. @author MyEclipse Persistence Tools
 */

public class Standard implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String stime;
	private String content;

	// Constructors

	/** default constructor */
	public Standard() {
	}

	/** full constructor */
	public Standard(String name, String stime, String content) {
		this.name = name;
		this.stime = stime;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStime() {
		return this.stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}