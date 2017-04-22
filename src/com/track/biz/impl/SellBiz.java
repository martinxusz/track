package com.track.biz.impl;

import java.util.List;

import com.track.biz.ISellBiz;
import com.track.dao.IOrdersDAO;
import com.track.dao.ISellDAO;
import com.track.entity.Orders;
import com.track.entity.Sell;

public class SellBiz implements ISellBiz {	
	private ISellDAO sellDAO;
	private IOrdersDAO ordersDAO;
	
	public List<Orders> getOrders(int uid, int size,int pageNo){
		return ordersDAO.getOrders(uid, size, pageNo);
	}
	public int getOrdersTotal(int uid){
		return ordersDAO.getOrdersTotal(uid); 
	}
	public void updateOrders(Orders orders){
		ordersDAO.updateOrders(orders);
	}
	public Orders getOrdersById(int id){
		return ordersDAO.getOrdersById(id);
	}
	public void addOrders(Orders orders ){
		 ordersDAO.addOrders(orders);
	}
	public void deleteOrders(Orders orders ){
		ordersDAO.deleteOrders(orders);
	}
	
	public List<Sell> getSell(int uid, int size,int pageNo){
		return sellDAO.getSell(uid, size, pageNo);
	}
	public int getSellTotal(int uid){
		return sellDAO.getSellTotal(uid);
	}
	public void updateSell(Sell sell){
		sellDAO.updateSell(sell);
	}
	public Sell getSellById(int id){
		return sellDAO.getSellById(id);
	}
	public void addSell(Sell sell ){
		sellDAO.addSell(sell);
	}
	public void deleteSell(Sell sell ){
		sellDAO.deleteSell(sell);
	}
	
	public ISellDAO getSellDAO() {
		return sellDAO;
	}
	public void setSellDAO(ISellDAO sellDAO) {
		this.sellDAO = sellDAO;
	}
	public IOrdersDAO getOrdersDAO() {
		return ordersDAO;
	}
	public void setOrdersDAO(IOrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	public Orders getOrdersByTId(String tid) {
		
		return ordersDAO.getOrdersByTId(tid);
	}
	public Sell getSellByTId(String tid) {
		// TODO Auto-generated method stub
		return sellDAO.getSellByTId(tid);
	}
	
}
