<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>选课页面</title>
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
</head>
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
  	$('#flexigridData').datagrid({
        title: '课程信息', //列表的标题
        iconCls: 'icon-site',
        width: 'auto',
        height: 'auto',
        nowrap: false,
        striped: true,
        collapsible: true,
        singleSelect: true,
        url: '/es_manager/schedule/getScheduleSpread', //获取数据的url
        sortName: 'Id',
        sortOrder: 'desc',
        queryParams:{condition:search},
        idField: 'Id',
        toolbar:'#search',
		  columns: [[
		             { field: 'SCHE_NO', title: '<label for="SCHE_NO">排课号</label>',width:150,hidden:'true'},
		           { field: 'course_no', title: '<label for="COURSE_NO">课程号</label>',width:150,formatter: function(value,row,index){
        					$("#courseNo").val(value);
        					return value;
        				} },
		           { field: 'jobno', title: '<label for="jobno">教师工号</label>',width:150},
		           { field: 'tname', title: '<label for="tname">教师姓名</label>',width:150},
		           { field: 'capacity', title: '<label for="capacity">总量</label>',width:150},
		           { field: 'margin', title: '<label for="margin">余量</label>',width:150},
		           { field: 'timeandplace', title: '<label for="timeandplace">时间地点</label>',width:150}
					, { field: 'course_name', title: '<label for="TYPE_NAME">课程类型</label>', width: 226 
					}
					, { field: 'credit', title: '<label for="CREDIT">学分</label>', width: 226
					}
					, { field: 'weektime', title: '<label for="WEEKTIME">周学时</label>', width: 100 }
					, { field: 'totaltime', title: '<label for="TOTALTIME">总学时</label>', width: 100 }
					, { field: 'des', title: '<label for="DES">描述</label>', width: 200 }
					, { field: 'mark', title: '<label for="SPE_NAME">选择</label>', width: 200,formatter: function(value,row,index){
						
 	        				if(value==0){
 	        					return "<input type='radio' name='mark'>";
 	        				}else{
 	        					 $("#selected").val(row.SCHE_NO);
 	        					return "<input id='"+row.SCHE_NO+"' type='radio' name='mark' checked>";
 	        				}
 						} }
					
             ]],
        rownumbers: true

    });
  	
  	
})
 function flexiModify() {
			var reserve = $("input[name='reserve']:checked").val();
			var sno = $("#sno").val();
			var yeartime = $("#yeartime").val();
			var termtime = $("#termtime").val();
			var courseNo = $("#courseNo").val();
			$.post("/es_manager/bookReserve/insertBookReserve",{sno:sno,yeartime:yeartime,termtime:termtime,courseNo:courseNo,reserve:reserve},function(res){
				
			},"json")
			var seScheNo1 =  $("#selected").val();
         var arr = $('#flexigridData').datagrid('getSelections');
             $.post("/es_student/selectCourse/insert",{scheNo:arr[0].SCHE_NO+"&"+seScheNo1},function(res){
            	 $.messager.alert('操作提示',res.result, 'warning');
            	 var search = $("#queryCondition").serialize();
            		search = search.replace(/&/g,",");
            		search = search.replace(/=/g,":");
            		search = decodeURIComponent(search,true);
            		 $('#flexigridData').datagrid('reload',{
            		 condition:search
            		});
             },"json")
     };
</script>
<body>
<div class="page .container-fluid">
	<div class="content">
    <div class="panel panel-primary">
      <div class="panel-heading">
         <h3 class="panel-title">开课详情</h3>
      </div>
      <div class="panel-body">
      <div id="search">
      	是否预定教材：
      	<input type="radio" name="reserve" value="1">预定
      	<input type="radio" name="reserve" value="0" checked>不预定
		<a href="#" onclick="flexiModify();" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">保存</a>
	 </div>
         <table id="flexigridData">
             
         </table>
        <form id="queryCondition">
						 <input id="college" name="college" type="hidden" value="${user.college}">
						 <input id="specialty" name="specialty" type="hidden" value="${user.classname}">
						 <input id="sno" name="sno" type="hidden" value="${user.sno}"/>	
						
						 <input id="classno" name="classno" type="hidden" value="${user.classNo }">
						         
					 	 <input id="grade" name="grade" type="hidden" value="${user.grade }">
					 		
					 	 <input type="hidden" id="courseNo" name="courseNo" value="<%=request.getParameter("courseNo")%>">
					 	 
					 	 <input type="hidden" id="yeartime" name="yeartime">
					 	 	
					 	 <input id="termtime" name="termtime" type="hidden">
						
						 <input id="selected" name="selected" type="hidden">
						 <input id="courseNo" name="courseNo" type="hidden">
						 
					</form>
      </div>
    </div>
    
  </div>
	<div class="footer"></div>
</div>
</body>
<c:remove var="message"/>
</html>