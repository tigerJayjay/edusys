<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head id="MyHead">
    <script src="/resources/Scripts/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/Scripts/jquery.easyui.min-1.3.5.js" type="text/javascript"></script>
        <script src="/resources/Scripts/jquery.datagrid.js" type="text/javascript"></script>
    <script src="/resources/Scripts/JScriptIndex.js" type="text/javascript"></script>
    <link href="/resources/Content/Default.css" rel="stylesheet" type="text/css" />
    <link href="/resources/Content/IndexStyle.css" rel="stylesheet" type="text/css" />

        <link href="/resources/Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
        <script src="/resources/Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="/resources/Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <title>
	
  收入列表

</title>
     <script type="text/javascript">
    function exports() {  
         var data = JSON.stringify($('#flexigridData').datagrid('getData').rows); 
         if (data == '')  
             return;  
		 $("#json").val(data);
		 $("#title").val(document.title);
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
    
<script src="/resources/Scripts/jquery.PrintArea.js" type="text/javascript"></script>
    <script type="text/javascript" language="javascript">
        $(function () {

        	 $('#flexigridData').datagrid({
                 //title: '费用流水', //列表的标题
                 iconCls: 'icon-site',
                 width: 'auto',
                 height: 'auto',
                 nowrap: true,
                 striped: true,
                 fitColumns:true,
                 collapsible: true,
                // url: 'S_COST_LIST/GetData', //GetDataStudent获取数据的url
                 url: '/financial/GetDataStudent', //
                 queryParams: { searchCondition:"{'parentType':'3'}"},
                 sortName: 'fcId',
                 sortOrder: 'desc',
                 idField: 'fcId',
                 loadMsg:'数据载入中,请稍后...',
                 toolbar: '.datagrid-toolbar',
                 columns: [[
                     { field: 'ck', checkbox: true },
                     {field:"fcId",title:"流水编号",width:100},
                     {field:"fcTime",title:"记录时间",width:100},
                     {field:"ftTypeName",title:"流水分类",width:80},
                     {field:"fcState",title:"结账状态",
                     	styler: function(value,row,index){
 	        				if(value=="未结账"){
 	        					return 'color:red';
 	        				}
 	        				if(value=="已结账"){
 	        					return 'color:green';
 	        				}
         			    },width:80
                     },
                     {field:"fcModifyTime",title:"结账时间",width:100},
                     {field:"fcModifyPerson",title:"结账人",width:80},
                     {field:"fcTicketId",title:"票据编号",width:80},
                     {field:"fcPayStyle",title:"结账方式",width:80},
                 	{field:"fcIncomePay",title:"应收金额",width:80},
                 	{field:"fcDiscount",title:"实收金额",width:80},
                 	{field:"fcDisState",title:"优惠金额",width:80},
                 	{field:"dest",title:"收支状态",
                 		formatter: function(value){
 	        				if (value==1){
 	        					return "收入";
 	        				} 
 	        				if(value==0) {
 	        					return "支出";
 	        				}
         				}
 					},
                 	{field:"fcChargePerson",title:"收款人",width:80},
                 	{field:"fcCheckoutState",title:"核对状态",
                 		styler: function(value,row,index){
         				if(value=="未核对"){
         					return 'color:red';
         				}
         				if(value=="已核对"){
         					return 'color:green';
         				}
     			    },width:80},
                 	{field:"fcCheckTime",title:"核对时间",width:100},
                 	{field:"fcCheckPerson",title:"核对人",width:80}
        
                 ]],
                 pageSize:1,
                 pageList:[1,5,10],
                 pagePosition:'noth',
                 rownumbers: true,
                 pagination:true,
                 scrollbarSize:10
             });

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
                // alert(iframeid);
                //关闭AJAX相应的缓存
                $.ajaxSetup({
                    cache: false
                });

                $.getJSON("Home/GetToolbar", { id: iframeid }, function (data) {

                var Priter=[{   
            text:'打印',   
            iconCls:'icon-print',   
            handler:function(e){   //打印
                PrintArea();
            }   
        }
        ];
        var Priterdc=[
                   {
                     text: '导出EXCEL',
                      iconCls: 'icon-excel',
                                 handler: function () {
                                     $.messager.confirm('操作提示', "确认要出到EXCEL吗？", function (r) {
                                         if (r) { return xuanzedayin('huizong'); }
                                     });
                                 }
                             }
];


                    if (data == null) {
                        return;
                    }

                    $('#flexigridData').datagrid("addToolbarItem", data);
                    $('#flexigridData').datagrid("addToolbarItem", Priter);
                    $('#flexigridData').datagrid("addToolbarItem", Priterdc);
                });

            } else {
                //添加选择按钮
                $('#flexigridData').datagrid("addToolbarItem", [{
                    text: '查询',
                    iconCls: 'icon-search',
                    handler: function () {
                        flexiQuery();
                    }
                }, { "text": "选择", "iconCls": "icon-ok", handler: function () { flexiSelect(); } }]);
            }

        });

                   //作废操作
           function Invalid() {
               var rows = $('#flexigridData').datagrid('getSelections');
               if (rows.length == 0) {
                   $.messager.alert('操作提示', '请选择数据!', 'warning');
                   return false;
               }
               var arr = [];
               for (var i = 0; i < rows.length; i++) {
                   if(removeHTMLTag(rows[i].scl_jiezhang)=='已结帐')
                   {
                        $.messager.alert('操作提示', '流水' + rows[i].SCL_NO + '已经结帐，不能作废!', 'warning');
                        return false;
                   }
                   else{
                        arr.push(rows[i].PK_ID);
                   }
                   
               }
               $.messager.confirm('操作提示', "确认作废这 " + arr.length + " 项吗？", function (r) {
                   if (r) {
                       $.post("S_COST_LIST/OperatingInvalid", { query: arr.join(",") }, function (res) {

                           if (res == "OK") {
                               //移除删除的数据
                               $.messager.alert('操作提示', '操作成功!', 'info');

                               $("#flexigridData").datagrid("reload");
                               $("#flexigridData").datagrid("clearSelections");

                           }
                           else {
                               $.messager.alert('操作提示', res, 'info');
                           }
                       });
                   }
               });
               //****************
           }

                   function openCheck() {
               var rows = $('#flexigridData').datagrid('getSelections');
               if (rows.length == 0) {
                   $.messager.alert('操作提示', '请选择数据!', 'warning');
                   return false;
               }
               var arr = [];
               for (var i = 0; i < rows.length; i++) {
                   arr.push(rows[i].PK_ID);
               }
               $.messager.confirm('操作提示', "确认核对这 " + arr.length + " 项吗？", function (r) {
                   if (r) {
                       $.post("S_COST_LIST/OperatingCheck", { query: arr.join(",") }, function (res) {

                           if (res == "OK") {
                               //移除删除的数据
                               $.messager.alert('操作提示', '操作成功!', 'info');

                               $("#flexigridData").datagrid("reload");
                               $("#flexigridData").datagrid("clearSelections");

                           }
                           else {
                               $.messager.alert('操作提示', res, 'info');
                           }
                       });
                   }
               });
           }

        //打印方法
        var isbuda="yes";
        function PrintArea() 
        {
             var rows = $('#flexigridData').datagrid('getSelections');
                if (rows.length == 0) {
                    $.messager.alert('操作提示', '请选择数据!', 'warning');
                    return false;
                }
                if(rows.length>1)
                {
                    $.messager.alert('操作提示', '请选择一条数据!', 'warning');
                    return false;
                }
// 
//                var arr = rows[0].PK_ID;

            //var SysMenuId = '2012120315004764062502a4e5a9f40';
            //var url = "S_Ticket_List/Print_Other/" + arr + "@SysMenuId=" + SysMenuId + "&rd=" + Math.random();
            //window.parent.showIdWindow("打印管理", url, 800, 550, false, false, true);
                
                //alert(rows[0].SCL_SerialNumber);

                $.post("ReceiptBill/getRbInfo",{bianhao:rows[0].SCL_SerialNumber},function(res){
                    if(res!="NO")
                    {
                         $("#shoujutitle").html(res["shoujutitle"]);
                         $("#kaipiaoriqi").html(dateConvert(res["kaipiaoriqi"]));
                         $("#bianhao").html(res["bianhao"]);
                         $("#shoudao").html(res["shoudao"]);
                         $("#jiaolai").html(res["jiaolai"]);
                         $("#daxie").html(res["daxie"]);
                         $("#zhidanren").html(res["zhidanren"]);
                         $("#shoukuanren").html(res["shoukuanren"]);
                         $("#jiaokuanren").html(res["jiaokuanren"]);
                         $("#beizhu").html(res["beizhu"]);
                         $("#buda").html("&nbsp;(补打)");  
                    }
                    else
                    {
                         $("#bianhao").html(rows[0].SCL_SerialNumber);
                         $("#shoudao").html(rows[0].SCL_JBR);
                         $("#jiaolai").html(rows[0].FK_SP_ID + "(￥" + formatCurrency(rows[0].SCL_Real) + ")");
                         //$("#daxie").html(convertCurrency(formatCurrency(rows[0].SCL_Real)));
                         $("#daxie").html(convertCurrency(formatCurrency(rows[0].SCL_Real))+" 小写：￥"+formatCurrency(rows[0].SCL_Real));
                         $("#zhidanren").html(rows[0].opertPerson);
                         $("#shoukuanren").html(rows[0].opertPerson);
                         //$("#jiaokuanren").html(rows[0].rb_jiaokuan);
                         $("#beizhu").html(rows[0].SCL_REMARK);
                         $("#kaipiaoriqi").html('2018-01-18');
                         isbuda="no";
                    }
                    $('#shoufeimodel').dialog("open");
                });



                 

        }

        //“查询”按钮，弹出查询框
        function flexiQuery() {
            $('#divQuery').dialog({
                buttons: [{
                    text: '查询',
                    iconCls: 'icon-ok',
                    handler: function () {
                        //将查询条件按照分隔符拼接成字符串
                        var search = "Costdisplay&4^";
                        $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                            search = search + this.id + "&" + this.value + "^";
                        });
                        //执行查询                        
                        $('#flexigridData').datagrid('reload', { search: search });
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
                arr.push(rows[i].PK_ID);
            }
            arr.push("^");
            for (var i = 0; i < rows.length; i++) {
                arr.push(rows[i].SCL_NO);
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
                window.location.href = "S_Income/Details/" + arr[0].PK_ID;

            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
        }
        //导航到创建的按钮
        function flexiCreate() {

            window.location.href = "S_Income/Create";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "S_Income/Edit/" + arr[0].PK_ID;

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

            var arr = [];
            for (var i = 0; i < rows.length; i++) {
                arr.push(rows[i].PK_ID);
            }

            $.messager.confirm('操作提示', "确认删除这 " + arr.length + " 项吗？", function (r) {
                if (r) {
                    $.post("S_Income/Delete", { query: arr.join(",") }, function (res) {
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


      //选择导出
       function xuanzedayin(type_) {
            $('#xuanzedayin').dialog({
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function () {
                        var fields = "";
                        var titles = "";                    
                                              
                        if ($("#SCL_NO1").attr("checked")) {
                            fields += ",'SCL_NO'";
                            titles += ",'费用流水号'";
                        }

                        if ($("#scl_state").attr("checked")) {
                            fields += ",'scl_state'";
                            titles += ",'状态'";
                        }

                        if ($("#CreateTime").attr("checked")) {
                            fields += ",'CreateTime'";
                            titles += ",'记录时间'";
                        }
                   
                        if ($("#SCL_SerialNumber").attr("checked")) {
                            fields += ",'SCL_SerialNumber'";
                            titles += ",'票据编号'";
                        }

                        if ($("#SCL_Real1").attr("checked")) {
                            fields += ",'SCL_Real'";
                            titles += ",'实收/实付'";
                        }
                        if ($("#FK_SP_ID1").attr("checked")) {
                            fields += ",'FK_SP_ID'";
                            titles += ",'费用'";
                        }
                        if ($("#FK_DIC_CASHTYPE").attr("checked")) {
                            fields += ",'FK_DIC_CASHTYPE'";
                            titles += ",'结账方式'";
                        }
                        if ($("#SCL_JBR1").attr("checked")) {
                            fields += ",'SCL_JBR'";
                            titles += ",'缴款人'";
                        }
                        if ($("#qita_cardno").attr("checked")) {
                            fields += ",'qita_cardno'";
                            titles += ",'身份证号'";
                        }
                        if ($("#qita_mob").attr("checked")) {
                            fields += ",'qita_mob'";
                            titles += ",'联系电话'";
                        }
                        if ($("#qita_suoshu").attr("checked")) {
                            fields += ",'qita_suoshu'";
                            titles += ",'招生所属'";
                        }
                        if ($("#SCL_type").attr("checked")) {
                            fields += ",'SCL_type'";
                            titles += ",'收'";
                        }
                         if ($("#fenxiaoID").attr("checked")) {
                            fields += ",'fenxiaoID'";
                            titles += ",'所属分校'";
                        }
                        if ($("#baomingID").attr("checked")) {
                            fields += ",'baomingID'";
                            titles += ",'报名点'";
                        }
                        if ($("#SCL_REMARK").attr("checked")) {
                            fields += ",'SCL_REMARK'";
                            titles += ",'备注'";
                        }
                        if ($("#scl_jiezhang").attr("checked")) {
                            fields += ",'scl_jiezhang'";
                            titles += ",'结账状态'";
                        }
                        if ($("#scl_jiezhangren").attr("checked")) {
                            fields += ",'scl_jiezhangren'";
                            titles += ",'结账人'";
                        }
                        if ($("#scl_jiezTime").attr("checked")) {
                            fields += ",'scl_jiezTime'";
                            titles += ",'结账时间'";
                        }
                        if ($("#scl_check").attr("checked")) {
                            fields += ",'scl_check'";
                            titles += ",'核对状态'";
                        }
                        if ($("#scl_heduiren").attr("checked")) {
                            fields += ",'scl_heduiren'";
                            titles += ",'核对人'";
                        }
                        if ($("#scl_heduitime").attr("checked")) {
                            fields += ",'scl_heduitime'";
                            titles += ",'核对时间'";
                        }
                        if ($("#CretePerson").attr("checked")) {
                            fields += ",'CretePerson'";
                            titles += ",'记录人'";
                        }
                        $("#fields_").val(fields);
                        $("#titles_").val(titles);
                        //alert(type_)
                        if (type_ == "huizong") {

                            flexiExport();
                        }

                        $('#xuanzedayin').dialog("close");
                    }
                },
                     {
                         text: '取消',
                         iconCls: 'icon-cancel',
                         handler: function () {
                             $('#xuanzedayin').dialog("close");
                         }
                     }]
            });
            $('#xuanzedayin').dialog("open");
        };

         //“导出EXCEL”按钮     在6.0版本中修改
        function flexiExport() {

            progress();
           
            var search1="";
            $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                search1 = search1 + this.id + "&" + this.value + "^";
            });

            var files = $("#fields_").val();
            var titles = $("#titles_").val();
            var field = eval("[" + files.substr(1, files.length) + "]"); //所有的列名
            var title = eval("[" + titles.substr(1, titles.length) + "]"); //所有的标题名称
           // alert(title);
            var titlestr = title.join(",");
            $.post("S_Income/Export",
                {
                    title: titlestr,
                    field: field.join(","),
                    sortName: $('#flexigridData').datagrid('options').sortName,
                    sortOrder: $('#flexigridData').datagrid('options').sortOrder,
                    //search: $('#flexigridData').datagrid('options').search,
                    search:search1,
                    filename1: '其他收入管理'
                }, function (res) {
                    // alert(res);
                    $.messager.progress('close');
                    window.location.href = res;
                });
        }

        function progress() {
            var win = $.messager.progress({
                title: '请等待',
                text: '数据正在处理中'
            });
        }
        //js过滤HTML标签以及空格
        function removeHTMLTag(str) {
            str = str.replace(/<\/?[^>]*>/g, ''); //去除HTML tag
            str = str.replace(/[ | ]*\n/g, '\n'); //去除行尾空白
            //str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
            str = str.replace(/ /ig, ''); //去掉 
            return str;
        }


//作废操作
           function Invalid() {
               var rows = $('#flexigridData').datagrid('getSelections');
               if (rows.length == 0) {
                   $.messager.alert('操作提示', '请选择数据!', 'warning');
                   return false;
               }
               var arr = [];
               for (var i = 0; i < rows.length; i++) {
                   if(removeHTMLTag(rows[i].scl_jiezhang)=='已结帐')
                   {
                        $.messager.alert('操作提示', '流水' + rows[i].SCL_NO + '已经结帐，不能作废!', 'warning');
                        return false;
                   }
                   else{
                        arr.push(rows[i].PK_ID);
                   }
                   
               }
               $.messager.confirm('操作提示', "确认作废这 " + arr.length + " 项吗？", function (r) {
                   if (r) {
                       $.post("S_COST_LIST/OperatingInvalid", { query: arr.join(",") }, function (res) {

                           if (res == "OK") {
                               //移除删除的数据
                               $.messager.alert('操作提示', '操作成功!', 'info');

                               $("#flexigridData").datagrid("reload");
                               $("#flexigridData").datagrid("clearSelections");

                           }
                           else {
                               $.messager.alert('操作提示', res, 'info');
                           }
                       });
                   }
               });
               //****************
           }

           function querenprint(){
                   //如果是补打
                   var rows = $('#flexigridData').datagrid('getSelections');
        if(isbuda=="yes")
        {
            

            $.messager.confirm('操作提示', "确认要打印吗？", function (r) {
                if(r)
                {
                            $.post("ReceiptBill/budaPiaoju",{bianhao:rows[0].SCL_SerialNumber},function(res){
                 
                if(res=="OK")
                {
                    $("#shouju").printArea();
                    $('#shoufeimodel').dialog("close");
                    $.messager.alert('系统提示：','打印成功！','info');

                    
                }
            });
                }
            });



            }else
            {
            
                 var riqi=$("#kaipiaoriqi").text();
                 var bianhao=$("#bianhao").text();
                 var shoudao=$("#shoudao").text();
                 var jiaolai=$("#jiaolai").text();
                 var daxie=$("#daxie").text();
                 var zhidan=$("#zhidanren").text();
                 var shoukuan=$("#shoukuanren").text();
                 var jiaokuan=$("#jiaokuanren").text().replace("&nbsp;","");
                 var beizhu=$("#beizhu").text();
                 var shoujutitle=$("#shoujutitle").text();


         

                 //alert(rows[0].PK_ID);

                 $.messager.confirm('操作提示', "确认要打印吗？", function (r) {
                 
                 if(r){
                 
                 $.post("ReceiptBill/querenprint",{pkids:rows[0].PK_ID,shoujutitle:shoujutitle,riqi:riqi,bianhao:bianhao,shoudao:shoudao,jiaolai:jiaolai,daxie:daxie,zhidan:zhidan,shoukuan:shoukuan,jiaokuan:jiaokuan,beizhu:beizhu,sclclass:'qitaShouru'},
                    function(res){
                        if(res=="OK")
                        {


                            $("#flexigridData").datagrid("reload");
                            $("#flexigridData").datagrid("clearSelections");

                            $('#shoufeimodel').dialog("close");
                    
                            $.messager.alert('系统提示：','打印成功！','info');

                            $("#shouju").printArea();
                    
                        }
                        else{
                            $.messager.alert('系统提示：','开票失败！','info');
                        }
                    }
                 );
                  }

                 });
            }
       }

    </script>

    <style type="text/css">
		div,ul,li{ margin:0px; padding:0px; list-style:none;}
	
	#shouju{width:750px;  margin:0 auto; font-family:新宋体;}
	#title{text-align:center; font-size:18px; height:30px; line-height:30px; font-weight:bolder;}
	
	#content{ overflow:hidden;zoom:1; font-size:14px; font-weight:800;}
	#content ul li{ display:block;}
	#content #left{ float:left; width:20px; line-height:30px; text-align:left;}
	#content #left span{ display:block; height:100px; width:20px; margin-top:32px;}
	#content #right{ float:left;width:700px;}
	#content #right1{ float:right;width:20px; padding-top:42px; font-size:12px;}
	#content #right1 span{display:block; margin-top:2px; margin-bottom:2px; width:20px;}
	
	#title1{overflow:hidden;zoom:1; height:30px; line-height:30px;}
	#title1 .left{ display:block;float:left; margin-left:32px;}
	#title1 .right{ display:block;float:right;margin-right:32px;}
	
	#content123{ border:#000 1px solid;height:auto; min-height:180px; }
	#content123 .line ul li{ display:block; height:auto;}
	#content123 .line{ overflow:hidden;zoom:1;}
	#content123 .line .left1{ float:left; width:92px; margin-left:15px; line-height:32px; text-align:left;}
	#content123 .line .right1{ float:right; text-align:left;line-height:23px; padding-top:6px; width:576px; margin-right:10px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;margin-right:10px;}
	#content123 .line .right1 span{ float:left;text-align:left; }
	#content123 .line .left2{ float:left; width:60px; margin-left:10px; line-height:37px; text-align:left;}
	#content123 .line .right2{ float:left; text-align:left;line-height:23px; padding-top:6px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;}
	#content123 .textarea{ border:0px; height:30px; width:100%;overflow:auto;background-attachment:fixed;background-repeat:no-repeat;}
	
	#content123 .line .right1 .xiangmu{display:block; width:180px;}
	
	.tishi{height:auto; font-size:12px; line-height:15px; text-align:left; overflow:hidden;zoom:1; margin-top:6px;}
	.tishi .span1{ display:block; float:left;width:80px;margin-left:30px;}
	.tishi .span2{ display:block; float:left;width:566px;}
	.width100{ width:100px;}
	.textarea{ font-size:14px; color:#000; font-weight:800;}
	#content123 .line .noneline{ border-bottom:0px;}
</style>
<script src="/resources/Res/My97DatePicker/WdatePicker.js" type="text/javascript"></script>

      <base target = "_self">
</head>
<body class="easyui-layout" style="padding:3px;">
    <table id="flexigridData" fit="true">
    </table>
    
    <div id="divQuery" title="查询列表" class="easyui-dialog" closed="true" modal="false"
        iconcls="icon-search">
         
        
            <div class="input">
                <div class="editor-label-search" style="width: 70px;">
                    <label for="SCL_NO">费用流水号</label>
                </div>
                <div class="editor-field-search"  style="width: 130px;">
                    <input type='text' id='SCL_NO'/>
                </div>
            </div>
            <div class="input">
                <div class="editor-label-search" style="width: 70px;" >
                    <label for="FK_SP_ID">费用名称</label>
                </div>
                <div class="editor-field-search" style="width: 130px;">
                         <select id="FK_SP_ID" name="FK_SP_ID" style="width:120px"><option value="">请选择</option>
   
<option value="20140415085857940476552cd9a98f2" >科一补考费(收)</option>

<option value="2014041508593643067804f43b31be0" >科二补考费(收)</option>

<option value="20140415090018662093561aa05b0f1" >科三补考费(收)</option>

<option value="201412301703254965587869208be0d" >换班差价</option>

<option value="201712250858566278093e588d3fe29" >C1报名费</option>

<option value="201712250859061903093c52bdd86fd" >C2报名费</option>

<option value="2017122509023484655931d894dac55" >C1报名费（VIP）</option>

<option value="20180112102153674684344452603e5" >报名费</option>


</select>
                </div>
            </div>

                    <div class="input">
             <div class="editor-label-search" style="width: 35px;">
                    <label for="SCL_Real">实收/实付</label>
                </div>
                <div class="editor-field-to" style="width: 270px;">
                    <input type="text" id="SCL_RealStart_Int" onkeyup = "isInt(this)" style="width:50px" />
                  到
                    <input type="text" id="SCL_RealEnd_Int" onkeyup = "isInt(this)"  style="width:50px" />
                </div>
             </div>
                         <div class="input">
                <div class="editor-label-search" style="width: 70px;">
                    <label for="SCL_JBR">缴款人</label>
                </div>
                <div class="editor-field-search"  style="width: 130px;">
                    <input type='text' id='SCL_JBR'/>
                </div>
            </div>
                 <div class="input">
                  <div class="editor-label-search" style="width: 70px;">
                    <label for="Add_date">记录日期</label>
                </div>
                <div class="editor-field-to" style="width: 280px;">
                    <input type="text" id="Add_dateStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'Add_dateEnd_Time\');}'})"  />
                   到
                    <input type="text" id="Add_dateEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'Add_dateStart_Time\');}'})" />
                </div>
                 </div>
    </div>

<!--收费单据-->
        <div id="shoufeimodel" class="easyui-window" title="其他收入单据" data-options="modal:true,closed:true,minimizable:false,collapsible:false,maximizable:false,iconCls:'icon-print'" style="width:800px;height:460px;padding:10px;">
 
<div id="shouju">
<style type="text/css" media="print">

		div,ul,li{ margin:0px; padding:0px; list-style:none;}
	
	#shouju{width:750px;  margin:0 auto; font-family:新宋体;}
	#title{text-align:center; font-size:18px; height:30px; line-height:30px; font-weight:bolder;}
	
	#content{ overflow:hidden;zoom:1; font-size:14px; font-weight:800;}
	#content ul li{ display:block;}
	#content #left{ float:left; width:20px; line-height:30px; text-align:left;}
	#content #left span{ display:block; height:100px; width:20px; margin-top:32px;}
	#content #right{ float:left;width:700px;}
	#content #right1{ float:right;width:20px; padding-top:42px; font-size:12px;}
	#content #right1 span{display:block; margin-top:2px; margin-bottom:2px; width:20px;}
	
	#title1{overflow:hidden;zoom:1; height:30px; line-height:30px;}
	#title1 .left{ display:block;float:left; margin-left:32px;}
	#title1 .right{ display:block;float:right;margin-right:32px;}
	
	#content123{ border:#000 1px solid;height:auto; min-height:180px; }
	#content123 .line ul li{ display:block; height:auto;}
	#content123 .line{ overflow:hidden;zoom:1;}
	#content123 .line .left1{ float:left; width:92px; margin-left:15px; line-height:32px; text-align:left;}
	#content123 .line .right1{ float:right; text-align:left;line-height:23px; padding-top:6px; width:576px; margin-right:10px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;margin-right:10px;}
	#content123 .line .right1 span{ float:left;text-align:left; }
	#content123 .line .left2{ float:left; width:60px; margin-left:10px; line-height:37px; text-align:left;}
	#content123 .line .right2{ float:left; text-align:left;line-height:23px; padding-top:6px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;}
	#content123 .textarea{ border:0px; height:30px; width:100%;overflow:auto;background-attachment:fixed;background-repeat:no-repeat;}
	
	#content123 .line .right1 .xiangmu{display:block; width:180px;}
	
	.tishi{height:auto; font-size:12px; line-height:15px; text-align:left; overflow:hidden;zoom:1; margin-top:6px;}
	.tishi .span1{ display:block; float:left;width:80px;margin-left:30px;}
	.tishi .span2{ display:block; float:left;width:566px;}
	.width100{ width:100px;}
	.textarea{ font-size:14px; color:#000; font-weight:800;}
	#content123 .line .noneline{ border-bottom:0px;}
</style>
	<div id="title" ><span id="shoujutitle">北京博奥创软科技有限公司收款凭据</span></div>
    <div id="content">
    	<ul>
        	<li id="left"><span>其他收入单据</span></li>
            <li id="right">
            	<div id="title1"><span class="left">开票日期：<span id="kaipiaoriqi"></span></span><span class="right">NO：<span id="bianhao"></span><span id="buda"></span></span></div>
                <div id="content123">
                	<div class="line">
                        <ul>
                            <li class="left1">今收到：</li>
                            <li class="right1" id="shoudao">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="line">
                         <ul>
                            <li class="left1">交&nbsp;&nbsp;来：</li>
                            <li class="right1" id="jiaolai">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="line">
                        <ul>
                            <li class="left1">合计(大写)：</li>
                            <li class="right1" id="daxie">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="line">
                        <ul>
                            <li class="left1">单位公章：</li>
                            <li class="left2">制单人：</li>
                            <li class="right2" id="zhidanren">&nbsp;</li>
                            <li class="left2">收款人：</li>
                            <li class="right2" id="shoukuanren">&nbsp;</li>
                            <li class="left2">缴款人：</li>
                            <li class="right2 width100" id="jiaokuanren">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="line">
                        <ul>
                            <li class="left1">备注说明：</li>
                            <li class="right1 noneline"><textarea name="beizhu" id="beizhu" class="textarea" cols="" rows=""></textarea></li>
                        </ul>
                    </div>
                </div>
            </li>
            <li id="right1">白存根<span>/</span>粉记账<span>/</span>黄学员</li>
        </ul>
    </div>
</div>



        <input type="hidden" value="" id="pkids" />
        <div class="piaoline" style=" text-align:center; margin-top:10px;"><a href="javascript:void(0);" onclick="querenprint();" class="easyui-linkbutton" data-options="iconCls:'icon-print'">确认打印</a></div>
</div>


<div id="xuanzedayin" title="选择导出列" class="easyui-dialog" style="width: 400px; height: 500px;
        padding-top: 8px;" closed="true" modal="false" iconcls="icon-search">
        <table>
        <tr>
        <td>
        选择导出<br />
        <input onclick="selectAll()" type="checkbox"   name="controlAll" id="controlAll" />全部选则<br />
        <input name="selectedprint" id="SCL_NO1" type="checkbox" value="1" />费用流水号<br />
        <input name="selectedprint" id="scl_state" type="checkbox" value="1" />状态<br />
        <input name="selectedprint" id="CreateTime" type="checkbox" value="1" />记录时间<br />
        <input name="selectedprint" id="SCL_SerialNumber" type="checkbox" value="1" />票据编号<br />
        <input name="selectedprint" id="SCL_Real1" type="checkbox" value="1" />实收/实付<br />
        <input name="selectedprint" id="FK_SP_ID1" type="checkbox" value="1" />费用<br />
        <input name="selectedprint" id="FK_DIC_CASHTYPE" type="checkbox" value="1" />结账方式<br />
        <input name="selectedprint" id="SCL_JBR1" type="checkbox" value="1" />缴款人<br />
        <input name="selectedprint" id="qita_cardno" type="checkbox" value="1" />身份证号<br />
        <input name="selectedprint" id="qita_mob" type="checkbox" value="1" />联系电话<br/>
        <input name="selectedprint" id="qita_suoshu" type="checkbox" value="1" />招生所属<br />
        <input name="selectedprint" id="SCL_type" type="checkbox" value="1" />收<br/>
       <input name="selectedprint" id="fenxiaoID" type="checkbox" value="1" />所属分析<br />
        <input name="selectedprint" id="baomingID" type="checkbox" value="1" />报名点<br/>
        <input name="selectedprint" id="SCL_REMARK" type="checkbox" value="1" />备注<br />
        <input name="selectedprint" id="scl_jiezhang" type="checkbox" value="1" />结账状态<br />
        <input name="selectedprint" id="scl_jiezhangren" type="checkbox" value="1" />结账人<br/>
        <input name="selectedprint" id="scl_jiezTime" type="checkbox" value="1" />结账时间<br/>
        <input name="selectedprint" id="scl_check" type="checkbox" value="1" />核对状态<br/>
        <input name="selectedprint" id="scl_heduiren" type="checkbox" value="1" />核对人<br/>
          <input name="selectedprint" id="scl_heduitime" type="checkbox" value="1" />核对时间<br/>
        <input name="selectedprint" id="CretePerson" type="checkbox" value="1" />记录人<br/>
        <br />
        <input name="fields_" id="fields_" value="" type="hidden"/><br>
        <input name="titles_" id="titles_" value="" type="hidden" />
        </table>
</div>
<div class="datagrid-toolbar">
<table cellspacing="0" cellpadding="0"><tbody>
<tr><td><a href="javascript:void(0)" class="l-btn l-btn-plain" group="" id=""><span class="l-btn-left"><span class="l-btn-text icon-print l-btn-icon-left">打印</span></span></a></td>
<td><a href="javascript:void(0)" onclick="exports()" class="l-btn l-btn-plain" group="" id=""><span class="l-btn-left"><span class="l-btn-text icon-excel l-btn-icon-left">导出EXCEL</span></span></a></td>
</tr>
</tbody>
</table>
<form id="exportdiv" method="post" action="/financial/export">
  		<input type="hidden" name="json" id="json">
  		<input type="hidden" name="title" id="title">
  </form>
</div>
<script src="/resources/Scripts/newadd.js" type="text/javascript"></script>

        

</body>
</html>
