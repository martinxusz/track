package com.track.dao;

import java.util.List;

import com.track.entity.Standard;

public interface IStandardDAO {
	public List<Standard> getStandard();
	public void addStandard(Standard standard );
	public void deleteStandard(Standard standard );
}
