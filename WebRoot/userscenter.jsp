<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>农产品质量安全追溯系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
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
              ${requestScope.message}
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
      <div class="news">
        <div class="news_title">农产品生产商列表</div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <c:forEach items="${requestScope.mlist}" var="pl"> 
		 <tr>
            <td width="30%" height="18">${pl.company}</td>
            <td width="30%">${pl.address }</td>
            <td width="20%" align="center">${pl.telephone }</td>
            <td width="20%" align="center"><a href="getUsersByID.action?id=${pl.id }">详细</a></td>
          </tr>
         </c:forEach> 
		<tr>
            <td colspan="4" height="40"><s:if test="#request.pagetotal==0">没有记录！&nbsp;</s:if><s:else>&nbsp;当前第<s:property value="#request.pageNo"/>页
				<s:if test="#request.pageNo ==1"></s:if>
				<s:else><a href="getUsersList.action?pageNo=1&pagetotal=<s:property value="#request.pagetotal"/>">[首页]</a>&nbsp;
						<a href="getUsersList.action?pageNo=${pageNo-1}&pagetotal=${pagetotal}">[上一页]</a> 
				</s:else>
				<s:if test="#request.pageNo ==#request.pagetotal"></s:if>
				<s:else> <a href="getUsersList.action?pageNo=${pageNo+1}&pagetotal=${pagetotal}">[下一页]</a> 
				 		 <a href="getUsersList.action?pageNo=${pagetotal}&pagetotal=${pagetotal}">[尾页]</a>
				</s:else> &nbsp;&nbsp; 共<s:property value="#request.pagetotal"/>页
				</s:else></td>
          </tr>       
        </table>
      </div>
    </div>
    <div class="clear"></div>    
  </div> 
</div>
<script src="js/meun.js" type="text/javascript"></script>
</body>
</html>
