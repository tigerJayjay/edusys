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
    <title>
  		  角色
	</title>
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


            $('#flexigridData').datagrid({
                title: '角色', //列表的标题
                iconCls: 'icon-site',
                width: 'auto',
                height: 'auto',
                nowrap: false,
                striped: true,
                collapsible: true,
                singleSelect: true,
                url: '/es_manager/role/showRole', //获取数据的url
                sortName: 'Id',
                sortOrder: 'desc',
                idField: 'Id',

                toolbar: [
                 {
                     text: '查询',
                     iconCls: 'icon-search',
                     handler: function () {
                         flexiQuery();
                     }
                 },
                 {
                	 text: '添加',
                     iconCls: 'icon-add',
                     handler: function () {
                    	 flexiCreate();
                     }
                 },
                 {
                	 text: '删除',
                     iconCls: 'icon-cancel',
                     handler: function () {
                    	 flexiDelete();
                     }
                 },
                   {
                       text: '分配权限',
                       iconCls: 'icon-search',
                       handler: function () {
                           flexiSetSysMenu();
                       }
                   }
                   ],

                columns: [[
					  { field: 'NO', title: '<label for="NO">角色编号</label>'}
					, { field: 'roleName', title: '<label for="Name">角色名称</label>', width: 226 }
					, { field: 'authoName', title: '<label for="authoName">权限</label>', width: 226 }
					

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

                $.getJSON("../Home/GetToolbar", { id: iframeid }, function (data) {
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
            $('#divQuery').dialog({
                buttons: [{
                    text: '查询',
                    iconCls: 'icon-ok',
                    handler: function () {
                        var no = $("#no").val();
                        //执行查询                        
                        $('#flexigridData').datagrid('reload', { no: no });
                    }
                },
                     {
                         text: '取消',
                         iconCls: 'icon-cancel',
                         handler: function () {
                             $('#divQuery').dialog("close");
                         }
                     }]
            });
            $('#divQuery').dialog("open");
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

            window.location.href = "/es_manager/systemmanager/addRole.jsp";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "/es_manager/systemmanager/updRole?roleId="+arr[0].NO;

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

            $.messager.confirm('操作提示', "确认删除这 " + rows.length + " 项吗？", function (r) {
                if (r) {
                    $.post("/es_manager/role/deleteRole", { roleNo:rows[0].NO }, function (res) {
                        if (res == "OK") {
                            //移除删除的数据
                            $("#flexigridData").datagrid("reload");
                            $("#flexigridData").datagrid("clearSelections");
                            $.messager.alert('操作提示', '删除成功!', 'info');
                        }
                        else {
                            if (res == "") {
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

            if (arr.length == 1) {
                window.location.href = "/es_manager/systemmanager/allocationAhtho.jsp?roleNo="+arr[0].NO;

            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;


        };
    </script>

      <base target = "_self">
</head>
<body class="easyui-layout" style="padding:3px;">
    <table id="flexigridData" fit="true">
    </table>
    
    <div id="divQuery" title="查询列表" class="easyui-dialog" closed="true" modal="false"
        iconcls="icon-search">
        <div class="input">
            <div class="editor-label-search">
                <label for="no"></label>
            </div>
            <div class="editor-field-search">
               <select>
               	  <option value="1">学生</option>
               	  <option value="2">教师</option>
               	  <option value="3">教务处</option>
               </select>
            </div>
        </div>
    </div>

        

</body>
</html>
