package com.track.biz.impl;

import java.util.List;

import com.track.biz.ISystemBiz;
import com.track.dao.INewsDAO;
import com.track.entity.News;
import com.track.entity.Notice;

public class SystemBiz implements ISystemBiz {
	private INewsDAO newsDAO;
	
	public List<News> getNews(int size,int pageNo){
		return newsDAO.getNews(size, pageNo);
	}
	public int getNewsTotal(){
		return newsDAO.getNewsTotal();
	}
	public void updateNews(News news){
		newsDAO.updateNews(news);
	}
	public News getNewsById(int id){
		return newsDAO.getNewsById(id);
	}
	public void addNews(News news ){
		newsDAO.addNews(news);
	}
	public void deleteNews(News news ){
		newsDAO.deleteNews(news);
	}
	
	public Notice getNotice(){
		return newsDAO.getNotice();
	}
	public void updateNotice(Notice notice){
		newsDAO.updateNotice(notice);
	}
	
	
	public INewsDAO getNewsDAO() {
		return newsDAO;
	}
	public void setNewsDAO(INewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}
	
	
	
}
