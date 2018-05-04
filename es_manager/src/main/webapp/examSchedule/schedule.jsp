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
                 url: '/es_manager/schedule/getSchedule', //获取数据的url
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
{ field: 'SCHE_NO', title: '<label for="SCHE_NO">排课号</label>'}
  ,{ field: 'COURSE_NO', title: '<label for="COURSE_NO">课程号</label>'}
	, { field: 'JOBNO', title: '<label for="JOBNO">教师工号</label>', width: 226 }
	, { field: 'COURSE_NAME', title: '<label for="COURSE_NAME">课程名</label>', width: 200 }
	, { field: 'PLACE', title: '<label for="PLACE">地点</label>', width: 226
	}
	, { field: 'START_WEEK', title: '<label for="START_WEEK">开始周</label>', width: 100 }
	, { field: 'END_WEEK', title: '<label for="END_WEEK">结束周</label>', width: 100 }
	, { field: 'CAPACITY', title: '<label for="CAPACITY">容量</label>', width: 100 }
	, { field: 'MARGIN', title: '<label for="MARGIN">剩余容量</label>', width: 100 }
	, { field: 'YEARTIME', title: '<label for="YEARTIME">学年</label>', width: 200 }
	, { field: 'TERMTIME', title: '<label for="TERMTIME">学期</label>', width: 100 }
	,{ field: 'GRADE', title: '<label for="GRADE">面向年级</label>', width: 100 }
	,{ field: 'WEEKNO', title: '<label for="WEEKNO">周几</label>', width: 100 }
	,{ field: 'JIE', title: '<label for="JIE">第几节</label>', width: 100 }
	,{ field: 'COLLEGE', title: '<label for="COLLEGE">面向学院</label>', width: 200 }
	,{ field: 'SPECIALTY', title: '<label for="SPECIALTY">面向专业</label>', width: 200 }
	,{ field: 'CLASSNO', title: '<label for="CLASSNO">面向班级</label>', width: 100 }
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
                 title: '课程信息', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 striped: true,
                 fitColumns:true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/schedule/getSchedule', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',
  			  columns: [[
						{ field: 'SCHE_NO', title: '<label for="SCHE_NO">排课号</label>'}
  			           ,{ field: 'COURSE_NO', title: '<label for="COURSE_NO">课程号</label>'}
 						, { field: 'JOBNO', title: '<label for="JOBNO">教师工号</label>', width: 226 }
 						, { field: 'COURSE_NAME', title: '<label for="COURSE_NAME">课程名</label>', width: 200 }
 						, { field: 'PLACE', title: '<label for="PLACE">地点</label>', width: 226
 						}
 						, { field: 'START_WEEK', title: '<label for="START_WEEK">开始周</label>', width: 100 }
 						, { field: 'END_WEEK', title: '<label for="END_WEEK">结束周</label>', width: 100 }
 						, { field: 'CAPACITY', title: '<label for="CAPACITY">容量</label>', width: 100 }
 						, { field: 'MARGIN', title: '<label for="MARGIN">剩余容量</label>', width: 100 }
 						, { field: 'YEARTIME', title: '<label for="YEARTIME">学年</label>', width: 200 }
 						, { field: 'TERMTIME', title: '<label for="TERMTIME">学期</label>', width: 100 }
 						,{ field: 'GRADE', title: '<label for="GRADE">面向年级</label>', width: 100 }
 						,{ field: 'WEEKNO', title: '<label for="WEEKNO">周几</label>', width: 100 }
 						,{ field: 'JIE', title: '<label for="JIE">第几节</label>', width: 100 }
 						,{ field: 'COLLEGE', title: '<label for="COLLEGE">面向学院</label>', width: 200 }
 						,{ field: 'SPECIALTY', title: '<label for="SPECIALTY">面向专业</label>', width: 200 }
 						,{ field: 'CLASSNO', title: '<label for="CLASSNO">面向班级</label>', width: 100 }
  	                ]],
                 pagination: true,
                 rownumbers: true

             });
        };

        //导航到创建的按钮
        function flexiCreate() {
            window.location.href = "/es_manager/examSchedule/addSchedule.jsp";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "/es_manager/schedule/toModifySchedule?no="+arr[0].SCHE_NO;
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
            var no = rows[0].SCHE_NO;
            $.messager.confirm('操作提示', "确认删除这 " + rows.length + " 项吗？", function (r) {
                if (r) {
                    $.post("/es_manager/schedule/deleteSchedule", {scheduleId:no}, function (res) {
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
        
        function flexiExport(){
        	$("#form2").submit();
        }
     
        //导入排课信息
		function flexiImport(){
			 $('#divimport').dialog({
	                buttons: [{
	                    text: '导入',
	                    iconCls: 'icon-ok',
	                    handler: function () {
	                             var formData = new FormData();
	                             formData.append("inputExcel", document.getElementById("excel").files[0]);   
	                             $.ajax({
	                                 url: "/es_manager/schedule/uploadSchedule",
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
					 	
					 	 学年：<select id="yeartime" name="yeartime">
					 	 	<option value="">全部</option>
					 	 </select>
					 	 学期： <select id="termtime" name="termtime">
					 	 	<option value="">全部</option>
					 	 	<option value="1">1</option>
					 	 	<option value="2">2</option>
					 	 </select>
					 	  课程号：<input type="text" id="courseNo" name="courseNo">
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
					</td>
			</tr>
			<tr>
			<td>
					<a href="#" onclick="flexiImport();;"
					class="easyui-linkbutton" data-options="iconCls:'icon-add'">导入</a>
					<a href="#" onclick="flexiExport();" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">导出排课信息模板</a> 
					</td>
			</tr>
		</table>
	
<div id="divimport" title="导入排课信息" class="easyui-dialog" closed="true"
		modal="false" style="width: 300px">
		<div class="input">
			<form action="" method="post" id="form1"
				enctype="multipart/form-data">
				选择文件： <input id="excel" name="inputExcel" class="easyui-filebox"
					type="file" data-options="prompt:'请选择文件...'">
			</form>
		</div>
<form action="/es_manager/schedule/getCoExcelModel" method="post"
		id="form2"></form>
	</div>
	</div>
	</div>
</body>
</html>
