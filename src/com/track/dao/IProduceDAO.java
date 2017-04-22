package com.track.dao;

import java.util.List;

import com.track.entity.Produce;

public interface IProduceDAO {
	public void addProduce(Produce pl );
	public void updateProduce(Produce pl);
	public void deleteProduce(Produce pl );
	public  List<Produce> getProduceByUid(int uid,int size,int pageNo);
	public int getProduceTotalByUid(int uid);
	public Produce getProduceByID(int id );
	public Produce getProduceByTID(String tid );
}
