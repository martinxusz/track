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
	var title =document.getElementById("title").value;
	var author =document.getElementById("organ").value;
	
	if(title==null || title==""){
		alert("标题不能为空");
		return false;
	}else if(author==null || author==""){
		alert("发布机构不能为空");
		return false;
	}else{
		return true;		
	}
}
</script>
<link rel="stylesheet" href="themes/default/default.css" />
	<link rel="stylesheet" href="plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor.js"></script>
	<script charset="utf-8" src="lang/zh_CN.js"></script>
	<script charset="utf-8" src="plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : 'plugins/code/prettify.css',
				uploadJson : 'upload_json.jsp',
				fileManagerJson : 'file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>

<body class="ContentBody">
<form action="addLaw.action" method="post" name="form" onsubmit="return check();">
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
				<legend>发布法律法规&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                             </legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">				 
					 
					    <tr>
							<td align="right" width="19%">法律法规名称：</td>					   
					    <td width="33%"><span class="red">
					       <input id="title" name="law.title" type="text"  class="text" style="width:154px" /> 
				        </span></td>
					     </tr> 
						<tr>							
					    <td nowrap align="right" width="13%">发布机构</td>
					    <td width="33%"><span class="red">
					       <input id="organ" name="law.organ" type="text" class="text" style="width:154px" /> 
				        </span></td>
					     </tr>
<tr>		
					    <td nowrap align="right" width="13%">详细内容：</td>
					    <td width="33%"><span class="red">
					       <textarea id="content1" name="content1" cols="80" rows="20" ></textarea>
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
			<input type="submit" name="Submit" value="添加法律法规" class="button"/>　
			
					</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
