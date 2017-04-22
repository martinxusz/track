package com.track.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.track.dao.IUsersDAO;
import com.track.entity.Users;

public class UsersDAO extends HibernateDaoSupport  implements IUsersDAO {
	
	public List<Users> getAllUsers(int size,int pageNo){
		List<Users> wList = new ArrayList<Users>();
		Session session = this.getSession();
		
		String hql = "from Users as ak  where ak.type>0";
		Query query = session.createQuery(hql);
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList;
	}
	public int getAllUsersTotal(){
		String hql ="select count(ak)from Users as ak where ak.type>0";
		Session session =this.getSession();		
		Query query = session.createQuery(hql);	
		
		int count = 0;
		if(query.uniqueResult()!=null){
			count = Integer.parseInt(query.uniqueResult().toString());
		}
		this.releaseSession(session);
		return count;
	}
	
	public List<Users> getUsersByType(int type, int size,int pageNo){
		List<Users> wList = new ArrayList<Users>();
		Session session = this.getSession();
		
		String hql = "from Users as ak  where ak.type =:type";
		Query query = session.createQuery(hql);
		query.setInteger("type", type);
		int firstResultIndex =size*(pageNo-1);
		query.setFirstResult(firstResultIndex);   
		query.setMaxResults(size);
		
		wList =query.list();	
		
		this.releaseSession(session);
		return wList;
	}
	public int getUsersTotalByType(int type){
		String hql ="select count(ak)from Users as ak where ak.type =:type";
		Session session =this.getSession();		
		Query query = session.createQuery(hql);			
		query.setInteger("type", type);
		
		int count = 0;
		if(query.uniqueResult()!=null){
			count = Integer.parseInt(query.uniqueResult().toString());
		}
		this.releaseSession(session);
		return count;
	}
	
	
	public void updateUsers(Users user){
		this.getHibernateTemplate().update(user);
	}
	
	public Users getUsersByName(String name){
		Users ad = null;
		String hql ="from Users as ad where ad.name=:name";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setString("name", name);		
		
		if(query.list().size()!=0){
			ad = new Users();
			ad =(Users)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad; 
	}
	public Users getUsersById(int id){
		Users ad = new Users();
		String hql ="from Users as ad where ad.id=:id";
		Session session = this.getSession();
		Query query = session.createQuery(hql);		
		query.setInteger("id",id);		
		
		if(query.list().size()!=0){
			ad =(Users)query.list().get(0);	 
		}
		this.releaseSession(session);
		return ad; 
	}
	public void addUsers(Users user ){
		this.getHibernateTemplate().save(user);
		this.getSession().flush();
		this.releaseSession(this.getSession());
	}
	public void deleteUsers(Users user ){
		this.getHibernateTemplate().delete(user);
	}
}
