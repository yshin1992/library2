<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="library/tags" prefix="library" %>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
	<link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/displaytag.css">
    <script src="js/jquery-1.11.2.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("#cboxs").click(
    			function(){
    				if($(this).prop("checked")){
    					$(":checkbox").prop("checked",true);
    				}else{
    					$(":checkbox").prop("checked",false);
    				}
    				
    			}
    		);
    		$("#query").click(function(){
    			$("form")[0].submit();
    		});
			$("#delete").click(function(){
				$("form")[1].submit();
    		});
    	});
    </script>
</head>
<body>
	<library:navigation/>
	<library:pageTitle/>
	
	<form action="manager/delmanager.html" method="post">
    	<table>
    		<tr>
    			<td>查询方式:<select name="selType"><option value="Precise" <c:if test="${searchType eq 'Precise' }">selected="selected"</c:if>>精确查询</option><option value="Fuzzy" <c:if test="${searchType eq 'Fuzzy' }">selected="selected"</c:if>>模糊查询</option></select></td>
    			<td>管理员ID:<input type="text" name="managerID"/></td>
    			<td>姓名:<input type="text" name="userName"/></td>
    		</tr>
    		<tr>
    			<td>性别:
    				<select name="sex">
    					<option value="">&nbsp;</option>
    					<option value="男">男</option>
    					<option value="女">女</option>
    				</select>
    			</td>
    			<td>电话:<input type="text" name="telephone"/></td>
    			<td>电子邮件:<input type="text" name="email"/></td>
    		</tr>
    		<tr>
    			<td>用户角色:
					<select name="roleId">
    					<option value="">&nbsp;</option>
    					<option value="1">普通管理员</option>
    					<option value="2">超级管理员</option>
    				</select>
				</td>
    			<td>创建时间:<input type="text" name="createTime"/></td>
    			<td>用户状态:<select name="status"><option value="">&nbsp;</option><option value="0">正常</option><option value="1">已注销</option></select></td>
    		</tr>
    	</table>
    	<div style="float:right"><input type="button" id="query" value="查询"/>&nbsp;<input type="button" id="delete" value="删除"/></div>
    </form>
    <form action="manager/delMgrCmt.html" method="post">
	    <div id="data_container" class="data_container">
		    <c:if test="${not empty mgrList }">
		    	<display:table name="mgrList" id="manager" defaultsort="1"  class="data_content_tb" requestURI="manager/querymanager.html" export="false">
			    	<display:column title="<input type='checkbox' id='cboxs' name='cboxs'>">
						<input type="checkbox" id="${manager.managerID}ID" name="ids" value="${manager.managerID}" <c:if test="${manager.status eq true }">disabled="disabled"</c:if> />
					</display:column>
					<display:column title="头像">
    					<img src="manager/showPhoto.do?managerID=${manager.managerID }" width="59" height="82" style="vertical-align:middle"/>
    				</display:column>
			    	<display:column title="管理员ID" sortable="true"  sortProperty="managerID" property="managerID"  />
			    	<display:column title="姓名" property="userName" />
			    	<display:column title="性别" property="sex" />
			    	<display:column title="电话" property="telephone" />
			    	<display:column title="电子邮件" property="email" />
			    	<display:column title="用户角色" sortable="true"  sortProperty="roleId">
				    	<c:if test="${manager.roleId eq 1 }">普通管理员</c:if>
			    		<c:if test="${manager.roleId eq 2 }">超级管理员</c:if>
			    	</display:column>
			    	<display:column title="创建时间">
			    		<fmt:formatDate value="${manager.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
			    	</display:column>
			    	<display:column title="用户状态">
			    		<c:if test="${manager.status eq false }">正常</c:if>
			    		<c:if test="${manager.status eq true }">已注销</c:if>
			    	</display:column>
		    	</display:table>
		    </c:if>
		    <c:if test="${empty mgrList }">
		    	<div style="clear:both;text-align:center;width:100%;">未查询到相关数据</div>
		    </c:if>
    	</div>
    </form>
</body>
</html>