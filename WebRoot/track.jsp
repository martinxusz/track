<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>农产品质量安全追溯系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<style>
.right table{
	align:center;   
    width:100%;   
    border-collapse:collapse; 
}
.right table td{
 text-align:center;   
	height:35px;
    border:1px solid #b4a5c6;   
}
</style>
<script type="text/javascript" language="javascript">
function checkNumber(){
	var number = document.getElementById("trackNumber").value;
	var patrn=/^[0-9]{1,16}$/; 
	
	if(number ==null ||number ==""){
		alert("追溯码不为空！");
		return false;
	}else if(number.length!=16){
		alert("追溯码为16位！");
		return false;
	}else if (!patrn.exec(number)) {
		alert("追溯码为数字！");
		return false;
	}else{
		return true;
	}
}
function checkLogin(){
		var name = document.getElementById("name").value;
		var password = document.getElementById("password").value;
		var vCode = document.getElementById("vCode").value;		
		if(name ==null ||name ==""){
			alert("用户名不为空！");
			return false;
		}else if(password ==null ||password ==""){
			alert("密码不为空！");
			return false;
		}else if(vCode==null || vCode ==""){
			alert("验证码不为空！");
			return false;
		}else{
			return true;
		}
	}		
	function reloadVerifyCode(){
	     var timenow = new Date().getTime();                      
        document.getElementById("validateCode").src="<%=request.getContextPath()%>/validateCode?date="+timenow;
	}		
</script>

</head>
<body>
<div class="zhong">  
  <div class="banner"><img src="images/img_2.gif" /></div>
  <div class="menu">
    <div class="menusel" style="width:95px;">
      <h2><a href="index.action">首页</a></h2>
    </div>
    <div id="menu1" class="menusel">
      <h2><a href="getLawList.action">法律法规</a></h2>
      <div class="position">
        <ul class="clearfix typeul">                
        </ul>
      </div>
    </div>
    <div id="menu2" class="menusel">
      <h2><a href="getNewsList.action">新闻中心</a></h2>
      <div class="position">
        <ul class="clearfix typeul">
        </ul>
      </div>
    </div>
    <div id="menu3" class="menusel">
      <h2><a href="getUsersList.action">农产品生产商</a></h2>
      <div class="position">
        <ul class="clearfix typeul">        
        </ul>
      </div>
    </div>  
  </div>
  <div class="main">
    <div class="left">
      <div class="box_1">
        <div class="left_title">会员中心</div>
		<form action="login.action" method="post" name="login" onsubmit="return checkLogin()" >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="32%" height="37" valign="middle">用户名：</td>
            <td width="68%" valign="middle">
              <input type="text" name="users.name" id="name" class="input_1"/>
            </td>
          </tr>
          <tr>
            <td height="37" valign="middle">密　码：</td>
            <td valign="middle">
              <input type="password" name="users.password" id="password" class="input_2"/>
            </td>
          </tr>
          <tr>
            <td height="37" valign="middle">验证码：</td>
            <td valign="middle">
              <input type="text" name="vCode" id="vCode" class="input_3"/>
             <a href="javascript:reloadVerifyCode();" ><img style="margin:0px;padding:0px;border:0px;" alt="验证码" id="validateCode" src="<%=request.getContextPath()%>/validateCode" />
							</a></td>
          </tr>
          <tr>
            <td colspan="2">
              <input name="input" type="submit" value=" 登 录 "/>
              &nbsp;&nbsp;<a href="regist.jsp">免费注册</a>
            </td>
          </tr>
		 <tr>
            <td colspan="2" style="color:red; font-weight: bold;">              
            </td>
          </tr>
        </table>
		</form>
      </div>
      <div class="box_1">
        <div class="left_title">本站公告</div>
        <div class="left_nr">
          ${requestScope.notice.content}
        </div>
      </div>
     
    </div>
    <div class="right">
      <div class="right_top_img"></div>     
    <form action="selectTrack.action" method="post" onsubmit="return checkNumber()">
	<div class="news">
	<c:set value="${requestScope.produce}" var="produce"></c:set>
	<c:set value="${requestScope.pick}" var="pick"></c:set>
	<c:set value="${requestScope.place}" var="place"></c:set>
	<c:set value="${requestScope.sell}" var="sell"></c:set>
	<c:set value="${requestScope.orders}" var="orders"></c:set>
        <div class="news_title"><span>请输入追溯码：</span><input type="text" name="trackNumber"  id="trackNumber" /> <input type="submit"  value="追溯查询"/></div>
        <c:if test="${requestScope.state==OK}">        
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="48%" colspan="4" height="24">产品信息</td>            
          </tr>
			 <tr>
					    <td nowrap align="right" width="13%">产品名称:</td>
					    <td width="33%"><span class="red">
					      ${produce.name }
				        </span></td>
					    <td align="right" width="19%">产品类型：</td>
					    <td width="35%">${produce.type}
				        </td>
					    </tr>

					    <tr>
					    <td nowrap align="right" width="13%">保质期:</td>
					    <td width="33%"><span class="red">
					     ${produce.shelflife}个月
				        </span></td>
					    <td align="right" width="19%">生产日期：</td>
					    <td width="35%">${produce.dateproduce }</td>
					    </tr> 	
<tr>
					    <td nowrap align="right" width="13%">生产标准:</td>
					    <td width="33%"><span class="red">
					      ${produce.standards}
				        </span></td>
					    <td align="right" width="19%">生产许可证号：</td>
					    <td width="35%">${produce.license}</td>
					    </tr> 
<tr>
					    <td nowrap align="right" width="13%">储藏方法:</td>
					    <td width="33%"><span class="red">
					       ${produce.storage }
				        </span></td>
					    <td align="right" width="19%">营养成分：</td>
					    <td width="35%">${produce.nutrients }</td>
					    </tr> 
 <tr>
					    <td nowrap align="right" width="13%">净重量：</td>
					    <td width="33%"><span class="red">
					       ${produce.weight }
				        </span></td>
					    <td align="right" width="19%"></td>
					    <td width="35%"></td>
					    </tr> 



<tr>
            <td width="48%" colspan="4" height="24">采摘记录</td>          
          </tr>  
<tr>
					    <td nowrap align="right" width="13%">采摘人员：</td>
					    <td width="33%"><span class="red">
					       ${pick.picker }
				        </span></td>
					    <td align="right" width="19%">采摘日期:：</td>
					    <td width="35%">${pick.pdate }
				        </td>
					    </tr>

					    <tr>
					    <td nowrap align="right" width="13%">检验员:</td>
					    <td width="33%"><span class="red">
					      ${pick.pdate }
				        </span></td>
					    <td align="right" width="19%">采摘基地：</td>
					    <td width="35%">${pick.checker }</td>
					    </tr> 

<tr>
					    <td nowrap align="right" width="13%">检验标准:</td>
					    <td width="33%"><span class="red">${pick.standard }					       
				        </span></td>
					    <td align="right" width="19%">产品等级：</td>
					    <td width="35%">${pick.grade } </td>
					    </tr> 
<tr>
            <td width="48%" colspan="4" height="24">产地信息</td>          
          </tr>  
 <tr>
					    <td nowrap align="right" width="13%">产地名称:</td>
					    <td width="33%"><span class="red">
					      ${place.pname }
				        </span></td>
					    <td align="right" width="19%">产地面积：</td>
					    <td width="35%">${place.area }
				        </td>
					    </tr>

					    <tr>
					    <td nowrap align="right" width="13%">详细地址:</td>
					    <td width="33%"><span class="red">
					       ${place.address }
				        </span></td>
					    <td align="right" width="19%">种植范围：</td>
					    <td width="35%">${place.range}</td>
					    </tr> 
							
						<tr>
					    <td nowrap align="right" width="13%">执行标准:</td>
					    <td width="33%"><span class="red">
					       ${place.pstandard }
				        </span></td>
					    <td align="right" width="19%">预计产量：</td>
					    <td width="35%">${place.production }</td>
					    </tr> 
<tr>
            <td width="48%" colspan="4" height="24">订购信息</td>          
          </tr> 
 <tr>
					    <td nowrap align="right" width="13%">订单编号:</td>
					    <td width="33%"><span class="red">
					      ${orders.number }
				        </span></td>
					    <td align="right" width="19%">交易负责人：</td>
					    <td width="35%">${orders.manager}
				        </td>
					    </tr>
 <tr>
					    <td nowrap align="right" width="13%">交易时间:</td>
					    <td width="33%"><span class="red">
					      ${orders.otime }
				        </span></td>
					    <td align="right" width="19%"></td>
					    <td width="35%">
				        </td>
					    </tr>
<tr>
            <td width="48%" colspan="4" height="24">销售信息</td>          
          </tr> 
 <tr>
					    <td nowrap align="right" width="13%">销售地点:</td>
					    <td width="33%"><span class="red">
					      ${sell.address }
				        </span></td>
					    <td align="right" width="19%">负责人：</td>
					    <td width="35%">${sell.person}
				        </td>
					    </tr>
 <tr>
					    <td nowrap align="right" width="13%">销售时间:</td>
					    <td width="33%"><span class="red">
					      ${sell.sdate }
				        </span></td>
					    <td align="right" width="19%"></td>
					    <td width="35%">
				        </td>
					    </tr>
        </table>
		</c:if>
		<c:if test="${requestScope.state==NO}">        
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="48%" height="18" colspan="4">无记录！</td>            
          </tr>        
        </table>
		</c:if>
      </div>
	</form>  
    </div>
    <div class="clear"></div>    
  </div> 
</div>
<script src="js/meun.js" type="text/javascript"></script>
</body>
</html>
