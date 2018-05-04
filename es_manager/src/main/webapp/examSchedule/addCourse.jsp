<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
	<title>添加违纪信息</title>
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
 	    		$("#colNo").append("<option value="+e.colNo+">"+e.colName+"</option>")
 	    	})
 	    })   
 	    $.post("/es_manager/course/getCourseTypes",{},function(res){
 	    	$.each(res.rows,function(i,e){
 	    		$("#couseno").append("<option value="+e.couseno+">"+e.typeName+"</option>");
 	    	})
 	    })
 	    var colNo;
 	    var speNo;
 	    $("#colNo").change(function(){
 	    	colNo = $(this).val();
 	    	$("#specialty option:gt(0)").remove();
 	    	 $.post("/es_manager/specialty/getSpeByCol",{colNo:colNo},function(res){
      	    	$.each(res.rows,function(i,e){
      	    		$("#specialty").append("<option value="+e.speNo+">"+e.speName+"</option>")
      	    	})
      	    })   
 	    })
 	    
 	     $("#specialty").change(function(){
 	    	speNo = $(this).val();
 	    	$("#classno option:gt(0)").remove();
 	    	 $.post("/es_manager/classes/getClaBySpe",{speNo:speNo,colNo:colNo},function(res){
      	    	$.each(res.rows,function(i,e){
      	    		$("#classno").append("<option value="+e.classNo+">"+e.classNo+"班"+"</option>")
      	    	})
      	    })   
 	    })
 	    function grade(){
 	    	var nowdate = new Date();
 	    	var year = nowdate.getFullYear();
 	    	var month = nowdate.getMonth();
 	    	if(month>7){
 	    		for(var i = year-3;i<=year;i++){
 	    			$("#grade").append("<option value='"+i+"'>"+i+"</option>");
 	    		}
 	    	}else{
 	    		for(var i = year-4;i<year;i++){
 	    			$("#grade").append("<option value='"+i+"'>"+i+"</option>");
 	    		}
 	    	}
 	    }
 	    grade();
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
                url: "/es_manager/course/addCourse" ,//url,
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
     添加 教材
</div>
<form action="#" method="post" onsubmit="return false" id="form1">
    <fieldset>
        <legend>
            <input class="submitcss" type="submit" onclick="login()" id="submit" value="保存" />
            <input class="submitcss" type="button" onclick="BackList('/es_manager/examSchedule/course.jsp')" value="返回" />
        </legend>
        <div class="bigdiv">
            <div class="editor-label">
               	<label for="courseNo">课程号</label>
        	</div>
	        <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="courseNo" name="courseNo" type="text" value="${role.roleStatus }" />
	        </div>
	        <div class="editor-label">
                <label for="couseno">课程类型</label>
            </div>
            <div class="editor-field">
	             <select id="couseno" name="couseno"></select>
	        </div>
	         <div class="editor-label">
                <label for="colNo">面向学院</label>
            </div>
            <div class="editor-field">
	            <select name="colNo" id="colNo">
	            <option value="">无</option>
				</select>
	        </div>
	       <div class="editor-label">
                <label for="specialty">面向专业</label>
            </div>
            <div class="editor-field">
	            <select id="specialty" name="specialty">
	            <option value="">无</option>
						      </select>
	        </div>
	        <div class="editor-label">
                <label for="classno">面向班级</label>
            </div>
            <div class="editor-field">
	            <select id="classno" name="classno">
	            <option value="">无</option>
						      </select>
	        </div>
	        <div class="editor-label">
                <label for="grade">面向年级</label>
            </div>
            <div class="editor-field">
	            <select id="grade" name="grade">
	            <option value="">无</option>
						      </select>
	        </div>
	         <div class="editor-label">
                <label for="courseName">课程名</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="courseName" name="courseName" type="text" value="${role.roleStatus }" />
	        </div>
	          <div class="editor-label">
                <label for="credit">学分</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="credit" name="credit" type="text" value="${role.roleStatus }" />
	        </div>
	        <div class="editor-label">
                <label for="weektime">周学时</label>
            </div>
            <div class="editor-field">
	           <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="weektime" name="weektime" type="text" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="totaltime">总学时</label>
            </div>
            <div class="editor-field">
	           <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="totaltime" name="totaltime" type="text" value="${role.roleStatus }" />
	        </div>
	  		 <div class="editor-label">
                <label for="des">备注</label>
            </div>
            <div class="editor-field">
	           <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="des" name="des" type="text" value="${role.roleStatus }" />
	        </div>
	       
    </fieldset>

    </form>
    <c:remove var="message"/>
</body>
</html>