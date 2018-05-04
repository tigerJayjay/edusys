<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head id="MyHead">
    <script src="/resources/Scripts/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/Scripts/JScriptIndex.js" type="text/javascript"></script>
    <script src="/resources/Scripts/jquery.easyui.min-1.3.5.js" type="text/javascript"></script>
        <script src="/resources/Res/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
        <script src="/resources/Scripts/jquery.PrintArea.js" type="text/javascript"></script>
    <link href="/Content/Default.css" rel="stylesheet" type="text/css" />
    <link href="/Content/IndexStyle.css" rel="stylesheet" type="text/css" />

        <link href="/resources/Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
        <script src="/resources/Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
        <script src="/resources/exportexcel.js" type="text/javascript"></script>
    <link href="/resources/Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <title>
	
  流水账

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
    
    
   
    <script type="text/javascript" language="javascript">
        //var iframeid="";
        var S_Costs = [];
        var fukuanTypes=[];
        $.ajax({type:"POST",async:false,cache:false,url:"../../S_Cost/getSeldata/?costType=2014032816561048932587e8b8c264c",success:function(res){
                    if (res != "") {
                    //alert(res);
            S_Costs = res;
        }
        }});

                $.ajax({type:"POST",async:false,cache:false,url:"../../SysField/getSelData/?table=payment&colum=models&pid=201212041839076250000dafc77afa5",success:function(res){
                    if (res != "") {
            fukuanTypes = res;
        }
        }});


$(function () {
    //$("#fendianID").combobox({ panelHeight: 'auto', editable: false });
   
            var currTab = window.top.$('#tabs').tabs('getSelected'); //获得当前tab
            var iframeid = $(currTab.panel('options').content).attr('id');

                        //关闭AJAX相应的缓存
                $.ajaxSetup({
                    cache: false
                });

                $.getJSON("../Home/GetToolbar", { id: iframeid }, function (data) {

                      var Priter=[{   
            text:'打印',   
            iconCls:'icon-print',   
            handler:function(e){   //打印
                PrintArea();
            }   
        }
        ];

        var ExportExcel=[{   
            text:'导出EXCEL',   
            iconCls:'icon-excel',   
            handler:function(e){   //打印
            	method1("flexigridData");
            }   
        }
        ];
                    if (data == null) {
                        return;
                    }
                    $("#flexigridData").datagrid({toolbar:"#yesSearch"});
                    $('#flexigridData').datagrid("addToolbarItem", data);
                    //$('#flexigridData').datagrid("addToolbarItem", Priter);
                    $('#flexigridData').datagrid("addToolbarItem", ExportExcel);
                    
                });
                
                
            $('#flexigridData').datagrid({
                //title: '费用流水', //列表的标题
                iconCls: 'icon-site',
                width: 'auto',
                height: 'auto',
                nowrap: true,
                striped: true,
                collapsible: true,
               // url: 'S_COST_LIST/GetData', //GetDataStudent获取数据的url
                url: '/financial/GetDataStudent', //
                  onRowContextMenu: onRowContextMenu,
                queryParams: { searchCondition:"{'parentType':'1'}"},
                sortName: 'fcId',
                sortOrder: 'desc',
                idField: 'fcId',
                detailFormatter: function (index, row) {
                    return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
                },
                onExpandRow: function (index, row) { onExpandRow(index, row); },
                loadMsg:'数据载入中,请稍后...',
                toolbar: '.row',
                columns: [[
                    { field: 'ck', checkbox: true },
                    {field:"fcId",title:"流水编号"},
                    {field:"fcTime",title:"记录时间"},
                    {field:"ftTypeName",title:"流水分类"},
                    {field:"fcState",title:"结账状态",
                    	styler: function(value,row,index){
	        				if(value=="未结账"){
	        					return 'color:red';
	        				}
	        				if(value=="已结账"){
	        					return 'color:green';
	        				}
        			    }
                    },
                    {field:"fcModifyTime",title:"结账时间"},
                    {field:"fcModifyPerson",title:"结账人"},
                    {field:"fcTicketId",title:"票据编号"},
                    {field:"fcStuId",title:"学员编号"},
                    {field:"stuName",title:"学员姓名"},
                    {field:"stuSex",title:"学员性别"},
                    {field:"stuDriverType",title:"准驾车型"},
                    {field:"stuPhone",title:"手机号"},
                    {field:"stuAssignsSchool",title:"分校"},
                    {field:"stuAssigns",title:"分点"},
                	{field:"fcIncomePay",title:"应收/应付金额"},
                	{field:"fcDiscount",title:"实收/实付金额"},
                	{field:"fcDisState",title:"优惠金额"},
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
                	{field:"fcChargePerson",title:"收款人"},
                	{field:"fcCheckoutState",title:"核对状态",
                		styler: function(value,row,index){
        				if(value=="未核对"){
        					return 'color:red';
        				}
        				if(value=="已核对"){
        					return 'color:green';
        				}
    			    }},
                	{field:"fcCheckTime",title:"核对时间"},
                	{field:"fcCheckPerson",title:"核对人"}
       
                ]],
                rownumbers: true,
                pagination:true,
                pagePosition:"top",
                scrollbarSize:10
            });
            
            S_Costs.push({
                                'Id': '',
                                'Text': '请选择',
                                "selected": true
                            });
            $("#scostname").combobox({ data: S_Costs.reverse(), valueField: 'Id', textField: 'Text' });

                        fukuanTypes.push({
                                'id': '',
                                'text': '请选择',
                                "selected": true
                            });

                            //alert(fukuanTypes.length);

            $("#FK_DIC_CASHTYPE").combobox({ data: fukuanTypes.reverse(), valueField: 'text', textField: 'text' });
            
        });

                var search1 = "ischuliStart_Int&1^ischuliEnd_Int&1^";
            //“导出EXCEL”按钮     在6.0版本中修改
        function flexiExport() {

        $.messager.confirm('操作提示', "确认要导出EXCEL！", function (r) {
        
         if(r)
         {
             progress();
            //将查询条件按照分隔符拼接成字符串
            
//            $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
//                search = search + this.id + "&" + this.value + "^";
//            });
             var str = "yes"
             search1 = 'ischuliStart_Int&1^ischuliEnd_Int&1^';

             var wordvalue = document.getElementById(str + "wordvalue").value; //关键字

             var S_regdateStart_Time = document.getElementById(str + "S_regdateStart_Time").value; //关键字
             var S_regdateEnd_Time = document.getElementById(str + "S_regdateEnd_Time").value; //关键字

             var piaojubianhao = $("#piaojubianhao").val();
             if (piaojubianhao) {
                 search1 += "SCL_SerialNumber&" + piaojubianhao + "^";
             }

             var searchType = $("#" + str + "searchType").combobox("getValue"); //查询条件

             if (wordvalue != "") {
                 search1 += searchType + "&" + wordvalue + "^"
             }
             var fenxiao = $("#fenxiaoID").combobox("getValue"); //录入分校
             if (fenxiao != "") {
                 search1 += "fenxiaoID&" + fenxiao + "^"
             }
             var FK_DIC_from = $("#FK_DIC_from").combobox("getValue"); //报名分校
             if (FK_DIC_from != "") {
                 search1 += "S_Student_FK_DIC_from&" + FK_DIC_from + "^"
             }

             var scostname = $("#scostname").combobox("getValue"); //费用名称
             if (scostname != "") {
                 search1 += "FK_SP_ID&" + scostname + "^"
             }

             var SCL_type1 = $("#SCL_type1").combobox("getValue"); //费用名称
             if (SCL_type1 != "") {
                 search1 += "SCL_type&" + SCL_type1 + "^"
             }

             if (S_regdateStart_Time != "") {
                 search1 += "CreateTimeStart_Time&" + S_regdateStart_Time + "^"
             }
             if (S_regdateEnd_Time != "") {
                 search1 += "CreateTimeEnd_Time&" + S_regdateEnd_Time + "^"
             }

             var fenlei = $("#fenlei").combobox("getValue"); //流水分类
             if (fenlei != "") {
                 search1 += "scl_class&" + fenlei + "^"
             }

             var scl_state = $("#scl_state").combobox("getValue"); //状态
             if (scl_state != "") {
                 search1 += "scl_stateStart_Int&" + scl_state + "^scl_stateEnd_Int&" + scl_state + "^"
             }

             var zhifufangshi = $("#FK_DIC_CASHTYPE").combobox("getValue"); //状态
             //alert(zhifufangshi);
             if (zhifufangshi != "请选择") {
                 search1 += "FK_DIC_CASHTYPE&" + zhifufangshi + "^"
             }

             var jiezhangDateStart_Time = $("#jiezhangDateStart_Time").val(); //关键字
             var jiezhangDateEnd_Time = $("#jiezhangDateEnd_Time").val(); //关键字

             //alert(jiezhangDateStart_Time);

             if (jiezhangDateStart_Time != "") {
                 search1 += "scl_jiezTimeStart_Time&" + jiezhangDateStart_Time + "^"
             }
             if (jiezhangDateEnd_Time != "") {
                 search1 += "scl_jiezTimeEnd_Time&" + jiezhangDateEnd_Time + "^"
             }

             var scl_jiezhang = $("#scl_jiezhang").combobox("getValue");
             if (scl_jiezhang != "") {
                 search1 += "scl_jiezhangStart_Int&" + scl_jiezhang + "^scl_jiezhangEnd_Int&" + scl_jiezhang + "^"
             }

             var liushuihao = $("#liushuihao").val();
             if (liushuihao != "") {
                 search1 += "SCL_NO&" + liushuihao + "^"
             }
            var p = $('#flexigridData').datagrid('options').columns[0];
            var field = []; //所有的列名
            var title = []; //所有的标题名称
            $(p).each(function () {
                if(this.title!=null)
                {
                    field.push(this.field);
                    title.push(this.title);
                }

            });
            //alert(search1);
            var titlestr = removeHTMLTag(title.join(","))
            //alert(titlestr);
            //alert(field.join(","));
            $.post("../../S_COST_LIST/Export",
                {
                    title: titlestr,
                    field: field.join(","),
                    sortName: $('#flexigridData').datagrid('options').sortName,
                    sortOrder: $('#flexigridData').datagrid('options').sortOrder,
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

                 var fieldSearchVal="";
       
          function fieldReload(){
          fieldSearchVal="";
            $('#flexigridData').datagrid('reload', { search: "" });
          }
        //添加右击菜单内容
                function onRowContextMenu(e, rowIndex, rowData){
                   e.preventDefault(); //阻止浏览器自带的右键菜单弹出
                     $("#flexigridData").datagrid("clearSelections");
                   var selected=$("#flexigridData").datagrid('getRows'); //获取所有行集合对象
                    var idValue = selected[rowIndex].PK_ID; //index为当前右键行的索引，指向当前行对象
                    $(this).datagrid('selectRecord', idValue);
                    $('#mm').menu('show', {
                        left:e.pageX,
                        top:e.pageY
                    });        
                }

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
                window.location.href = "../S_COST_LIST/Details/" + arr[0].PK_ID;
               
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
        }
        //导航到创建的按钮
        function flexiCreate() {

            window.location.href = "../S_COST_LIST/Create";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "../S_COST_LIST/Edit/" + arr[0].PK_ID;

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
                    $.post("../S_COST_LIST/Delete", { query: arr.join(",") }, function (res) {
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

    </script>
       <script type="text/javascript">
          // $("a#PrintArea").click(function () {
         //});

           function PrintArea() {
               var SysMenuId = '201212031457004218750f6733c399e';
               var rows = $('#flexigridData').datagrid('getSelections');
               if (rows.length == 0) {
                   $.messager.confirm('操作提示', "尚未选择数据，是否打印当前页？", function (r) {
                       if (r) {
                           var grows = $('#flexigridData').datagrid('getRows');
                           for (var i = 1; i < grows.length; i++){
                               $('#flexigridData').datagrid('selectRow', i-1);
                           }

                           var arr = [];
                           for (var i = 0; i < rows.length; i++) {
                               arr.push(rows[i].PK_ID);
                           }
                           var url = "../../S_Ticket_List/clPrinter/0?pid=" + arr.join(",") + "&SysMenuId=" + SysMenuId + "&rd=" + Math.random();
                           window.parent.showIdWindow("打印管理", url, 800, 550, false, false, true);
                           $("#flexigridData").datagrid("clearSelections");
                          
                       } else {

                           return false;
                       }

                   })
                  // $.messager.alert('操作提示', '请选择数据!', 'warning');
                   return false;
               }

               var arr = [];
               for (var i = 0; i < rows.length; i++) {
                   arr.push(rows[i].PK_ID);
               }

               var url = "../../S_Ticket_List/clPrinter/0?pid=" + arr.join(",") + "&SysMenuId=" + SysMenuId + "&rd=" + Math.random();
               window.parent.showIdWindow("打印管理", url, 800, 550, false, false, true);
               $("#flexigridData").datagrid("clearSelections");

           }

          
           $(function () {
             //  $('#flexigridData').datagrid('reload', { search: 'FK_S_ID&nonull^' });
           });

           //判断是否结帐

           //作废操作
           function Invalid() {
               var rows = $('#flexigridData').datagrid('getSelections');
               if (rows.length == 0) {
                   $.messager.alert('操作提示', '请选择数据!', 'warning');
                   return false;
               }
               var arr = [];
               for (var i = 0; i < rows.length; i++) {
                   if(removeHTMLTag(rows[i].scl_state)!='作废')
                   {
                       if(removeHTMLTag(rows[i].scl_jiezhang)=='已结帐' )
                       {
                            $.messager.alert('操作提示', '流水' + rows[i].SCL_NO + '已经结帐，不能作废!', 'warning');
                            return false;
                       }
                       else{
                            if(rows[i].PK_ID!="")
                            {
                                arr.push(rows[i].PK_ID);
                            }
                            
                       }
                   }
                   else
                   {
                        $.messager.alert('操作提示', '流水' + rows[i].SCL_NO + '已经作废，请核对!', 'warning');
                            return false;
                   }

                   
               }
               $.messager.confirm('操作提示', "确认作废这 " + arr.length + " 项吗？", function (r) {
                   if (r) {
                       $.post("../S_COST_LIST/OperatingInvalid", { query: arr.join(",") }, function (res) {

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

           //作废操作
           function chaojizuofei() {
               var rows = $('#flexigridData').datagrid('getSelections');
               if (rows.length == 0) {
                   $.messager.alert('操作提示', '请选择数据!', 'warning');
                   return false;
               }
               if(arr=="本页总计"){
            	   $.messager.alert('系统提示：','操作失败！','info');
            	   return false;
               }
               var arr = [];
               for (var i = 0; i < rows.length; i++) {
                   if(removeHTMLTag(rows[i].scl_state)!='作废')
                   {
//                       if(removeHTMLTag(rows[i].scl_jiezhang)=='已结帐' )
//                       {
//                            $.messager.alert('操作提示', '流水' + rows[i].SCL_NO + '已经结帐，不能作废!', 'warning');
//                            return false;
//                       }
//                       else{
                            if(rows[i].PK_ID!="")
                            {
                                arr.push(rows[i].PK_ID);
                            }
                            
//                       }
                   }
                   else
                   {
                        $.messager.alert('操作提示', '流水' + rows[i].SCL_NO + '已经作废，请核对!', 'warning');
                            return false;
                   }

                   
               }
               $.messager.confirm('操作提示', "确认作废这 " + arr.length + " 项吗？", function (r) {
                   if (r) {
                       $.post("../S_COST_LIST/chaojizuofei", { query: arr.join(",") }, function (res) {

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
               if(arr=="本页总计"){
            	   $.messager.alert('系统提示：','操作失败！','info');
            	   return false;
               }
               var arr = [];
               for (var i = 0; i < rows.length; i++) {
                   if(rows[i].fcId!="")
                   {
                        arr.push(rows[i].fcId);
                   }
                   
               }
               //核对
               $.messager.confirm('操作提示', "确认核对这 " + arr.length + " 项吗？", function (r) {
                   if (r) {
                       $.post("/financial/updateCharge", { query: arr.join(",") }, function (res) {

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


           //结帐
           function openJiezhang() {
               
        	   var rows = $('#flexigridData').datagrid('getSelections');
               if (rows.length == 0) {
                   $.messager.alert('操作提示', '请选择数据!', 'warning');
                   return false;
               }
               if(rows.length > 1){
            	   $.messager.alert('操作提示', '只能选择一条数据!', 'warning');
                   return false;
               }
               var arr = rows[0].fcId;
               if(arr=="本页总计"){
            	   $.messager.alert('系统提示：','操作失败！','info');
            	   return false;
               }
               //progressJisuan();
			   var arrJson = {"searchCondition":"{'fcId':'"+arr+"'}"};
               $.post('/financial/checkData',arrJson,
               function(res){
                        $("#jzdan").html(res["title"]);//标题
                        $("#jzren").html(res["jzren"]);//结 帐 人

                        $("#stuYingshou").html(' ￥' + formatCurrency(res["stuYingshou"]));//应收合计
                        $("#stuShishou").html(' ￥' + formatCurrency(res["stuShishou"]));//实收合计
                        $("#stuYouhui").html(' ￥' + formatCurrency(res["stuYouhui"]));//优惠合计
                       // $("#stuTuifei").html(' ￥' + formatCurrency(res["stuTuifei"]));//退费合计
                        //$("#mingxi").html(res["mingxi"]); //结帐明细
                        
                       // $("#pkids").val(res["pkids"]);
                        $('#jiezhang').dialog("open");
                        $.messager.progress('close');
               },"json");
           }
            
           function querenjiez(){
        	    var rows = $('#flexigridData').datagrid('getSelections');
        	    var fcId = rows[0].fcId;
                var fsTitle=$("#jzdan").text();//标题
                var fsName=$("#jzren").text();//结 帐 人
                var fsMingxi=$("#mingxi").text();//结帐明细

                var fsYingshou=$("#stuYingshou").text()//学员应收合计
                var fsYouhui=$("#stuYouhui").text()//学员优惠合计
                var fsShishou=$("#stuShishou").text()//学员实收合计
                var fsTuifei=$("#stuTuifei").text()//学员退费合计

                //alert(pkids);
                $.messager.confirm('操作提示', "确认要结帐吗？", function (r) {
                    if(r){
                    
                    $('#jiezbutton').linkbutton('disable');    //禁用按钮
                    //progressComm();
                        $.post("/financial/affirm",{
                       	"fcId":fcId,
                       	"fsTitle":fsTitle,
                       	"fsName":fsName,
                       	//"fsMingxi":fsMingxi,
                       	"fsYingshou":fsYingshou,
                       	"fsYouhui":fsYouhui,
                       	"fsShishou":fsShishou
                       	//"fsTuifei":fsTuifei
                        },function(res){
                        
                        $('#jiezhang').dialog("close");
                            //$.messager.progress('close');
                            if(res=="OK")
                            {
                                $('#jiezbutton').linkbutton('enable');     //启用按钮
                                $.messager.alert('系统提示：','结帐操作成功！','info');
                               $("#flexigridData").datagrid("reload");
                            }
                            else{
                                $.messager.alert('系统提示：','结帐操作失败，请重试！','info');
                            }
                               
                               
                        });
                        }
                });
           }

        //内部学员查询
       function FindData(){
        	var searchCondition = "{";
			//查询条件
			if($("#wordvalue").val()!=''){
				searchCondition+="'"+$("#searchType").combobox("getValue")+"':";
				searchCondition+="'"+$("#wordvalue").val()+"',";
			}
			//分类
			if($("#fenlei").combobox("getValue")!=''){
				searchCondition+="'ftTypeName':'"+$("#fenlei").combobox("getValue")+"',";
			}
			//费用流水
			if($("#fcId").val()!=''){
				searchCondition+="'fcId':'"+$("#fcId").val()+"',";
			}
			//资金流向
			if($("#dest").combobox("getValue")!=''){
				searchCondition+="'dest':'"+$("#dest").combobox("getValue")+"',";
			}
			//报名分校
			if($("#stuAssignsSchool").combobox("getValue")!=''){
				searchCondition+="'stuAssignsSchool':'"+$("#stuAssignsSchool").combobox("getText")+"',";
			}
			//报名分点
			if($("#fendianID").combobox("getValue")!=''){
				searchCondition+="'stuAssigns':'"+$("#fendianID").combobox("getText")+"',";
			}
			//结账状态
			if($("#scl_jiezhang").combobox("getValue")!=''){
				searchCondition+="'fcState':'"+$("#scl_jiezhang").combobox("getText")+"',";
			}
			//结账日期
			if($("#beginFcCheckTime").val()!=''){
				searchCondition+="'beginFcCheckTime':'"+$("#beginFcCheckTime").val()+"',";
			}
			if($("#endFcCheckTime").val()!=''){
				searchCondition+="'endFcCheckTime':'"+$("#endFcCheckTime").val()+"',";
			}
			//记录日期
			if($("#beginFcTime").val()!=''){
				searchCondition+="'beginFcTime':'"+$("#beginFcTime").val()+"',";
			}
			if($("#endFcTime").val()!=''){
				searchCondition+="'endFcTime':'"+$("#endFcTime").val()+"',";
			}
			//父级分类
			 searchCondition +="'parentType':'1'"
			searchCondition+="}";
            $('#flexigridData').datagrid('reload',{"searchCondition":searchCondition});
        }

        function flexiArchives() {
            var rows = $('#flexigridData').datagrid('getSelections');
            if (rows.length != 1) {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
                return false;
            }
            parent.addTab("档案:" + rows[0].FK_S_ID, "../../S_Archives/IndexNew/" + rows[0].S_PKID + "?rd=" + Math.random(), "tu1001", true, rows[0].S_PKID);
        }

        function dayingJiez() {
            $("#jiezhangdan").printArea();
        }
        

    </script>

      <base target = "_self">
</head>
<body class="easyui-layout" style="padding:3px;">
   
<table id="flexigridData">
    </table>

  <div id="mm" class="easyui-menu" style="width: 120px;">
        <div onclick="fieldSearch('SCL_NO')" data-options="iconCls:'icon-search'">
            费用流水号</div>
        <div onclick="fieldSearch('S_name')" data-options="iconCls:'icon-search'">
            学员</div>
        <div onclick="fieldSearch('FK_DIC_CASHTYPE')" data-options="iconCls:'icon-search'">
            付费方式</div>
             <div onclick="fieldSearch('FK_SP_IDOld')" data-options="iconCls:'icon-search'">
           费用</div>
           <div onclick="fieldSearch('SCL_UID')" data-options="iconCls:'icon-search'">
           收款人</div>
           <div onclick="fieldSearch('SCL_SPID')" data-options="iconCls:'icon-search'">
           产品</div>
           <div onclick="fieldSearch('FK_SC_ID')" data-options="iconCls:'icon-search'">
           班别</div>
           <div onclick="fieldSearch('Add_date')" data-options="iconCls:'icon-search'">
           操作日期</div>
            <div class="menu-sep"></div>
        <div onClick="fieldReload()" data-options="iconCls:'icon-reload'">刷新</div>
    </div>
    <div id="divQuery" title="查询列表" class="easyui-dialog" closed="true" modal="false"
        iconcls="icon-search">
         
            <div class="input">
                <div class="editor-label-search" style="width: 70px;">
                    <label for="SCL_NO">费用流水号</label>
                </div>
                <div class="editor-field-search" style="width: 130px;">
                    <input type='text' id='SCL_NO'/>
                </div>
            </div> 
             <div class="input">
                 <div class="editor-label-search" style="width: 70px;">
               学员编号
            </div>
            <div class="editor-field-search" style="width: 130px;">
                <input type='text' id='S_NO' />
            </div>
            </div>
            <div class="input">
                <div class="editor-label-search" style="width:70px;">
                  学员姓名
                </div>
                <div class="editor-field-search" style="width: 210px;">
                    <input type='text' id='S_name'/>
                </div>
            </div>
              <div class="input">
            <div class="editor-label-search" style="width: 70px;">
               身份证号
            </div>
            <div class="editor-field-search" style="width: 130px;">
                <input type='text' id='S_cardno' />
            </div>
        </div>
            <div class="input">
                <div class="editor-label-search" style="width: 70px;">
                    <label for="FK_SP_ID">费用名称</label>
                </div>
                <div class="editor-field-search" style="width: 130px;">
                   <select  id="FK_SP_ID" name="FK_SP_ID"  style="width:115px;" ><option value="">请选择</option>
  
                           
                        <option value="2012121115132964062509994f2ccc4"  >退学</option>
                        
                        <option value="20140415084244584803729c575c26b"  >科一报考费</option>
                        
                        <option value="201404150843357167283a702a7d00c"  >科二报考费</option>
                        
                        <option value="201404150844291127824970b72a9a4"  >科三报考费</option>
                        
                        <option value="201404150846198301151f159579c6a"  >科一补考费(支)</option>
                        
                        <option value="2014041508471371019687fa9ed1faf"  >科二补考费(支)</option>
                        
                        <option value="201404150848172658320fb3328534b"  >科三补考费(支)</option>
                        
                        <option value="20140415085857940476552cd9a98f2"  >科一补考费(收)</option>
                        
                        <option value="2014041508593643067804f43b31be0"  >科二补考费(收)</option>
                        
                        <option value="20140415090018662093561aa05b0f1"  >科三补考费(收)</option>
                        
                        <option value="2014110700195942495602ba9fe1a5a"  >报考费</option>
                        
                        <option value="201412301703254965587869208be0d"  >换班差价</option>
                        
                        <option value="201712250858566278093e588d3fe29"  >C1报名费</option>
                        
                        <option value="201712250859061903093c52bdd86fd"  >C2报名费</option>
                        
                        <option value="2017122509023484655931d894dac55"  >C1报名费（VIP）</option>
                        
                        <option value="20180112102153674684344452603e5"  >报名费</option>
                        
                        <option value="201801221457462215593c73edb9f25"  >科二补时</option>
                        

</select>

                </div>
            </div>

                    <div class="input">
            <div class="editor-label-search" style="width: 70px;">
             <label for="SCL_type"> 收/支</label>
            </div>
            <div class="editor-field-search" style="width: 210px;">
                    <select id="SCL_type" name="SCL_type"><option value="">请选择</option>
<option value="收">收</option>
<option value="支">支</option>
</select>  
            </div>
        </div>
        <div  class="input">
         <div class="editor-label-search" style="width: 70px;">
                  报名来源
                </div>
        </div>
    
       
                  <div class="input">
             <div class="editor-label-search" style="width: 70px;">
                    <label for="SCL_Real">实收/实付</label>
                </div>
                <div class="editor-field-to" style="width: 430px;">
                    <input type="text" id="SCL_RealStart_Int" onkeyup = "isInt(this)" style="width:50px" />
                  到
                    <input type="text" id="SCL_RealEnd_Int" onkeyup = "isInt(this)"  style="width:50px" />
                </div>
             </div> 
             
                   
              <div class="input">
                  <div class="editor-label-search" style="width: 70px;">
                    <label for="Add_date">记录日期</label>
                </div>
                <div class="editor-field-to" style="width: 400px;">
                    <input type="text" id="Add_dateStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'Add_dateEnd_Time\');}'})"  />
                   到
                    <input type="text" id="Add_dateEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'Add_dateStart_Time\');}'})" />
                </div>
                 </div>    
                 
    </div>

            <!--结帐单-->
        <style type="text/css">
            .piaoh2{ text-align:center; height:auto; height:30px; padding:0px; margin:0px; font-size:16px;}
            .piaoline{height:auto;line-height:23px; }
            .line1{ border-bottom:#000 1px solid; margin-bottom:4px; padding-bottom:4px;}
            .center{ text-align:center;}
            .piaoline{ overflow:hidden;zoom:1;}
            .piaoline span{ font-size:14px; display:block; float:left; }
            .piaoline .left{ width:100px;}
            .piaoline .right{ width:160px; text-align:right;}
        </style>
        <div id="jiezhang" class="easyui-dialog" title="分点结帐单" 
        data-options="modal:true,closed:true,minimizable:false,collapsible:false,maximizable:false,iconCls:'icon-print',
        buttons: [{
                    id:'jiezbutton',
                    text:'确认结帐',
                   iconCls:'icon-ok',
                   handler:function(){
                       querenjiez();
                  }
                },{
                   text:'打印结帐单',
                   iconCls:'icon-print',
                    handler:function(){
                       dayingJiez();
                   }
               }]" style="width:350px;height:500px;padding:10px;">
        <div id="jiezhangdan">
        <style type="text/css" media="print">
            .piaoh2{ text-align:center; height:auto; height:30px; padding:0px; margin:0px; font-size:16px;}
            .piaoline{height:auto;line-height:23px; }
            .line1{ border-bottom:#000 1px solid; margin-bottom:4px; padding-bottom:4px;}
            .center{ text-align:center;}
            .piaoline{ overflow:hidden;zoom:1;}
            .piaoline span{ font-size:14px; display:block; float:left; }
            .piaoline .left{ width:100px;}
            .piaoline .right{ width:160px; text-align:right;}
        </style>
        
        <h2 class="piaoh2 line1"><span id="jzdan"></span></h2>
        <div class="piaoline"><span class="left">结 帐 人：</span><span id="jzren" class="right"></span></div>
        <div class="piaoline"><span>学员应收合计：</span><span id="stuYingshou" class="right"></span></div>
        <div class="piaoline line1"><span>学员优惠合计：</span><span id="stuYouhui" class="right"></span></div>
        <div class="piaoline"><span>学员实收合计：</span><span id="stuShishou" class="right"></span></div>
        <div class="piaoline"><span>学员退费合计：</span><span id="stuTuifei" class="right"></span></div>

        <div class="piaoline line1"><span class="left">结帐明细：</span><span id="mingxi" class="right"></span></div>
        </div>
        <input type="hidden" id="pkids" name="pkids" value="" />
        
        <!--结帐单-->
<!--操作和搜索-->

    <div id="yesSearch" onkeydown="if(event.keyCode==13){FindData()}" style="padding:5px;height:60px; font-size:12px;">
    <style type="text/css">
    .row{ height:30px; clear:both; text-align:left;}
</style>
        <div class="row">
         &nbsp;查询条件：<select class="easyui-combobox" panelHeight="auto" id="searchType" style="width:100px">
                <option value="stuName">学员姓名</option>
                <option value="fcStuId">学员编号</option>
                 <option value="fcChargePerson">收款人</option>
                <option value="stuPhone">手机号码</option>
           </select>&nbsp;
            &nbsp;关 键 字: <input value="" class="input-textbox" id="wordvalue" style="width:80px" />
            
            &nbsp;流水分类：
            <select class="easyui-combobox" id="fenlei" name="ftTypeName" panelHeight="auto" style="width:80px;"><option value="">请选择</option>
            <option value="1">报名费</option>
            <option value="3">科一补考费</option>
            <option value="4">科二补考费</option>
            <option value="5">科三补考费</option>
            </select>
            &nbsp;费用流水号：<input class="input-textbox" id="fcId" style="width:100px" />
            &nbsp;收支状态：<select class="easyui-combobox" panelHeight="auto" id="dest" style="width:50">
                <option value="">请选择</option>
                <option value="0">收</option>
                <option value="1">支</option>
           </select>
            &nbsp;<a href="javascript:void(0);" onclick="FindData();" class="easyui-linkbutton" iconCls="icon-search">查询</a>
            </div>
            <div class="row">

             &nbsp;报名分校：<select class="easyui-combobox" id="stuAssignsSchool" name="FK_DIC_from" style="width:80px;"><option value="">请选择</option>
<option value="分校一">分校一</option>
<option value="分校二">分校二</option>
<option value="分校三">分校三</option>
<option value="分校四">分校四</option>
</select> 
            &nbsp;报名分点：<select class="easyui-combobox" data-val="true" data-val-length="长度不可超过50" data-val-length-max="50" id="fendianID" name="fendianID" style="width:100px;">
            <option value="">请选择</option>
            <option value="分点一">分点一</option>
<option value="分点二">分点二</option>
<option value="分点三">分点三</option>
<option value="分点四">分点四</option>
            </select>
             &nbsp;结帐状态：<select class="easyui-combobox" panelHeight="auto" id="scl_jiezhang" style="width:50">
                <option value="">请选择</option> 存储
                <option value="0">未结账</option>
                <option value="1">已结账</option>
           </select>
             &nbsp;结帐日期：<input type="text" class="input-textbox" style=" width:70px;"  id="beginFcCheckTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  />
             <span>到</span>
             <input type="text" class="input-textbox" style=" width:70px;"  id="endFcCheckTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
             &nbsp;流水状态：<select class="easyui-combobox" panelHeight="auto" id="fcCheckPerson" style="width:50">
                <option value="">请选择</option>
                <option value="0">正常</option>
                <option value="1">作废</option>
           </select>
                       &nbsp;记录日期：<input type="text" class="input-textbox" style=" width:70px;" value='' id="beginFcTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  />
             <span>到</span>
             <input type="text" class="input-textbox" style=" width:70px;" value='' id="endFcTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
        </div>
    </div>
<!--操作和搜索-->
  <div class="datagrid-toolbar row" >
  <form id="exportdiv" method="post" action="/financial/export">
  		<input type="hidden" name="json" id="json">
  		<input type="hidden" name="title" id="title">
  </form>
  <table cellspacing="0" cellpadding="0">
  <tbody>
  <tr>
  <td><a href="javascript:void(0)" onclick="openCheck()" class="l-btn l-btn-plain" group="" id="check"><span class="l-btn-left"><span class="l-btn-text icon-ok l-btn-icon-left">核对</span></span></a></td>
  <td><a href="javascript:void(0)" onclick="openJiezhang()" class="l-btn l-btn-plain" group="" id=""><span class="l-btn-left"><span class="l-btn-text icon-ok l-btn-icon-left">结帐</span></span></a></td>
  <td><a href="javascript:void(0)" onclick="exports()" class="l-btn l-btn-plain" group="" id=""><span class="l-btn-left"><span class="l-btn-text icon-save l-btn-icon-left" >导出EXCEL</span></span></a></td></tr></tbody></table>
  </div>

</body>
</html>
