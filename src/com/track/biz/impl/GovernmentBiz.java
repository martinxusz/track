package com.track.biz.impl;

import java.util.List;

import com.track.biz.IGovernmentBiz;
import com.track.dao.ICheckerDAO;
import com.track.dao.ILawDAO;
import com.track.dao.INewsDAO;
import com.track.dao.IStandardDAO;
import com.track.entity.Checker;
import com.track.entity.Law;
import com.track.entity.Notice;
import com.track.entity.Standard;

public class GovernmentBiz implements IGovernmentBiz {
	private ILawDAO lawDAO;
	private INewsDAO newsDAO;
	private IStandardDAO standardDAO;
	private ICheckerDAO checkerDAO;
	
	public void addChecker(Checker checker) {
		// TODO Auto-generated method stub
		checkerDAO.addChecker(checker);
	}
	public void addStandard(Standard standard) {
		// TODO Auto-generated method stub
		standardDAO.addStandard(standard);
	}
	public void deleteChecker(Checker checker) {
		// TODO Auto-generated method stub
		checkerDAO.deleteChecker(checker);
	}
	public void deleteStandard(Standard standard) {
		// TODO Auto-generated method stub
		standardDAO.deleteStandard(standard);
	}
	public List<Checker> getChecker() {
		// TODO Auto-generated method stub
		return checkerDAO.getChecker();
	}
	public List<Standard> getStandard() {
		// TODO Auto-generated method stub
		return standardDAO.getStandard();
	}
	public List<Law> getLaw(int size,int pageNo){
		return lawDAO.getLaw(size, pageNo);
	}
	public int getLawTotal(){
		return lawDAO.getLawTotal();
	}
	public void updateLaw(Law law){
		lawDAO.updateLaw(law);
	}
	public Law getLawById(int id){
		return lawDAO.getLawById(id);
	}
	public void addLaw(Law law ){
		lawDAO.addLaw(law);
	}
	public void deleteLaw(Law law ){
		lawDAO.deleteLaw(law);
	}	
	
	public ILawDAO getLawDAO() {
		return lawDAO;
	}
	public void setLawDAO(ILawDAO lawDAO) {
		this.lawDAO = lawDAO;
	}
	public Notice getNotice(){
		return newsDAO.getNotice();
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
	
	
	
}
