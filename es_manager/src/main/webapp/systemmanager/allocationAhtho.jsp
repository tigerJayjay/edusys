<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
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
    
    <script type="text/javascript">
        $(function () {

            $('#flexigridData').datagrid({
                title: ' 当前角色是：报名处权限  ',
                iconCls: 'icon-site',
                url: '/es_manager/role/SetSysMenu?roleId='+$("#CurrentUserID").val(),
                idField: 'roleId',
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

                    	{ field: 'authName', title: '角色列表', width: 1304
                                        , formatter: function (value, rec) {
                                        	console.log(value);
                                        	console.log(rec);
                                            if (value) {
                                          		if(rec.mark!='-1'){
                                          			return '<input id="' + rec.authNo + '" type="checkbox" checked>' + (value);
                                          		}else{
                                          			return '<input id="' + rec.authNo + '" type="checkbox">' + (value);
                                          		}
                                                
                                            }
                                        }
                    	}
            ]]
            });


        });

        //保存
        function getView() {
            var datas = '';
            $("input[type='checkbox']").each(function () {
                if ($(this).is(":checked"))
                    datas += ',' + $(this).attr('id');
            });
            $.post("/es_manager/role/saveRolePermission", { roleId: $("#CurrentUserID").val(), ids: datas }, function (res) {
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
            window.location.href = "/es_manager/systemmanager/SysRole.jsp";
            return false;
        };
    </script>

      <base target = "_self">
</head>
<body class="easyui-layout" style="padding:3px;">
    <table id="flexigridData" fit="true">
    </table>
    
     <input type="hidden" id="CurrentUserID" value="<%=request.getParameter("roleNo") %>" />

        

</body>
</html>