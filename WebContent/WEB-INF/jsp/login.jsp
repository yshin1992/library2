<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>login.html</title>
	<meta charset="UTF-8">
    <meta name="keywords" content="libray,图书馆">
    <meta name="description" content="图书馆管理系统">
	<style>
		html,body{
		/** 让body内无空白框 **/
			padding:0;
			margin:0;
		}
		div{
			font-size:1.5em;
			text-align:center;
			background:#3992d0;
			width:100%;
		}
		div.head{
			border-bottom:1px solid black;
			line-height:2;/**缩放因子**/
			margin:0 0 1em 0;
			color:white;
		}
		table{
			width:100%;
			line-height:2;
		}
		.tdTitle{
			min-width:75px;
			width:45%;
			text-align:right;
			font-style:weight;
		}
		.tdValue{
			min-width:250px;
			width:55%;
			text-align:left;
		}
		.error{
			font-size:12px;
			color:red;
		}
		
		td[colspan]{
			text-align:center;
		}
		
		input[name="userId"],input[name="password"]{
			width: 200px;
		}
		/** td内图片与文本框居中对齐 **/
		td,td img,td input { vertical-align:text-bottom;}  
		input[type="text"]:focus,input[type="password"]:focus{
			background-color:#f5f5f5;
			color:black;
			border-color: gray 1px solid;
		}
	</style>
	<script src="js/jquery-1.11.2.js"></script>
	<script>
	if (window != top){
		top.location.href ="<c:out value='${basePath }'/>";
	}
	
	function checkForm(){
		var userId = $("input[name='userId']").val();
		var pswd = $(":password").val();
		var verifyCode=$("input[name='verifyCode']").val();
		//清除空格
		userId = userId.replace(/\s/g, "");
		pswd = pswd.replace(/\s/g, "");
		verifyCode=verifyCode.replace(/\s/g, "");
		if (userId == "") {
			$("#errorId").html("*用户名不能为空");
		}
		if (pswd == "") {
			$("#errorPswd").html("*密码不能为空");
		}
		if (verifyCode == "") {
			$("#errorVrCode").html("*验证码不能为空");
		}
		console.log("ok");
		if (userId != "" && pswd != ""&&verifyCode!=""){
			$("#form1").attr("action","<c:url value='/login.html'/>");
			$("#form1").submit();
		}
	}
	
	$(document).ready(function() {
		$("img").click(function(){
			$("img").attr("src","<c:url value='/verifyCode.do'/>?time="+new Date());
		})
	})
</script>
  </head>
  
  <body>
  	<div class="head">图书馆管理系统</div>
    <form method="post" id="form1">
    <table>
    <!-- 
    	<tr>
    		<td class="tdTitle">类型:</td>
    		<td class="tdValue"><select name="userType">
    				<option value="student">学生</option>
    				<option value="teacher">教师</option>
    			</select>
    		</td>
    	</tr> 
    	-->
    	<tr>
    		<td class="tdTitle">账号:</td>
    		<td class="tdValue"><input type="text" name="userId"  maxlength="30"/><span id="errorId"></span></td>
    	</tr>
    	<tr>
    		<td class="tdTitle">密码:</td>
    		<td class="tdValue"><input type="password" name="password" maxlength="30"/><span id="errorPswd"></span></td>
    	</tr>
    	<tr>
    		<td class="tdTitle">验证码:</td>
    		<td class="tdValue"><input type="text" name="verifyCode" size="6" maxlength="4"/>&nbsp;<img src="<c:url value='/verifyCode.do'/>" title="看不清，换一张" />&nbsp;
    			<span id="errorVrCode" class="error">${verifyError }</span></td>
    	</tr>
    	<tr>
    		<td colspan="2" >
    		<!-- 这里的button的name不能为submit，否则会导致提交失效 -->
    			<input type="button" value="提交" onclick="checkForm();"/>&nbsp;&nbsp;
    			<input type="reset" name="reset" value="重置"/>
    		</td>
    	</tr>
    </table>
     <c:if test="${not empty error}">
    	<font color="red"><c:out value="${error }"/></font>
    </c:if>
    </form>
  </body>
</html>

