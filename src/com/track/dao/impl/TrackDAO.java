package com.track.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.ITrackDAO;
import com.track.entity.Track;

public class TrackDAO extends HibernateDaoSupport implements ITrackDAO {
	public void addTrack(Track track){
		this.getHibernateTemplate().save(track);
	}
	public Track getTrackByTID(String tid){
		Track ad = null;
		String hql ="from Track as ad where ad.trackId=:tid";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setString("tid", tid);	
		
		if(query.list().size()!=0){
			ad = new Track();
			ad =(Track)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad;
	}
}
