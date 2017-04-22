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
	var name =document.getElementById("name").value;
	var telephone =document.getElementById("telephone").value;
	var unit =document.getElementById("unit").value;
	var post =document.getElementById("post").value;
	var department =document.getElementById("department").value;
	
	if(name==null || name==""){
		alert("姓名不能为空");
		return false;
	}else if(telephone==null || telephone==""){
		alert("电话不能为空");
		return false;
	}else if(unit==null || unit==""){
		alert("单位不能为空");
		return false;
	}else if(post==null || post==""){
		alert("职位 不能为空");
		return false;
	}else if(department==null || department==""){
		alert("部门不能为空");
		return false;
	}else{
		return true;		
	}
}
</script>
</head>

<body class="ContentBody">
<form action="addChecker.action" method="post" name="form" onsubmit="return check();">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" > <strong><span style="margin-left:15px; color: red; font-weight: bold;">${requestScope.state}</span></strong> </th>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">	
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>添加质检人员&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                             </legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">				 
					 
					    <tr>
							<td align="right" width="19%">姓名：</td>					   
					    <td width="33%"><span class="red">
					       <input id="name" name="checker.name" type="text"  class="text" style="width:154px" /> 
				        </span></td>
					     </tr> 
						<tr>							
					    <td nowrap align="right" width="13%">工作电话</td>
					    <td width="33%"><span class="red">
					       <input id="telephone" name="checker.telephone" type="text" class="text" style="width:154px" /> 
				        </span></td>
					     </tr>
<tr>		
					    <td nowrap align="right" width="13%">单位名称：</td>
					    <td width="33%"><span class="red">
					      <input id="unit" name="checker.unit" type="text" class="text" style="width:154px" /> 
				        </span></td>
					     </tr>
<tr>		
					    <td nowrap align="right" width="13%">部门名称：</td>
					    <td width="33%"><span class="red">
					      <input id="department" name="checker.department" type="text" class="text" style="width:154px" /> 
				        </span></td>
					     </tr>
<tr>		
					    <td nowrap align="right" width="13%">职位名称：</td>
					    <td width="33%"><span class="red">
					      <input id="post" name="checker.post" type="text" class="text" style="width:154px" /> 
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
			<input type="submit" name="Submit" value="添加质检人员" class="button"/>　
			
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
