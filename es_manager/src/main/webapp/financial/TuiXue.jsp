<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head id="MyHead">
<script src="/resources/Scripts/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="/resources/Scripts/JScriptIndex.js" type="text/javascript"></script>
<script src="/resources/Scripts/jquery.easyui.min-1.3.5.js"
	type="text/javascript"></script>
<script src="/resources/Res/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
<link href="/resources/Content/Default.css" rel="stylesheet" type="text/css" />
<link href="/resources/Content/IndexStyle.css" rel="stylesheet" type="text/css" />

<link href="/resources/Res/easyui/themes/icon.css" rel="stylesheet"
	type="text/css" />
<script src="/resources/Res/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<link href="/resources/Res/easyui/themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<title>退学管理</title>
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


<style type="text/css">
.line {
	clear: both;
	overflow: hidden;
	zoom: 1;
}

.editor-label {
	width: 60px;
	text-align: left;
	float: left;
	height: 26px;
	padding-left: 4px;
}

.editor-field {
	width: 320px;
	text-align: left;
	float: left;
	height: 26px;
	padding-top: 4px;
	margin-right: 16px;
}

.blueline {
	border-bottom: #95b8e7 1px solid;
	margin-bottom: 10px;
	padding-bottom: 10px;
}

.height80 {
	height: 80px;
	line-height: 80px;
}

.TextArea {
	width: 320px;
	height: 60px;
	border: #95b8e7 1px solid;
}

.editor-field input, .input-textbox {
	border: #95b8e7 1px solid;
	line-height: 18px;
}

.stupic {
	position: absolute;
	top: 40px;
	left: 264px;
}
</style>
<script type="text/javascript" language="javascript">
     
        $(function () {

            $('#pifuflexigridData').datagrid({
                iconCls: 'icon-site',
                width: 'auto',
                height: 'auto',
                nowrap: true,
                striped: true,
                collapsible: true,
                singleSelect:true,
                rownumbers: true,
                url: '/financial/getTuixue', //获取数据的url
               queryParams: { queryCondition: 'DoStatus:已通过' },
                sortName: 'doStuId',
                sortOrder: 'desc',
                idField: 'doStuId',
                          onRowContextMenu: onRowContextMenu,
                toolbar: "#yesSearch3",
                columns: [[
                { field: 'doStuId', title: '<label for="doStuId">学员编号</label>',sortable:true,width:80,align:'center'}
					, { field: 'doStuName', title: '<label for="doStuName">姓名</label>',sortable:true,width:80,align:'center'}
                     ,{field:'manager',title:'受理人',sortable:true,width:80,align:'center'}
                    , { field: 'applyDate', title: '申请时间',sortable: true,width:120 ,align:'center'}
                    , { field: 'applyMoney', title: '申请金额',sortable:true,width:80,align:'center'}
                     , { field: 'doStatus', title: '<label for="S_tuixueBeizhu">退学状态</label>',sortable:true,width:80,align:'center',styler:function(){
                    	 return "color:green";
                     }}
                    , { field: 'doComment', title: '<label for="S_Carmodels">申请说明</label>',sortable:true,width:200,align:'center'}
                    , { field: 'doReplyMoney', title: '<label for="FK_DIC_from">批复金额</label>',sortable:true,width:80,align:'center'}
					, { field: 'doReplyComment', title: '<label for="S_sex">批复说明</label>',sortable:true,width:200,align:'center'}
                    , { field: 'checkMan', title: '<label for="S_MeetTable">批复人</label>',sortable:true,width:80,align:'center'}
                    , { field: 'checkTime', title: '<label for="S_MeetDate">批复时间</label>',sortable:true,width:120,align:'center'}
                ]],
                pagination: true,
                rownumbers: true

            });
        });


      var fieldSearchVal = "";

        // 查询下列菜单
        function fieldSearch(fieldName,obj) {
            var rows = $('#' + obj).datagrid('getSelections');
            if (rows.length == 0) {
                $.messager.alert('操作提示', '请选择数据!', 'warning');
                return false;
            }
            var idValue = "";
            switch (fieldName) {
                case "S_NO":
                    idValue = rows[0].S_NO;
                    break;
                case "S_name":
                    idValue = rows[0].S_name;

                    break;
                case "S_cardno":
                    idValue = rows[0].S_cardno;
                    break;
                case "S_sex":
                    idValue = rows[0].S_sex;
                    break;
                case "FK_Carid":
                    $.ajax({
                        type: "post",
                        url: "GetFileVal",
                        data: { query: rows[0].PK_ID, Fname: "FK_Carid" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                            idValue = res;
                        }
                    });
                    break;
                case "S_mob":
                    idValue = rows[0].S_mob;
                    break;
                case "FK_DIC_from": //来源
                    $.ajax({
                        type: "post",
                        url: "GetFileVal",
                        data: { query: rows[0].PK_ID, Fname: "FK_DIC_from" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                            idValue = res;
                        }
                    });
                    break;
                        case "CostSituation": //费用情况
                    $.ajax({
                        type: "post",
                        url: "GetFileVal",
                        data: { query: rows[0].PK_ID, Fname: "CostSituation" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                            idValue = res;
                        }
                    });
                    break;
                default:
                    idValue = "";
            }
            if (fieldSearchVal.indexOf(fieldName) < 0) {

            } else {
                var position = fieldSearchVal.indexOf(fieldName) - fieldName.length; //定位
                var positionStr = fieldSearchVal.substring(position);
                var Pstr = positionStr.indexOf("^") + 1;

                var positionVal = positionStr.substring(0, Pstr);
                fieldSearchVal = fieldSearchVal.replace(positionVal, "");
            }

            fieldSearchVal = fieldSearchVal + fieldName + "&" + $('<p>' + idValue + '</p>').text() + "^";

            //alert(fieldSearchVal);
            var search = fieldSearchVal;
            //执行查询                        
            $('#' + obj).datagrid('reload', { search: search });
        }

        function fieldReload(obj) {
            fieldSearchVal = "";
            if(obj=="noflexigridData")
            {
                $('#' + obj).datagrid('reload', { search: "S_TXtype&待受理^FK_DIC_Start&noway^" });
            }
            if(obj=="yesflexigridData")
            {
                $('#' + obj).datagrid('reload', { search: "S_TXtype&已受理^FK_DIC_Start&noway^" });
            }
            if (obj == "pifuflexigridData") {
                $('#' + obj).datagrid('reload', { search: "S_TXtype&已批复^FK_DIC_Start&noway^" });
            }
            
        }
        //添加右击菜单内容
        function onRowContextMenu(e, rowIndex, rowData) {
            e.preventDefault(); //阻止浏览器自带的右键菜单弹出


            $("#noflexigridData").datagrid("clearSelections");
            var selected = $("#noflexigridData").datagrid('getRows'); //获取所有行集合对象
            var idValue = selected[rowIndex].PK_ID; //index为当前右键行的索引，指向当前行对象
            $(this).datagrid('selectRecord', idValue);
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        }
                //添加右击菜单内容
        function onRowContextMenu1(e, rowIndex, rowData) {
            e.preventDefault(); //阻止浏览器自带的右键菜单弹出


            $("#yesflexigridData").datagrid("clearSelections");
            var selected = $("#yesflexigridData").datagrid('getRows'); //获取所有行集合对象
            var idValue = selected[rowIndex].PK_ID; //index为当前右键行的索引，指向当前行对象
            $(this).datagrid('selectRecord', idValue);
            $('#mm1').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        }

        function onRowContextMenu2(e, rowIndex, rowData) {
            e.preventDefault(); //阻止浏览器自带的右键菜单弹出


            $("#pifuflexigridData").datagrid("clearSelections");
            var selected = $("#pifuflexigridData").datagrid('getRows'); //获取所有行集合对象
            var idValue = selected[rowIndex].PK_ID; //index为当前右键行的索引，指向当前行对象
            $(this).datagrid('selectRecord', idValue);
            $('#mm3').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        }
   
      

      
               //备注查询
        function FindData2() {
            var search = "";
            var keyword = $("#keyword").val();
            var startTime = $("#startTime").val();
            var endTime = $("#endTime").val();
            var r_sid=$("#r_sid").val();
            var r_module=$("#r_module").val();
            if (keyword != "") {
                search = "r_content&" + keyword + "^"
            }
            if (startTime != "") {
                search += "CreateTimeStart_Time&" + startTime + "^"
            }
            if (endTime != "") {
                search += "CreateTimeEnd_Time&" + endTime + "^"
            }
            if (r_sid != "") {
                search += "r_sid&" + r_sid + "^"
            }
            if (r_module != "") {
                search += "r_module&" + r_module + "^"
            }
            //执行查询
            //alert(search);
            $('#beizhu_list').datagrid('reload', { search: search });
        }
       $(function(){
                   $("#add").click(function () {

                if ($("#r_content").val() == "") {
                    $.messager.alert('系统提示：', '请输入备注内容！', 'warning');
                    return false;
                }
                //alert($("#r_content").val());
                $.messager.confirm('操作提示', "确认添加备注吗？", function (r) {
                   if(r)
                   {
                   
                                       $.ajax({
                    url: "../RemarkRecord/Create",
                    type: "Post",
                    data: $("#ff").serialize(),
                    dataType: "json",
                    success: function (data) {
                        //$.messager.alert('系统提示：', '新增信息成功！', 'info');

                        //$.messager.alert('系统提示：', '添加备注成功！', 'info');
                        $('#r_content').val('');
                        $('#beizhu_list').datagrid('reload');
                    }
                    });

                   } 
                });
            });
});


       //内部学员查询
        function FindData(str) {
           
            var search = '';

            var wordvalue = document.getElementById(str + "wordvalue").value; //关键字
           
            var S_regdateStart_Time = document.getElementById(str + "S_regdateStart_Time").value; //关键字
            var S_regdateEnd_Time = document.getElementById(str + "S_regdateEnd_Time").value; //关键字

            var searchType = $("#" + str + "searchType").combobox("getValue"); //查询条件
            

            if (wordvalue != "") {
                search += searchType + ":" + wordvalue + ","
            }

            if (S_regdateStart_Time != "") {
                search += "regdateStartTime:" + S_regdateStart_Time + ","
            }
            if (S_regdateEnd_Time != "") {
                search += "regdateEndTime:" + S_regdateEnd_Time + ","
            }
            search+="DoStatus:已通过";

            //执行查询
           // alert(search);
            $('#' + str + 'flexigridData').datagrid('reload', { queryCondition: search });
        }

        function flexiArchives(str) {
            //alert(str);
            var rows = $('#' + str + 'flexigridData').datagrid('getSelections');
            if (rows.length != 1) {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
                return false;
            }
            parent.addTab("档案:" + rows[0].S_name, "../S_Archives/IndexNew/" + rows[0].PK_ID + "?rd=" + Math.random(), "tu1001", true, rows[0].PK_ID);
        }


        /////////////////////////////////////////////////////////
        //退学
        function DropSchool(str) {
            var arr = $('#' + str + 'flexigridData').datagrid('getSelections');
        
            if (arr.length == 1) {
                if (arr[0].S_TXpftype.replace(/<[^>]+>/g, "") == "通过") {
                    alert("此学员退学申请已被批复 通过，不能进行此操作");
                    return false;
                }else {
                    window.parent.showMyWindow("退学管理", "../S_App/DropSchool/" + arr[0].PK_ID + "?rd=" + Math.random(), 800, 600, true, false, true);
                     
                }
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
           
            return false;
        }
         function tuixue(){
        	 $.messager.confirm("操作提示", "您确定要执行操作吗？", function (data) {
                 if (data) {
                	 var arr = $('#pifuflexigridData').datagrid('getSelections');
                	 var stuId = arr[0].doStuId;
                	 var shifu = arr[0].doReplyMoney;
                	 if (arr.length == 1) {
                		 //1.改变申请表状态  通过stuid 更改状态信息 2.插入流水信息
                        $.post("/financial/tuifei",{stuId:stuId,shifu:shifu},function(res){
                        	if(res=="OK"){
                        		$.messager.alert('操作提示', '操作成功!', 'warning');
                        		 $('#pifuflexigridData').datagrid('reload');
                        	}else{
                        		$.messager.alert('操作提示','操作失败!','error');
                        	}
                        },"json")
                    } else {
                        $.messager.alert('操作提示', '请选择一条数据!', 'warning');
                        return false;
                    }
        	
                 }
                 else {
                     alert("取消");
                 }
             });
        			 
         }
         //退学退费
        function S_Should() {


            var arr = $('#pifuflexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                 window.parent.showMyWindow("退学退费", "../S_COST_LIST/stuTuiXueCost/" + arr[0].PK_ID + "@CostDisplay=4&rd=" + Math.random(), 1000, 600, true, false, true);
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
        }




    </script>


<base target="_self">
</head>
<body>

	<div class="easyui-layout" style="width: 100%; margin: 5px;" fit="true">

		<div data-options="region:'center',title:'已批复退学名单',iconCls:'icon-ok'"
			style="padding: 5px;">
			<table id="pifuflexigridData" fit="true"></table>
		</div>
	</div>


	<div id="mm3" class="easyui-menu" style="width: 120px;">
		<div onclick="fieldSearch('S_NO','pifuflexigridData')"
			data-options="iconCls:'icon-search'">编号</div>
		<div onclick="fieldSearch('S_name','pifuflexigridData')"
			data-options="iconCls:'icon-search'">姓名</div>
		<div onclick="fieldSearch('S_cardno','pifuflexigridData')"
			data-options="iconCls:'icon-search'">身份证</div>
		<div onclick="fieldSearch('S_sex','pifuflexigridData')"
			data-options="iconCls:'icon-search'">性别</div>


		<div onclick="fieldSearch('FK_Carid','pifuflexigridData')"
			data-options="iconCls:'icon-search'">班别</div>
		<div onclick="fieldSearch('S_mob','pifuflexigridData')"
			data-options="iconCls:'icon-search'">手机</div>
		<div onclick="fieldSearch('FK_DIC_from','pifuflexigridData')"
			data-options="iconCls:'icon-search'">报名来源</div>
		<div onclick="fieldSearch('CostSituation','pifuflexigridData')"
			data-options="iconCls:'icon-search'">费用情况</div>
		<div onclick="fieldSearch('S_TuiJianRen','pifuflexigridData')"
			data-options="iconCls:'icon-search'">推荐人</div>
		<div class="menu-sep"></div>

		<div onClick="fieldReload('pifuflexigridData')"
			data-options="iconCls:'icon-reload'">刷新</div>
	</div>

	<div id="yesSearch3"
		style="padding: 5px; height: auto; font-size: 12px;">
		<div>
			<a href="javascript:void(0);" onclick="tuixue();"
				class="easyui-linkbutton" iconCls="icon-ok" plain="true">退学退费</a>


		</div>
		<div>
			查询条件： <select class="easyui-combobox" panelHeight="auto"
				id="pifusearchType" style="width: 70px">
				<option value="StuNumber">学员编号</option>
				<option value="StuName">学员姓名</option>
			</select> 关键字: <input class="input-textbox" id="pifuwordvalue"
				style="width: 80px" />受理日期：<input type="text" class="input-textbox"
				style="width: 80px" id="pifuS_regdateStart_Time"
				onclick="WdatePicker({maxDate:'#F{$dp.$D(\'pifuS_regdateEnd_Time\');}'})" />
			<span>到</span> <input type="text" class="input-textbox"
				style="width: 80px" id="pifuS_regdateEnd_Time"
				onclick="WdatePicker({minDate:'#F{$dp.$D(\'pifuS_regdateStart_Time\');}'})" />
			<a href="javascript:void(0);" onclick="FindData('pifu');"
				class="easyui-linkbutton" iconCls="icon-search">查询</a>
		</div>
	</div>

</body>
</html>
