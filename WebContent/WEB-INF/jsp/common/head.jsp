<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
    <style>
    	body{
    		background-color:#3992D0;
    		color:white;
    		padding:0px;
    		margin:0px;
    	}
    	h1{
    		font-style:italic;
    		font-size:30px;
    		margin:0;
    	}
    	table{
    		width:100%;
    		height:100%;
    		margin:0px;
    	}
    	.tdTitle{
    		width:75%;
    		padding-left:3em;
    	}
    	.tdValue{
    		width:25%;
    		text-align:right;
    		padding-top:20px;
    	}
    	a{
    		color:white
    	}
    	h1{
    		margin:0.1em;
    	}
    </style>

  </head>
  
  <body>
  <table>
  	<tr>
  		<td class="tdTitle">
  			<h1>图书馆管理系统</h1>
  		</td>
  		<td class="tdValue">
	  		<c:if test="${not empty curUser }">
	    		<a href="<c:url value='/manager/managerinfo.html' />"  target="main"><c:out value="${curUser.model.userName }"/></a>&nbsp;<a href="<c:url value='/loginout.html' />"  target="_parent">退出</a>
	    	</c:if>
  		</td>
  	</tr>
  </table>
  </body>
</html>
