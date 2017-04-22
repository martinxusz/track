package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.IPickDAO;
import com.track.entity.Pick;

public class PickDAO extends HibernateDaoSupport   implements IPickDAO {
	public void addPick(Pick pl ){
		this.getHibernateTemplate().save(pl);
	}
	public void updatePick(Pick pl){
		this.getHibernateTemplate().update(pl);
	}
	public void deletePick(Pick pl ){
		this.getHibernateTemplate().delete(pl);
	}
	public Pick getPickByID(int id ){
		Pick ad = null;
		String hql ="from Pick as ad where ad.id=:id";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setInteger("id", id);	
		
		if(query.list().size()!=0){
			ad = new Pick();
			ad =(Pick)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad; 
	}
	
	public  List<Pick> getPickByUid(int uid,int size,int pageNo){
		List<Pick> wList = new ArrayList<Pick>();
		Session session = this.getSession();
		
		String hql = "from Pick as ak  where ak.uid =:uid";
		Query query = session.createQuery(hql);
		query.setInteger("uid", uid);
		
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}
	public int getPickTotalByUid(int uid){
		String hql ="select count(ak)from Pick as ak where ak.uid =:uid";
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
}
