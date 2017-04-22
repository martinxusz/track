package com.track.dao;

import java.util.List;

import com.track.entity.Notice;
import com.track.entity.News;

public interface INewsDAO {
	public List<News> getNews(int size,int pageNo);
	public int getNewsTotal();
	public void updateNews(News news);
	public News getNewsById(int id);
	public void addNews(News news );
	public void deleteNews(News news );
	
	public Notice getNotice();
	public void updateNotice(Notice notice);
}
