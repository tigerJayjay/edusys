<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
	<title>添加学生信息</title>
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
    
    
    var userDepts = [];
    var userPositions = [];
    $(function(){
    	  $.post("/es_manager/usermanager/getCol",{},function(res){
    	    	$.each(res.rows,function(i,e){
    	    		$("#college").append("<option value="+e.colNo+">"+e.colName+"</option>")
    	    	})
    	    })        
    })
   function login() {
            $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/es_manager/teachermanager/insertTea" ,//url,
                contentType: "application/json",
                data:JSON.stringify($('#form1').serializeJSON()),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.status == 200) {
                    	$.messager.alert("提示",result.result);
                    }
                    ;
                },
                error : function() {
                	$.messager.alert("提示!","添加失败!");
                	
                }
            });
        }
    </script>
</head>
<body>
    
<div class="mbx">
     添加 教师
</div>
<form action="#" method="post" onsubmit="return false" id="form1">
    <fieldset>
        <legend>
            <input class="submitcss" type="submit" onclick="login()" id="submit" value="保存" />
            <input class="submitcss" type="button" onclick="BackList('/es_manager/teacher/teacherManager.jsp')" value="返回" />
        </legend>
        <div class="bigdiv">
                 
            <div class="editor-label">
               	<label for="jobno">工号</label>
        	</div>
	        <div class="editor-field">
	            <input required=true class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="jobno" name="jobno" type="text" value="${role.roleName }" />
	        </div>     
            
            <div class="editor-label">
               	<label for="sname">姓名</label>
        	</div>
	        <div class="editor-field">
	            <input required=true class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="tname" name="tname" type="text" value="${role.roleStatus }" />
	        </div>
	        
	        <div class="editor-label">
                <label for="entrytime">入职时间</label>
            </div>
            <div class="editor-field">
	            <input class="easyui-datebox"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="entrytime" name="entrytime" type="text" value="${role.roleStatus }" />
	        </div>
	        
	        <div class="editor-label">
                <label for="phone">电话号码</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="phone" name="phone" type="text" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="email">邮箱</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="email" name="email" type="text" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="gender">性别</label>
            </div>
            <div class="editor-field">
	            <select name="gender" id="gender">
	            	<option value="0">女</option>
	            	<option value="1">男</option>
	            </select>
	        </div>
	        <div class="editor-label">
                <label for="college">学院</label>
            </div>
            <div class="editor-field">
	            <select name="college" id="college">
	              
	            </select>
	        </div>
	        <div class="editor-label">
                <label for="maritalstatus">婚否</label>
            </div>
            <div class="editor-field">
	            <select name="maritalstatus" id="maritalstatus">
	              
	            </select>
	        </div>
	          <div class="editor-label">
                <label for="birthdate">出生日期</label>
            </div>
            <div class="editor-field">
	            <input class="easyui-datebox"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="birthdate" name="birthdate" type="text" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="nativeplace">籍贯</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="nativeplace" name="nativeplace" type="text" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="maxdegree">最高学历</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="maxdegree" name="maxdegree" type="text" value="${role.roleStatus }" />
	        </div>
    </fieldset>

    </form>
    <c:remove var="message"/>
</body>
</html>