<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Main</title>
	<script>
		var stateObject = {};
		var title = "login.html";
		var newUrl = ${basePath};
		history.pushState(stateObject,title,newUrl);
	</script>
</head>
<frameset rows="50px,*" border="0">
  <frame src="<c:url value='/manager/head.html'/>" scrolling="no" name="head" noresize />
  <frameset cols="15%,*" border="0">
	<frame src="<c:url value='/manager/menu.html'/>" scrolling="no" name="menu" noresize />
	<frame src="<c:url value='/manager/main.html'/>" scrolling="yes" name="main" noresize />
  </frameset>
</frameset>
<noframes>
<body>
	<h1>您当前的浏览器不支持框架,请更换浏览器!</h1>
</body>
</noframes>
</html>