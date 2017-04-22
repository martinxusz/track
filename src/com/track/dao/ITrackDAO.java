package com.track.dao;

import com.track.entity.*;

public interface ITrackDAO {
	public void addTrack(Track track);
	public Track getTrackByTID(String tid);
}
