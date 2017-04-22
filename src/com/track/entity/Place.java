package com.track.entity;

import java.util.Date;

/**
 * Place entity. @author MyEclipse Persistence Tools
 */

public class Place implements java.io.Serializable {

	// Fields

	private Integer id;
	private String pname;
	private String address;
	private Integer chief;
	private Integer state;
	private String introduce;
	private String pstandard;
	private String area;
	private String range;
	private String production;
	private Date ptime;

	// Constructors

	/** default constructor */
	public Place() {
	}

	/** full constructor */
	public Place(String pname, String address, Integer chief, Integer state,
			String introduce, String pstandard, String area, String range,
			String production, Date ptime) {
		this.pname = pname;
		this.address = address;
		this.chief = chief;
		this.state = state;
		this.introduce = introduce;
		this.pstandard = pstandard;
		this.area = area;
		this.range = range;
		this.production = production;
		this.ptime = ptime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getChief() {
		return this.chief;
	}

	public void setChief(Integer chief) {
		this.chief = chief;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPstandard() {
		return this.pstandard;
	}

	public void setPstandard(String pstandard) {
		this.pstandard = pstandard;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRange() {
		return this.range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getProduction() {
		return this.production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public Date getPtime() {
		return this.ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

}