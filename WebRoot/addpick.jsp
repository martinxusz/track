<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
</head>

<body class="ContentBody">
<form action="addPick.action" method="post" name="form">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >录入采摘记录</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="提交采摘记录" class="button" />　
		</td></tr>
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>填写采集信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">					 
					  <tr>
					    <td nowrap align="right" width="13%">产品名称：</td>
					    <td width="33%"><span class="red">
					       <input name='pick.name' type="text" class="text" style="width:154px" value=""/>
				        </span></td>
					    <td align="right" width="19%">采摘人员：</td>
					    <td width="35%"><input name='pick.picker' type="text" class="text" style="width:154px" value=""/>
				        </td>
					    </tr>

					    <tr>
					    <td nowrap align="right" width="13%">采摘日期:</td>
					    <td width="33%"><span class="red">
					       <input name='pick.pdate' type="text" class="text" style="width:154px" value=""/> 如：2012-01-25
				        </span></td>
					    <td align="right" width="19%">采摘基地：</td>
					    <td width="35%"><input name='pick.address' type="text" class="text" style="width:154px" value=""/></td>
					    </tr> 

<tr>
					    <td nowrap align="right" width="13%">检验标准:</td>
					    <td width="33%"><span class="red">					       
<select name="pick.standard" >
<c:forEach items="${requestScope.slist}" var="sd">
<option value="${sd.name }">${sd.name}</option> 
</c:forEach>
 </select> 
				        </span></td>
					    <td align="right" width="19%">产品等级：</td>
					    <td width="35%"><select name="pick.grade" ><option value="1">A级</option> <option value="2">B级</option><option value="3">C级</option> </select> </td>
					    </tr>
<tr>
					   
					    <td align="right" width="19%">检验员：</td>
					    <td width="35%"><select name="pick.checker" >
<c:forEach items="${requestScope.clist}" var="cd">
<option value="${cd.name }">${cd.name}</option> 
</c:forEach>
 </select> </td><td></td><td></td>
					    </tr>  
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		</TABLE>
	
	
	 </td>
  </tr>
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="提交采摘记录" class="button"/>　
			
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
