package com.track.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.track.biz.ISellBiz;
import com.track.biz.IUsersBiz;
import com.track.entity.Checker;
import com.track.entity.News;
import com.track.entity.Notice;
import com.track.entity.Orders;
import com.track.entity.Pick;
import com.track.entity.Place;
import com.track.entity.Produce;
import com.track.entity.Sell;
import com.track.entity.Standard;
import com.track.entity.Track;
import com.track.entity.Users;
import com.track.tools.Converter;
import com.track.tools.Encryption;

public class UsersAction {
	private IUsersBiz usersBiz;
	private ISellBiz sellBiz;
	private  Users users;	
	private Double money;
	private String oldpassword="";
	
	private String newspassword="";
	private String message="";
	private Place place;
	private Produce produce;
	private Pick pick;
	private String content1;	
	private Notice notice;
	private String trackNumber;
	private Sell sell;
	private Orders orders;
	
	//查询追溯码
	public String selectTrack(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		Track tk  = usersBiz.getTrackByTID(trackNumber);
		String state ="";
		if(tk !=null){
			pick= usersBiz.getPickByID(tk.getCid());
			place= usersBiz.getPlaceByID(tk.getPid());
			produce = usersBiz.getProduceByTID(tk.getTrackId());
			
			sell =sellBiz.getSellByTId(tk.getTrackId());
			orders = sellBiz.getOrdersByTId(tk.getTrackId());
			notice = usersBiz.getNotice();
			state ="OK";
		}else{
			state="NO";
		}
		request.setAttribute("pick", pick);
		request.setAttribute("place", place);
		request.setAttribute("produce", produce);
		request.setAttribute("sell", sell);
		request.setAttribute("orders", orders);
		request.setAttribute("notice", notice);
		return "success";
	}
	
	//生产商管理
	public String getUsersByID(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		
		users = usersBiz.getUsersById(id);
		notice = usersBiz.getNotice();	
		return "success";
	}
	
	public String getUsersList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		if(request.getParameter("pageNo") != null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Users> mlist = usersBiz.getUsersByType(1, 20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =usersBiz.getUsersTotalByType(1);
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Users> mlist = usersBiz.getUsersByType(1, 20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		notice = usersBiz.getNotice();	
		return "success";
	} 
	
	//更新公司信息
	public String updateCompany(){
		users.setIntroduce(content1);
		usersBiz.updateUsers(users);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("users", users);
		
		return "success";
	}
	
	
	
	//pick
	public String loadPick(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		List<Standard> slist =usersBiz.getStandard();
		List<Checker> clist = usersBiz.getChecker();
		request.setAttribute("clist", clist);	
		request.setAttribute("slist", slist);	
		return "success"; 
	}
	public String addPick(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		
		pick.setUid(us.getId());		
		usersBiz.addPick(pick);	
		return "success";
	}
	public String pickList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		if(request.getParameter("pageNo") != null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Pick> mlist = usersBiz.getPickByUid(us.getId(), 20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =usersBiz.getPickTotalByUid(us.getId());
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Pick> mlist = usersBiz.getPickByUid(us.getId(), 20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	
	
	//produce
	public String loadProduce(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		
		List<Place> plist= usersBiz.getAllPlaceByUid(us.getId());
		request.setAttribute("plist", plist);
		return "success";
	}
	
	public String addProduce(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		
		
		int placeID = produce.getPlace();
		int pickID = produce.getPick();
		String place = Converter.converterNumber(placeID);
		String pick = Converter.converterNumber(pickID);
		String date = Converter.converterDate(produce.getDateproduce());
		
		String tracktemp = date+pick+place;
		
		
		Track tk = new Track();
		tk.setCid(pickID);
		tk.setPid(placeID);
		tk.setTrackId(tracktemp);
		usersBiz.addTrack(tk);
		
		produce.setTrackId(tracktemp);
		produce.setUid(us.getId());		
		usersBiz.addProduce(produce);		
		
		return "success";
	}
	
	public String produceList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		if(request.getParameter("pageNo") !=null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Produce> mlist = usersBiz.getProduceByUid(us.getId(), 20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =usersBiz.getProduceTotalByUid(us.getId());
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Produce> mlist = usersBiz.getProduceByUid(us.getId(), 20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	
	
	
	//place
	public String updatePlace(){
		place.setPtime(new Date());
		usersBiz.updatePlace(place);
		return "success";
	}
	
	public String loadPlace(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		Place pl = usersBiz.getPlaceByID(id);
		
		request.setAttribute("pl", pl);
		return "success";		
	}
	public String loadCheck(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		Place pl = usersBiz.getPlaceByID(id);
		
		request.setAttribute("pl", pl);
		return "success";		
	}
	public String check(){
		place.setState(1);
		usersBiz.updatePlace(place);
		return "success";		
	}
	public String noCheckPlace(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		if(request.getParameter("pageNo") !=null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Place> mlist = usersBiz.getPlaceByState(0,20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =usersBiz.getPlaceTotalByState(0);
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Place> mlist = usersBiz.getPlaceByState(0,20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	public String checkPlace(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		if(request.getParameter("pageNo") !=null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Place> mlist = usersBiz.getPlaceByState(1,20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =usersBiz.getPlaceTotalByState(0);
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Place> mlist = usersBiz.getPlaceByState(1,20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	public String placeList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		if(request.getParameter("pageNo") !=null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Place> mlist = usersBiz.getPlaceByUid(us.getId(), 20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =usersBiz.getPlaceTotalByUid(us.getId());
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Place> mlist = usersBiz.getPlaceByUid(us.getId(), 20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	
	public String addPlace(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		place.setChief(us.getId());
		place.setPtime(new Date());
		place.setState(0);
		
		usersBiz.addPlace(place);
		
		return "success";
	}
	//删除用户信息
	public String deleteUsers(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id").trim());
		
		Users us = new Users();
		us.setId(id);
		usersBiz.deleteUsers(us);
		
		return "success";
	}
	//加载所有的用户
	public String usersList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		if(request.getParameter("pageNo") !=null)
		{	
			int pageNo =Integer.valueOf(request.getParameter("pageNo"));			
			int pagetotal =Integer.valueOf(request.getParameter("pagetotal"));		
			if(pageNo<1)pageNo=1;if(pageNo>pagetotal)pageNo=pagetotal;
			List<Users> mlist = usersBiz.getAllUsers(20, pageNo);
						
			request.setAttribute("mlist", mlist);					
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}else{
			int pageNo =1;
			int pagetotal;		
			int totalCount =usersBiz.getAllUsersTotal();
			if(totalCount==0){
				pagetotal=0;
			}else{
				pagetotal =(totalCount-1)/20+1;	
			}			
			List<Users> mlist = usersBiz.getAllUsers(20, pageNo);
			
			request.setAttribute("mlist", mlist);							
			request.setAttribute("pageNo",pageNo);			
			request.setAttribute("pagetotal", pagetotal);
		}
		return "success";
	}
	//更新密码
	public String updatePassword(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users us = (Users)session.getAttribute("users");
		oldpassword = Encryption.encryptToMD5(oldpassword);
		if(oldpassword.equals(us.getPassword())){
			newspassword=Encryption.encryptToMD5(newspassword);
			us.setPassword(newspassword);
			usersBiz.updateUsers(us);
			session.setAttribute("users", us);
			request.setAttribute("state", "更新密码成功");
		}else{
			request.setAttribute("state", "更新失败");
		}
		return "success";
	}	
	
	//登录
	public String login(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String currentValidateCode=request.getParameter("vCode");
		currentValidateCode=currentValidateCode.toLowerCase();
		
		String validateCode=(String)session.getAttribute("validateCode");
		validateCode =validateCode.toLowerCase();
		System.out.println(validateCode);
		if(currentValidateCode.equals(validateCode)){
//			String password=Encryption.encryptToMD5(users.getPassword());
			String password=users.getPassword();
			Users us = usersBiz.getUsersByName(users.getName());	
			if(us==null){
				request.setAttribute("state", "用户名输入不正确！");
				return "input";
			}else{
				if(us.getPassword().equals(password)){
					session.setAttribute("users", us);
					return "success";
				}else{
					request.setAttribute("message", "密码输入不正确！");
					return "input";
				}
			}
		}else{
			request.setAttribute("message", "验证码输入不正确！");
			return "input";
		}			
	}
	
	//注册
	public String regist(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session =ServletActionContext.getRequest().getSession();
		if(usersBiz.getUsersByName(users.getName())!=null){
			request.setAttribute("state", "用户名已经存在！");
			notice = usersBiz.getNotice();	
			return "input";				
		}else{
			users.setIntroduce(content1);
			usersBiz.addUsers(users);
			Users us = usersBiz.getUsersByName(users.getName());
			session.setAttribute("users", us);		
			return "success";
		}
		
	}
	
	//退出
	public String exit(){
		HttpSession session =ServletActionContext.getRequest().getSession();
		if(session.getAttribute("users")!=null){
			session.removeAttribute("users");  
		}
		return "success";
	}

	public IUsersBiz getUsersBiz() {
		return usersBiz;
	}

	public void setUsersBiz(IUsersBiz usersBiz) {
		this.usersBiz = usersBiz;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}


	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewspassword() {
		return newspassword;
	}

	public void setNewspassword(String newspassword) {
		this.newspassword = newspassword;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Place getPlace() {
		return place;
	}


	public void setPlace(Place place) {
		this.place = place;
	}


	public Produce getProduce() {
		return produce;
	}


	public void setProduce(Produce produce) {
		this.produce = produce;
	}
	public Pick getPick() {
		return pick;
	}
	public void setPick(Pick pick) {
		this.pick = pick;
	}
	
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}

	public ISellBiz getSellBiz() {
		return sellBiz;
	}

	public void setSellBiz(ISellBiz sellBiz) {
		this.sellBiz = sellBiz;
	}

	public Sell getSell() {
		return sell;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
	
	
	
}
