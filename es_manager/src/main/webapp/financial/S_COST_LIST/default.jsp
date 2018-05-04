

<!DOCTYPE html>
<html>
<head id="MyHead">
    <script src="../Scripts/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="../Scripts/JScriptIndex.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.easyui.min-1.3.5.js" type="text/javascript"></script>
    <link href="../Content/Default.css" rel="stylesheet" type="text/css" />
    <link href="../Content/IndexStyle.css" rel="stylesheet" type="text/css" />

        <link href="../Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
        <script src="../Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="../Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <title>
	
  流水账

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
    
    
   
        <script src="../Res/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
        <script src="../Scripts/jquery.PrintArea.js" type="text/javascript"></script>
    <script type="text/javascript" language="javascript">
        //var iframeid="";
        var S_Costs = [];
        var fukuanTypes=[];
        $.ajax({type:"POST",async:false,cache:false,url:"../S_Cost/getSeldata/@costType=2014032816561048932587e8b8c264c",success:function(res){
                    if (res != "") {
                    //alert(res);
            S_Costs = res;
        }
        }});

                $.ajax({type:"POST",async:false,cache:false,url:"../SysField/getSelData/@table=payment&colum=models&pid=201212041839076250000dafc77afa5",success:function(res){
                    if (res != "") {
            fukuanTypes = res;
        }
        }});


$(function () {
    $("#fendianID").combobox({ panelHeight: 'auto', editable: false });
    $("#FK_DIC_from").combobox({
        editable: false,
        onSelect: function (record) {

            $.ajax({
                type: "POST",
                url: '../SysPerson/getSelData/@table=StudentSource&colum=models&pid=' + record.value,
                dataType: 'json',
                success: function (jsonstr) {
                    // 修改ajax返回的值
                    jsonstr.push({
                        'id': '',
                        'text': '全部',
                        "selected": true
                    });
                    $("#fendianID").combobox({ data: jsonstr, panelHeight: 'auto', editable: true, valueField: 'id', textField: 'text' });
                }
            });
        }
    });
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
                flexiExport();
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
                fit:true,
                nowrap: true,
                striped: true,
                collapsible: true,
               // url: 'S_COST_LIST/GetData', //GetDataStudent获取数据的url
                url: 'S_COST_LIST/GetDataStudent', //
                  onRowContextMenu: onRowContextMenu,
                queryParams: { search: 'CreateTimeStart_Time&' + $("#CreateTimeStart_Time").val() + '^CreateTimeEnd_Time&' + $("#CreateTimeEnd_Time").val() + '^ischuliStart_Int&1^ischuliEnd_Int&1^' },
                sortName: 'PK_ID',
                sortOrder: 'desc',
                idField: 'PK_ID',
                loadMsg:'数据载入中,请稍后...',
                toolbar: [
             ],
                columns: [[
                    {field:'ck',checkbox:true}
					,{ field: 'SCL_NO', title: '<label for="SCL_NO">费用流水号</label>', width: 120 ,sortable:true}
                    , { field: 'CreateTime', title: '<label for="CreateTime">记录时间</label>', width: 134,sortable:true
                    , formatter: function (value, rec) {
                        if (value) {
                            return dateConvert1(value);
                        }
                    }
                        }
                    ,{ field: 'scl_class', title: '<label for="scl_class">流水分类</label>', width: 60 ,sortable:true}
                    , { field: 'scl_state', title: '<label for="scl_state">状态</label>', width: 40 ,sortable:true}
                    ,{ field: 'SCL_SerialNumber', title: '<label for="SCL_SerialNumber">票据编号</label>', width: 80 ,sortable:true}
                    ,{ field: 'S_NO', title: '学员编号', width: 75 ,sortable:true}
					,{ field: 'FK_S_ID', title: '<label for="FK_S_IDOld">学员</label>', width: 75 ,sortable:true}
                    , { field: 's_cardno', title: '身份证号', width: 136, sortable: true }
                    , { field: 'S_TuiJianRen', title: '推荐人', width: 60, sortable: true }
                    , { field: 'S_Carmodels', title: '准驾车型', width: 60, sortable: true }
					,{ field: 'SCL_type', title:  '<label for="SCL_type"> 收/支</label>', width: 36,align:'center',sortable:true}
					,{ field: 'FK_SP_ID', title: '<label for="FK_SP_IDOld">费用</label>', width: 100 ,sortable:true}
					,{ field: 'SCL_Should', title:  '<label for="SCL_Should">应收/应付</label>', width: 100 ,formatter: function (value, rec){return  formatCurrency(value)},align:'right',sortable:true}
                    ,{ field: 'SCL_Real', title:  '<label for="SCL_Real">实收/实付</label>', width: 100 ,formatter: function (value, rec){return  formatCurrency(value)},align:'right',sortable:true}
                    //,{ field: 'weishou', title:  '<label for="weishou">未收金额</label>', width: 80 ,formatter: function (value, rec){return  formatCurrency(value)},align:'right',sortable:true}
                    ,{ field: 'youhui', title:  '<label for="youhui">优惠金额</label>', width: 80 ,formatter: function (value, rec){return  formatCurrency(value)},align:'right',sortable:true}
                    ,{ field: 'youhuiState', title:  '<label for="youhuiState">优惠状态</label>', width: 60 ,align:'center',sortable:true}
                    ,{ field: 'FK_DIC_CASHTYPE', title:  '<label for="FK_DIC_CASHTYPE">结帐方式</label>', width: 120 ,align:'left',sortable:true}

					, { field: 'S_PKID', title: '学员id', width: 75, sortable: true,hidden:true }
                    , { field: 'CretePerson', title: '<label for="SCL_UID">收款人</label>', width: 75, sortable: true }
                    , { field: 'SCL_JBR', title: '收款缴款人', width: 75 }
                    ,{ field: 'fenxiaoID', title:  '记录分校', width: 55 ,sortable:true}
                    ,{ field: 'baomingID', title:  '记录分点', width: 65 ,sortable:true}
                    ,{ field: 'bmfenxiao', title:  '报名分校', width: 55 ,sortable:true}
                    ,{ field: 'bmfendian', title:  '报名分点', width: 65 ,sortable:true}
                    ,{ field: 'SCL_REMARK', title:  '<label for="SCL_REMARK">备注</label>', width: 275 }
                    , { field: 'scl_jiezhang', title: '<label for="scl_jiezhang">结帐状态</label>', width: 70 ,sortable:true}
                    , { field: 'scl_jiezhangren', title: '<label for="scl_jiezhangren">结帐人</label>', width: 70 ,sortable:true}
                    , { field: 'scl_jiezTime', title: '<label for="scl_jiezTime">结帐时间</label>', width: 130 ,sortable:true, formatter: function (value, rec) {
                        if (value) {return dateConvert1(value);}
                    }}
                    , { field: 'scl_check', title: '<label for="scl_check">核对状态</label>', width: 70 ,sortable:true}
                    , { field: 'scl_heduiren', title: '<label for="scl_heduiren">核对人</label>', width: 70 ,sortable:true}
                    , { field: 'scl_heduitime', title: '<label for="scl_heduitime">核对时间</label>', width: 130 ,sortable:true, formatter: function (value, rec) {
                        if (value) {return dateConvert1(value);}
                    }}
                    , { field: 'scl_zuofeiren', title: '<label for="scl_zuofeiren">作废人</label>', width: 70 ,sortable:true}
                    , { field: 'scl_zuofeitime', title: '<label for="scl_zuofeitime">作废时间</label>', width: 130 ,sortable:true, formatter: function (value, rec) {
                        if (value) {return dateConvert1(value);}
                    }
                    }
                    , { field: 'CretePerson', title: '记录人', width: 70 ,sortable:true}
                    , { field: 'UpdatePerson', title: '修改人', width: 70 ,sortable:true}
                    , { field: 'UpdateTime', title: '修改时间', width: 134 ,sortable:true, formatter: function (value, rec) {
                        if (value) {return dateConvert1(value);}
                    }}
                        
					
                ]],
                pagePosition:'noth',
                pagination: true,
                rownumbers: true,
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
            $.post("Export",
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
           // 查询下列菜单
            function fieldSearch(fieldName){
               var rows = $('#flexigridData').datagrid('getSelections');
            if (rows.length == 0) {
                $.messager.alert('操作提示', '请选择数据!', 'warning');
                return false;
            }
            	 var FK_S_ID="";
						     $.ajax({
                        type: "post",
                        url: "GetFileVal",
                        data: { query: rows[0].PK_ID, Fname: "FK_S_ID" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                           FK_S_ID = res;
                        }
                    });

             var idValue="";
            switch(fieldName){
              case "S_NO":
                  $.ajax({ 
                          type : "post", 
                          url : "../S_Student/GetFileVal", 
                          data : {query:FK_S_ID,Fname:"S_NO"} , 
                          async : false, 
                          success : function(res){ 
                            //data = eval("(" + res + ")"); 
                            idValue = res; 
                          } 
                          }); 
              break;
              case "S_name":
              idValue=rows[0].FK_S_ID;
              
              break;
                  case "S_cardno":
                 
                 $.ajax({ 
                          type : "post", 
                          url : "../S_Student/GetFileVal", 
                          data : {query:FK_S_ID,Fname:"S_cardno"} , 
                          async : false, 
                          success : function(res){ 
                            //data = eval("(" + res + ")"); 
                            idValue = res; 
                          } 
                          }); 
              break;
            
              case "SCL_Real":
                       
              	     $.ajax({
                        type: "post",
                        url: "GetFileVal",
                        data: { query: rows[0].PK_ID, Fname: "SCL_Real" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                         idValue = res;
                        }
                    });

                     fieldName="SCL_RealStart_Int&"+idValue+"^SCL_RealEnd_Int&"+idValue+"^";

                     idValue="";
              break;
            default :
            idValue="";
            }

            var positionVal=fieldName+ "&" +$('<p>'+idValue+'</p>').text() + "^";
             if(fieldSearchVal.indexOf(positionVal)<0){
             
             }else{
//                 var position=fieldSearchVal.indexOf(fieldName)-fieldName.length;//定位
//                 var positionStr=fieldSearchVal.substring(position);
//                 var Pstr=positionStr.indexOf("^")+1;

//                var positionVal=positionStr.substring(0,Pstr);
//                fieldSearchVal=fieldSearchVal.replace(positionVal,"");
                    fieldSearchVal=fieldSearchVal.replace(positionVal,"");
             }
          
              fieldSearchVal= fieldSearchVal+fieldName+ "&" +$('<p>'+idValue+'</p>').text() + "^";
                    var search =fieldSearchVal;
                        //执行查询      
                       // alert(search);                  
                  $('#flexigridData').datagrid('reload', { search: search });
            }

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
        //“查询”按钮，弹出查询框
        function flexiQuery() {
            $('#divQuery').dialog({
                buttons: [{
                    text: '查询',
                    iconCls: 'icon-ok',
                    handler: function () {
                        //将查询条件按照分隔符拼接成字符串
                        //var search = "Costdisplay&4^";
                        var search = "";
                        $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                            search = search + this.id + "&" + this.value + "^";

                        });

                        alert(search);

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
                window.location.href = "Details/" + arr[0].PK_ID;
               
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
        }
        //导航到创建的按钮
        function flexiCreate() {

            window.location.href = "Create";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "Edit/" + arr[0].PK_ID;

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
                    $.post("Delete", { query: arr.join(",") }, function (res) {
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
                           var url = "../S_Ticket_List/clPrinter/0@pid=" + arr.join(",") + "&SysMenuId=" + SysMenuId + "&rd=" + Math.random();
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

               var url = "../S_Ticket_List/clPrinter/0@pid=" + arr.join(",") + "&SysMenuId=" + SysMenuId + "&rd=" + Math.random();
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
                       $.post("OperatingInvalid", { query: arr.join(",") }, function (res) {

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
                       $.post("chaojizuofei", { query: arr.join(",") }, function (res) {

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
                   if(rows[i].PK_ID!="")
                   {
                        arr.push(rows[i].PK_ID);
                   }
                   
               }
               //alert(arr.join(','));
               $.messager.confirm('操作提示', "确认核对这 " + arr.length + " 项吗？", function (r) {
                   if (r) {
                       $.post("OperatingCheck", { query: arr.join(",") }, function (res) {

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
               
               $('#jiezbutton').linkbutton('enable');     //启用按钮

               progressJisuan();

               $.ajax({type:'POST',async:true,cache:false,url:'Jiezhang',
               success:function(res){
               //alert(res["pkids"]);
                        $("#jzdan").html(res["title"]);//标题
                        $("#jzren").html(res["jzren"]);//结 帐 人
                        $("#shangci").html(res["shangci"]);//上次结帐
                        $("#benci").html(res["benci"]);//本次结帐

                        $("#stuYingshou").html(' ￥' + formatCurrency(res["stuYingshou"]));//应收合计
                        $("#stuShishou").html(' ￥' + formatCurrency(res["stuShishou"]));//实收合计
                        $("#stuYouhui").html(' ￥' + formatCurrency(res["stuYouhui"]));//优惠合计
                        $("#stuTuifei").html(' ￥' + formatCurrency(res["stuTuifei"]));//退费合计

                        $("#qitaShouru").html(' ￥' + formatCurrency(res["qitaShouru"]));//其他收入合计
                        $("#qitaZhichu").html(' ￥' + formatCurrency(res["qitaZhichu"]));//其他支出合计

                        //$("#shengyuJine").html(' ￥' + formatCurrency(res["shengyuJine"]) + '<br />' + convertCurrency(res["shengyuJine"]));//剩余金额
                        $("#shengyuJine").html(' ￥' + formatCurrency(res["shengyuJine"]));//剩余金额

                        $("#mingxi").html(res["mingxi"]); //结帐明细

                        $("#shoukuanren").html(res["shoukuanren"]); //收款人明细
                        
                        $("#pkids").val(res["pkids"]);
                        $('#jiezhang').dialog("open");
                        $.messager.progress('close');
               }
               });
           }

           function querenjiez(){

                var jzdan=$("#jzdan").text();//标题
                var jzren=$("#jzren").text();//结 帐 人
                var shangci=$("#shangci").text();//上次结帐
                var benci=$("#benci").text();//本次结帐
                var mingxi=$("#mingxi").text();//结帐明细
                //var yingshou=$("#yingshou").text();//应收合计
                //var shishou=$("#shishou").text();//实收合计
                var pkids=$("#pkids").val();//费用ID集合

                var stuYingshou=$("#stuYingshou").text()//学员应收合计
                var stuYouhui=$("#stuYouhui").text()//学员优惠合计
                var stuShishou=$("#stuShishou").text()//学员实收合计
                var stuTuifei=$("#stuTuifei").text()//学员退费合计
                var qitaShouru=$("#qitaShouru").text()//其他收入合计
                var qitaZhichu=$("#qitaZhichu").text()//其他支出合计
                var shengyuJine = $("#shengyuJine").text()//剩余合计
                var shoukuanren = $("#shoukuanren").text()//收款人明细

                //alert(pkids);
                $.messager.confirm('操作提示', "确认要结帐吗？", function (r) {
                    if(r){
                    
                    $('#jiezbutton').linkbutton('disable');    //禁用按钮
                    //progressComm();
                        $.post("../S_Water/querenjiez",{
                        jzdan:jzdan
                        ,jzren:jzren
                        ,shangci:shangci
                        ,benci:benci
                        , mingxi: mingxi + "||" + shoukuanren
                        ,pkids:pkids
                        ,stuYingshou:stuYingshou
                        ,stuYouhui:stuYouhui
                        ,stuShishou:stuShishou
                        ,stuTuifei:stuTuifei
                        ,qitaShouru:qitaShouru
                        ,qitaZhichu:qitaZhichu
                        , shengyuJine: shengyuJine

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
        function FindData() {

            var str="yes"
            search1 = 'ischuliStart_Int&1^ischuliEnd_Int&1^';

            var wordvalue = document.getElementById(str + "wordvalue").value; //关键字

            var S_regdateStart_Time = document.getElementById(str + "S_regdateStart_Time").value; //关键字
            var S_regdateEnd_Time = document.getElementById(str + "S_regdateEnd_Time").value; //关键字

            var piaojubianhao=$("#piaojubianhao").val();
            if(piaojubianhao)
            {
                search1+="SCL_SerialNumber&" + piaojubianhao + "^";
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

            var scostname=$("#scostname").combobox("getValue"); //费用名称
            if(scostname!="")
            {
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

            var fenlei=$("#fenlei").combobox("getValue"); //流水分类
            if(fenlei!="")
            {
                search1 += "scl_class&" + fenlei + "^"
            }

            var scl_state=$("#scl_state").combobox("getValue"); //状态
            if(scl_state!="")
            {
                search1 += "scl_stateStart_Int&" + scl_state + "^scl_stateEnd_Int&" + scl_state + "^"
            }

            var zhifufangshi=$("#FK_DIC_CASHTYPE").combobox("getValue"); //状态
            //alert(zhifufangshi);
            if(zhifufangshi!="请选择")
            {
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

            var scl_jiezhang=$("#scl_jiezhang").combobox("getValue");
            if(scl_jiezhang!="")
            {
               search1 += "scl_jiezhangStart_Int&" + scl_jiezhang + "^scl_jiezhangEnd_Int&" + scl_jiezhang + "^" 
            }

            var liushuihao=$("#liushuihao").val();
            if(liushuihao!="")
            {
                search1 += "SCL_NO&" + liushuihao + "^"
            }
            //alert(search1);

//            if(search!="")
//            {
//                search +="FK_DIC_Start&noway^allstu";
//            }
//            else
//            {
//                search +="FK_DIC_Start&noway^";
//            }
            //执行查询
            //alert(search);
            $('#flexigridData').datagrid('reload', { search: search1 });
        }

        function flexiArchives() {
            var rows = $('#flexigridData').datagrid('getSelections');
            if (rows.length != 1) {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
                return false;
            }
            parent.addTab("档案:" + rows[0].FK_S_ID, "../S_Archives/IndexNew/" + rows[0].S_PKID + "?rd=" + Math.random(), "tu1001", true, rows[0].S_PKID);
        }

        function dayingJiez() {
            $("#jiezhangdan").printArea();
        }
        

    </script>

      <base target = "_self">
</head>
<body>
    

<div class="easyui-panel" fit="true" style="height:120%;padding:5px;" border="false">
<table id="flexigridData">
    </table>
</div>
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
        <div class="piaoline"><span class="left">上次结帐：</span><span id="shangci" class="right"></span></div>
        <div class="piaoline line1"><span class="left">本次结帐：</span><span id="benci" class="right"></span></div>
        <div class="piaoline"><span>学员应收合计：</span><span id="stuYingshou" class="right"></span></div>
        <div class="piaoline line1"><span>学员优惠合计：</span><span id="stuYouhui" class="right"></span></div>
        <div class="piaoline"><span>学员实收合计：</span><span id="stuShishou" class="right"></span></div>
        <div class="piaoline"><span>学员退费合计：</span><span id="stuTuifei" class="right"></span></div>
        <div class="piaoline "><span>其他收入合计：</span><span id="qitaShouru" class="right"></span></div>
        <div class="piaoline line1"><span>其他支出合计：</span><span id="qitaZhichu" class="right"></span></div>
        <div class="piaoline line1"><span class="left">剩余合计：</span><span id="shengyuJine" class="right"></span></div>

        <div class="piaoline line1"><span class="left">结帐明细：</span><span id="mingxi" class="right"></span></div>
        <div class="piaoline"><span class="left">收款人明细：</span><span id="shoukuanren" class="right"></span></div>
        </div>
        <input type="hidden" id="pkids" name="pkids" value="" />
        
        <!--结帐单-->
<!--操作和搜索-->

    <div id="yesSearch" onkeydown="if(event.keyCode==13){FindData()}" style="padding:5px;height:60px; font-size:12px;">
    <style type="text/css">
    .row{ height:30px; clear:both; text-align:left;}
</style>
        <div class="row">
         &nbsp;查询条件：<select class="easyui-combobox" panelHeight="auto" id="yessearchType" style="width:100px">
                <option value="S_cardno">身份证号</option>
                <option value="S_name">学员姓名</option>
                <option value="S_NO">学员编号</option>
                <option value="S_ArNO">档案编号</option>
                 <option value="opertPerson">收款人</option>
                <option value="S_mob">手机号码</option>
           </select>&nbsp;
            &nbsp;关 键 字: <input class="input-textbox" id="yeswordvalue" style="width:80px" />
            
            &nbsp;流水分类：
            <select class="easyui-combobox" id="fenlei" name="fenlei" panelHeight="auto" style="width:80px;"><option value="">请选择</option>
            <option value="201405101025075354165059be1e0f2">学员收入</option>
            <option value="2014051010261921251627a793effc6">学员补时</option>
            <option value="201405101026450669950a3d68cee35">学员退费</option>
            <option value="2014051010270923237714fd8e08a82">其他收入</option>
              <option value="20140510102734689833218843568c4">其他支出</option>
            </select>
            &nbsp;费用名称：<select class="easyui-combobox" id="scostname" name="scostname" style="width:100px;"></select>
           
            &nbsp;结帐方式：<select class="easyui-combobox" id="FK_DIC_CASHTYPE" panelHeight="auto" name="FK_DIC_CASHTYPE" style="width:100px;"></select>
            &nbsp;费用流水号：<input class="input-textbox" id="liushuihao" style="width:100px" />
            &nbsp;收支状态：<select class="easyui-combobox" panelHeight="auto" id="SCL_type1" style="width:50">
                <option value="">请选择</option>
                <option value="收">收</option>
                <option value="支">支</option>
           </select>
            &nbsp;<a href="javascript:void(0);" onclick="FindData();" class="easyui-linkbutton" iconCls="icon-search">查询</a>
            </div>
            <div class="row">

             
             &nbsp;记录分校：<select class="easyui-combobox" id="fenxiaoID" name="fenxiaoID" style="width:80px;"><option value="">请选择</option>
<option value="2014033114432090614426dd681c9f6">总校</option>
<option value="2018011210134664343439256106478">挂靠</option>
</select> 
             &nbsp;报名分校：<select class="easyui-combobox" id="FK_DIC_from" name="FK_DIC_from" style="width:80px;"><option value="">请选择</option>
<option value="2014033114432090614426dd681c9f6">总校</option>
<option value="2018011210134664343439256106478">挂靠</option>
</select> 
            &nbsp;报名分点：<select class="easyui-combobox" data-val="true" data-val-length="长度不可超过50" data-val-length-max="50" id="fendianID" name="fendianID" style="width:100px;"></select>
             &nbsp;结帐状态：<select class="easyui-combobox" panelHeight="auto" id="scl_jiezhang" style="width:50">
                <option value="">请选择</option>
                <option value="0">未结帐</option>
                <option value="1">已结帐</option>
           </select>
             &nbsp;结帐日期：<input type="text" class="input-textbox" style=" width:70px;"  id="jiezhangDateStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'jiezhangDateEnd_Time\');}'})"  />
             <span>到</span>
             <input type="text" class="input-textbox" style=" width:70px;"  id="jiezhangDateEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'jiezhangDateStart_Time\');}'})" />
             &nbsp;流水状态：<select class="easyui-combobox" panelHeight="auto" id="scl_state" style="width:50">
                <option value="">请选择</option>
                <option value="0">正常</option>
                <option value="1">作废</option>
           </select>
                       &nbsp;记录日期：<input type="text" class="input-textbox" style=" width:70px;" value='2017-12-26' id="yesS_regdateStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'yesS_regdateEnd_Time\');}'})"  />
             <span>到</span>
             <input type="text" class="input-textbox" style=" width:70px;" value='2018-01-18' id="yesS_regdateEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'yesS_regdateStart_Time\');}'})" />
        </div>
    </div>
<!--操作和搜索-->


</body>
</html>
