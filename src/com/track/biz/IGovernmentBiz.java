package com.track.biz;

import java.util.List;

import com.track.entity.Checker;
import com.track.entity.Law;
import com.track.entity.Notice;
import com.track.entity.Standard;

public interface IGovernmentBiz {
	public List<Law> getLaw(int size,int pageNo);
	public int getLawTotal();
	public void updateLaw(Law law);
	public Law getLawById(int id);
	public void addLaw(Law law );
	public void deleteLaw(Law law );
	public Notice getNotice();
	public List<Checker> getChecker();
	public void addChecker(Checker checker );
	public void deleteChecker(Checker checker );
	public List<Standard> getStandard();
	public void addStandard(Standard standard );
	public void deleteStandard(Standard standard );
}
