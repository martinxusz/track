package com.track.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.track.biz.IGovernmentBiz;
import com.track.entity.Checker;
import com.track.entity.Law;
import com.track.entity.Notice;
import com.track.entity.Standard;

public class GovernmentAction {
	private IGovernmentBiz governmentBiz;
	private Law law;
	private Notice notice;
	private String content1;
	private Checker checker;
	private Standard standard;
	
	//添加质量安全标准
	public String addStandard(){
		governmentBiz.addStandard(standard);
		return "success";
	}
	//查询质量安全标准
	public String standardList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		List<Standard> clist = governmentBiz.getStandard();
		request.setAttribute("clist",clist);
		return "success";
	}
	//删除质量安全标准
	public String deleteStandard(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		Standard ck = new Standard();
		ck.setId(id);
		governmentBiz.deleteStandard(ck);
		return "success";
		
	}
	
	//添加质检人员
	public String addChecker(){
		governmentBiz.addChecker(checker);
		return "success";
	}
	//查询质检人员
	public String checkerList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		List<Checker> clist = governmentBiz.getChecker();
		request.setAttribute("clist",clist);
		return "success";
	}
	//删除质检人员
	public String deleteChecker(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		Checker ck = new Checker();
		ck.setId(id);
		governmentBiz.deleteChecker(ck);
		return "success";
		
	}
	
	public String getLawByID(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		
		law = governmentBiz.getLawById(id);
		notice = governmentBiz.getNotice();
		return "success";
	}
	
	public String getLawList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		if(request.getParameter("pageNo") != null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Law> mlist = governmentBiz.getLaw(20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =governmentBiz.getLawTotal();
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Law> mlist = governmentBiz.getLaw(20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		notice = governmentBiz.getNotice();	
		return "success";
	}
	
	//更新法律法规--系统管理员
	public String updateLaw(){
		law.setContent(content1);
		law.setLdate(new Date());
		governmentBiz.updateLaw(law);
		
		return "success";
	}
	
	//加载法律法规
	public String  loadLaw(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		
		law = governmentBiz.getLawById(id);		
		return "success";
	}
	
	//删除法律法规
	public String  deleteLaw(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		Law ns  = new Law();
		ns.setId(id);
		governmentBiz.deleteLaw(ns);
		return "success";
	}
	
	//法律法规列表
	public String  lawList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		if(request.getParameter("pageNo") != null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Law> mlist = governmentBiz.getLaw(20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =governmentBiz.getLawTotal();
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Law> mlist = governmentBiz.getLaw(20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	
	//添加法律法规
	public String addLaw(){
		law.setContent(content1);
		law.setLdate(new Date());
		governmentBiz.addLaw(law);
		return "success";
	}

	public IGovernmentBiz getGovernmentBiz() {
		return governmentBiz;
	}

	public void setGovernmentBiz(IGovernmentBiz governmentBiz) {
		this.governmentBiz = governmentBiz;
	}

	public Law getLaw() {
		return law;
	}

	public void setLaw(Law law) {
		this.law = law;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public Checker getChecker() {
		return checker;
	}
	public void setChecker(Checker checker) {
		this.checker = checker;
	}
	public Standard getStandard() {
		return standard;
	}
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	
	
	
}
