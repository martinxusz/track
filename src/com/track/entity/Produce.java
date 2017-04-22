package com.track.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.track.tools.Converter;

/**
 * Produce entity. @author MyEclipse Persistence Tools
 */

public class Produce implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private Integer shelflife;
	private Date dateproduce;
	private String trackId;
	private Integer uid;
	private String weight;
	private String standards;
	private String license;
	private String storage;
	private String nutrients;
	private Integer place;
	private Integer pick;

	// Constructors

	/** default constructor */
	public Produce() {
	}

	/** full constructor */
	public Produce(String name, String type, Integer shelflife,
			Date dateproduce, String trackId, Integer uid, String weight,
			String standards, String license, String storage, String nutrients,
			Integer place, Integer pick) {
		this.name = name;
		this.type = type;
		this.shelflife = shelflife;
		this.dateproduce = dateproduce;
		this.trackId = trackId;
		this.uid = uid;
		this.weight = weight;
		this.standards = standards;
		this.license = license;
		this.storage = storage;
		this.nutrients = nutrients;
		this.place = place;
		this.pick = pick;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getShelflife() {
		return this.shelflife;
	}

	public void setShelflife(Integer shelflife) {
		this.shelflife = shelflife;
	}

	public Date getDateproduce() {
		return this.dateproduce;
	}

	public void setDateproduce(Date dateproduce) {
		this.dateproduce = dateproduce;
	} 
	
//	public void setDateproduce(String dateproduce) throws ParseException {
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		this.dateproduce = df.parse(dateproduce);
//	}

	public String getTrackId() {
		return this.trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getStandards() {
		return this.standards;
	}

	public void setStandards(String standards) {
		this.standards = standards;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getNutrients() {
		return this.nutrients;
	}

	public void setNutrients(String nutrients) {
		this.nutrients = nutrients;
	}

	public Integer getPlace() {
		return this.place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public Integer getPick() {
		return this.pick;
	}

	public void setPick(Integer pick) {
		this.pick = pick;
	}

}