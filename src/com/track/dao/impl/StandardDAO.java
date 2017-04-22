package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.IStandardDAO;
import com.track.entity.Standard;

public class StandardDAO extends HibernateDaoSupport implements IStandardDAO {
	public void addStandard(Standard standard) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(standard);
	}
	public void deleteStandard(Standard standard) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(standard);
		
	}
	public List<Standard> getStandard() {
		// TODO Auto-generated method stub
		List<Standard> wList = new ArrayList<Standard>();
		Session session = this.getSession();
		
		String hql = "from Standard as ak";
		Query query = session.createQuery(hql);		
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}
}
