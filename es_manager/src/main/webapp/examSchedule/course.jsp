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
<title>课程管理</title>
<script type="text/javascript" language="javascript">
         $(function () {
             $.extend($.fn.datagrid.methods, {
                 addToolbarItem: function (jq, items) {
                     return jq.each(function () {
                         var dpanel = $(this).datagrid('getPanel');
                         var toolbar = dpanel.children("div.datagrid-toolbar");
                         if (!toolbar.length) {
                             toolbar = $("<div class=\"datagrid-toolbar\"><table cellspacing=\"0\" cellpadding=\"0\"><tr></tr></table></div>").prependTo(dpanel);
                             $(this).datagrid('resize');
                         }
                         var tr = toolbar.find("tr");
                         for (var i = 0; i < items.length; i++) {
                             var btn = items[i];
                             if (btn == "-") {
                                 $("<td><div class=\"datagrid-btn-separator\"></div></td>").appendTo(tr);
                             } else {
                                 var td = $("<td></td>").appendTo(tr);
                                 var b = $("<a href=\"javascript:void(0)\"></a>").appendTo(td);
                                 b[0].onclick = eval(btn.handler || function () { });
                                 b.linkbutton($.extend({}, btn, {
                                     plain: true
                                 }));
                             }
                         }
                     });
                 },
                 removeToolbarItem: function (jq, param) {
                     return jq.each(function () {
                         var dpanel = $(this).datagrid('getPanel');
                         var toolbar = dpanel.children("div.datagrid-toolbar");
                         var cbtn = null;
                         if (typeof param == "number") {
                             cbtn = toolbar.find("td").eq(param).find('span.l-btn-text');
                         } else if (typeof param == "string") {
                             cbtn = toolbar.find("span.l-btn-text:contains('" + param + "')");
                         }
                         if (cbtn && cbtn.length > 0) {
                             cbtn.closest('td').remove();
                             cbtn = null;
                         }
                     });
                 }
             });
         });
    </script>

<script type="text/javascript" language="javascript">

        $(function () {
            	  $.post("/es_manager/usermanager/getCol",{},function(res){
            	    	$.each(res.rows,function(i,e){
            	    		$("#college").append("<option value="+e.colNo+">"+e.colName+"</option>")
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
 $('#flexigridData').datagrid({
                 title: '课程信息', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 fitColumns:true,
                 striped: true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/course/getCourse', //获取数据的url
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
  			           { field: 'COURSE_NO', title: '<label for="COURSE_NO">课程号</label>'}
  						, { field: 'TYPE_NAME', title: '<label for="TYPE_NAME">课程类型</label>', width: 226 }
  						, { field: 'COURSE_NAME', title: '<label for="COURSE_NAME">课程名</label>', width: 100 }
  						, { field: 'CREDIT', title: '<label for="CREDIT">学分</label>', width: 226
  						}
  						, { field: 'WEEKTIME', title: '<label for="WEEKTIME">周学时</label>', width: 100 }
  						, { field: 'TOTALTIME', title: '<label for="TOTALTIME">总学时</label>', width: 100 }
  						, { field: 'DES', title: '<label for="DES">描述</label>', width: 100 }
  						, { field: 'SPE_NAME', title: '<label for="SPE_NAME">面向专业</label>', width: 100 }
  						, { field: 'COL_NAME', title: '<label for="COL_NAME">面向学院</label>', width: 100 }
  						, { field: 'CLASS_NO', title: '<label for="CLASS_NO">面向班级</label>', width: 100 }
  						,{ field: 'GRADE', title: '<label for="GRADE">面向年级</label>', width: 100 }
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
                 title: '课程信息', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 striped: true,
                 fitColumns:true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/course/getCourse', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
  			           { field: 'COURSE_NO', title: '<label for="COURSE_NO">课程号</label>'}
 						, { field: 'TYPE_NAME', title: '<label for="TYPE_NAME">课程类型</label>', width: 226 }
 						, { field: 'COURSE_NAME', title: '<label for="COURSE_NAME">课程名</label>', width: 100 }
 						, { field: 'CREDIT', title: '<label for="CREDIT">学分</label>', width: 226
 						}
 						, { field: 'WEEKTIME', title: '<label for="WEEKTIME">周学时</label>', width: 100 }
 						, { field: 'TOTALTIME', title: '<label for="TOTALTIME">总学时</label>', width: 100 }
 						, { field: 'DES', title: '<label for="DES">描述</label>', width: 100 }
 						, { field: 'SPE_NAME', title: '<label for="SPE_NAME">面向专业</label>', width: 100 }
 						, { field: 'COL_NAME', title: '<label for="COL_NAME">面向学院</label>', width: 100 }
 						, { field: 'CLASS_NO', title: '<label for="CLASS_NO">面向班级</label>', width: 100 }
 						,{ field: 'GRADE', title: '<label for="GRADE">面向年级</label>', width: 100 }
  	                ]],
                 pagination: true,
                 rownumbers: true

             });
        };

        //导航到创建的按钮
        function flexiCreate() {
            window.location.href = "/es_manager/examSchedule/addCourse.jsp";
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
						 面向学院：<select id="college" name="college">
								<option value="">全部</option>
						     </select>
						 面向专业：<select id="specialty" name="specialty">
						 		 <option value="">全部</option>
						      </select>
						
						 面向班级：<select id="classno" name="classno">
						         <option value="">全部</option>
						 	  </select>
					 	 面向年级：<select id="grade" name="grade">
					 		 <option value="">全部</option>
					 	   </select>
						<a href="javascript:flexiQuery();"
							class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;
					</form>

				</td>
				<td><a href="#" onclick="flexiCreate();"
					class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
					<a href="#" onclick="flexiModify();" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">修改</a>
					<a href="#" onclick="flexiDelete();"
					class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</a>
			</tr>
		</table>
	</div>
</body>
</html>
