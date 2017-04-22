package com.track.dao;

import java.util.List;

import com.track.entity.Orders;

public interface IOrdersDAO {
	public List<Orders> getOrders(int uid, int size,int pageNo);
	public int getOrdersTotal(int uid);
	public void updateOrders(Orders orders);
	public Orders getOrdersById(int id);
	public void addOrders(Orders orders );
	public void deleteOrders(Orders orders );
	
	public Orders getOrdersByTId(String tid);
}
