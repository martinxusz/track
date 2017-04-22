<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>农产品质量安全追溯系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
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
	function  checkRegist(){
		var name = document.getElementById("rname").value;
		var password = document.getElementById("rpassword").value;
		var rcompany = document.getElementById("rcompany").value;		
		var rtelephone = document.getElementById("rtelephone").value;	
		var raddress = document.getElementById("raddress").value;	
		if(name ==null ||name ==""){
			alert("用户名不为空！");
			return false;
		}else if(password ==null ||password ==""){
			alert("密码不为空！");
			return false;
		}else if(rcompany==null || rcompany ==""){
			alert("公司名称不为空！");
			return false;
		}else if(rtelephone==null || rtelephone ==""){
			alert("公司电话不为空！");
			return false;
		}else if(raddress==null || raddress ==""){
			alert("公司地址不为空！");
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
      
     
    </div>
    <div class="right">
      <div class="right_top_img"></div>     
      <div class="news">
        <div class="news_title">免费注册本站会员  &nbsp; <strong style="color:red; font-weight: bold;">${requestScope.state}</strong></div>
<form action="regist.action" method="post" name="regist" onsubmit="return checkRegist()" >       
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
       
		 <tr>
            <td width="20%" height="30" align="right">用户名：</td>
            <td width="80%" align="left"><input type="text" name="users.name" id="rname" /></td>
          </tr>
<tr>
            <td width="20%" height="30" align="right">密码：</td>
            <td width="80%" align="left"><input type="password" name="users.password" id="rpassword" /></td>
          </tr>
<tr>
            <td width="20%" height="30" align="right">类型：</td>
            <td width="80%"  align="left"> <select name="users.type"> 
<option value="1">农产品生产商</option>
<option value="2">农产品销售商</option>
<option value="3">政府执法部门</option>
</select> </td>
          </tr>
<tr>
            <td width="20%" height="30" align="right">公司名称：</td>
            <td width="80%" align="left"><input type="text" name="users.company" id="rcompany" /></td>
          </tr>
 <tr>
            <td width="20%" height="30" align="right">公司地址：</td>
            <td width="80%" align="left"><input type="text" name="users.address" id="raddress" /></td>
          </tr>    <tr>
            <td width="20%" height="30" align="right">公司电话：</td>
            <td width="80%" align="left"><input type="text" name="users.telephone" id="rtelephone" /></td>
          </tr> <tr>
            <td width="20%" height="30" align="right">公司简介：</td>
            <td width="80%" align="left"><textarea id="content1" name="content1" cols="70" rows="13" ></textarea>
				   </td>
          </tr> 
<tr>
            <td height="50" align="center"  colspan="2"><input type="submit" value="添加用户" /></td>
            
          </tr>     
		    
        </table>
</form>
      </div>
    </div>
    <div class="clear"></div>    
  </div> 
</div>
<script src="js/meun.js" type="text/javascript"></script>
</body>
</html>
