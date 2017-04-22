package com.track.biz;

import java.util.List;

import com.track.entity.Checker;
import com.track.entity.Notice;
import com.track.entity.Pick;
import com.track.entity.Place;
import com.track.entity.Produce;
import com.track.entity.Standard;
import com.track.entity.Track;
import com.track.entity.Users;

public interface IUsersBiz {
	public List<Users> getUsersByType(int type, int size,int pageNo);
	public int getUsersTotalByType(int type);
	public void updateUsers(Users user);
	public Users getUsersByName(String name);
	public Users getUsersById(int id);
	public void addUsers(Users user );
	public void deleteUsers(Users user );
	
	public void addPlace(Place pl );
	public void updatePlace(Place pl);
	public void deletePlace(Place pl );
	public  List<Place> getPlaceByUid(int uid,int size,int pageNo);
	public int getPlaceTotalByUid(int uid);
	public Place getPlaceByID(int id );
	public  List<Place> getPlaceByState(int state,int size,int pageNo);
	public int getPlaceTotalByState(int state);
	public  List<Place> getAllPlaceByUid(int uid);
	
	public Produce getProduceByTID(String tid );
	public void addProduce(Produce pl );
	public void updateProduce(Produce pl);
	public void deleteProduce(Produce pl );
	public  List<Produce> getProduceByUid(int uid,int size,int pageNo);
	public int getProduceTotalByUid(int uid);
	public Produce getProduceByID(int id );
	
	public void addPick(Pick pl );
	public void updatePick(Pick pl);
	public Pick getPickByID(int id );
	public int getPickTotalByUid(int uid);
	public  List<Pick> getPickByUid(int uid,int size,int pageNo);
	
	public Notice getNotice();
	public List<Checker> getChecker();	
	public List<Standard> getStandard();	
	
	public int getAllUsersTotal();
	public List<Users> getAllUsers(int size,int pageNo);
	
	public void addTrack(Track track);
	public Track getTrackByTID(String tid);
}
