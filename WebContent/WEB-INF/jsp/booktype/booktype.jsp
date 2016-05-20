<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="library/tags" prefix="library" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/base.css">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="css/metroStyle/metroStyle.css" type="text/css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.all-3.5.js"></script>
	<script src="js/base-util.js"></script>
	 <script type="text/javascript">
		<!--
		var tmpBookTypeInfo;
		
		var treeNodes=${btTree};
		
		var maxNodeId=65535;
		
		var updateNode;
		
		var addFlag=false;
		
		var setting = {
				view: {
	                addHoverDom: addHoverDom,
	                removeHoverDom: removeHoverDom,
	                selectedMulti: false
	            },
	            check: {
	                enable: true,
	                chkStyle: "checkbox",
	        		chkboxType: { "Y": "s", "N": "s" }/**保证勾选子节点的时候不勾选父节点**/
	            },
	            data: {
	                simpleData: {
	                    enable: true
	                }
	            },
	            edit: {
	                enable: true
	            },
				callback:{
					onClick:showBookType,
					beforeEditName: updateBookType,
					beforeRemove: beforeRemove
				}
		};
		
		function getBookTypeInfo(id){
			$.ajax({
				url:"webservice/booktype/queryByPk",
				method:'POST',
				data:{
					id:id
				},
				success:function(data){
					$("#showbookType").css("display","block");
					$("#updateTypeInfo").css("display","none");
					$("#levelSpan").html(data.level);
					$("#typeNameSpan").html(data.typeName);
					$("#daysSpan").html(data.days);
					$("#fineSpan").html(Number(data.fine).toFixed(2));
				}
			});
		}
		
		/**显示书籍类别信息 **/
		function showBookType(event, treeId, treeNode, clickFlag) {
			console.log(treeNode);
			getBookTypeInfo(treeNode["id"]);
		}
		
		/**显示书籍类别更新信息**/
		function updateBookType(treeId, treeNode){
			updateNode=treeNode;
			$.ajax({
				url:"webservice/booktype/queryByPk",
				method:'POST',
				data:{
					id:treeNode["id"]
				},
				success:function(data,status){
					$("#updateBtn").css("display","inline");
					$("#addBtn").css("display","none");
					
					$("#showbookType").css("display","none");
					$("#updateTypeInfo").css("display","block");
					tmpBookTypeInfo=data;
					$("input[name='level']").val(data.level);
					$("input[name='typeName']").val(data.typeName);
					$("input[name='days']").val(data.days);
					$("input[name='fine']").val(Number(data.fine).toFixed(2));
					$("input[name='id']").val(data.id);
				}
			});
			return false;
		}
		/**更新书籍类别信息**/
		function update(){
			$.ajax({
				url:"webservice/booktype/updateBookType",
				method:'PUT',
				data:{
					id:$("input[name='id']").val(),
					typeName:$("input[name='typeName']").val(),
					fine:$("input[name='fine']").val(),
					days:$("input[name='days']").val()
				},
				success:function(data,status){
					if(status=="success"){
						getBookTypeInfo($("input[name='id']").val());
						var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
						updateNode.name=$("input[name='typeName']").val();
						treeObj.updateNode(updateNode);
						$("#EEE").html("修改图书类别信息成功!");
					}else{
						$("#EEE").html("修改图书类别信息失败!");
					}
					tsotsi($("#EEE"),10);
				}
			});
		}
		
		/**新增书籍类别信息**/
		function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) btn.bind("click", function(){
            	$.ajax({
    				url:"webservice/booktype/queryByPk",
    				method:'POST',
    				data:{
    					id:treeNode.id
    				},
    				success:function(data){
    					$("#showbookType").css("display","none");
    					$("#updateTypeInfo").css("display","block");
    					//显示新增书籍类别表格信息
    					$("input[name='level']").val(parseInt(data.level)+1);
    					$("input[name='typeName']").val(treeNode.name+"子类别");
    					$("input[name='days']").val(data.days);
    					$("input[name='fine']").val(Number(data.fine).toFixed(2));
    					$("input[name='parentId']").val(data.id);
    					
    					$("#updateBtn").css("display","none");
    					$("#addBtn").css("display","inline");
    				}
    			});
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                zTree.addNodes(treeNode,{id:maxNodeId,pId:treeNode.id,name:treeNode.name+"子类别"});
                updateNode=zTree.getNodeByParam("id",maxNodeId,treeNode);
                //更新addFlag
                addFlag=true;
                return false;
            });
        };
        
        function add(){
        	addFlag=false;
        	$.ajax({
				url:"webservice/booktype/addBookType",
				method:'POST',
				data:{
					typeName:$("input[name='typeName']").val(),
					fine:$("input[name='fine']").val(),
					days:$("input[name='days']").val(),
					level:$("input[name='level']").val(),
					parentId:$("input[name='parentId']").val()
				},
				success:function(data,status){
					if(data!="-1"){
						var zTree = $.fn.zTree.getZTreeObj("treeDemo");
						updateNode.id=parseInt(data);
						updateNode.name=$("input[name='typeName']").val();
						zTree.updateNode(updateNode);
						//显示添加的图书类别信息
						getBookTypeInfo(parseInt(data));
						$("#EEE").html("添加图书类别信息成功!");
					}else{
						$("#EEE").html("添加图书类别信息失败!");
					}
					tsotsi($("#EEE"),10);
				}
			});
        }
        
        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        };
		
        /**初始化Tree**/
		var zNodes=new Array();
		for(var i=0;i<treeNodes.length;i++){
			zNodes.push({
				id:treeNodes[i]["id"],
				pId:treeNodes[i]["parentId"],
				name:treeNodes[i]["typeName"]
			});
		}
		zNodes[0].open=true;
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		
		/**删除书籍类别**/
		var ids="";
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			var nodes = zTree.getCheckedNodes(true);
			if(nodes.length==0){
				alert("请勾选图书类别进行删除!");
				return false;
			}
			if(nodes.length>0){
				//初始化ids
				ids="";
				var confirmStr="确认删除图书类别： ";
				for(var i=0;i<nodes.length;i++){
					ids+=nodes[i].id;
					confirmStr+=nodes[i].name;
					if(i!=nodes.length-1){
						confirmStr+=",";
						ids+=",";
					}else{
						confirmStr+=" ?";
					}
				}
				if(confirm(confirmStr)){
					$.ajax({
						url:"webservice/booktype/deleteBookType",
						method:"DELETE",
						data:{
							ids:ids
						},
						success:function(data,status){
							if(status=="success"){
								for(var i=0;i<nodes.length;i++){
									zTree.removeNode(nodes[i],false);
								}
								//隐藏表单，防止被删除的结点二次提交
								$("#showbookType").css("display","none");
		    					$("#updateTypeInfo").css("display","none");
								alert("删除图书类别成功!");
							}else{
								alert("删除图书类别出错!");
							}
						}
					});
				}
			} 
			return false;
		}
		
		/**重置表单**/
		function resetForm(){
			//当取消新增书籍类别时，同时移除相应的子节点
			if(addFlag){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.removeNode(updateNode,false);
				$("#updateTypeInfo").css("display","none");
				return;
			}
			$("input[name='level']").val(tmpBookTypeInfo.level);
			$("input[name='typeName']").val(tmpBookTypeInfo.typeName);
			$("input[name='days']").val(tmpBookTypeInfo.days);
			$("input[name='fine']").val(Number(tmpBookTypeInfo.fine).toFixed(2));
			$("input[name='id']").val(tmpBookTypeInfo.id);
			$("input[name='parentId']").val(tmpBookTypeInfo.parentId);
		}
		
		//-->
	</script>
  </head>
  
  <body>
  	<library:navigation/>
    <library:pageTitle/>
	
	<div style="float:left;width:40%;min-width:200px">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div style="float:right;width:60%;min-width:400px;display:none" id="showbookType">
			<table border="1" >
				<tr>
					<td class="tdTitle">图书类别级别</td>
					<td class="tdValue"><span id="levelSpan"></span></td>
				</tr>
				<tr>
					<td class="tdTitle">图书类别名称</td>
					<td class="tdValue"><span id="typeNameSpan"></span></td>
				</tr>
				<tr>
					<td class="tdTitle">可借天数(单位:天)</td>
					<td class="tdValue"><span id="daysSpan"></span></td>
				</tr>
				<tr>
					<td class="tdTitle">迟还一天的罚金(单位:元)</td>
					<td class="tdValue"><span id="fineSpan"></span></td>
				</tr>
			</table> 
			<div id="EEE"></div>
	</div>
	<div style="float:right;width:60%;min-width:400px;display:none" id="updateTypeInfo">
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
		   <input type="hidden" name="id"/>
		   <input type="hidden" name="parentId"/>
		   <input type="button" value="新增" id="addBtn" onclick="add()" style="display:none"/>
		   <input type="button" value="保存修改" id="updateBtn" onclick="update();"/> &nbsp;
		   <input type="button" value="取消" id="resetBtn" onclick="resetForm();"/>
		</form>
	</div>
	
  </body>
</html>
