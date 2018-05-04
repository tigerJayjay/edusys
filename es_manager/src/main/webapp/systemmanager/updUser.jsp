<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
	<title>添加用户</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/es_manager/resources/Scripts/jquery.min.js" type="text/javascript"></script>
    <script src="/es_manager/resources/Scripts/JScriptCommon.js" type="text/javascript"></script>
    <link href="/es_manager/resources/Content/StyleSheet.css" rel="stylesheet" type="text/css" />
    <script src="/es_manager/resources/Scripts/jquery.validate.min.js" type="text/javascript"></script>
    <script src="/es_manager/resources/Scripts/jquery.validate.unobtrusive.min.js" type="text/javascript"></script>
    <link href="/es_manager/resources/Content/IndexStyle.css" rel="stylesheet" type="text/css" />
    <script src="/es_manager/resources/Res/easyui/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="/es_manager/resources/Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="/es_manager/resources/Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
    <link href="/es_manager/resources/Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
	<script src="/es_manager/resources/script/jquery.serializejson.js"></script>
    
    <script type="text/javascript">
    $(function(){
    	$.post("/es_manager/User/AllocationUserRole",{userId:1},function(res){
    		$.each(res.rows,function(index,content){
    			$("#roleNo").append("<option value='"+content.no+"'>"+content.roleName+"</option>");
    		})
    	},"json")
    })
    function login() {
        $.ajax({
        //几个参数需要注意一下
            type: "GET",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/es_manager/User/addUser" ,//url,
            contentType: "application/json",
            data:$('#form1').serializeJSON(),
            success: function (result) {
                $.messager.alert(result);
            },
            error : function() {
            	$.messager.alert("warning!","添加失败!");
            	
            }
        });
    }
    
    </script>

</head>
<body>
    
<div class="mbx">
      创建 系统用户
</div>
<form id="form1" action="#" onsubmit="return false">
    <fieldset>
        <legend>
            <input class="submitcss" type="submit" onclick="login()" id="submit" value="创建" />
            <input class="submitcss" type="button" onclick="BackList('/es_manager/systemmanager/SysPerson.jsp')" value="返回" />
        </legend>
        <div class="bigdiv">
        	<input type="hidden" name="no" id="no" value="${loginUser.no}">
            <div class="editor-label">
               	<label for="account">用户账号</label>
        	</div>
	        <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="account" name="account" type="text" value="${loginUser.account }" />
	        </div>     
         
	        <div class="editor-label">
               	<label for="password">用户密码</label>
        	</div>
	        <div class="editor-field">
	            <input  class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="password" name="password" type="password" value="${loginUser.account }" />
	        </div>
        </div>
    </fieldset>

    </form>
    <c:remove var="message"/>
</body>
</html>
