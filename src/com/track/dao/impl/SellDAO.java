package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.ISellDAO;
import com.track.entity.Sell;

public class SellDAO extends HibernateDaoSupport  implements ISellDAO {
	public void addSell(Sell sell) {
		this.getHibernateTemplate().save(sell);		
	}

	public void deleteSell(Sell sell) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(sell);
	}
	
	public List<Sell> getSell(int uid, int size, int pageNo) {
		// TODO Auto-generated method stub
		List<Sell> wList = new ArrayList<Sell>();
		Session session = this.getSession();
		
		String hql = "from Sell as ak where ak.uid=:uid order by ak.recordtime DESC";
		Query query = session.createQuery(hql);		
		query.setInteger("uid", uid);
		
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}
	public Sell getSellByTId(String tid) {
		// TODO Auto-generated method stub
		Sell ad = null;
		String hql ="from Sell as ad where ad.trackId=:id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setString("id", tid);	
		
		if(query.list().size()!=0){
			ad = new Sell();
			ad =(Sell)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad;
	}
	public Sell getSellById(int id) {
		// TODO Auto-generated method stub
		Sell ad = null;
		String hql ="from Sell as ad where ad.id=:id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setInteger("id", id);	
		
		if(query.list().size()!=0){
			ad = new Sell();
			ad =(Sell)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad;
	}

	public int getSellTotal(int uid) {
		// TODO Auto-generated method stub
		String hql ="select count(ak)from Sell as ak where uid=:uid";
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

	public void updateSell(Sell sell) {
		this.getHibernateTemplate().update(sell);
		
	}
}
