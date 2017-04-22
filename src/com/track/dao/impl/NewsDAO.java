package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.INewsDAO;
import com.track.entity.News;
import com.track.entity.Notice;

public class NewsDAO extends HibernateDaoSupport implements INewsDAO {

	public void addNews(News news) {
		this.getHibernateTemplate().save(news);		
	}

	public void deleteNews(News news) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(news);
	}

	public List<News> getNews(int size, int pageNo) {
		// TODO Auto-generated method stub
		List<News> wList = new ArrayList<News>();
		Session session = this.getSession();
		
		String hql = "from News as ak order by ak.ntime DESC";
		Query query = session.createQuery(hql);		
		
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}

	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		News ad = null;
		String hql ="from News as ad where ad.id=:id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setInteger("id", id);	
		
		if(query.list().size()!=0){
			ad = new News();
			ad =(News)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad;
	}

	public int getNewsTotal() {
		// TODO Auto-generated method stub
		String hql ="select count(ak)from News as ak";
		Session session =this.getSession();		
		Query query = session.createQuery(hql);
		
		int count = 0;
		if(query.uniqueResult()!=null){
			count = Integer.parseInt(query.uniqueResult().toString());
		}
		this.releaseSession(session);
		return count;
	}

	public Notice getNotice() {
		Notice ad = null;
		String hql ="from Notice as ad ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		
		if(query.list().size()!=0){
			ad = new Notice();
			ad =(Notice)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad;
	}

	public void updateNews(News news) {
		this.getHibernateTemplate().update(news);
		
	}

	public void updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(notice);
	}
	
}
