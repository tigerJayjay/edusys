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
<title>可用教室管理</title>
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
            	    		$("#college").append("<option value="+e.colName+">"+e.colName+"</option>")
            	    	})
            	    })   
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
                title: '可用教室信息', //列表的标题
                iconCls: 'icon-site',
                width: 'auto',
                height: 'auto',
                nowrap: false,
                striped: true,
                collapsible: true,
                singleSelect: true,
                unselectAll:true,
                url: '/es_manager/logger/getLogger', //获取数据的url
                sortName: 'Id',
                sortOrder: 'desc',
                idField: 'Id',
 				toolbar:'#search',
 				columns: [[
 				          { field: 'NO', title: '<label for="NO">编号</label>',width:50}
 	   						, { field: 'OPRNO', title: '<label for="OPRNO">登录账号</label>', width: 226 }
 	   						,{field: 'OPRTIME', title: '<label for="OPRTIME">操作时间</label>', width: 226,formatter:function(date){
 							    var dt = new Date(date).format("yyyy-MM-dd hh:mm:ss"); 
 								return dt.toString();
 						 }}
 	   						, { field: 'CONTENT', title: '<label for="CONTENT">操作内容</label>', width: 800 }
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
                 title: '可用教室信息', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: false,
                 striped: true,
                 collapsible: true,
                 singleSelect: true,
                 unselectAll:true,
                 url: '/es_manager/logger/getLogger', //获取数据的url
                 queryParams:{condition:search},
                 sortName: 'Id',
                 sortOrder: 'desc',
                 idField: 'NO',
  				toolbar:'#search',
  				columns: [[
  				         { field: 'NO', title: '<label for="NO">编号</label>'}
	   						, { field: 'OPRNO', title: '<label for="OPRNO">登录账号</label>', width: 226 }
	   						,{field: 'OPRTIME', title: '<label for="OPRTIME">操作时间</label>', width: 226,formatter:function(date){
							    var dt = new Date(date).format("yyyy-MM-dd hh:mm:ss"); 
								return dt.toString();
						 }}
	   						, { field: 'CONTENT', title: '<label for="CONTENT">操作内容</label>', width: 200 }
   	                ]],
                 pagination: true,
                 rownumbers: true

             });
        };


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
        	var arr = $('#flexigridData').datagrid('getSelections');
            
            if (arr.length == 1) {
            	window.location.href = "/es_manager/classroom/addUseInfo.jsp?no="+arr[0].NO;
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
            return false;
        }
      
        //删除的按钮
        function flexiDelete() {

            var rows = $('#flexigridData').datagrid('getSelections');
            if (rows.length == 0) {
                $.messager.alert('操作提示', '请选择数据!', 'warning');
                return false;
            }
            var jobno = rows[0].jobno;
            $.messager.confirm('操作提示', "确认删除这 " + rows.length + " 项吗？", function (r) {
                if (r) {
                    $.post("/es_manager/teachermanager/deleteTea", { tno:jobno }, function (res) {
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
						时间： <input class="easyui-datebox" name="beginOprTime" id="beginOprTime" type="text" style="width: 80px">
						- <input class="easyui-datebox" name="endOprTime" id="endOprTime" type="text"
							style="width: 80px">
						操作账号：  <input  name="oprno" id="oprno" type="text" style="width: 80px">
					 	
					 <a href="javascript:flexiQuery();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;
					</form>

				</td>
			</tr>
		</table>
	</div>
</body>
</html>
