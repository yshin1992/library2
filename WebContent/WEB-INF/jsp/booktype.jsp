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
    <meta charset="UTF-8">
    <title></title>
	<style>
		.levelTitle{
			width:100%;
			background-color:lightgray;
			font-weight: bold;
		}
		#level1,#level2,#level3,#level4{
			width:100%;
			padding:10px;
		}
		#add{
			display:none;
		}
		.imgcls{
			color:red;
			border:1px dotted gray;
			text-decoration: none;
			padding:0.2em;
			margin:0.1em;
		}
	</style>
	<link rel="stylesheet" href="css/base.css">
	<script src="js/jquery-1.11.2.js"></script>
	<script src="js/base-util.js"></script>
  </head>
  
  <body>
    <library:navigation/>
    <div class="levelTitle">一级分类:</div>
    <div id="level1">
    	<c:forEach var="bookType" items="${bookTypeList }">
    		<a href="javascript:void(0)" class="imgcls" onclick="queryTypeList(${bookType.id },${bookType.level },'${bookType.typeName }')">+</a><a href="javascript:void(0)" onclick="showDetail(${bookType.id })"><c:out value="${bookType.typeName }"/></a><a href="javascript:void(0)" onclick="del(${bookType.id },1,0,'一级分类')" class="imgcls">-</a>&nbsp;
    	</c:forEach>
    	<input type="button" value="新增" onclick="addType(0,1,'一级分类');"/>
    </div>
    <div class="levelTitle">二级分类:</div>
    <div id="level2">
    
    </div>
    <div class="levelTitle">三级分类:</div>
    <div id="level3">
    
    </div>
    <div class="levelTitle">四级分类:</div>
    <div id="level4">
    
    </div>
    
    <div id="add">
    	<fieldset>
    		<legend></legend>
    		<form>
			    <table border="1" >
			    	<tr>
			    		<td class="tdTitle">图书类别级别</td>
			    		<td class="tdValue"><input type="text" name="level" readonly="readonly"/></td>
			    	</tr>
			    	<tr>
			    		<td class="tdTitle">图书类别名称</td>
			    		<td class="tdValue"><input type="text" name="typeName"/></td>
			    	</tr>
			    	<tr>
			    		<td class="tdTitle">可借天数(单位:天)</td>
			    		<td class="tdValue"><input type="text" name="days"/></td>
			    	</tr>
			    	<tr>
			    		<td class="tdTitle">迟还一天的罚金(单位:元)</td>
			    		<td class="tdValue"><input type="text" name="fine"/></td>
			    	</tr>
			    </table> 
		    	<input type="hidden" name="parentId"/>
		    	<input type="hidden" name="id"/>
		    	<input type="button" value="新增" id="addBtn" onclick="save()"/>
		    	<input type="button" value="保存修改" id="updateBtn" onclick="saveUpdate();"/> &nbsp;
		    	<input type="button" value="取消" onclick="cancle();"/>
		    </form>
    	</fieldset>
    </div>
    
    <div id="RRR"></div>
    <script>
		function queryTypeList(pid,level,parentTypeName){
			$.ajax({
				url:'manager/booktype.do',
				data:{
					pid:pid
				},
				type:'POST',
				success:function(data){
					var obj=eval("("+data+")")
					var htmlStr="";
					$.each(obj,function(index,value){
						if(level<3){
							htmlStr+="<a href='javascript:void(0);' class='imgcls' onclick='queryTypeList("+value.id+","+value.level+",\""+value.typeName+"\")'>+</a><a href='javascript:void(0)' onclick='showDetail("+value.id+")'>"+value.typeName+"</a><a href='javascript:void(0)' onclick='del("+value.id+","+value.level+","+pid+",\""+parentTypeName+"\")' class='imgcls'>-</a>&nbsp";
						}else{
							htmlStr+="<a href='javascript:void(0)' onclick='showDetail("+value.id+")'>"+value.typeName+"</a><a href='javascript:void(0)' onclick='del("+value.id+","+value.level+","+pid+",\""+parentTypeName+"\")' class='imgcls'>-</a>&nbsp";
						}
					});
					htmlStr+='<input type="button" value="新增" onclick="addType('+pid+','+(level+1)+',\''+parentTypeName+'\');"/>'; 
					$("#level"+(level+1)).html(htmlStr);
				}
			});
		}
		
		function addType(pid,level,typeName){
			$("#add").hide();
			document.forms[0].reset();
			$("legend").html(typeName);
			$("input[name='level']").val(level);
			$("input[name='parentId']").val(pid);
			$("input[name='id']").val("");//将ID置为空
			$("#add").show();
			$("#addBtn").show();
			$("#updateBtn").hide();
		}
		
		function cancle(){
			$("#add").hide();
		}
		
		function showDetail(id){
			$("#add").hide();
			$("legend").html("");
			document.forms[0].reset();
			$.ajax({
				url:'manager/booktypedetail.do',
				data:{
					id:id
				},
				type:'GET',
				success:function(data){
					var obj=eval("("+data+")");
					$("input[name='level']").val(obj.level);
					$("input[name='parentId']").val(obj.parentId);
					$("input[name='typeName']").val(obj.typeName);
					$("input[name='days']").val(obj.days);
					$("input[name='fine']").val(obj.fine.toFixed(2));
					$("input[name='id']").val(obj.id);
				}
			});
			$("#add").show();
			$("#addBtn").hide();
			$("#updateBtn").show();
		}
		
		function save(){
			var level=$("input[name='level']").val();
			var typeName=$("input[name='typeName']").val();
			var pid=$("input[name='parentId']").val();
			$.ajax({
				url:'manager/booktypeadd.do',
				data:$("form").serialize(),
				type:'POST',
				success:function(data){
				 	if(data!="failure"){
				 		cancle();
						$("input[name='level']").val(level);
						$("input[name='parentId']").val(pid);
				 		if(level<4){
				 			$("#level"+level).find(":button").before("<a href=\"javascript:void(0);\" class='imgcls' onclick=\"queryTypeList("+data+","+level+",'"+typeName+"')\">+</a><a href='javascript:void(0)' onclick='showDetail("+data+")'>"+typeName+"</a><a href='javascript:void(0)' onclick='del("+data+","+level+","+pid+",\""+typeName+"\")' class='imgcls'>-</a>&nbsp");
				 		}else{
				 			$("#level"+level).find(":button").before("<a href='javascript:void(0)' onclick='showDetail("+data+")'>"+typeName+"</a><a href='javascript:void(0)' onclick='del("+data+","+level+","+pid+",\""+typeName+"\")' class='imgcls'>-</a>&nbsp");
				 		}
				 		$("#RRR").html("图书类别添加成功！");
				 	}else{
				 		$("#RRR").html("图书类别添加失败！");
				 	}
				 	tsotsi($("#RRR"),10);
				}
			}); 
		}
		
		function saveUpdate(){
			var level=$("input[name='level']").val();
			var typeName=$("input[name='typeName']").val();
			$.ajax({
				url:'manager/booktypeupdate.do',
				data:$("form").serialize(),
				type:'POST',
				success:function(data){
				 	if(data!="failure"){
				 		$("#RRR").html("图书类别更新成功！");
				 	}else{
				 		$("#RRR").html("图书类别更新失败！");
				 	}
				 	tsotsi($("#RRR"),10);
				}
			}); 
		}
		
		function del(id,level,pid,parentTypeName){
			if(level<=4){
				$.ajax({
					url:'manager/booktype.do',
					data:{
						pid:id
					},
					type:'POST',
					success:function(data){
						data=eval("("+data+")");
						if(data.length>0){
							alert("删除失败，子分类不为空，不能删除!")
						}else{
							delType(id,level,pid,parentTypeName);
						}
					}
				});
			}else{
				delType(id);
			}
		}
		
		function delType(id,level,pid,parentTypeName){
			if(window.confirm("确认删除该分类？"))
			{
				$.ajax({
					url:'manager/booktypedel.do',
					data:{
						id:id
					},
					type:'POST',
					success:function(data){
						if(data!="failure"){
					 		$("#RRR").html("图书类别删除成功！");
					 		queryTypeList(pid,level-1,parentTypeName);
					 	}else{
					 		$("#RRR").html("图书类别删除失败！");
					 	}
					 	tsotsi($("#RRR"),10);
					}
				});
			}
		}
	</script>
  </body>
</html>
