<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="library/tags" prefix="library" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    <link rel="stylesheet" href="css/base.css">
	<script src="js/jquery-1.11.2.js"></script>
	<script>
		$(document).ready(function(){
			$(":button").click(function(){
				$("form").submit();
			});
		});
	</script>
  </head>
  
  <body>
  	<library:navigation/>
    <library:pageTitle/>
    <form action="manager/updateMgrCmt.html" method="post">
    <table border="1" >
    	<tr>
    		<td class="tdTitle">管理员ID</td>
    		<td class="tdValue"><input type="text" name="managerID" value="${curUser.model.managerID }" readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td class="tdTitle">姓名</td>
    		<td class="tdValue"><input type="text" name="userName" value="${curUser.model.userName }"/></td>
    	</tr>
    	<tr>
    		<td class="tdTitle">性别</td>
    		<td class="tdValue">
    			<input type="radio" name="sex" value="男" <c:if test="${curUser.model.sex eq '男'}">checked="checked"</c:if> />男 &nbsp;
    			<input type="radio" name="sex" value="女" <c:if test="${curUser.model.sex eq '女'}">checked="checked"</c:if> />女
    		</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">联系电话</td>
    		<td class="tdValue"><input type="text" name="telephone" value="${curUser.model.telephone }"/></td>
    	</tr>
    	<tr>
    		<td class="tdTitle">电子邮箱</td>
    		<td class="tdValue"><input type="text" name="email" value="${curUser.model.email }"/></td>
    	</tr>
    </table> 
    	<!--  <input type="hidden" name="managerID" value="${curUser.model.managerID }"/> -->
    	<input type="button" value="保存修改"/> &nbsp;<input type="reset" value="取消"/>
    </form>
  </body>
</html>
