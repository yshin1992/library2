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
				/**
				校验这一块js还未做
				**/
				$("form").submit();
			});
		});
	</script>
</head>
<body>
	<library:navigation/>
	<library:pageTitle/>
	<form action="manager/addMgrCmt.html" method="post">
    <table border="1" >
    	<tr>
    		<td class="tdTitle">管理员ID</td>
    		<td class="tdValue"><input type="text" name="managerID" /></td>
    	</tr>
    	<tr>
    		<td class="tdTitle">姓名</td>
    		<td class="tdValue"><input type="text" name="userName"/></td>
    	</tr>
    	<tr>
    		<td class="tdTitle">性别</td>
    		<td class="tdValue">
    			<input type="radio" name="sex" value="男" checked="checked"/>男 &nbsp;
    			<input type="radio" name="sex" value="女" />女
    		</td>
    	</tr>
    	<tr>
    		<td class="tdTitle">联系电话</td>
    		<td class="tdValue"><input type="text" name="telephone"/></td>
    	</tr>
    	<tr>
    		<td class="tdTitle">电子邮箱</td>
    		<td class="tdValue"><input type="text" name="email"/></td>
    	</tr>
    </table> 
    	<input type="button" value="新增"/> &nbsp;<input type="reset" value="取消"/>
    </form>
    <div id="EEE"><c:out value="${addMgrError}"/></div>
</body>
</html>