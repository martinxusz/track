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
</head>

<body class="ContentBody">
<form action="addPlace.action" method="post" name="form">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >申请产地</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="提交申请" class="button" />　
		</td></tr>
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>填写产地信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">					 
					  <tr>
					    <td nowrap align="right" width="13%">产地名称:</td>
					    <td width="33%"><span class="red">
					       <input name='place.pname' type="text" class="text" style="width:154px" value=""/>
				        </span></td>
					    <td align="right" width="19%">产地面积：</td>
					    <td width="35%"><input name='place.area' type="text" class="text" style="width:154px" value=""/>
				        </td>
					    </tr>

					    <tr>
					    <td nowrap align="right" width="13%">详细地址:</td>
					    <td width="33%"><span class="red">
					       <input name='place.address' type="text" class="text" style="width:154px" value=""/>
				        </span></td>
					    <td align="right" width="19%">种植范围：</td>
					    <td width="35%"><input name='place.range' type="text" class="text" style="width:154px" value=""/></td>
					    </tr> 
							
						<tr>
					    <td nowrap align="right" width="13%">执行标准:</td>
					    <td width="33%"><span class="red">
					       <input name='place.pstandard' type="text" class="text" style="width:154px" value=""/>
				        </span></td>
					    <td align="right" width="19%">预计产量：</td>
					    <td width="35%"><input name='place.production' type="text" class="text" style="width:154px" value=""/></td>
					    </tr> 

					    
					  <tr>
					    <td width="13%" nowrap align="right">详细介绍:</td>
					    <td colspan="3"><textarea name="place.introduce" cols="105" rows="20"></textarea></td>
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
			<input type="submit" name="Submit" value="提交申请" class="button"/>　
			
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
