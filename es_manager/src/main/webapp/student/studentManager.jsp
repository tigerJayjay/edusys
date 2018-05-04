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
<title>学生管理</title>
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

            $('#flexigridData').datagrid({
                title: '学生信息', //列表的标题
                iconCls: 'icon-site',
                width: 'auto',
                height: 'auto',
                nowrap: false,
                striped: true,
                collapsible: true,
                singleSelect: true,
                url: '/es_manager/usermanager/getStu', //获取数据的url
                sortName: 'Id',
                sortOrder: 'desc',
                idField: 'Id',
 				toolbar:'#search',

                columns: [[
					  { field: 'SNO', title: '<label for="SNO">学号</label>'}
					, { field: 'CLASS_NO', title: '<label for="CLASS_NO">班级</label>', width: 226 }
					, { field: 'SNAME', title: '<label for="SNAME">姓名</label>', width: 100 }
					, { field: 'ENTRANCE_TIME', title: '<label for="ENTRANCE_TIME">入学时间</label>', width: 226
					}
					, { field: 'GRADE', title: '<label for="GRADE">年级</label>', width: 100 },
					{ field: 'COLLEGE', title: '<label for="COLLEGE">学院</label>', width: 226 },
					{ field: 'GENDER', title: '<label for="GENDER">性别</label>', width: 100,
						formatter: function(value,row,index){
 	        				if(value==0){
 	        					return '女';
 	        				}
 	        				if(value==1){
 	        					return '男';
 	        				}}},
					 {field: 'BIRTHDATE', title: '<label for="BIRTHDATE">生日</label>', width: 226 },
					 {field: 'PHONENUMBER', title: '<label for="PHONENUMBER">电话</label>', width: 226 },
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
        
        function flexiExport(){
        	$("#form2").submit();
        }
        function flexiExport1(){
        	$("#form3").submit();
        }
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
	                                 url: "/es_manager/usermanager/uploadStu",
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
        //“查询”按钮，弹出查询框
        function flexiQuery() {
        	var search = $("#queryCondition").serialize();
        	search = search.replace(/&/g,",");
        	search = search.replace(/=/g,":");
        	search = decodeURIComponent(search,true);
        	 $('#flexigridData').datagrid({
                 title: '学生信息', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 striped: true,
                 collapsible: true,
                 singleSelect: true,
                 url: '/es_manager/usermanager/getStu', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'Id',
  				toolbar:'#search',

                 columns: [[
 					  { field: 'SNO', title: '<label for="SNO">学号</label>'}
 					, { field: 'CLASS_NO', title: '<label for="CLASS_NO">班级</label>', width: 226 }
 					, { field: 'SNAME', title: '<label for="SNAME">姓名</label>', width: 100 }
 					, { field: 'ENTRANCE_TIME', title: '<label for="ENTRANCE_TIME">入学时间</label>', width: 226
 					}
 					, { field: 'GRADE', title: '<label for="GRADE">年级</label>', width: 100 },
 					{ field: 'COLLEGE', title: '<label for="COLLEGE">学院</label>', width: 226 },
 					{ field: 'GENDER', title: '<label for="GENDER">性别</label>', width: 100,
 						formatter: function(value,row,index){
  	        				if(value==0){
  	        					return '女';
  	        				}
  	        				if(value==1){
  	        					return '男';
  	        				}}},
 					 {field: 'BIRTHDATE', title: '<label for="BIRTHDATE">生日</label>', width: 226 },
 					 {field: 'PHONENUMBER', title: '<label for="PHONENUMBER">电话</label>', width: 226 },
                 ]],
                 pagination: true,
                 rownumbers: true

             });
        };

        //“选择”按钮，在其他（与此页面有关联）的页面中，此页面以弹出框的形式出现，选择页面中的数据
        function flexiSelect() {

            var rows = $('#flexigridData').datagrid('getSelections');
            if (rows.length == 0) {
                $.messager.alert('操作提示', '请选择数据!', 'warning');
                return false;
            }

            var arr = [];
            for (var i = 0; i < rows.length; i++) {
                arr.push(rows[i].Id);
            }
            arr.push("^");
            for (var i = 0; i < rows.length; i++) {
                arr.push(rows[i].Name);
            }
            //主键列和显示列之间用 ^ 分割   每一项用 , 分割
            if (arr.length > 0) {//一条数据和多于一条
                returnParent(arr.join("&")); //每一项用 & 分割
            }
        }
        //导航到查看详细的按钮
        function getView() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "../SysRole/Details/" + arr[0].Id;

            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
        }
        //导航到创建的按钮
        function flexiCreate() {

            window.location.href = "/es_manager/student/addStudent.jsp";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "/es_manager/usermanager/toModifyStu?sno="+arr[0].SNO;
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

      /*       var arr = [];
            for (var i = 0; i < rows.length; i++) {
                arr.push(rows[i].SNO);
            } */
            var sno = rows[0].SNO;
            $.messager.confirm('操作提示', "确认删除这 " + rows.length + " 项吗？", function (r) {
                if (r) {
                    $.post("/es_manager/usermanager/deleteStu", { stuId:sno }, function (res) {
                        if (res.status == "200") {
                            //移除删除的数据
                            $("#flexigridData").datagrid("reload");
                            $("#flexigridData").datagrid("clearSelections");
                            $.messager.alert('操作提示', '删除成功!', 'info');
                        }
                        else {
                            if (res == "500") {
                                $.messager.alert('操作提示', '删除失败!请查看该数据与其他模块下的信息的关联，或联系管理员。', 'info');
                            }
                            else {
                                $.messager.alert('操作提示', res, 'info');
                            }
                        }
                    });
                }
            });

        };
        //分配权限
        flexiSetSysMenu = function () {
            var arr = $('#flexigridData').datagrid('getSelections');
            var bro = $.browser;
            if (bro.msie) {
                binfo = bro.version;
                //alert(binfo);
                if ( binfo == "9.0" || binfo == "10.0") {

                } else {
                    document.write("");
                }

            }
            if (arr.length == 1) {
                window.location.href = "/toSetSysMenu?roleId=" + arr[0].roleId;

            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;


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
						学号： <input name="sno" id="sno" type="text" style="width: 80px">
						&nbsp;&nbsp;姓名： <input name="sname" id="sname" type="text"
							style="width: 80px"> 
							性别： 
						<select name="gender">
							<option value="0">女</option>
							<option value="1">男</option>
						</select> 
						年级： <input name="grade" id="grade" type="text" style="width: 80px">
						班级： <input name="classname" id="classname" type="text" style="width: 80px">
						学院：<select id="college" name="college">
						<option value="">全部</option>
						</select>
						&nbsp;&nbsp;出生日期&nbsp; <input type="text" width="80"
							id="birthdateStart" name="birthdateStart" class="easyui-datebox"
							style="width: 100px" /> <span>到</span> <input type="text"
							id="birthdateEnd" name="birthdateEnd" class="easyui-datebox"
							style="width: 100px" /> <a href="javascript:flexiQuery();"
							class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;
					</form>

				</td>
			</tr>
			<tr>
				<td><a href="#" onclick="flexiCreate();"
					class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
					<a href="#" onclick="flexiDelete();" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'">删除</a> <a href="#"
					onclick="flexiModify();" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">修改</a> <a href="#"
					onclick="flexiImport();" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'">导入</a> <a href="#"
					onclick="flexiExport();" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">导出学生模板</a> <a href="#"
					onclick="flexiExport1();" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit'">导出学生信息</a></td>
			</tr>
		</table>
	</div>
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
	<form action="/es_manager/usermanager/getStuExcelModel" method="post"
		id="form2"></form>
	<form action="/es_manager/usermanager/getStuExcel" method="post"
		id="form3"></form>
</body>
</html>
