<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
    <script src="/resources/Scripts/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/Scripts/jquery.easyui.min-1.3.5.js" type="text/javascript"></script>
    <script src="/resources/Scripts/jquery.datagrid.js" type="text/javascript"></script>
    <script src="/resources/Scripts/JScriptIndex.js" type="text/javascript"></script>
    <link href="/resources/Content/Default.css" rel="stylesheet" type="text/css" />
    <link href="/resources/Content/IndexStyle.css" rel="stylesheet" type="text/css" />
    <link href="/resources/Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="/resources/Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="/resources/Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    
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
    
    <script type="text/javascript">
        $(function () {

            $('#flexigridData').treegrid({
                title: ' 当前角色是：报名处权限  ',
                iconCls: 'icon-site',
                url: '/system_manage/SetSysMenu?roleId='+$("#CurrentRoleID").val(),
                idField: 'permissionId',
                treeField: 'permissionName',
                rownumbers: true,

                toolbar: [
                    {
                        text: '保存',
                        iconCls: 'icon-save',
                        handler: function () {
                            return getView();
                        }
                    }, {
                        text: '全选',
                        iconCls: 'icon-ok',
                        handler: function () {
                            return flexiCreate();
                        }
                    }, {
                        text: '全不选',
                        iconCls: 'icon-remove',
                        handler: function () {
                            return flexiDelete();
                        }
                    }, {
                        text: '返回',
                        iconCls: 'icon-undo',
                        handler: function () {
                            return flexiModify();
                        }
                    }],

                columns: [[

                    	{ field: 'permissionName', title: '权限列表', width: 1304
                                        , formatter: function (value, rec) {
                                            if (value) {
                                          		if(rec.check1){
                                          			return '<input id="' + rec.permissionId + '" type="checkbox" checked>' + (value);
                                          		}else{
                                          			return '<input id="' + rec.permissionId + '" type="checkbox">' + (value);
                                          		}
                                                
                                            }
                                        }
                    	}
					/*, { field: 'isCheck', title: '操作', width: 1099, formatter: function (value, rec) {
					    if (value) {
					        var index = value.split(","); //分割符 , 的位置
					        if (index[0] == null || index[0] == "undefined" || index[0].length < 1) {
					            return;
					        }
					        var content = ""; //需要添加到check中的内容 
					        for (var i = 0; i < index.length; i++) {
					            var view = index[i].split('^'); //显示值
					            if (view != null) {
					                content += '<input id="' + rec.permissionId + '^' + view[0] + '" type="checkbox">' + view[1];
					            }
					        }
					        return content;
					    }
					} 
					}*/
				    ]],
                /* onLoadSuccess: function (row, data) {
                    if (data) {
                        $.ajaxSetup({
                            cache: false //关闭AJAX相应的缓存
                        });
                        $.getJSON('/system_manage/showCheck?roleId='+$("#CurrentRoleID").val(), function (checks) {
                            $.each(checks, function (i, item) {
                                var c = document.getElementById(item);
                                c.checked = true;
                            });
                        });

                    }
                }
 */
            });


        });

        //保存
        function getView() {
            var datas = '';
            $("input[type='checkbox']").each(function () {
                if ($(this).is(":checked"))
                    datas += ',' + $(this).attr('id');
            });
            $.post("/system_manage/saveRolePermission", { roleId: $("#CurrentRoleID").val(), ids: datas }, function (res) {
                if (res == "OK") {
                    $.messager.alert('操作提示', '保存成功!', 'info');
                }
                else {
                    if (res == "") {
                        $.messager.alert('操作提示', '保存失败!请联系管理员。', 'info');
                    }
                    else {
                        $.messager.alert('操作提示', res, 'info');
                    }
                }
            });
            return false;
        }
        
        
        
        
        //全选
        function flexiCreate() {

            $("input[type='checkbox']").each(function () {
                $(this).attr("checked", true);
            });

            return false;
        }
      	//全不选
        function flexiDelete() {
            $("input[type='checkbox']").each(function () {
                $(this).attr("checked", false);
            });
            return false;
        };
        //返回
        function flexiModify() {
            window.location.href = "/system_manage/SysRole.jsp";
            return false;
        };
    </script>

      <base target = "_self">
</head>
<body class="easyui-layout" style="padding:3px;">
    <table id="flexigridData" fit="true">
    </table>
    
     <input type="hidden" id="CurrentRoleID" value="${roleId}" />

        

</body>
</html>
