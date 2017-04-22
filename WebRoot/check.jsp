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
<form action="check.action" method="post" name="form">
<c:set value="${requestScope.pl}" var="pl"></c:set>
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >审核产地信息</th>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="审核产地信息" class="button" /> &nbsp; <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
<input type="hidden" name="place.id" value="${pl.id }" />　
<input type="hidden" name="place.chief" value="${pl.chief }" />
<input type="hidden" name="place.state" value="${pl.state }" />
<input type="hidden" name="place.pname" value="${pl.pname }" />
<input type="hidden" name="place.area" value="${pl.area }" />
<input type="hidden" name="place.address" value="${pl.address }" />
<input type="hidden" name="place.range" value="${pl.range }" />
<input type="hidden" name="place.pstandard" value="${pl.pstandard }" />
<input type="hidden" name="place.production" value="${pl.production }" />
<input type="hidden" name="place.introduce" value="${pl.introduce }" />
		</td></tr>
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>审核产地信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">					 
					  <tr>
					    <td nowrap align="right" width="13%">产地名称:</td>
					    <td width="33%"><span class="red">
					       ${pl.pname}
				        </span></td>
					    <td align="right" width="19%">产地面积：</td>
					    <td width="35%">${pl.area}"
				        </td>
					    </tr>

					    <tr>
					    <td nowrap align="right" width="13%">详细地址:</td>
					    <td width="33%"><span class="red">
					      ${pl.address}
				        </span></td>
					    <td align="right" width="19%">种植范围：</td>
					    <td width="35%">${pl.range }</td>
					    </tr> 
							
						<tr>
					    <td nowrap align="right" width="13%">执行标准:</td>
					    <td width="33%"><span class="red">
					     ${pl.pstandard }
				        </span></td>
					    <td align="right" width="19%">预计产量：</td>
					    <td width="35%">${pl.production }</td>
					    </tr> 

					    
					  <tr>
					    <td width="13%" nowrap align="right">详细介绍:</td>
					    <td colspan="3">${pl.introduce }</td>
					  </tr>
					  </table>
			  <br />
				</fieldset>	</TD>
			
		</TR>
		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<c:if test="${pl.state==0}"> <input type="submit" name="Submit" value="审核" class="button"/> </c:if>
			<c:if test="${pl.state==1}">  <input type="button" name="Submit2" value="已审核，返回" class="button" onclick="window.history.go(-1);"/></c:if>
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
