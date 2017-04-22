package com.track.biz.impl;

import java.util.List;

import com.track.biz.IUsersBiz;
import com.track.dao.ICheckerDAO;
import com.track.dao.INewsDAO;
import com.track.dao.IPickDAO;
import com.track.dao.IPlaceDAO;
import com.track.dao.IProduceDAO;
import com.track.dao.IStandardDAO;
import com.track.dao.ITrackDAO;
import com.track.dao.IUsersDAO;
import com.track.entity.Checker;
import com.track.entity.Notice;
import com.track.entity.Pick;
import com.track.entity.Place;
import com.track.entity.Produce;
import com.track.entity.Standard;
import com.track.entity.Track;
import com.track.entity.Users;

public class UsersBiz implements IUsersBiz {
	private IUsersDAO usersDAO;
	private IPlaceDAO placeDAO;
	private IProduceDAO produceDAO;
	private IPickDAO pickDAO;	
	private INewsDAO newsDAO;
	private IStandardDAO standardDAO;
	private ICheckerDAO checkerDAO;
	private ITrackDAO trackDAO;
	
	public int getAllUsersTotal(){
		return usersDAO.getAllUsersTotal();
	}
	public List<Users> getAllUsers(int size,int pageNo){
		return usersDAO.getAllUsers(size, pageNo);
	}
	public List<Checker> getChecker(){
		return checkerDAO.getChecker();
	}
	public List<Standard> getStandard(){
		 return standardDAO.getStandard();
	 }
	public Notice getNotice(){
		return newsDAO.getNotice();
	}
	
	
	public void addPick(Pick pl ){
		pickDAO.addPick(pl);
	}
	public void updatePick(Pick pl){
		pickDAO.updatePick(pl);
	}
	public Pick getPickByID(int id ){
		return pickDAO.getPickByID(id);
	}
	public int getPickTotalByUid(int uid){
		return pickDAO.getPickTotalByUid(uid);
	}
	public  List<Pick> getPickByUid(int uid,int size,int pageNo){
		return pickDAO.getPickByUid(uid, size, pageNo);
	}
	
	//produce
	public Produce getProduceByTID(String tid ){
		return produceDAO.getProduceByTID(tid);
	}
	public void addProduce(Produce pl ){
		produceDAO.addProduce(pl);
	}
	public void updateProduce(Produce pl){
		produceDAO.updateProduce(pl);
	}
	public void deleteProduce(Produce pl ){
		produceDAO.deleteProduce(pl);
	}
	public  List<Produce> getProduceByUid(int uid,int size,int pageNo){
		return produceDAO.getProduceByUid(uid, size, pageNo);
	}
	public int getProduceTotalByUid(int uid){
		return produceDAO.getProduceTotalByUid(uid);
	}
	public Produce getProduceByID(int id ){
		return produceDAO.getProduceByID(id);
	}
	
	//place
	public  List<Place> getAllPlaceByUid(int uid){
		return placeDAO.getAllPlaceByUid(uid);
	}
	public void addPlace(Place pl ){
		placeDAO.addPlace(pl);
	}
	public void updatePlace(Place pl){
		placeDAO.updatePlace(pl);
	}
	public void deletePlace(Place pl ){
		placeDAO.deletePlace(pl);
	}
	public  List<Place> getPlaceByUid(int uid,int size,int pageNo){
		return placeDAO.getPlaceByUid(uid, size, pageNo);
	}
	public int getPlaceTotalByUid(int uid){
		return placeDAO.getPlaceTotalByUid(uid);
	}
	public Place getPlaceByID(int id ){
		return placeDAO.getPlaceByID(id);
	}
	public  List<Place> getPlaceByState(int state,int size,int pageNo){
		return placeDAO.getPlaceByState(state, size, pageNo);
	}
	public int getPlaceTotalByState(int state){
		return placeDAO.getPlaceTotalByState(state);
	}
	public void addTrack(Track track){
		trackDAO.addTrack(track);
	}
	public Track getTrackByTID(String tid){
		return trackDAO.getTrackByTID(tid);
	}
	
	//users
	public List<Users> getUsersByType(int type, int size,int pageNo){
		return usersDAO.getUsersByType(type, size, pageNo);
	}
	public int getUsersTotalByType(int type){
		return usersDAO.getUsersTotalByType(type);
	}
	public void updateUsers(Users user){
		usersDAO.updateUsers(user);
	}
	public Users getUsersByName(String name){
		return usersDAO.getUsersByName(name);
	}
	public Users getUsersById(int id){
		return usersDAO.getUsersById(id);
	}
	public void addUsers(Users user ){
		usersDAO.addUsers(user);
	}
	public void deleteUsers(Users user ){
		usersDAO.deleteUsers(user);
	}
	
	public IUsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(IUsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	public IPlaceDAO getPlaceDAO() {
		return placeDAO;
	}
	public void setPlaceDAO(IPlaceDAO placeDAO) {
		this.placeDAO = placeDAO;
	}
	public IProduceDAO getProduceDAO() {
		return produceDAO;
	}
	public void setProduceDAO(IProduceDAO produceDAO) {
		this.produceDAO = produceDAO;
	}
	public IPickDAO getPickDAO() {
		return pickDAO;
	}
	public void setPickDAO(IPickDAO pickDAO) {
		this.pickDAO = pickDAO;
	}


	public INewsDAO getNewsDAO() {
		return newsDAO;
	}


	public void setNewsDAO(INewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}
	public IStandardDAO getStandardDAO() {
		return standardDAO;
	}
	public void setStandardDAO(IStandardDAO standardDAO) {
		this.standardDAO = standardDAO;
	}
	public ICheckerDAO getCheckerDAO() {
		return checkerDAO;
	}
	public void setCheckerDAO(ICheckerDAO checkerDAO) {
		this.checkerDAO = checkerDAO;
	}
	public ITrackDAO getTrackDAO() {
		return trackDAO;
	}
	public void setTrackDAO(ITrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}
	
	
	
	
}
