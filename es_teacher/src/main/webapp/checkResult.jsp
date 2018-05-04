<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head id="MyHead">

		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/student-main.css">
	<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/student-main.js"></script>
	<script src="/es_teacher/resources/Scripts/jquery-1.8.3.min.js"
		type="text/javascript"></script>
	<script src="/es_teacher/resources/Scripts/jquery.easyui.min-1.3.5.js"
		type="text/javascript"></script>
	<script src="/es_teacher/resources/Scripts/jquery.datagrid.js"
		type="text/javascript"></script>
	<script src="/es_teacher/resources/Scripts/JScriptIndex.js"
		type="text/javascript"></script>
	<link href="/es_teacher/resources/Content/default.css" rel="stylesheet"
		type="text/css" />
	<link href="/es_teacher/resources/Content/IndexStyle.css"
		rel="stylesheet" type="text/css" />
	<link href="/es_teacher/resources/Res/easyui/themes/icon.css"
		rel="stylesheet" type="text/css" />
	<script
		src="/es_teacher/resources/Res/easyui/locale/easyui-lang-zh_CN.js"
		type="text/javascript"></script>
	<link href="/es_teacher/resources/Res/easyui/themes/default/easyui.css"
		rel="stylesheet" type="text/css" />
<title>评教结果</title>

<script type="text/javascript" language="javascript">

        $(function () {
            	    function yeartime(){
                  	var date = new Date();
                  	var year = date.getFullYear();
                  	var month = date.getMonth()+1;
                  	if(month<9){
                  		for(var i = year-8;i<year;i++){
                  			if(i==year-1){
                  				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
                  			}else{
                  				$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
                  			}
                  		}
                  	}else{
                  		for(var i = year-7;i<=year;i++){
                  			if(i==year){
                  				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
                  			}else{
                      			$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>")
                  			}
                  		}
                  		
                  	}
                 	}
            	    var tno = "${user.jobno}";
            	    
            	$.post("/es_teacher/getSelectInfo",{condition:"tno:"+tno},function(res){
            		$.each(res.rows,function(i,e){
            			$("#courseNo").append("<option value='"+e.course_no+"'>"+e.course_name+"</option>");
            			  yeartime();
                        	var search = $("#queryCondition").serialize();
                      	search = search.replace(/&/g,",");
                      	search = search.replace(/=/g,":");
                      	search = decodeURIComponent(search,true);
                      $('#flexigridData').datagrid({
                          title: '考评信息', //列表的标题
                          iconCls: 'icon-site',
                          width: 'auto',
                          height: 'auto',
                          nowrap: false,
                          striped: true,
                          collapsible: true,
                          singleSelect: true,
                          url: '/es_manager/teachermanager/checkResult', //获取数据的url
                          sortName: 'Id',
                          sortOrder: 'desc',
                          queryParams:{condition:search},
                          idField: 'Id',
           				toolbar:'#search',
           				columns: [[
             						  { field: 'jobno', title: '<label for="jobno">工号</label>'}
             						, { field: 'tname', title: '<label for="tname">姓名</label>', width: 100 }
             						,{field: 'college', title: '<label for="college">学院</label>', width: 226},
             						{field: 'courseNo', title: '<label for="college">课程号</label>', width: 100},
             						{field: 'courseName', title: '<label for="college">课程名</label>', width: 150}
             						, { field: 'checkContent', title: '<label for="checkContent">考评内容</label>', width: 350 },
             						 {field: 'countsYouxiu', title: '<label for="countsYouxiu">优秀</label>', width: 100}
             						, { field: 'countsLianghao', title: '<label for="countsLianghao">良好</label>', width: 100 },
             						 {field: 'countsZhongdeng', title: '<label for="countsZhongdeng">中等</label>', width: 100}
             						, { field: 'countsJige', title: '<label for="countsJige">及格</label>', width: 100 },
             						{ field: 'countsBujige', title: '<label for="countsBujige">不及格</label>', width: 100 }
             	                ]],
                          pagination: true,
                          rownumbers: true

                      });
            		})
            	},"json")
              

        });
        
        //“查询”按钮，弹出查询框
        function flexiQuery() {
        	var search = $("#queryCondition").serialize();
        	search = search.replace(/&/g,",");
        	search = search.replace(/=/g,":");
        	search = decodeURIComponent(search,true);
        	 $('#flexigridData').datagrid({
                 title: '考评信息', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 striped: true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/teachermanager/checkResult', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  				columns: [[
   						  { field: 'jobno', title: '<label for="jobno">工号</label>'}
   						, { field: 'tname', title: '<label for="tname">姓名</label>', width: 226 }
   						,{field: 'college', title: '<label for="college">学院</label>', width: 226},
   						{field: 'courseNo', title: '<label for="college">课程号</label>', width: 226},
   						{field: 'courseName', title: '<label for="college">课程名</label>', width: 226}
   						, { field: 'checkContent', title: '<label for="checkContent">考评内容</label>', width:300 },
   						 {field: 'countsYouxiu', title: '<label for="countsYouxiu">优秀</label>', width: 100}
   						, { field: 'countsLianghao', title: '<label for="countsLianghao">良好</label>', width: 100 },
   						 {field: 'countsZhongdeng', title: '<label for="countsZhongdeng">中等</label>', width: 100}
   						, { field: 'countsJige', title: '<label for="countsJige">及格</label>', width: 100 },
   						{ field: 'countsBujige', title: '<label for="countsBujige">不及格</label>', width: 100 }
   	                ]],
                 pagination: true,
                 rownumbers: true

             });
        };

    </script>

<base target="_self">
</head>
<body class="easyui-layout" style="padding: 3px;">

<jsp:include page="stutop.jsp"></jsp:include>
	<table id="flexigridData" fit="true">
	</table>

	<div id="divQuery" title="查询列表" class="easyui-dialog" closed="true"
		modal="false" iconcls="icon-search">
		<div class="input">
			<div class="editor-label-search">
				<label for="roleName">名称</label>
			</div>
			<div class="editor-field-search">
				<input type='text' id='roleName' />
			</div>
		</div>
	</div>
	<div id="search" style="padding: 5px;">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<form id="queryCondition">
						<input  value="${user.jobno }" name="tno" id="tno" type="hidden" style="width: 80px">
						
						学年： <select id="yeartime" name="yeartime"></select>
						学期：<select id="termtime" name="termtime">
								  <option value="1">1</option>
								  <option value="2" selected>2</option>
						      </select>
						 课程：<select id="courseNo" name="courseNo">
						 
						 	  </select>
					</form>
					<button onclick="flexiQuery();">查询</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
