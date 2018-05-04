<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head id="MyHead">
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
<title>课程教材管理</title>

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
 $('#flexigridData').datagrid({
                 title: '课程教材', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 fitColumns:true,
                 striped: true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/courseBook/getCourseBook', //获取数据的url
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
  			           { field: 'NO', title: '<label for="COURSE_NO">编号</label>'}
  						, { field: 'COURSE_NO', title: '<label for="COURSE_NAME">课程号</label>', width: 100 }
  						, { field: 'COURSE_NAME', title: '<label for="CREDIT">课程名</label>', width: 226
  						}
  						, { field: 'BOOK_NO', title: '<label for="WEEKTIME">书号</label>', width: 100 }
  						, { field: 'BOOK_NAME', title: '<label for="TOTALTIME">书名</label>', width: 100 }
  						, { field: 'YEARTIME', title: '<label for="DES">学年</label>', width: 100 }
  						, { field: 'TERMTIME', title: '<label for="SPE_NAME">学期</label>', width: 100 }
  						
  	                ]],
                 pagination: true,
                 rownumbers: true

             });
        });
        
        //“查询”按钮，弹出查询框
        function flexiQuery() {
        	var search = $("#queryCondition").serialize();
        	search = search.replace(/&/g,",");
        	search = search.replace(/=/g,":");
        	search = decodeURIComponent(search,true);
        	 $('#flexigridData').datagrid({
                 title: '课程教材', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 striped: true,
                 fitColumns:true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/courseBook/getCourseBook', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
					{ field: 'NO', title: '<label for="COURSE_NO">编号</label>'}
						, { field: 'COURSE_NO', title: '<label for="COURSE_NAME">课程号</label>', width: 100 }
						, { field: 'COURSE_NAME', title: '<label for="CREDIT">课程名</label>', width: 226
						}
						, { field: 'BOOK_NO', title: '<label for="WEEKTIME">书号</label>', width: 100 }
						, { field: 'BOOK_NAME', title: '<label for="TOTALTIME">书名</label>', width: 100 }
						, { field: 'YEARTIME', title: '<label for="DES">学年</label>', width: 100 }
						, { field: 'TERMTIME', title: '<label for="SPE_NAME">学期</label>', width: 100 }
  	                ]],
                 pagination: true,
                 rownumbers: true

             });
        };

        //导航到创建的按钮
        function flexiCreate() {
            window.location.href = "/es_manager/examSchedule/addCourseBook.jsp";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "/es_manager/course/toModifyCourse?no="+arr[0].COURSE_NO;
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;

        };
        //删除的按钮
        function flexiDelete() {

            var rows = $('#flexigridData').datagrid('getSelections');
            if (rows.length == 0) {
                $.messager.alert('操作提示', '请选择数据!', 'warning');
                return false;
            }
            var no = rows[0].COURSE_NO;
            $.messager.confirm('操作提示', "确认删除这 " + rows.length + " 项吗？", function (r) {
                if (r) {
                    $.post("/es_manager/course/deleteCourse", {courseId:no}, function (res) {
                        if (res.status == "200") {
                            //移除删除的数据
                            $("#flexigridData").datagrid("reload");
                            $("#flexigridData").datagrid("clearSelections");
                            $.messager.alert('提示', '删除成功!');
                        }
                        else {
                            if (res == "500") {
                                $.messager.alert('提示', '删除失败!请查看该数据与其他模块下的信息的关联，或联系管理员。', 'info');
                            }
                        }
                    });
                }
            });

        };
       

    </script>

<base target="_self">
</head>
<body class="easyui-layout" style="padding: 3px;">
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
						课程号：<input id="courseNo" name="courseNo" type="text">
						课程名：<input id="courseName" name="courseName" type="text">
						学年： <select id="yeartime" name="yeartime">
							<option value="">全部</option>
						</select>
						学期：<select id="termtime" name="termtime">
						<option value="">全部</option>
								  <option value="1">1</option>
								  <option value="2">2</option>
						      </select>
						<a href="javascript:flexiQuery();"
							class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;
					</form>

				</td>
				<td><a href="#" onclick="flexiCreate();"
					class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
					<a href="#" onclick="flexiDelete();"
					class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</a>
			</tr>
		</table>
	</div>
</body>
</html>
