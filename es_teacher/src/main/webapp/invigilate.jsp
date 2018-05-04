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
<title>考试监考安排查询</title>

<script type="text/javascript" language="javascript">

        $(function () {
            	  $.post("/es_manager/usermanager/getCol",{},function(res){
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
            	    	$.each(res.rows,function(i,e){
            	    		$("#college").append("<option value="+e.colNo+">"+e.colName+"</option>")
            	    	})
            	    })   
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
                 fitColumns:true,
                 striped: true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/invigilate/getInvigilate', //获取数据的url
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  queryParams:{condition:search},
  			  columns: [[
				{ field: 'NO', title: '<label for="NO">编号</label>'}
				, { field: 'courseNo', title: '<label for="courseNo">课程号</label>',  width: 226}
				, { field: 'TERMTIME', title: '<label for="TERMTIME">学期</label>',  width: 226
				},{ field: 'YEARTIME', title: '<label for="YEARTIME">学年</label>', width: 250
					}
				, { field: 'WEEKTH', title: '<label for="WEEKTH">第几周</label>', width: 226 },
				{ field: 'WEEKNO', title: '<label for="WEEKNO">周几</label>', width: 100 },
				{ field: 'SCHOOLTIME', title: '<label for="SCHOOLTIME">第几节</label>', width: 226 },
				{ field: 'classno', title: '<label for="classno">教室</label>', width: 100 },
				{ field: 'jobno', title: '<label for="jobno">教师工号</label>', width: 200 },
				{ field: 'COLLEGE', title: '<label for="COLLEGE">学院</label>', width: 100 }
  	                ]],
  	                 pagination: true,
                 rownumbers: true

             });

            //如果列表页出现在弹出框中，则只显示查询和选择按钮 
            //如果列表页出现在弹出框中，则只显示查询和选择按钮 
            var parent = window.dialogArguments; //获取父页面
            if (parent == "undefined" || parent == null) {
                //异步获取按钮
                var iframeid;

                var fs = window.parent.window.frames;
                for (var i = 0; i < fs.length; i++) {
                    if (window == fs[i]) {
                        var iframe = window.parent.document.getElementsByTagName("iframe")[i];
                        iframeid = iframe.id;

                    }
                }
                //关闭AJAX相应的缓存
                $.ajaxSetup({
                    cache: false
                });

                $.getJSON("", { id: iframeid }, function (data) {
                    if (data == null) {
                        return;
                    }
                    $('#flexigridData').datagrid("addToolbarItem", data);

                });

            } else {
                //添加选择按钮
                //$('#flexigridData').datagrid("addToolbarItem", [{ "text": "选择", "iconCls": "icon-ok", handler: function () { flexiSelect(); } }]);
            }

        });
        
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
                 url: '/es_manager/invigilate/getInvigilate', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
						{ field: 'NO', title: '<label for="NO">编号</label>'}
							, { field: 'courseNo', title: '<label for="courseNo">课程号</label>',  width: 226}
							, { field: 'TERMTIME', title: '<label for="TERMTIME">学期</label>',  width: 226
							},{ field: 'YEARTIME', title: '<label for="YEARTIME">学年</label>', width: 250
	  						}
							, { field: 'WEEKTH', title: '<label for="WEEKTH">第几周</label>', width: 226 },
							{ field: 'WEEKNO', title: '<label for="WEEKNO">周几</label>', width: 100 },
							{ field: 'SCHOOLTIME', title: '<label for="SCHOOLTIME">第几节</label>', width: 226 },
							{ field: 'classno', title: '<label for="classno">教室</label>', width: 100 },
							{ field: 'jobno', title: '<label for="jobno">教师工号</label>', width: 200 },
							{ field: 'COLLEGE', title: '<label for="COLLEGE">学院</label>', width: 100 }
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
						
						工号： <input name="tno" id="tno" type="hidden" value="${user.jobno}" style="width: 80px"> 
						学年：<select name="yeartime" id="yeartime">
						</select>
						学期：<select name="termtime" id="termtime">
							<option value="1">1</option>
							<option value="2" selected>2</option>
						</select>
					</form>
					<button onclick="flexiQuery();">查询</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
