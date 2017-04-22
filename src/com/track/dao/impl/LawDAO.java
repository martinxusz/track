package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.ILawDAO;
import com.track.entity.Law;
import com.track.entity.Law;

public class LawDAO extends HibernateDaoSupport implements ILawDAO {
	public void addLaw(Law law) {
		this.getHibernateTemplate().save(law);		
	}

	public void deleteLaw(Law law) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(law);
	}

	public List<Law> getLaw(int size, int pageNo) {
		// TODO Auto-generated method stub
		List<Law> wList = new ArrayList<Law>();
		Session session = this.getSession();
		
		String hql = "from Law as ak order by ak.ldate DESC";
		Query query = session.createQuery(hql);		
		
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}

	public Law getLawById(int id) {
		// TODO Auto-generated method stub
		Law ad = null;
		String hql ="from Law as ad where ad.id=:id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setInteger("id", id);	
		
		if(query.list().size()!=0){
			ad = new Law();
			ad =(Law)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad;
	}

	public int getLawTotal() {
		// TODO Auto-generated method stub
		String hql ="select count(ak)from Law as ak";
		Session session =this.getSession();		
		Query query = session.createQuery(hql);
		
		int count = 0;
		if(query.uniqueResult()!=null){
			count = Integer.parseInt(query.uniqueResult().toString());
		}
		this.releaseSession(session);
		return count;
	}

	public void updateLaw(Law law) {
		this.getHibernateTemplate().update(law);
		
	}

}
