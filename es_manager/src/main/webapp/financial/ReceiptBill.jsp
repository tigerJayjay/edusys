<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="/resources/Scripts/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/Scripts/jquery.easyui.min-1.3.5.js" type="text/javascript"></script>
        <script src="/resources/Scripts/jquery.datagrid.js" type="text/javascript"></script>
        
<script src="/resources/Res/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
                                         
    <script src="/resources/Scripts/JScriptIndex.js" type="text/javascript"></script>
    <link href="/resources/Content/Default.css" rel="stylesheet" type="text/css" />
    <link href="/resources/Content/IndexStyle.css" rel="stylesheet" type="text/css" />

        <link href="/resources/Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
        <script src="/resources/Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="/resources/Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <title>
	
    收据票据表

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
                title: '收据票据表', //列表的标题
                iconCls: 'icon-site',
                width: 'auto',
                height: 'auto',
                nowrap: true,
                striped: true,
                collapsible: true,
                url: '/financial/getTicket', //获取数据的url
                sortName: 'pk_id',
                sortOrder: 'desc',
                idField: 'pk_id',
                detailFormatter: function (index, row) {
                    return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
                },
                onExpandRow: function (index, row) { onExpandRow(index, row); },
                toolbar: "#yesSearch",
                columns: [[
					{ field: 'ftId', title: '<label for="rb_bianhao">票据编号</label>', width: 100 }
                    , { field: 'ftClass', title: '<label for="rb_class">票据分类</label>', width: 80 }
                     , { field: 'ftFenxiao', title: '<label for="rb_fenxiao">开票分校</label>', width: 80 }
                     , { field: 'frFendian', title: '<label for="rb_fendian">开票分点</label>', width: 80 }
					, { field: 'ftDate', title: '<label for="rb_riqi">开票日期</label>', width: 100}
                 , { field: 'ftTitle', title: '<label for="rb_title">收据标题</label>', width: 160 }
                , { field: 'ftRise', title: '<label for="rb_taitou">票据抬头</label>', width: 160 }
					, { field: 'ftDetail', title: '<label for="rb_mingxi">备注</label>', width: 300 }
					, { field: 'ftAmount', title: '<label for="rb_jine">票据金额</label>', width: 100 }
					, { field: 'ftBiller', title: '<label for="rb_opert">开票人</label>', width: 100 }
					, { field: 'ftPayee', title: '<label for="rb_shoukuan">收款人</label>', width: 100 }
					
                ]],
                pagination: true,
                pagePosition:"top",
                rownumbers: true
            });

             var parent = window.dialogArguments; //获取父页面
            if (parent == "undefined" || parent == null) {
                //    不是在iframe中打开的
            } else {
                //隐藏所有的按钮和分隔符
                $(".l-btn.l-btn-plain").hide();
                $(".datagrid-btn-separator").hide();
                //添加选择按钮
                $('#flexigridData').datagrid("addToolbarItem", [{ "text": "选择", "iconCls": "icon-ok", handler: function () { flexiSelect(); } }]);
            }

            $("#fenlei").combobox({ panelHeight: 'auto' });
            $("#fendian").combobox({ panelHeight: 'auto' });
            $("#fenxiao").combobox({
                editable: false,
                onSelect: function (record) {

                    $.ajax({
                        type: "POST",
                        url: 'SysPerson/getSelData/@table=StudentSource&colum=models&pid=' + record.value,
                        dataType: 'json',
                        success: function (jsonstr) {
                            // 修改ajax返回的值
                            jsonstr.push({
                                'id': '0',
                                'text': '全部',
                                "selected": true
                            });
                            $("#fendian").combobox({ data: jsonstr, panelHeight: 'auto', editable: false, valueField: 'id', textField: 'text' });
                        }
                    });
                }
            });
        });


        function onExpandRow(index, row) {
            //alert(index);
            $('#ddv-' + index).datagrid({
                url: 'S_COST_LIST/GetDataNoPage',
                queryParams: { search: 'SCL_SerialNumber&' + row.rb_bianhao + '^ischuliStart_Int&1^ischuliEnd_Int&1^' },
                fitColumns: false,
                singleSelect: false,
                rownumbers: true,
                loadMsg: '数据正在读取中...',
                height: 'auto',
                columns: [[
							{ field: 'liushuihao', title: '费用流水号', width: 120, sortable: true }
                            , { field: 'SCL_SerialNumber', title: '票据编号', width: 80, sortable: true }
                            , { field: 'FK_SC_ID', title: '费用名称', width: 80, sortable: true }
                            , { field: 'SCL_type', title: '收/支', width: 46, align: 'center', sortable: true }
                            , { field: 'SS_price', title: '应收/应付', width: 70, sortable: true, align: 'right', formatter: function (value) { return formatCurrency(value) } }
                            , { field: 'SCL_Real', title: '实收/实付', width: 70, sortable: true, align: 'right', formatter: function (value) { return formatCurrency(value) } }
                             , { field: 'weishou', title: '未收/未支', width: 70, sortable: true, align: 'right', formatter: function (value, rec) {
                                 return formatCurrency(value);
                             }
                             }
                            , { field: 'youhui', title: '优惠金额', width: 70, sortable: true, align: 'right', formatter: function (value, rec) {
                                return formatCurrency(value);
                            }
                            }
                            , { field: 'youhuiState', title: '优惠状态', width: 60, sortable: true }
                            , { field: 'cashType', title: '结帐方式', width: 70, align: 'center', sortable: true }
                                                , { field: 'scl_check', title: '核对状态', width: 70, sortable: true, styler: cellStyler }
                    , { field: 'scl_state', title: '状态', width: 70, sortable: true }
                    , { field: 'fenxiaoID', title: '分校', width: 75, sortable: true }
                    , { field: 'baomingID', title: '分点', width: 75, sortable: true }
                    , { field: 'scl_jiezhang', title: '结帐状态', width: 70, sortable: true }
                    , { field: 'scl_jiezTime', title: '结帐时间', width: 130, sortable: true, formatter: function (value, rec) {
                        if (value) { return dateConvert1(value); }
                    } 
                    }


                            , { field: 'opertion', title: '记录人', sortable: true, width: 60 }
                            , { field: 'operttime', title: '记录时间', width: 80, sortable: true, formatter: function (value, rec) {
                                if (value) {
                                    return dateConvert(value);
                                }
                            }
                            }
                            , { field: 'SCL_REMARK', title: '备注', width: 175 }

						]],
                onResize: function () {
                    $('#flexigridData').datagrid('fixDetailRowHeight', index);
                },
                onLoadSuccess: function () {
                    setTimeout(function () {
                        $('#flexigridData').datagrid('fixDetailRowHeight', index);
                    }, 0);
                }
            });
            $('#flexigridData').datagrid('fixDetailRowHeight', index);
        }


        //“查询”按钮，弹出查询框
        function flexiQuery() {

            //将查询条件按照分隔符拼接成字符串
            var search = "";
            $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                search = search + this.id + "&" + this.value + "^";
            });
            //执行查询                        
            $('#flexigridData').datagrid('reload', { search: search });

        };
        //“导出”按钮     在6.0版本中修改
        function flexiExport() {

            //将查询条件按照分隔符拼接成字符串
            var search = "";
            $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                search = search + this.id + "&" + this.value + "^";
            });
          
            var p = $('#flexigridData').datagrid('options').columns[0];
            var field = [];//所有的列名
            var title = [];//所有的标题名称
            $(p).each(function () {
                field.push(this.field);
                title.push(this.title);              
            });
           
            $.post("ReceiptBill/Export",
                {
                    title: title.join(","),
                    field: field.join(","),
                    sortName: $('#flexigridData').datagrid('options').sortName,
                    sortOrder: $('#flexigridData').datagrid('options').sortOrder,
                    search: search
                }, function (res) {
                    window.location.href = res;

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
                arr.push(rows[i].pk_id);
            }
            arr.push("^");
            for (var i = 0; i < rows.length; i++) {
                arr.push(rows[i].rb_bianhao);
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
                window.location.href = "ReceiptBill/Details/" + arr[0].pk_id;
               
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
        }
        //导航到创建的按钮
        function flexiCreate() {

            window.location.href = "ReceiptBill/Create";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "ReceiptBill/Edit/" + arr[0].pk_id;

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
                arr.push(rows[i].pk_id);
            }

            $.messager.confirm('操作提示', "确认删除这 " + arr.length + " 项吗？", function (r) {
                if (r) {
                    $.post("ReceiptBill/Delete", { query: arr.join(",") }, function (res) {
                        if (res == "OK") {
                           //移除删除的数据

                            $.messager.alert('操作提示', '删除成功!', 'info');
                            $("#flexigridData").datagrid("reload");
                            $("#flexigridData").datagrid("clearSelections");
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

       //内部学员查询
       function FindData() {
           var search = '';

           var bianhao = $("#bianhao").val(); //关键字

           var rb_riqiStart_Time = $("#rb_riqiStart_Time").val(); //关键字
           var rb_riqiEnd_Time = $("#rb_riqiEnd_Time").val(); //关键字

           var fenlei = $("#fenlei").combobox("getValue"); //分类
           var fenxiao = $("#fenxiao").combobox("getValue"); //分校
           var fendian = $("#fendian").combobox("getValue"); //分点

           if (bianhao != "") {
               search += "ftId:" + bianhao + ","
           }

           if (fenlei != "") {
               search += "ftClass:" + fenlei + ","
           }

           if (fenxiao != "") {
               search += "ftFenxiao:" + fenxiao + ","
           }

           if (fendian != "") {
               search += "frFendian:" + fendian + ","
           }

           if (rb_riqiStart_Time != "") {
               search += "beginTime:" + rb_riqiStart_Time + ","
           }
           if (rb_riqiEnd_Time != "") {
               search += "endTime:" + rb_riqiEnd_Time + ","
           }
           //执行查询
           //alert(search);

           $('#flexigridData').datagrid('reload', { queryCondition: search });
       }
    </script>
</head>
<body class="easyui-layout" style="padding:3px;">
    <table id="flexigridData" fit="true">
    </table>
    
    <div id="divQuery">
         
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="rb_bianhao">票据编号</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='rb_bianhao'/>
                </div>
            </div> 
            <div class='left02'>
                <div class="editor-label-search">
                    <label for="rb_riqi">开票日期</label>：
                </div>
                <div class="editor-field-to">
                    <input type="text" id="rb_riqiStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'rb_riqiEnd_Time\');}'})"  />
                    <span>到</span>
                    <input type="text" id="rb_riqiEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'rb_riqiStart_Time\');}'})" />
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="rb_mingxi">票据明细</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='rb_mingxi'/>
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="rb_opert">开票人</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='rb_opert'/>
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="rb_shoukuan">收款人</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='rb_shoukuan'/>
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="rb_jiaokuan">缴款人</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='rb_jiaokuan'/>
                </div>
            </div>
    </div>
    <div class="left03">
        <input class="a4" type="button" value="查 询" onclick="flexiQuery()" />
    </div>

       <div id="yesSearch" style="padding:5px;height:auto">
        <div>
            &nbsp;&nbsp;票据分类：
            <select class="easyui-combobox" id="fenlei" name="fenlei" style="width:80px;"><option value="">请选择</option>
<option value="stuShouru">学员收入</option>

<option value="stuBushi">学员补时</option>
<option value="stuTuifei">学员退费</option>
<option value="qitaShouru">其他收入</option>

</select>  
            &nbsp;&nbsp;票据编号: <input class="input-textbox" id="bianhao" style="width:80px" />&nbsp;&nbsp;
            &nbsp;&nbsp;分校：<select class="easyui-combobox" id="fenxiao" name="fenxiao" style="width:80px;"><option value="">请选择</option>
<option value="2014033114432090614426dd681c9f6">总校</option>
<option value="2018011210134664343439256106478">挂靠</option>
</select> 
            &nbsp;&nbsp;分点: <select class="easyui-combobox" id="fendian" name="fendian" style="width:60px;"><option value="">全部</option>
</select>
            &nbsp;&nbsp;开票日期：&nbsp;<input type="text" class="input-textbox" width="60" id="rb_riqiStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'rb_riqiStart_Time\');}'})"  />
            &nbsp;<span>到</span>&nbsp;
             <input type="text" class="input-textbox" width="60" id="rb_riqiEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'rb_riqiEnd_Time\');}'})" />
           &nbsp;&nbsp;<a href="javascript:void(0);" onclick="FindData();" class="easyui-linkbutton" iconCls="icon-search">查询</a>
           
        </div>
    </div>
</body>
</html>
