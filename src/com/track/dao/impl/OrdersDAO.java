package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.IOrdersDAO;
import com.track.entity.Orders;

public class OrdersDAO  extends HibernateDaoSupport  implements IOrdersDAO {
	public void addOrders(Orders orders) {
		this.getHibernateTemplate().save(orders);		
	}

	public void deleteOrders(Orders orders) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(orders);
	}
	
	public List<Orders> getOrders(int uid, int size, int pageNo) {
		// TODO Auto-generated method stub
		List<Orders> wList = new ArrayList<Orders>();
		Session session = this.getSession();
		
		String hql = "from Orders as ak where ak.uid=:uid order by ak.recordtime DESC";
		Query query = session.createQuery(hql);		
		query.setInteger("uid", uid);
		
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList; 
	}
	public Orders getOrdersByTId(String tid) {
		// TODO Auto-generated method stub
		Orders ad = null;
		String hql ="from Orders as ad where ad.trackId=:id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setString("id", tid);	
		
		if(query.list().size()!=0){
			ad = new Orders();
			ad =(Orders)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad;
	}
	public Orders getOrdersById(int id) {
		// TODO Auto-generated method stub
		Orders ad = null;
		String hql ="from Orders as ad where ad.id=:id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setInteger("id", id);	
		
		if(query.list().size()!=0){
			ad = new Orders();
			ad =(Orders)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad;
	}

	public int getOrdersTotal(int uid) {
		// TODO Auto-generated method stub
		String hql ="select count(ak)from Orders as ak where uid=:uid";
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

	public void updateOrders(Orders orders) {
		this.getHibernateTemplate().update(orders);
		
	}
}
