<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
	<title>修改教师信息</title>
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
   function login() {
            $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/es_manager/teachermanager/updateExpre" ,//url,
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
     更新 教师工作情况
</div>
<form action="#" method="post" onsubmit="return false" id="form1">
    <fieldset>
        <legend>
            <input class="submitcss" type="submit" onclick="login()" id="submit" value="保存" />
            <input class="submitcss" type="button" onclick="BackList('/es_manager/teacher/workExpre.jsp')" value="返回" />
        </legend>
        <div class="bigdiv">
                  <input style="display: none" value="${expre.no }" name="no">
            <div class="editor-label">
               	<label for="workerNo">工号</label>
        	</div>
	        <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="workerNo" name="workerNo" type="text" value="${expre.workerNo }" />
	        </div>     
            
            <div class="editor-label">
               	<label for="compony">公司</label>
        	</div>
	        <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="compony" name="compony" type="text" value="${expre.compony}" />
	        </div>
	        
	        <div class="editor-label">
                <label for="begintime">开始时间</label>
            </div>
            <div class="editor-field">
	            <input class="easyui-datebox" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="begintime" name="begintime" type="text" value='<fmt:formatDate value="${expre.begintime}"  type="date" dateStyle="default"/>' />
	        </div>
	        
	        <div class="editor-label">
                <label for="endtime">结束时间</label>
            </div>
            <div class="editor-field">
	            <input class="easyui-datebox" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="endtime" name="endtime" type="text" value='<fmt:formatDate value="${expre.endtime}"  type="date" dateStyle="default"/>' />
	        </div>
	        
	        <div class="editor-label">
                <label for="des">描述</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="des" name="des" type="text" value="${expre.des}" />
	        </div>
	        <div class="editor-label">
                <label for="positions">职位</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="positions" name="positions" type="text" value="${expre.positions}" />
	        </div>
    </fieldset>

    </form>
</body>
</html>