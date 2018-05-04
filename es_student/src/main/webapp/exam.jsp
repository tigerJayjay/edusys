<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>考试安排</title>
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
		<script type="text/javascript" language="javaScript">
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
            fitColumns:true,
            collapsible: true,
            singleSelect: true,
            url: '/es_manager/examArrange/getArrange', //获取数据的url
            sortName: 'Id',
            sortOrder: 'desc',
            idField: 'Id',
            queryParams:{condition:search+",sno:"+"${user.sno}"},
				toolbar:'#search',
			  columns: [[
					{ field: 'COURSE_NO', title: '<label for="SCHE_NO">课程号</label>'}
					,{ field: 'COURSE_NAME', title: '<label for="COURSE_NAME">课程名</label>'}
			           ,{ field: 'WEEKTH', title: '<label for="COURSE_NO">第几周</label>'}
					, { field: 'WEEKNO', title: '<label for="JOBNO">周几</label>', width: 226 }
					, { field: 'SCHOOLTIME', title: '<label for="COURSE_NAME">第几节</label>', width: 200 }
					
					
	                ]],
            rownumbers: true

        });
	})
	 //“查询”按钮，弹出查询框
        function flexiQuery() {
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
                 fitColumns:true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/examArrange/getArrange', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
{ field: 'COURSE_NO', title: '<label for="SCHE_NO">课程号</label>'}
,{ field: 'COURSE_NAME', title: '<label for="COURSE_NAME">课程名</label>'}
,{ field: 'WEEKTH', title: '<label for="COURSE_NO">第几周</label>'}
, { field: 'WEEKNO', title: '<label for="JOBNO">周几</label>', width: 226 }
, { field: 'SCHOOLTIME', title: '<label for="COURSE_NAME">第几节</label>', width: 200 }
 						
  	                ]],
                 rownumbers: true

             });
        };
    
	</script>
</head>
<body>
<div class="page .container-fluid">
	<jsp:include page="stutop.jsp"></jsp:include>
	<div class="content">
    <div class="panel panel-primary">
    <form id="queryCondition">
      <div class="panel-heading">
        <select name="yeartime" id="yeartime">
         
        </select>
         <select name="termtime" id="termtime">
         	<option value="1">1</option>
         	<option value="2">2</option>
         </select>
        <a href="javascript:flexiQuery();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;
      </div>
      </form>
      <div class="panel-body">
   <table id="flexigridData">
    
</table>
      </div>
    </div>
    
  </div>
	<div class="footer"></div>
</div>
</body>
</html>