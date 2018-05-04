<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head id="MyHead">
    <script src="/resources/Scripts/jquery-1.8.3.min.js" type="text/javascript"></script>
     <script src="/resources/Scripts/JScriptIndex.js" type="text/javascript"></script>
    <script src="/resources/Scripts/jquery.easyui.min-1.3.5.js" type="text/javascript"></script>
    <link href="/resources/Content/Default.css" rel="stylesheet" type="text/css" />
    <link href="/resources/Content/IndexStyle.css" rel="stylesheet" type="text/css" />

        <link href="/resources/Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
        <script src="/resources/Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="/resources/Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <title>
费用管理

</title>
<script type="text/javascript">
    function exports1() {  
         var data = JSON.stringify($('#flexigridData1').datagrid('getData').rows);  
         if (data == '')  
             return;  
		 $("#json").val(data);
		 $("#title").val('待处理费');
		 $("#exportdiv").submit();
     } 
    function exports2() {  
        var data = JSON.stringify($('#flexigridData2').datagrid('getData').rows); 
        if (data == '')  
            return;  
		 $("#json").val(data);
		 $("#title").val('已处理费');
		 $("#exportdiv").submit();
    } 
    </script>
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
    
    
   
        <script src="/resources/Res/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script type="text/javascript" language="javascript">

        $(function () {

            setTimeout(function () { getData("1"); }, 1000);
            setTimeout(function () { getData("2"); }, 1000);
            //setTimeout(function () { zhichuList(); }, 1000);
        });

        function getData(typeStr) {

        
            var search = '';
            var toolbar = "#yesSearch";
            if(typeStr == "1"){
            	search = "{'freState':'待处理'}";
            }
            if (typeStr == "2") {
                search = "{'freState':'已收费'}";
                var toolbar = "#yesSearch" + typeStr;
            }


            $('#flexigridData' + typeStr).datagrid({
                //title: '费用流水', //列表的标题
                iconCls: 'icon-site',
                width: 'auto',
                height: 'auto',
                fit: true,
                nowrap: true,
                striped: true,
                collapsible: true,
                url: '/financial/GetDataBukaofei', 
                queryParams: { searchCondition: search },
                sortName: 'freId',
                sortOrder: 'desc',
                idField: 'freId',
                singleSelect: true,
                loadMsg: '数据载入中,请稍后...',
                toolbar: toolbar,
                columns: [[
                    { field: 'ck', checkbox: true }
					, { field: 'freId', title: '<label for="SCL_NO">费用流水号</label>', width: 120, sortable: true }
                    , { field: 'freTime', title: '<label for="CreateTime">记录时间</label>', width: 134, sortable: true }
                    , { field: 'freClass', title: '<label for="scl_class">流水分类</label>', width: 60, sortable: true }
                    , { field: 'freState', title: '<label for="scl_state">状态</label>', width: 40, sortable: true }
                    , { field: 'freStuId', title: '学员编号', width: 75, sortable: true }
					, { field: 'freCost', title: '<label for="FK_SP_IDOld">费用</label>', width: 100, sortable: true }
                    , { field: 'freIncomePay', title: '<label for="SCL_Should">应收/应付</label>', width: 100, align: 'right', sortable: true }
                    , { field: 'freRealincomeRealpay', title: '<label for="SCL_Real">实收/实付</label>', width: 100,align: 'right', sortable: true }
                    , { field: 'freUnincome', title: '<label for="weishou">未收金额</label>', width: 80,align: 'right', sortable: true }
                    , { field: 'freDiscount', title: '<label for="youhui">优惠金额</label>', width: 80,align: 'right', sortable: true }
                    , { field: 'frePaystyle', title: '<label for="FK_DIC_CASHTYPE">结帐方式</label>', width: 120, align: 'left', sortable: true }
                    , { field: 'freRecordPerson', title: '记录人', width: 70, sortable: true }
                    , { field: 'reModifyPerson', title: '修改人', width: 70, sortable: true }
                    , { field: 'freModifyTime', title: '修改时间', width: 134, sortable: true}

                ]],
                pageList: [10, 20, 50, 100, 500, 1000, 10000, 20000, 50000],
                pagination: true,
                rownumbers: true,
                scrollbarSize: 10
            });

        }


        //“导出EXCEL”按钮     在6.0版本中修改
        function flexiExport(strtype) {
            var str = "yes"
            search1 = 'ischuliStart_Int&0^ischuliEnd_Int&0^scl_stateStart_Int&0^scl_stateEnd_Int&0^SCL_type&收^CostID&ALL^';

            if (strtype == "2") {
                search1 = 'ischuliStart_Int&1^ischuliEnd_Int&1^scl_stateStart_Int&0^scl_stateEnd_Int&0^SCL_type&收^CostID&ALL^';
            }




            var wordvalue = document.getElementById(str + "wordvalue" + strtype).value; //关键字
            var searchType = $("#" + str + "searchType" + strtype).combobox("getValue"); //查询条件

            if (wordvalue != "") {
                search1 += searchType + "&" + wordvalue + "^";
            }

            var FK_DIC_from = $("#FK_DIC_from" + strtype).combobox("getValue"); //报名分校
            if (FK_DIC_from != "") {
                search1 += "S_Student_FK_DIC_from&" + FK_DIC_from + "^"
            }



            var scostname = $("#scostname" + strtype).combobox("getValue"); //费用名称
            if (scostname != "") {
                search1 += "FK_SP_ID&" + scostname + "^"
            }

            //alert(search1);
            $.messager.confirm('操作提示', "确认要导出EXCEL！", function (r) {

                if (r) {
                    progress();
                    //将查询条件按照分隔符拼接成字符串

                    //            $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                    //                search = search + this.id + "&" + this.value + "^";
                    //            });

                    var p = $('#flexigridData' + strtype + '').datagrid('options').columns[0];
                    var field = []; //所有的列名
                    var title = []; //所有的标题名称
                    $(p).each(function () {
                        if (this.title != null) {
                            field.push(this.field);
                            title.push(this.title);
                        }

                    });
                    var titlestr = removeHTMLTag(title.join(","))
                    //alert(titlestr);
                    //alert(field.join(","));
                    $.post("ExportBukaofei",
                {
                    title: titlestr,
                    field: field.join(","),
                    sortName: $('#flexigridData' + strtype + '').datagrid('options').sortName,
                    sortOrder: $('#flexigridData' + strtype + '').datagrid('options').sortOrder,
                    search: search1
                }, function (res) {
                    //alert(res);
                    $.messager.progress('close');
                    window.location.href = res;
                });
                }

            });
        }

        function progress() {
            var win = $.messager.progress({
                title: '请等待',
                text: '数据正在处理中'
            });
        }
    </script>
       <script type="text/javascript">

           //判断是否结帐
         //内部学员查询
        
     
        function FindData(strType) {

        var search11="";
            var str="yes"
            search1 = '';
        if (strType == "2") {
            search11=search1;
        }
       

        
        
            var wordvalue = document.getElementById(str + "wordvalue" + strType).value; //关键字
            var searchType = $("#" + str + "searchType" + strType).combobox("getValue"); //查询条件
            
            if (wordvalue != "") {
                search1 += searchType + ":" + wordvalue + ",";
            }

            var FK_DIC_from = $("#FK_DIC_from" + strType).combobox("getValue"); //报名分校
            if (FK_DIC_from != "") {
                search1 += "stuAssignsSchool:" + FK_DIC_from + ","
            }

            

            var scostname=$("#scostname" + strType).combobox("getValue"); //费用名称
            if(scostname!="")
            {
                search1 += "freClass:" + scostname + ","
            }
            if(strType==1){
            	search1+="freState:待处理";
            }
            if(strType==2){
            	search1+="freState:已收费";
            }
            $('#flexigridData' + strType).datagrid('reload', { queryCondition: search1 });
        }
                        //学员收费
        function S_Should() {


            var arr = $('#flexigridData1').datagrid('getSelections');

            if (arr.length == 1) {
                //window.location.href = "../S_Should/ShouldList/" + arr[0].PK_ID;
                //window.parent.showMyWindow("学员收费", "StudentCost/" + arr[0].PK_ID + "@CostDisplay=4&rd=" + Math.random(), 1000, 600, true, false, false);
                parent.addTab(removeHTMLTag("收费:" + arr[0].freStuId), "/financial/toBukaofei/"+arr[0].freStuId, "tu1001", true, arr[0].freStuId);
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
        }

                function flexiArchives() {
            var rows = $('#flexigridData1').datagrid('getSelections');
            if (rows.length != 1) {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
                return false;
            }
            parent.addTab(removeHTMLTag("档案:" + rows[0].FK_S_ID), "../S_Archives/IndexNew/" + rows[0].stuid + "?rd=" + Math.random(), "tu1001", true, rows[0].PK_ID);
        }

    </script>

      <base target = "_self">
</head>
<body>
    

<div class="easyui-panel" fit="true" style="height:120%;padding:5px;" border="false">


              <div class="easyui-tabs" data-options="tabWidth:180" fit="true">
       <div title="待处理费" style="padding:5px;">
             <table id="flexigridData1"></table>
        </div>
       <div title="已处理费" style="padding:5px;">
            <table id="flexigridData2"></table>
       </div>

        
    </div>

</div>
 
<!--操作和搜索-->

    <div id="yesSearch" style="padding:5px;height:auto; font-size:12px;">
    <style type="text/css">
    .row{ height:30px; clear:both; text-align:left;}
</style>
        <div class="row">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick='S_Should();' plain="true">收费</a>
            <a href="javascript:void(0);" onclick="exports1()" class="easyui-linkbutton" iconCls="icon-excel" plain="true">导出EXCEL</a>
        </div>
        <div class="row">
         &nbsp;查询条件：<select class="easyui-combobox" panelHeight="auto" id="yessearchType1" style="width:100px">
                <option value="stuCardId">身份证号</option>
                <option value="stuName">学员姓名</option>
                <option value="stuId">学员编号</option>
                <option value="stuRecoderId">档案编号</option>
                <option value="stuPhone">手机号码</option>
           </select>&nbsp;
            关 &nbsp;键 字：<input class="input-textbox" id="yeswordvalue1" style="width:80px" />
            补考费分类：<select class="easyui-combobox" id="scostname1" name="scostname1" panelHeight="auto" style="width:80px;"><option value="">请选择</option>
            <option value="科一补考费">科一补考费</option>
            <option value="科二补考费">科二补考费</option>
            <option value="科三补考费">科三补考费</option>

            </select>
            &nbsp;报名分校：<select class="easyui-combobox" id="FK_DIC_from1" name="FK_DIC_from1" style="width:78px;"><option value="">请选择</option>
<option value="总校">总校</option>
<option value="挂靠">挂靠</option>
</select> 
            &nbsp;<a href="javascript:void(0);" onclick="FindData('1');" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </div>

    </div>

        <div id="yesSearch2" style="padding:5px;height:auto; font-size:12px;">
    <style type="text/css">
    .row{ height:30px; clear:both; text-align:left;}
</style>
        <div class="row">
            <a href="javascript:void(0);" onclick="exports2()" class="easyui-linkbutton" iconCls="icon-excel" plain="true">导出EXCEL</a>
        </div>
        <div class="row">
         &nbsp;查询条件：<select class="easyui-combobox" panelHeight="auto" id="yessearchType2" style="width:100px">
                <option value="stuCardId">身份证号</option>
                <option value="stuName">学员姓名</option>
                <option value="stuId">学员编号</option>
                <option value="stuRecoderId">档案编号</option>
                <option value="stuPhone">手机号码</option>
           </select>&nbsp;
            关 &nbsp;键 字：<input class="input-textbox" id="yeswordvalue2" style="width:80px" />
            补考费分类：<select class="easyui-combobox" id="scostname2" name="scostname2" panelHeight="auto" style="width:80px;"><option value="">请选择</option>
            <option value="科一补考费">科一补考费</option>
            <option value="科二补考费">科二补考费</option>
            <option value="科三补考费">科三补考费</option>

            </select>
            &nbsp;报名分校：<select class="easyui-combobox" id="FK_DIC_from2" name="FK_DIC_from2" style="width:78px;"><option value="">请选择</option>
<option value="总校">总校</option>
<option value="挂靠">挂靠</option>
</select> 
            &nbsp;<a href="javascript:void(0);" onclick="FindData('2');" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </div>
    </div>

            <div id="yesSearch3" style="padding:5px;height:auto; font-size:12px;">
    <style type="text/css">
    .row{ height:30px; clear:both; text-align:left;}
</style>
    <div class="row">
            <a href="javascript:void(0);" onclick="flexiExport('3')" class="easyui-linkbutton" iconCls="icon-excel" plain="true">导出EXCEL</a>
        </div>
        <div class="row">
         &nbsp;查询条件：<select class="easyui-combobox" panelHeight="auto" id="yessearchType3" style="width:100px">
                <option value="S_cardno">身份证号</option>
                <option value="S_name">学员姓名</option>
                <option value="S_NO">学员编号</option>
                <option value="S_ArNO">档案编号</option>
                <option value="S_mob">手机号码</option>
           </select>&nbsp;
            关 &nbsp;键 字：<input class="input-textbox" id="yeswordvalue3" style="width:80px" />
            补考费分类：<select class="easyui-combobox" id="scostname3" name="scostname3" panelHeight="auto" style="width:80px;"><option value="">请选择</option>
            <option value="201404150846198301151f159579c6a">科一补考费</option>
            <option value="2014041508471371019687fa9ed1faf">科二补考费</option>
            <option value="201404150848172658320fb3328534b">科三补考费</option>
            </select>
            &nbsp;报名分校：<select class="easyui-combobox" id="FK_DIC_from3" name="FK_DIC_from3" style="width:78px;"><option value="">请选择</option>
<option value="分校一">分校一</option>
<option value="分校二">分校二</option>
<option value="分校三">分校三</option>
<option value="分校四">分校四</option>
</select> 
            &nbsp;<a href="javascript:void(0);" onclick="FindData2();" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </div>
        <form id="exportdiv" method="post" action="/financial/export">
  		<input type="hidden" name="json" id="json">
  		<input type="hidden" name="title" id="title">
  </form>
    </div>

<!--操作和搜索-->




</body>
</html>
