<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
	<title>添加教材信息</title>
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
    	 function yeartime(){
           	var date = new Date();
           	var year = date.getFullYear();
           	var month = date.getMonth()+1;
           	if(month<9){
           		for(var i = year-8;i<year;i++){
           			if("${arrange.yeartime}"==(i+"-"+(i-0+1))){
           				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
           			}else{
           				$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
           			}
           		}
           	}else{
           		for(var i = year-7;i<=year;i++){
           			if("${arrange.yeartime}"==(i+"-"+(i-0+1))){
           				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
           			}else{
               			$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>")
           			}
           		}
           		
           	}
          	}
           yeartime();
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
                url: "/es_manager/examArrange/updateExamArrange" ,//url,
                contentType: "application/json",
                data:JSON.stringify($('#form1').serializeJSON()),
                success: function (result) {
                    	$.messager.alert("提示",result.result);
                },
                error : function() {
                	$.messager.alert("提示!","更新失败!");
                	
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
            <input class="submitcss" type="button" onclick="BackList('/es_manager/exam/examArrange.jsp')" value="返回" />
        </legend>
        <div class="bigdiv">
        	<input value="${arrange.no}" name="no" id="no" type="hidden">
         
	        <div class="editor-label">
                <label for="courseNo">课程号</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="courseNo" name="courseNo" type="text" value="${arrange.courseNo }" />
	        </div>
	         <div class="editor-label">
                <label for="yeartime">学年</label>
            </div>
            <div class="editor-field">
	            <select name="yeartime" id="yeartime">
				</select>
	        </div>
	       <div class="editor-label">
                <label for="termtime">学期</label>
            </div>
            <div class="editor-field">
	            <select name="termtime" id="termtime">
	            			<c:if test="${arrange.termtime==1}">
	            			<option value="1" selected="selected">1</option>
							<option value="2">2</option>
	            			</c:if>
							
							<c:if test="${arrange.termtime==2 }">
								<option value="1" >1</option>
							<option value="2" selected="selected">2</option>
							</c:if>
						</select>
	        </div>
	         <div class="editor-label">
                <label for="weekth">第几周</label>
            </div>
            <div class="editor-field">
	            <input class="easyui-numberbox" data-options="min:1,max:18,required:true" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="weekth" name="weekth" type="text" value="${arrange.weekth}" />
	        </div>
	          <div class="editor-label">
                <label for="weekno">周几</label>
            </div>
            <div class="editor-field">
	            <input class="easyui-numberbox" data-options="min:1,max:7,required:true" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="weekno" name="weekno" type="text" value="${arrange.weekno}" />
	        </div>
	        <div class="editor-label">
                <label for="schooltime">第几节</label>
            </div>
            <div class="editor-field">
	            <select name="schooltime" id="schooltime">
							<option value="1-2">1-2</option>
							<option value="3-4">3-4</option>
							<option value="5-6">5-6</option>
							<option value="7-8">7-8</option>
							<option value="9-10">9-10</option>
				</select>
	        </div>
	         <div class="editor-label">
                <label for="examPlace">教室号</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="examPlace" name="examPlace" type="text" value="${arrange.examPlace}" />
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