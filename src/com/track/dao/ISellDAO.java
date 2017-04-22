package com.track.dao;

import java.util.List;

import com.track.entity.Sell;

public interface ISellDAO {
	public List<Sell> getSell(int uid, int size,int pageNo);
	public int getSellTotal(int uid);
	public void updateSell(Sell sell);
	public Sell getSellById(int id);
	public void addSell(Sell sell );
	public void deleteSell(Sell sell );
	
	public Sell getSellByTId(String tid);
}
