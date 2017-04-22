<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>农产品质量追溯系统</title>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />

<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
<script  type="text/javascript">
function check(){
	var password =document.getElementById("oldpassword").value;
	var newpassword =document.getElementById("password_2").value;
	var repassword = document.getElementById("password_3").value;
	if(password==null || password==""){
		alert("旧密码不能为空");
		return false;
	}else if(newpassword==null || newpassword==""){
		alert("新密码不能为空");
		return false;
	}else if(repassword==null || repassword==""){
		alert("确认密码不能为空");
		return false;
	}else{
		if(password.length<5 ||password.length>18){
			alert("密码长度为5-18");	
			return false;
		}else if(newpassword.length<5 ||newpassword.length>18){
			alert("密码长度为5-18");	
			return false;
		}else if(repassword.length<5 ||repassword.length>18){
			alert("密码长度为5-18");	
			return false;
		}else if(newpassword !=repassword){
			alert("两次输入的密码不一致！");
			return false;
		}else{
			return true;
		}
	}
}
</script>
</head>

<body class="ContentBody">
<form action="updatePassword.action" method="post" name="form" onsubmit="return check();">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >更新登录密码 <strong><span style="margin-left:15px; color: red; font-weight: bold;">${requestScope.state}</span></strong> </th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">	
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>填写新的密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                             </legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">					 
					  <tr>
					    <td nowrap align="right" width="13%">旧密码：</td>
					    <td width="33%"><span class="red">
					       <input id="oldpassword" name="oldpassword" type="password" class="text" style="width:154px" value=""/>
				        </span></td>					   
					    </tr>
					    <tr>
							<td align="right" width="19%">新密码：</td>					   
					    <td width="33%"><span class="red">
					       <input id="password_2" name="newspassword" type="password"  class="text" style="width:154px" value=""/> 
				        </span></td>
					     </tr> 
						<tr>							
					    <td nowrap align="right" width="13%">再次输入新密码:</td>
					    <td width="33%"><span class="red">
					       <input id="password_3" name="repassword" type="password" class="text" style="width:154px" value=""/> 
				        </span></td>
					     </tr>
					  </table>
			  <br />
				</fieldset></TD>
			
		</TR>
		
		</TABLE>	
	
	 </td>
  </tr>
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="更新密码" class="button"/>　
			
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
