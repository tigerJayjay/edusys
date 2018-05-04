<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
	<title>添加排课信息</title>
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
            		for(var i = year-4;i<year;i++){
            			if(i==year-1){
            				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
            			}else{
            				$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
            			}
            		}
            	}else{
            		for(var i = year-3;i<=year;i++){
            			if(i==year){
            				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
            			}else{
                			$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>")
            			}
            		}
            		
            	}
           	}
            yeartime();
    	
 	    $.post("/es_manager/course/getCourseTypes",{},function(res){
 	    	$.each(res.rows,function(i,e){
 	    		$("#couseno").append("<option value="+e.couseno+">"+e.typeName+"</option>");
 	    	})
 	    })
 	    var colNo;
 	    var speNo;
 	    $("#college").change(function(){
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
                url: "/es_manager/schedule/addSchedule" ,//url,
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
     添加 排课信息
</div>
<form action="#" method="post" onsubmit="return false" id="form1">
    <fieldset>
        <legend>
            <input class="submitcss" type="submit" onclick="login()" id="submit" value="保存" />
            <input class="submitcss" type="button" onclick="BackList('/es_manager/examSchedule/schedule.jsp')" value="返回" />
        </legend>
        <div class="bigdiv">
            <div class="editor-label">
               	<label for="courseNo">课程号</label>
        	</div>
	        <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="courseNo" name="courseNo" type="text" value="${role.roleStatus }" />
	        </div>
	        <div class="editor-label">
               	<label for="jobno">教师工号</label>
        	</div>
	        <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="jobno" name="jobno" type="text" value="${role.roleStatus }" />
	        </div>
	        <div class="editor-label">
                <label for="place">上课地点</label>
            </div>
            <div class="editor-field">
	          <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="place" name="place" type="place" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="college">面向学院</label>
            </div>
            <div class="editor-field">
	            <select name="college" id="college">
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
                <label for="startWeek">开始周</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="startWeek" name="startWeek" type="text" value="${role.roleStatus }" />
	        </div>
	          <div class="editor-label">
                <label for="endWeek">结束周</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="endWeek" name="endWeek" type="text" value="${role.roleStatus }" />
	        </div>
	          <div class="editor-label">
                <label for="weekno">周几</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="weekno" name="weekno" type="text" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="jie">第几节</label>
            </div>
            <div class="editor-field">
	              <select id="jie" name="jie">
	              	<option value="1-2">1-2</option>
							<option value="3-4">3-4</option>
							<option value="5-6">5-6</option>
							<option value="7-8">7-8</option>
							<option value="9-10">9-10</option>
	              </select>
	        </div>
	        <div class="editor-label">
                <label for="capacity">容量</label>
            </div>
            <div class="editor-field">
	           <input class="text-box single-line"  data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="capacity" name="capacity" type="text" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="yeartime">学年</label>
            </div>
            <div class="editor-field">
	          	<select id="yeartime" name="yeartime"></select>
	        </div>
	  		 <div class="editor-label">
                <label for="des">学期</label>
            </div>
            <div class="editor-field">
	            <select id="termtime" name="termtime">
	            	<option value="1">1</option>
	            	<option value="2">2</option>
	            </select>
	        </div>
	       
    </fieldset>

    </form>
    <c:remove var="message"/>
</body>
</html>