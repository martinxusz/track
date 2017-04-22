package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.IPlaceDAO;
import com.track.entity.Place;
import com.track.entity.Place;

public class PlaceDAO extends HibernateDaoSupport  implements IPlaceDAO {
	public void addPlace(Place pl ){
		this.getHibernateTemplate().save(pl);
	}
	public void updatePlace(Place pl){
		this.getHibernateTemplate().update(pl);
	}
	public void deletePlace(Place pl ){
		this.getHibernateTemplate().delete(pl);
	}	
	public Place getPlaceByID(int id ){
		Place ad = null;
		String hql ="from Place as ad where ad.id=:id";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setInteger("id", id);	
		
		if(query.list().size()!=0){
			ad = new Place();
			ad =(Place)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad; 
	}
	
	public  List<Place> getPlaceByUid(int uid,int size,int pageNo){
		List<Place> wList = new ArrayList<Place>();
		Session session = this.getSession();
		
		String hql = "from Place as ak  where ak.chief =:uid";
		Query query = session.createQuery(hql);
		query.setInteger("uid", uid);
		
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}
	public int getPlaceTotalByUid(int uid){
		String hql ="select count(ak)from Place as ak where ak.chief =:uid";
		Session session =this.getSession();		
		Query query = session.createQuery(hql);
		query.setInteger("uid", uid);
		
		int count = 0;
		if(query.uniqueResult()!=null){
			count = Integer.parseInt(query.uniqueResult().toString());
		}
		this.releaseSession(session);
		return count;
	}
	public  List<Place> getAllPlaceByUid(int uid){
		List<Place> wList = new ArrayList<Place>();
		Session session = this.getSession();
		
		String hql = "from Place as ak  where ak.chief =:uid";
		Query query = session.createQuery(hql);
		query.setInteger("uid", uid);		
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}	
	public  List<Place> getPlaceByState(int state,int size,int pageNo){
		List<Place> wList = new ArrayList<Place>();
		Session session = this.getSession();
		
		String hql = "from Place as ak  where ak.state =:state";
		Query query = session.createQuery(hql);
		query.setInteger("state", state);
		
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}
	public int getPlaceTotalByState(int state){
		String hql ="select count(ak)from Place as ak where ak.state =:state";
		Session session =this.getSession();		
		Query query = session.createQuery(hql);
		query.setInteger("state", state);
		
		int count = 0;
		if(query.uniqueResult()!=null){
			count = Integer.parseInt(query.uniqueResult().toString());
		}
		this.releaseSession(session);
		return count;
	}
}
