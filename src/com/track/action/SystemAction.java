package com.track.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.track.biz.ISystemBiz;
import com.track.entity.News;
import com.track.entity.Notice;
import com.track.entity.Pick;

public class SystemAction {
	private ISystemBiz systemBiz;
	private News news;
	private Notice notice;
	private String content1;
	
	
	public String getNewsByID(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		
		news = systemBiz.getNewsById(id);
		notice = systemBiz.getNotice();	
		return "success";
	}
	
	public String getNewsList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		if(request.getParameter("pageNo") != null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<News> mlist = systemBiz.getNews(20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =systemBiz.getNewsTotal();
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<News> mlist = systemBiz.getNews(20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		notice = systemBiz.getNotice();	
		return "success";
	}
	
	//更新新闻--系统管理员
	public String updateNews(){
		news.setContent(content1);
		news.setNtime(new Date());
		systemBiz.updateNews(news);
		
		return "success";
	}
	
	//加载新闻
	public String  loadNews(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		
		news = systemBiz.getNewsById(id);		
		return "success";
	}
	
	//删除新闻
	public String  deleteNews(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		News ns  = new News();
		ns.setId(id);
		systemBiz.deleteNews(ns);
		return "success";
	}
	
	//新闻列表
	public String  newsList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		if(request.getParameter("pageNo") != null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<News> mlist = systemBiz.getNews(20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =systemBiz.getNewsTotal();
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<News> mlist = systemBiz.getNews(20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	
	//添加新闻
	public String addNews(){
		news.setNtime(new Date());
		news.setContent(content1);
		
		systemBiz.addNews(news);
		return "success";
	}	
	
	//更新公告
	public String updateNotice(){
		notice.setContent(content1);
		systemBiz.updateNotice(notice);
		notice = systemBiz.getNotice();	
		return "success";
	}
	
	//加载公告
	public String loadNotice(){
		notice = systemBiz.getNotice();		
		return "success";
	}
	//加载首页
	public String  index(){
		notice = systemBiz.getNotice();		
		return "success";
	}
	
	public ISystemBiz getSystemBiz() {
		return systemBiz;
	}
	public void setSystemBiz(ISystemBiz systemBiz) {
		this.systemBiz = systemBiz;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	
}
