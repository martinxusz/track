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
<form action="updatePlace.action" method="post" name="form">
<c:set value="${requestScope.pl}" var="pl"></c:set>
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >更新产地信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="更新产地信息" class="button" /> &nbsp; <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
<input type="hidden" name="place.id" value="${pl.id }" />　
<input type="hidden" name="place.chief" value="${pl.chief }" />
<input type="hidden" name="place.state" value="${pl.state }" />
		</td></tr>
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>填写需要更改信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">					 
					  <tr>
					    <td nowrap align="right" width="13%">产地名称:</td>
					    <td width="33%"><span class="red">
					       <input name='place.pname' type="text" class="text" style="width:154px"  value="${pl.pname}"/>
				        </span></td>
					    <td align="right" width="19%">产地面积：</td>
					    <td width="35%"><input name='place.area' type="text" class="text" style="width:154px" value="${pl.area}"/>
				        </td>
					    </tr>

					    <tr>
					    <td nowrap align="right" width="13%">详细地址:</td>
					    <td width="33%"><span class="red">
					       <input name='place.address' type="text" class="text" style="width:154px" value="${pl.area}"/>
				        </span></td>
					    <td align="right" width="19%">种植范围：</td>
					    <td width="35%"><input name='place.range' type="text" class="text" style="width:154px" value="${pl.range }"/></td>
					    </tr> 
							
						<tr>
					    <td nowrap align="right" width="13%">执行标准:</td>
					    <td width="33%"><span class="red">
					       <input name='place.pstandard' type="text" class="text" style="width:154px" value="${pl.pstandard }"/>
				        </span></td>
					    <td align="right" width="19%">预计产量：</td>
					    <td width="35%"><input name='place.production' type="text" class="text" style="width:154px" value="${pl.production }"/></td>
					    </tr> 

					    
					  <tr>
					    <td width="13%" nowrap align="right">详细介绍:</td>
					    <td colspan="3"><textarea name="place.introduce" cols="105" rows="20">${pl.introduce }</textarea></td>
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
			<input type="submit" name="Submit" value="更新产地信息" class="button"/>　&nbsp; 
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
