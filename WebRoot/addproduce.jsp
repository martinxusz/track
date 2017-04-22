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
<form action="addProduce.action" method="post" name="form">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >录入产品信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="添加产品" class="button" />　
		</td></tr>
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>填写产品信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">					 
					  <tr>
					    <td nowrap align="right" width="13%">产品名称:</td>
					    <td width="33%"><span class="red">
					       <input name='produce.name' type="text" class="text" style="width:154px" value=""/>
				        </span></td>
					    <td align="right" width="19%">产品类型：</td>
					    <td width="35%"><select name="produce.type">
<option>无公害蔬菜</option>
<option>无公害水果</option>
<option>无公害畜禽</option>
<option>无公害水产品</option>
<option>无公害茶叶</option>
<option>无公害蛋与蛋制品</option>
<option>无公害乳与乳制品</option>
<option>无公害食用菌</option>
<option>无公害蜂产品</option>
</select>
				        </td>
					    </tr>

					    <tr>
					    <td nowrap align="right" width="13%">保质期:</td>
					    <td width="33%"><span class="red">
					       <input name='produce.shelflife' type="text" class="text" style="width:154px" value=""/>个月
				        </span></td>
					    <td align="right" width="19%">生产日期：</td>
					    <td width="35%"><input name='produce.dateproduce' type="text" class="text" style="width:154px" value=""/>格式如：2012-02-04</td>
					    </tr> 
							
						

<tr>
					    <td nowrap align="right" width="13%">生产标准:</td>
					    <td width="33%"><span class="red">
					       <input name='produce.standards' type="text" class="text" style="width:154px" value=""/>
				        </span></td>
					    <td align="right" width="19%">生产许可证号：</td>
					    <td width="35%"><input name='produce.license' type="text" class="text" style="width:154px" value=""/></td>
					    </tr> 
<tr>
					    <td nowrap align="right" width="13%">储藏方法:</td>
					    <td width="33%"><span class="red">
					       <input name='produce.storage' type="text" class="text" style="width:154px" value=""/>
				        </span></td>
					    <td align="right" width="19%">营养成分：</td>
					    <td width="35%"><input name='produce.nutrients' type="text" class="text" style="width:154px" value=""/></td>
					    </tr> 
<tr>
					    <td nowrap align="right" width="13%">产地名称：</td>
					    <td width="33%"><span class="red">
					       <select name="produce.place">
<c:forEach items="${requestScope.plist}" var="pl">
<option value="${pl.id}">${pl.pname}</option>
</c:forEach>
</select>
				        </span></td>
					    <td align="right" width="19%">采摘编号：</td>
					    <td width="35%"><input name='produce.pick' type="text" class="text" style="width:154px" value=""/></td>
					    </tr> 
 <tr>
					    <td nowrap align="right" width="13%">净重量：</td>
					    <td width="33%"><span class="red">
					       <input name='produce.weight' type="text" class="text" style="width:154px" value=""/>
				        </span></td>
					    <td align="right" width="19%"></td>
					    <td width="35%"></td>
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
			<input type="submit" name="Submit" value="添加产品" class="button"/>　
			
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
