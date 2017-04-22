package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.IProduceDAO;
import com.track.entity.Produce;

public class ProduceDAO  extends HibernateDaoSupport implements IProduceDAO {
	public void addProduce(Produce pl ){
		this.getHibernateTemplate().save(pl);
	}
	
	public void updateProduce(Produce pl){
		this.getHibernateTemplate().update(pl);
	}
	
	public void deleteProduce(Produce pl ){
		this.getHibernateTemplate().delete(pl);
	}
	public Produce getProduceByTID(String tid ){
		Produce ad = null;
		String hql ="from Produce as ad where ad.trackId=:id";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setString("id", tid);	
		
		if(query.list().size()!=0){
			ad = new Produce();
			ad =(Produce)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad; 
	}
	public Produce getProduceByID(int id ){
		Produce ad = null;
		String hql ="from Produce as ad where ad.id=:id";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setInteger("id", id);	
		
		if(query.list().size()!=0){
			ad = new Produce();
			ad =(Produce)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad; 
	}
	
	public  List<Produce> getProduceByUid(int uid,int size,int pageNo){
		List<Produce> wList = new ArrayList<Produce>();
		Session session = this.getSession();
		
		String hql = "from Produce as ak  where ak.uid =:uid";
		Query query = session.createQuery(hql);
		query.setInteger("uid", uid);
		
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		wList = query.list();	
		
		this.releaseSession(session);
		return wList; 
	}
	
	public int getProduceTotalByUid(int uid){
		String hql ="select count(ak)from Produce as ak where ak.uid =:uid";
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
