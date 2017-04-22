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
		alert("名称不能为空");
		return false;
	}else if(telephone==null || telephone==""){
		alert("发布时间不能为空");
		return false;
	}else{
		return true;		
	}
}
</script>
</head>

<body class="ContentBody">
<form action="addStandard.action" method="post" name="form" onsubmit="return check();">
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
				<legend>添加质量安全标准&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                             </legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">				 
					 
					    <tr>
							<td align="right" width="19%">名称：</td>					   
					    <td width="33%"><span class="red">
					       <input id="name" name="standard.name" type="text"  class="text" style="width:154px" /> 
				        </span></td>
					     </tr> 
						<tr>							
					    <td nowrap align="right" width="13%">发布时间</td>
					    <td width="33%"><span class="red">
					       <input id="telephone" name="standard.stime" type="text" class="text" style="width:154px" />如：2012-02-25 
				        </span></td>
					     </tr>
<tr>		
					    <td nowrap align="right" width="13%">详细说明：</td>
					    <td width="33%"><span class="red">
					     <textarea name="standard.content" rows="20" cols="60"></textarea>
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
			<input type="submit" name="Submit" value="添加质量安全标准" class="button"/>　
			
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
