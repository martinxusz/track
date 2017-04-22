package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.ICheckerDAO;
import com.track.entity.Checker;
import com.track.entity.News;

public class CheckerDAO  extends HibernateDaoSupport  implements ICheckerDAO {	
	public void addChecker(Checker checker) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(checker);
	}
	public void deleteChecker(Checker checker) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(checker);
		
	}
	public List<Checker> getChecker() {
		// TODO Auto-generated method stub
		List<Checker> wList = new ArrayList<Checker>();
		Session session = this.getSession();
		
		String hql = "from Checker as ak";
		Query query = session.createQuery(hql);		
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}
}
