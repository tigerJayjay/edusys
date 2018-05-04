<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
	<title>修改学生信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../resources/Scripts/jquery.min.js" type="text/javascript"></script>
    <script src="../resources/Scripts/JScriptCommon.js" type="text/javascript"></script>
    <link href="../resources/Content/StyleSheet.css" rel="stylesheet" type="text/css" />
    <script src="../resources/Scripts/jquery.validate.min.js" type="text/javascript"></script>
    <script src="../resources/Scripts/jquery.validate.unobtrusive.min.js" type="text/javascript"></script>
    <link href="../resources/Content/IndexStyle.css" rel="stylesheet" type="text/css" />
    <script src="../resources/Res/easyui/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="../resources/Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="../resources/Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
    <link href="../resources/Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
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
                url: "/es_manager/usermanager/updateStu" ,//url,
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
                	$.messager.alert("提示!","修改失败!");
                	
                }
            });
        }
    </script>
</head>
<body>
    
<div class="mbx">
     更新 学生
</div>
<form action="#" method="post" onsubmit="return false" id="form1">
    <fieldset>
        <legend>
            <input class="submitcss" type="submit" onclick="login()" id="submit" value="保存" />
            <input class="submitcss" type="button" onclick="BackList('/es_manager/student/studentManager.jsp')" value="返回" />
        </legend>
        <div class="bigdiv">
                 
            <div class="editor-label">
               	<label for="sno">学号</label>
        	</div>
	        <div class="editor-field">
	            <input readonly="readonly" class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="sno" name="sno" type="text" value="${stu.sno}" />
	        </div>     
            
            <div class="editor-label">
               	<label for="sname">姓名</label>
        	</div>
	        <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="sname" name="sname" type="text" value="${stu.sname}" />
	        </div>
	        
	        <div class="editor-label">
                <label for="entranceTime">入学时间</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="entranceTime" name="entranceTime" type="text" value="${stu.entranceTime}" />
	        </div>
	        
	        <div class="editor-label">
                <label for="grade">年级</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="grade" name="grade" type="text" value="${stu.grade }" />
	        </div>
	         <div class="editor-label">
                <label for="classname">班级</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="classname" name="classname" type="text" value="${stu.classname}" />
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
    </fieldset>

    </form>
    <c:remove var="message"/>
</body>
</html>