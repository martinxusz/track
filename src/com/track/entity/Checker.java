package com.track.entity;

/**
 * Checker entity. @author MyEclipse Persistence Tools
 */

public class Checker implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String telephone;
	private String post;
	private String department;
	private String unit;

	// Constructors

	/** default constructor */
	public Checker() {
	}

	/** full constructor */
	public Checker(String name, String telephone, String post,
			String department, String unit) {
		this.name = name;
		this.telephone = telephone;
		this.post = post;
		this.department = department;
		this.unit = unit;
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

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}