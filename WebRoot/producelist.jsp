<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>农产品安全质量检测</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/xiangmu.js"></script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 产品信息表 &nbsp;</td>
                    </tr>
                  <tr>							   
                    <td width="13%" height="20" align="center" bgcolor="#EEEEEE">产品名称</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">产品类型</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">保质期</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">生产日期</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">追溯号码</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">净重量</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">生产标准</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">生产许可证号</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">储藏方法</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">营养成分</td>
                  </tr>
					<c:forEach items="${requestScope.mlist}" var="pl"> <tr>									    
                    <td height="20" bgcolor="#FFFFFF">${pl.name}</td>
                    <td bgcolor="#FFFFFF">${pl.type }</td>
                    <td bgcolor="#FFFFFF">${pl.shelflife }个月</td>
                    <td bgcolor="#FFFFFF">${pl.dateproduce }</td>
                    <td bgcolor="#FFFFFF">${pl.trackId }</td>
                    <td bgcolor="#FFFFFF">${pl.weight }</td>
					<td bgcolor="#FFFFFF">${pl.standards }</td>
					<td bgcolor="#FFFFFF">${pl.license }</td>
					<td bgcolor="#FFFFFF">${pl.storage }</td>
					<td bgcolor="#FFFFFF">${pl.nutrients }</td>
                  </tr></c:forEach>
                 
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
		  <table width="100%" border="0" align="center" cellpadding="0" 
		  		cellspacing="0" class="right-font08">
              <tr>                
                <td width="49%" align="right">
					<s:if test="#request.pagetotal==0">没有记录！&nbsp;</s:if><s:else>&nbsp;当前第<s:property value="#request.pageNo"/>页
				<s:if test="#request.pageNo ==1"></s:if>
				<s:else><a href="produceList.action?pageNo=1&pagetotal=<s:property value="#request.pagetotal"/>">[首页]</a>&nbsp;
						<a href="produceList.action?pageNo=${pageNo-1}&pagetotal=${pagetotal}">[上一页]</a> 
				</s:else>
				<s:if test="#request.pageNo ==#request.pagetotal"></s:if>
				<s:else> <a href="produceList.action?pageNo=${pageNo+1}&pagetotal=${pagetotal}">[下一页]</a> 
				 		 <a href="produceList.action?pageNo=${pagetotal}&pagetotal=${pagetotal}">[尾页]</a>
				</s:else> &nbsp;&nbsp; 共<s:property value="#request.pagetotal"/>页
				</s:else>
				</td>                
              </tr>
          </table>
		 </td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>

