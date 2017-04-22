package com.track.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.track.biz.ISellBiz;
import com.track.entity.Orders;
import com.track.entity.Sell;
import com.track.entity.Users;

public class SellAction {
	private ISellBiz sellBiz;
	private Sell sell;
	private Orders orders;
	
	//添加销售记录
	public String addSell(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		sell.setUid(us.getId());
		sell.setRecordtime(new Date());
		sellBiz.addSell(sell);		
		return "success";
	}
	//查询销售记录
	public String sellList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		if(request.getParameter("pageNo") != null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Sell> mlist = sellBiz.getSell(us.getId(), 20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =sellBiz.getSellTotal(us.getId());
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Sell> mlist = sellBiz.getSell(us.getId(), 20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	//删除销售记录
	public String deleteSell(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		Sell ck = new Sell();
		ck.setId(id);
		sellBiz.deleteSell(ck);
		return "success";
		
	}
	
	//添加产品订单
	public String addOrder(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		orders.setUid(us.getId());
		orders.setRecordtime(new Date());
		sellBiz.addOrders(orders);		
		return "success";
	}
	//查询产品订单
	public String orderList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		if(request.getParameter("pageNo") != null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Orders> mlist = sellBiz.getOrders(us.getId(), 20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =sellBiz.getOrdersTotal(us.getId());
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Orders> mlist = sellBiz.getOrders(us.getId(), 20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	//删除产品订单
	public String deleteOrder(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		Orders ck = new Orders();
		ck.setId(id);
		sellBiz.deleteOrders(ck);
		return "success";
		
	}
	
	public ISellBiz getSellBiz() {
		return sellBiz;
	}
	public void setSellBiz(ISellBiz sellBiz) {
		this.sellBiz = sellBiz;
	}
	public Sell getSell() {
		return sell;
	}
	public void setSell(Sell sell) {
		this.sell = sell;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
	
}
