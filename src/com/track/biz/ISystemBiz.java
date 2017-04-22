package com.track.biz;

import java.util.List;

import com.track.entity.News;
import com.track.entity.Notice;

public interface ISystemBiz {
	public List<News> getNews(int size,int pageNo);
	public int getNewsTotal();
	public void updateNews(News news);
	public News getNewsById(int id);
	public void addNews(News news );
	public void deleteNews(News news );
	
	public Notice getNotice();
	public void updateNotice(Notice notice);
}
