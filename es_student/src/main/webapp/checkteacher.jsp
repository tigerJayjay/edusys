<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/student-main.css">
	<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/student-main.js"></script>
	<script src="/es_student/resources/Scripts/jquery-1.8.3.min.js"
		type="text/javascript"></script>
	<script src="/es_student/resources/Scripts/jquery.easyui.min-1.3.5.js"
		type="text/javascript"></script>
	<script src="/es_student/resources/Scripts/jquery.datagrid.js"
		type="text/javascript"></script>
	<script src="/es_student/resources/Scripts/JScriptIndex.js"
		type="text/javascript"></script>
	<link href="/es_student/resources/Content/default.css" rel="stylesheet"
		type="text/css" />
	<link href="/es_student/resources/Content/IndexStyle.css"
		rel="stylesheet" type="text/css" />
	<link href="/es_student/resources/Res/easyui/themes/icon.css"
		rel="stylesheet" type="text/css" />
	<script
		src="/es_student/resources/Res/easyui/locale/easyui-lang-zh_CN.js"
		type="text/javascript"></script>
	<link href="/es_student/resources/Res/easyui/themes/default/easyui.css"
		rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(function () {
	var date = new Date();
  	var year = date.getFullYear();
  	var month = date.getMonth()+1; 
  	if(month<6){
  			$("#yeartime").val((year-1)+"-"+year);
  			$("#termtime").val(2);
  	}else{
      		$("#yeartime").val(year+"-"+(year-0+1));
  			$("#termtime").val(1);
  	}
  	var search = $("#queryCondition").serialize();
	search = search.replace(/&/g,",");
	search = search.replace(/=/g,":");
	search = decodeURIComponent(search,true);
	$.post("/es_manager/schedule/getScheduleSpread",{condition:search},function(res){
		$.each(res.rows,function(i,e){
			if(e.mark!='0')
			$("#teacher").append("<option value='"+e.jobno+","+e.course_no+"'>"+e.course_name+"("+e.tname+")"+"</option>")
		})
		
	},"json");
	
  	contentflush();
})

function contentflush(){
	$("#content").empty();
	var selection;
	$.post("/es_manager/teachermanager/getCheckContent",{},function(res){
		$.each(res.rows,function(i,e){
			$("#content").append("<tr><td id='"+e.no+"'>"+e.content+"</td><td></td></tr>")
			if(i==0){
				selection = e.selections;
			}
			$.each(selection,function(m,se){
				$("#content tr:eq("+i+") td:eq(1)").append("<input name='selection"+i+"' type='radio' value='"+se.no+"'>"+se.selection)
			})
			
		})
		$("#content").append("<tr id='submit'><td><button onclick='save();'>提交</button></td></tr>")
		
	},"json");
}
function save(){
	var content = "";
	 var count = 0;
	 var count1 = 0;
	 $("#content tr:not(#submit)").each(function(){
		content += ","+$(this).find("td").eq(0).attr('id');
		count++;
	}) 
	var select = "";
	 $("input[type='radio']:checked").each(function(){
		 select += ","+$(this).val();
		 count1++;
	 })
	 if(count!=count1){
		 $.messager.alert("提示","请选择完整再提交!");
		 return false;
	 }
	 var yeartime = $("#yeartime").val();
	 var termtime = $("#termtime").val();
	 var sno = $("#sno").val();
	 var tno = $("#teacher").val();
	 $.post("/es_student/check",{content:content,select:select,yeartime:yeartime,termtime:termtime,sno:sno,tno:tno},function(res){
		 $.messager.alert("提示",res.result);
	 },"json")
}

</script>
</head>
<body>
<div class="page .container-fluid">
	<jsp:include page="stutop.jsp"></jsp:include>
	<div class="content">
    <div class="panel panel-primary">
     <div class="panel-heading">
         <h3 class="panel-title">评教</h3>
      </div>
      <div class="panel-body">
      	 <form id="queryCondition">
						 <input id="college" name="college" type="hidden" value="${user.college}">
						 <input id="specialty" name="specialty" type="hidden" value="${user.classname}">
						 <input id="sno" name="sno" type="hidden" value="${user.sno}"/>	
						
						 <input id="classno" name="classno" type="hidden" value="${user.classNo }">
						         
					 	 <input id="grade" name="grade" type="hidden" value="${user.grade }">
					 		
					 	 <input type="hidden" id="yeartime" name="yeartime">
					 	 	
					 	 <input id="termtime" name="termtime" type="hidden">
					</form>
	<form action="#" onsubmit="return false" id="form1">
		<select id="teacher" onchange="contentflush();"  name="teacher">
			
		</select>
		<table id="content" name="content">
			
		</table>
	</form>
      </div>
    </div>
    
  </div>
	<div class="footer"></div>
</div>
 
</body>
</html>