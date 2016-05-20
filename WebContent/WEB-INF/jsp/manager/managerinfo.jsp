<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="library/tags" prefix="library" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" href="css/base.css">
  </head>
  
  <body>
  	<library:navigation/>
    <library:pageTitle/>
    <table border="1" >
    	<tr>
    		<td colspan="2">
    			<img src="manager/showPhoto.do?managerID=${curUser.model.managerID }" width="59" height="82" style="vertical-align:middle"/>
    		</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">管理员ID</td>
    		<td class="tdValue">${curUser.model.managerID }</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">姓名</td>
    		<td class="tdValue">${curUser.model.userName }</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">性别</td>
    		<td class="tdValue">${curUser.model.sex }</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">联系电话</td>
    		<td class="tdValue">${curUser.model.telephone }</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">电子邮箱</td>
    		<td class="tdValue">${curUser.model.email }</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">创建时间</td>
    		<td class="tdValue"><fmt:formatDate value="${curUser.model.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    	</tr>
    	<c:if test="${curUser.model.roleId eq 2 }">
    	<tr>
    		<td class="tdTitle">是否是超级管理员</td>
    		<td class="tdValue">是</td>
    	</tr>
    	</c:if>
    </table>
  </body>
</html>
