<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script src="/es_manager/resources/Scripts/jquery-1.8.3.min.js"
		type="text/javascript"></script>
	<script src="/es_manager/resources/Scripts/jquery.easyui.min-1.3.5.js"
		type="text/javascript"></script>
	<script src="/es_manager/resources/Scripts/jquery.datagrid.js"
		type="text/javascript"></script>
	<script src="/es_manager/resources/Scripts/JScriptIndex.js"
		type="text/javascript"></script>
	<link href="/es_manager/resources/Content/default.css" rel="stylesheet"
		type="text/css" />
	<link href="/es_manager/resources/Content/IndexStyle.css"
		rel="stylesheet" type="text/css" />
	<link href="/es_manager/resources/Res/easyui/themes/icon.css"
		rel="stylesheet" type="text/css" />
	<script
		src="/es_manager/resources/Res/easyui/locale/easyui-lang-zh_CN.js"
		type="text/javascript"></script>
	<link href="/es_manager/resources/Res/easyui/themes/default/easyui.css"
		rel="stylesheet" type="text/css" />
	<script type="text/javascript" language="javascript">
    $(function () {
	      	var date = new Date();
	      	var year = date.getFullYear();
	      	var month = date.getMonth()+1; 
	      	if(month<6){
	      			$("#yeartime1").append("<option value='"+(year-1)+"-"+year+"'>"+(year-1)+"-"+(year)+"</option>");
	      			$("#termtime1").append("<option value='2'>2</option>");
	      			$("#yeartime").val((year-1)+"-"+year);
	      			$("#termtime").val(2);
	      	}else{
	          		$("#yeartime1").append("<option value='"+year+"-"+(year-0+1)+"'>"+year+"-"+(year-0+1)+"</option>")
	      			$("#termtime1").append("<option value='1'>1</option>");
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
                url: '/es_manager/schedule/getScheduleMerge', //获取数据的url
                sortName: 'Id',
                sortOrder: 'desc',
                queryParams:{condition:search},
                idField: 'Id',
 			  columns: [[
 			           { field: 'course_no', title: '<label for="COURSE_NO">课程号</label>',width:150}
 						, { field: 'course_name', title: '<label for="TYPE_NAME">课程名</label>', width: 226 ,	formatter: function(value,row,index){
 	        				return "<a target='_blank' href='/es_manager/courseinfo.jsp?courseNo="+row.course_no+"'>"+value+"</a>";
 						}
 						}
 						, { field: 'type_name', title: '<label for="COURSE_NAME">课程类型</label>', width: 100 }
 						, { field: 'credit', title: '<label for="CREDIT">学分</label>', width: 226
 						}
 						, { field: 'weektime', title: '<label for="WEEKTIME">周学时</label>', width: 100 }
 						, { field: 'totaltime', title: '<label for="TOTALTIME">总学时</label>', width: 100 }
 						, { field: 'des', title: '<label for="DES">描述</label>', width: 200 }
 						, { field: 'mark', title: '<label for="SPE_NAME">选择状态</label>', width: 200,formatter: function(value,row,index){
 	        				if(value==0){
 	        					return "未选";
 	        				}else{
 	        					return "已选";
 	        				}
 						}}
 						
 	                ]],
                rownumbers: true

            });
    })
	</script>
</head>
<body>
<div class="page .container-fluid">
	<jsp:include page="stutop.jsp"></jsp:include>
	<div class="content">
    <div class="panel panel-primary">
      <div class="panel-heading">
         <h3 class="panel-title"><select id="yeartime1" name="yeartime1"></select>学年<select id="termtime1" name="termtime1"></select>学期</h3>
      </div>
      <div class="panel-body">
      	 <form id="queryCondition">
						 <input id="college" name="college" type="hidden" value="${user.college}">
						 <input id="specialty" name="specialty" type="hidden" value="${user.classname}">
						 <input id="sno" name="sno" type="hidden" value="${user.sno}"/>	
						
						 <input id="classno" name="classno" type="hidden" value="${user.classNo}">
						         
					 	 <input id="grade" name="grade" type="hidden" value="${user.grade }">
					 		
					 	
					 	 <input type="hidden" id="yeartime" name="yeartime">
					 	 	
					 	 <input id="termtime" name="termtime" type="hidden">
						
					</form>
         <table id="flexigridData">
         </table>
      </div>
    </div>
    
  </div>
	<div class="footer"></div>
</div>
</body>
</html>