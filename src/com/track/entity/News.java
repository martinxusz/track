package com.track.entity;

import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private Date ntime;
	private String author;
	private String source;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String title, String content, Date ntime, String author,
			String source) {
		this.title = title;
		this.content = content;
		this.ntime = ntime;
		this.author = author;
		this.source = source;
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

	public Date getNtime() {
		return this.ntime;
	}

	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}