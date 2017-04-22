package com.track.biz;

import java.util.List;

import com.track.entity.Orders;
import com.track.entity.Sell;

public interface ISellBiz {
	public List<Orders> getOrders(int uid, int size,int pageNo);
	public int getOrdersTotal(int uid);
	public void updateOrders(Orders orders);
	public Orders getOrdersById(int id);
	public void addOrders(Orders orders );
	public void deleteOrders(Orders orders );
	
	public List<Sell> getSell(int uid, int size,int pageNo);
	public int getSellTotal(int uid);
	public void updateSell(Sell sell);
	public Sell getSellById(int id);
	public void addSell(Sell sell );
	public void deleteSell(Sell sell );
	
	public Orders getOrdersByTId(String tid);
	public Sell getSellByTId(String tid);
}
