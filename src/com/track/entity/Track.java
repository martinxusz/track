package com.track.entity;

/**
 * Track entity. @author MyEclipse Persistence Tools
 */

public class Track implements java.io.Serializable {

	// Fields

	private Integer id;
	private String trackId;
	private Integer pid;
	private Integer cid;

	// Constructors

	/** default constructor */
	public Track() {
	}

	/** full constructor */
	public Track(String trackId, Integer pid, Integer cid) {
		this.trackId = trackId;
		this.pid = pid;
		this.cid = cid;
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

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}