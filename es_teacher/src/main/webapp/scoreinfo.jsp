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
<title>成绩录入</title>

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
                yeartime();
                var tno = "${user.jobno}";
                var yeartime = $("#yeartime").val();
                var termtime = $("#termtime").val();
            	  $.post("/es_teacher/getSelectInfo",{condition:"tno:"+tno+",yeartime:"+yeartime+",termtime:"+termtime},function(res){
            	    	$.each(res.rows,function(i,e){
            	    		$("#courseNo").append("<option value="+e.course_no+">"+e.course_name+"</option>");
            	    	})

             		   var search = $("#queryCondition").serialize();
                    	search = search.replace(/&/g,",");
                    	search = search.replace(/=/g,":");
                    	search = decodeURIComponent(search,true);
             		$('#flexigridData').datagrid({
                         title: '成绩录入', //列表的标题
                         iconCls: 'icon-site',
                         width: 'auto',
                         height: 'auto',
                         nowrap: false,
                         fitColumns:true,
                         striped: true,
                         collapsible: true,
                         singleSelect: true,
                         url: '/es_teacher/getSelectInfo', //获取数据的url
                         sortName: 'Id',
                         sortOrder: 'desc',
                         idField: 'Id',
          				toolbar:'#search',
          			  queryParams:{condition:search},
          			  columns: [[
        					{ field: 'sno', title: '<label for="courseNo">学号</label>',  width: 226}
        				, { field: 'course_no', title: '<label for="TERMTIME">课程号</label>',  width: 226
        				},{ field: 'yeartime', title: '<label for="YEARTIME">学年</label>', width: 250
        					}
        				, { field: 'termtime', title: '<label for="WEEKTH">学期</label>', width: 226 },
        				{ field: 'PAPER_SCORE', title: '<label for="WEEKNO">卷面分</label>', width: 100 },
        				{ field: 'MANI_SCORE', title: '<label for="SCHOOLTIME">平时分</label>', width: 226 },
        				{ field: 'TOTAL_SCORE', title: '<label for="classno">总分</label>', width: 100 },
        				{ field: 'REEXAM', title: '<label for="jobno">补考</label>', width: 200 },
        				{ field: 'REBUILD', title: '<label for="COLLEGE">重修</label>', width: 100 }
          	                ]],
          	                 pagination: true,
                         rownumbers: true

                     });
            	    })  
        });
        function exports() {  
          var data = JSON.stringify($('#flexigridData').datagrid('getData').rows); 
           if (data == '')  
                return;  
   		 $("#json").val(data);
   		 $("#title").val(document.title);
   		 $("#exportdiv").submit();
        } 
        //“查询”按钮，弹出查询框
        function flexiQuery() {
        	var search = $("#queryCondition").serialize();
        	search = search.replace(/&/g,",");
        	search = search.replace(/=/g,":");
        	search = decodeURIComponent(search,true);
        	 $('#flexigridData').datagrid({
                 title: '考试监考安排信息', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 striped: true,
                 fitColumns:true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_teacher/getSelectInfo', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
						{ field: 'sno', title: '<label for="courseNo">学号</label>',  width: 226}
        				, { field: 'course_no', title: '<label for="TERMTIME">课程号</label>',  width: 226
        				},{ field: 'yeartime', title: '<label for="YEARTIME">学年</label>', width: 250
        					}
        				, { field: 'termtime', title: '<label for="WEEKTH">学期</label>', width: 226 },
        				{ field: 'PAPER_SCORE', title: '<label for="WEEKNO">卷面分</label>', width: 100 },
        				{ field: 'MANI_SCORE', title: '<label for="SCHOOLTIME">平时分</label>', width: 226 },
        				{ field: 'TOTAL_SCORE', title: '<label for="classno">总分</label>', width: 100 },
        				{ field: 'REEXAM', title: '<label for="jobno">补考</label>', width: 200 },
        				{ field: 'REBUILD', title: '<label for="COLLEGE">重修</label>', width: 100 }
  	                ]],

  	                 pagination: true,
                 rownumbers: true

             });
        };
        //导入学生信息
		function flexiImport(){
			 $('#divimport').dialog({
	                buttons: [{
	                    text: '导入',
	                    iconCls: 'icon-ok',
	                    handler: function () {
	                             var formData = new FormData();
	                             formData.append("inputExcel", document.getElementById("excel").files[0]);   
	                             $.ajax({
	                                 url: "/es_teacher/uploadStuScore",
	                                 type: "POST",
	                                 data: formData,
	                                 /**
	                                 *必须false才会自动加上正确的Content-Type
	                                 */
	                                 contentType: false,
	                                 /**
	                                 * 必须false才会避开jQuery对 formdata 的默认处理
	                                 * XMLHttpRequest会对 formdata 进行正确的处理
	                                 */
	                                 processData: false,
	                                 success: function (data) {
	                                     if (data.status == "200") {
	                                         $.messager.alert("提示",data.result);
	                                     }
	                                     if (data.status == "500") {
	                                         $.messager.alert("提示",data.result);
	                                     }
	                                 },
	                                 error: function () {
	                                	 $.messager.alert("上传失败!");
	                                 }
	                             });
	                    }
	                },
	                     {
	                         text: '取消',
	                         iconCls: 'icon-cancel',
	                         handler: function () {
	                             $('#divimport').dialog("close");
	                         }
	                     }]
	            });
	            $('#divimport').dialog("open");
		}
	     function queryscore() {
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
	                 url: '/es_student/getScoreInfo', //获取数据的url
	                 queryParams:{condition:search},
	                 sortName: 'Id',
	                 sortOrder: 'desc',
	                 idField: 'Id',
	  				toolbar:'#search',
	  			  columns: [[
							{ field: 'SNO', title: '<label for="SNO">学号</label>',width:100},
							{ field: 'COURSE_NO', title: '<label for="SCHE_NO">课程号</label>',width:100}
	  			           ,{ field: 'TYPE_NAME', title: '<label for="COURSE_NO">课程类型</label>',width:100}
	 						, { field: 'COURSE_NAME', title: '<label for="JOBNO">课程名</label>', width: 226 }
	 						, { field: 'PAPER_SCORE', title: '<label for="END_WEEK">卷面分</label>', width: 100 }
	 						, { field: 'MANI_SCORE', title: '<label for="CAPACITY">平时分</label>', width: 100 }
	 						, { field: 'TOTAL_SCORE', title: '<label for="MARGIN">总分</label>', width: 100 }
	 						, { field: 'REEXAM', title: '<label for="YEARTIME">补考</label>', width: 200 }
	 						, { field: 'REBUILD', title: '<label for="TERMTIME">重修</label>', width: 100 }
	 						
	  	                ]],
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
						教授课程：<select id="courseNo" name="courseNo">
							
						</select>
						<input name="tno" id="tno" type="hidden" value="${user.jobno}" style="width: 80px"> 
						学年：<select name="yeartime" id="yeartime">
						</select>
						学期：<select name="termtime" id="termtime">
							<option value="1">1</option>
							<option value="2" selected>2</option>
						</select>
					</form>
					<button onclick="flexiQuery();">查询选课学生信息</button>
					<button onclick="exports()">导出选课学生信息</button>
					<button onclick="flexiImport()">导入成绩</button>
					<button onclick="queryscore()">查看选课学生成绩信息</button>
				</td>
			</tr>
		</table>
		<form id="exportdiv" method="post" action="/es_teacher/export">
  		<input type="hidden" name="json" id="json">
  		<input type="hidden" name="title" id="title">
  </form>
  	<div id="divimport" title="导入学生信息" class="easyui-dialog" closed="true"
		modal="false" style="width: 300px">
		<div class="input">
			<form action="" method="post" id="form1"
				enctype="multipart/form-data">
				选择文件： <input id="excel" name="inputExcel" class="easyui-filebox"
					type="file" data-options="prompt:'请选择文件...'">
			</form>
		</div>

	</div>
	</div>
</body>
</html>
