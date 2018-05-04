<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head id="MyHead">
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
	
    流水结帐表

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
    
    
  <script type="text/javascript" src="/resources/Scripts/datagrid-detailview.js"></script>
  <script src="/resources/Scripts/jquery.PrintArea.js" type="text/javascript"></script>                                      
    <script type="text/javascript" language="javascript">
        $(function () {



            $('#flexigridData').datagrid({
                //title: '流水结帐表', //列表的标题
                iconCls: 'icon-site',
                width: 'auto',
                height: 'auto',
                nowrap: true,
                striped: true,
                collapsible: true,
                singleSelect: true,
                url: 'S_Water/GetData', //获取数据的url
                sortName: 'pk_id',
                sortOrder: 'desc',
                idField: 'pk_id',
//                view: detailview,
//                detailFormatter: function (index, row) {
//                    return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
//                },
//                onExpandRow: function (index, row) { onExpandRow(index, row); },
                toolbar: '#jiezSearch',
                columns: [[

                    { field: 'sw_title', title: '<label for="sw_title">结帐标题</label>', width: 160 }
                    					, { field: 'sw_fenxiao', title: '<label for="sw_fenxiao">所在分校</label>', width: 80 }
                    , { field: 'sw_fendian', title: '<label for="sw_fendian">所在分点</label>', width: 80 }
                    , { field: 'sw_datetime', title: '<label for="sw_datetime">本次结帐时间</label>', width: 130
                    , formatter: function (value, rec) {
                        if (value) {
                            return dateConvert1(value);
                        }
                    }
                }
                    					, { field: 'sw_starttime', title: '<label for="sw_starttime">上次结帐时间</label>', width: 130
                    , formatter: function (value, rec) {
                        if (value) {
                            return dateConvert1(value);
                        }
                    }
                }
                    , { field: 'stuYingshou', title: '<label for="sw_stuYingshou">学员应收合计</label>', width: 100,  align: 'right' }
                    , { field: 'stuYouhui', title: '<label for="sw_stuYouhui">学员优惠合计</label>', width: 100,  align: 'right' }
                    , { field: 'stuShishou', title: '<label for="sw_stuShishou">学员实收合计</label>', width: 100, align: 'right' }
                    , { field: 'stuTuifei', title: '<label for="sw_stuTuifei">学员退费合计</label>', width: 100, align: 'right' }
                    , { field: 'qitaShouru', title: '<label for="sw_qitaShouru">其他收入合计</label>', width: 100, align: 'right' }
                    , { field: 'qitaZhichu', title: '<label for="sw_qitaZhichu">其他支出合计</label>', width: 100, align: 'right' }
                    , { field: 'shengyuJine', title: '<label for="sw_shengyu">剩余合计</label>', width: 100, align: 'right' }


					, { field: 'sw_content', title: '<label for="sw_content">结帐明细</label>', width: 160 }
					, { field: 'sw_jiezhangren', title: '<label for="sw_jiezhangren">结帐人</label>', width: 80 }

					, { field: 'CreateTime', title: '<label for="CreateTime">记录日期</label>', width: 130
                    , formatter: function (value, rec) {
                        if (value) {
                            return dateConvert1(value);
                        }
                    }
					}
					, { field: 'CreatePerson', title: '<label for="CreatePerson">记录人</label>', width: 80 }
                ]],
                pagePosition:"top",
                pagination: true,
                rownumbers: true,
                scrollbarSize: 10

            });

            $("#sw_fenxiao").combobox({ panelHeight: 'auto', editable: false });

            $("#sw_fenxiao").combobox({
                onSelect: function (record) {
                    //alert(record.value);
                    var url = 'SysPerson/getSelData/@table=StudentSource&colum=models&pid=' + record.value;
                    //alert(url);
                    $("#sw_fendian").combobox({ url: url, valueField: 'id', panelHeight: 'auto', textField: 'text' }).combobox('clear');
                    //$('#sw_fendian').combobox('select', "");
                }
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
        });

        //内部学员查询
        function FindData() {
            var search = "";
            var sw_fenxiao = $("#sw_fenxiao").combobox("getValue");
            var sw_fendian = $("#sw_fendian").combobox("getValue");
            if (sw_fendian != "") {
                search = "sw_fendian&" + sw_fendian + "^"
            }
            if (sw_fenxiao != "") {
                search += "sw_fenxiao&" + sw_fenxiao + "^"
            }

            $('#jiezSearch').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                search = search + this.id + "&" + this.value + "^";
            });

            //执行查询
            //alert(search);

            $('#flexigridData').datagrid('reload', { search: search });
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

        function onExpandRow(index, row) {
            //alert(index);
            $('#ddv-' + index).datagrid({
                url: 'S_COST_LIST/GetDataNoPage',
                queryParams: { search: 'scl_pici&' + row.pk_id + '^' },
                fitColumns: true,
                singleSelect: true,
                rownumbers: true,
                loadMsg: '',
                height: 'auto',
                columns: [[
							{ field: 'liushuihao', title: '费用流水号', width: 110, sortable: true }
                            , { field: 'FK_SC_ID', title: '费用名称', width: 110, sortable: true }
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
                            , { field: 'cashType', title: '结帐方式', width: 50, align: 'center', sortable: true }
                            , { field: 'iszuofei', title: '状态', width: 40, sortable: true, align: 'center', styler: cellStyler }
                            , { field: 'opertion', title: '记录人', sortable: true, width: 60 }
                            , { field: 'operttime', title: '记录时间', width: 120, sortable: true, formatter: function (value, rec) {
                                if (value) {
                                    return dateConvert1(value);
                                }
                            }
                            }
                            , { field: 'S_Remark', title: '备注', width: 100, sortable: true, editor: { type: 'text'} }

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


//        //“导出”按钮     在6.0版本中修改
//        function flexiExport() {

//            //将查询条件按照分隔符拼接成字符串
//            var search = "";
//            $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
//                search = search + this.id + "&" + this.value + "^";
//            });
//          
//            var p = $('#flexigridData').datagrid('options').columns[0];
//            var field = [];//所有的列名
//            var title = [];//所有的标题名称
//            $(p).each(function () {
//                field.push(this.field);
//                title.push(this.title);              
//            });
//           
//            $.post("S_Water/Export",
//                {
//                    title: title.join(","),
//                    field: field.join(","),
//                    sortName: $('#flexigridData').datagrid('options').sortName,
//                    sortOrder: $('#flexigridData').datagrid('options').sortOrder,
//                    search: search
//                }, function (res) {
//                    window.location.href = res;

//                });
//        };
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
                arr.push(rows[i].sw_datetime);
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
                window.location.href = "S_Water/Details/" + arr[0].pk_id;
               
            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
        }
        //导航到创建的按钮
        function flexiCreate() {

            window.location.href = "S_Water/Create";
            return false;
        }
        //导航到修改的按钮
        function flexiModify() {

            var arr = $('#flexigridData').datagrid('getSelections');

            if (arr.length == 1) {
                window.location.href = "S_Water/Edit/" + arr[0].pk_id;

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
                    $.post("S_Water/Delete", { query: arr.join(",") }, function (res) {
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

                  //结帐
           function openJiezhang() {
               var rows = $('#flexigridData').datagrid('getSelections');
               if (rows.length == 0) {
                   $.messager.alert('操作提示', '请选择数据!', 'warning');
                   return false;
               }

               $("#jzdan").html(rows[0].sw_title); //标题
               $("#jzren").html(rows[0].sw_jiezhangren); //结 帐 人
               $("#shangci").html(dateConvert1(rows[0].sw_starttime)); //上次结帐
               $("#benci").html(dateConvert1(rows[0].sw_datetime)); //本次结帐

               var mingxiArr = rows[0].sw_content.split('||');

               if (mingxiArr.length > 1) {
                   $("#mingxi").html(mingxiArr[0].split(';').join(';<br />')); //结帐明细
                   $("#shoukuanren").html(mingxiArr[1].split(';').join(';<br />')); //收款明细
               }
               else {
                   $("#mingxi").html(rows[0].sw_content.split(';').join(';<br />')); //结帐明细
               }
               

               $("#stuYingshou").html(rows[0].stuYingshou); //学员应收合计
               $("#stuYouhui").html(rows[0].stuYouhui); //学员优惠合计
               $("#stuShishou").html(rows[0].stuShishou); //学员实收合计
               $("#stuTuifei").html(rows[0].stuTuifei); //学员退费合计
               $("#qitaShouru").html(rows[0].qitaShouru); //其他收入合计
               $("#qitaZhichu").html(rows[0].qitaZhichu); //其他支出合计
               $("#shengyuJine").html(rows[0].shengyuJine); //剩余合计

               $('#jiezhang').dialog("open");
           }

           //EXCEL导出 
           function xuanzedayin(type_) {
               $('#xuanzedayin').dialog({
                   buttons: [{
                       text: '确定',
                       iconCls: 'icon-ok',
                       handler: function () {
                           var fields = "";
                           var titles = "";
                           // var field = ['SSID', 'S_arNO', 'FK_SSID', 'S_Carmodels', 'S_mob', 'S_tel', 'S_fadd', 'S_cardno', 'S_tuijianren', 'S_remark', 'FK_DIC_from']; //所有的列名
                           //var title = ['序号', '档案编号', '姓名', '车型', '手机号', '电话号', '身份证地址', '身份证号', '推荐人', '备注', '报名来源']; //所有的标题名称
                           if ($("#jiezhangbiaoti_").attr("checked")) {
                               fields += ",'sw_title'";
                               titles += ",'结账标题'";
                           }
                           if ($("#suozaifenxiao_").attr("checked")) {
                               fields += ",'sw_fenxiao'";
                               titles += ",'所在分校'";
                           }
                           if ($("#suozaifendian_").attr("checked")) {
                               fields += ",'sw_fendian'";
                               titles += ",'所在分点'";
                           }
                           if ($("#bencijizhangshijian_").attr("checked")) {
                               fields += ",'sw_datetime'";
                               titles += ",'本次结账时间'";
                           }
                           if ($("#shangcijiezhangshijian_").attr("checked")) {
                               fields += ",'sw_starttime'";
                               titles += ",'上次结账时间'";
                           }
                           if ($("#xueyuanyingshouheji_").attr("checked")) {
                               fields += ",'stuYingshou'";
                               titles += ",'学员应收合计'";
                           }
                           if ($("#xueyuanyouhuiheji_").attr("checked")) {
                               fields += ",'stuYouhui'";
                               titles += ",'学员优惠合计'";
                           }
                           if ($("#xueyuanshishouheji_").attr("checked")) {
                               fields += ",'stuShishou'";
                               titles += ",'学员实收合计'";
                           }
                           if ($("#xueyuantuifeiheji_").attr("checked")) {
                               fields += ",'stuTuifei'";
                               titles += ",'学员退费合计'";
                           }
                           if ($("#qitashouruheji_").attr("checked")) {
                               fields += ",'qitaShouru'";
                               titles += ",'其他收入合计'";
                           }
                           if ($("#qitazhichuheji_").attr("checked")) {
                               fields += ",'qitaZhichu'";
                               titles += ",'其他支出合计'";
                           }
                           if ($("#shengyuheji_").attr("checked")) {
                               fields += ",'shengyuJine'";
                               titles += ",'剩余合计'";
                           }
                           if ($("#jiezhangmingxi_").attr("checked")) {
                               fields += ",'sw_content'";
                               titles += ",'结账明细'";
                           }
                           if ($("#jiezhangren_").attr("checked")) {
                               fields += ",'sw_jiezhangren'";
                               titles += ",'结账人'";
                           }
                           if ($("#jiluriqi_").attr("checked")) {
                               fields += ",'CreateTime'";
                               titles += ",'记录日期'";
                           }
                           if ($("#jiluren_").attr("checked")) {
                               fields += ",'CreatePerson'";
                               titles += ",'记录人'";
                           }
                           $("#fields_").val(fields);
                           $("#titles_").val(titles);
                           // alert(type_)
                           if (type_ == "shouru") {

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

           //“导出EXCEL”按钮     在6.0版本中修改
           function flexiExport() {

               progress();
               var search = "";
               var sw_fenxiao = $("#sw_fenxiao").combobox("getValue");
               var sw_fendian = $("#sw_fendian").combobox("getValue");
               if (sw_fendian != "") {
                   search = "sw_fendian&" + sw_fendian + "^"
               }
               if (sw_fenxiao != "") {
                   search += "sw_fenxiao&" + sw_fenxiao + "^"
               }

               $('#jiezSearch').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                   search = search + this.id + "&" + this.value + "^";
               });
              // alert(search);

               var files = $("#fields_").val();
               var titles = $("#titles_").val();
               //alert(files.substr(1,files.length))
               var field = eval("[" + files.substr(1, files.length) + "]"); //所有的列名
               var title = eval("[" + titles.substr(1, titles.length) + "]"); //所有的标题名称

               var titlestr = title.join(",");
               // alert(titlestr);
               // alert(field.join(","));
               $.post("S_Water/ExportJZ",
                {
                    title: titlestr,
                    field: field.join(","),
                    sortName: $('#flexigridData').datagrid('options').sortName,
                    sortOrder: $('#flexigridData').datagrid('options').sortOrder,
                    search: search,
                    filename1: ''
                }, function (res) {
                    // alert(res);
                    $.messager.progress('close');
                    window.location.href = res;
                });
           }

           function dayingJiez() {
               $("#jiezhangdan").printArea();
           }

    </script>

      <base target = "_self">
</head>
<body class="easyui-layout" style="padding:3px;">
    <table id="flexigridData" fit="true">
    </table>
    
    <div id="divQuery">
         
            <div class='left02'>
                <div class="editor-label-search">
                    <label for="sw_datetime">本次结帐时间</label>：
                </div>
                <div class="editor-field-to">
                    <input type="text" id="sw_datetimeStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'sw_datetimeEnd_Time\');}'})"  />
                    <span>到</span>
                    <input type="text" id="sw_datetimeEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'sw_datetimeStart_Time\');}'})" />
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="sw_content">结帐明细</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='sw_content'/>
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="sw_jiezhangren">结帐人</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='sw_jiezhangren'/>
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="sw_fendian">所在分点</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='sw_fendian'/>
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="sw_fenxiao">所在分校</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='sw_fenxiao'/>
                </div>
            </div> 
            <div class='left02'>
                <div class="editor-label-search">
                    <label for="CreateTime">记录日期</label>：
                </div>
                <div class="editor-field-to">
                    <input type="text" id="CreateTimeStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'CreateTimeEnd_Time\');}'})"  />
                    <span>到</span>
                    <input type="text" id="CreateTimeEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'CreateTimeStart_Time\');}'})" />
                </div>
            </div> 
            <div class="input_search">
                <div class="editor-label-search">
                    <label for="CreatePerson">记录人</label>：
                </div>
                <div class="editor-field-search">
                    <input type='text' id='CreatePerson'/>
                </div>
            </div>
    </div>
    <div class="left03">
        <input class="a4" type="button" value="查 询" onclick="flexiQuery()" />
    </div>
                                
                            <div id="jiezSearch" style="padding:5px;">
                                <table border="0" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td>分校：</td>
                                        <td><select class="easyui-combobox" id="sw_fenxiao" name="sw_fenxiao" style="width:120px;"><option value="">请选择</option>
<option value="分校一">分校一</option>
<option value="分校二">分校二</option>
<option value="分校三">分校三</option>
<option value="分校四">分校四</option>
</select>  </td>
                                        <td>&nbsp;&nbsp;分点：</td>
                                        <td><select class="easyui-combobox" id="sw_fendian" name="sw_fendian" style="width:120px;">
                                        <option value="分点一">分点一</option>
<option value="分点二">分点二</option>
<option value="分点三">分点三</option>
<option value="分点四">分点四</option>
                                        <option value="">请选择</option>
</select></td>
                                        <td>&nbsp;&nbsp;结帐日期&nbsp;</td>
                                        <td>
                                            <input type="text" class="input-textbox" width="80" id="sw_datetimeStart_Time" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'sw_datetimeEnd_Time\');}'})"  />
                                            <span>到</span>
                                            <input type="text" class="input-textbox" width="80" id="sw_datetimeEnd_Time" onclick="WdatePicker({minDate:'#F{$dp.$D(\'sw_datetimeStart_Time\');}'})" />
                                        </td>
                <td>&nbsp;&nbsp;<a href="javascript:FindData(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;
                                <a href="#" onclick="openJiezhang();" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查看结帐</a>
                                <a href="#" onclick="xuanzedayin('shouru');" class="easyui-linkbutton" data-options="iconCls:'icon-excel'">导出EXCEL</a>
 
                                        </td>
                                    </tr>
                                </table>
                            </div>

            <!--结帐单-->
        <style type="text/css">
            .piaoh2{ text-align:center; height:auto; height:30px; padding:0px; margin:0px; font-size:16px;}
            .piaoline{height:auto; line-height:25px; line-height:25px; }
            .line1{ border-bottom:#000 1px solid; margin-bottom:4px; padding-bottom:4px;}
            .center{ text-align:center;}
            .piaoline{ overflow:hidden;zoom:1;}
            .piaoline span{ font-size:14px; display:block; float:left; }
            .piaoline .left{ width:100px;}
            .piaoline .right{ width:160px; text-align:right;}
        </style>
        <div id="jiezhang" class="easyui-dialog" title="分点结帐单" data-options="modal:true,closed:true,minimizable:false,collapsible:false,maximizable:false,iconCls:'icon-print'
        ,buttons: [{
                   text:'打印结帐单',
                   iconCls:'icon-print',
                    handler:function(){
                       dayingJiez();
                   }
               }]
        " style="width:300px;height:500px;padding:10px;">
        <div id="jiezhangdan">
        <style type="text/css" media="print">
            .piaoh2{ text-align:center; height:auto; height:30px; padding:0px; margin:0px; font-size:16px;}
            .piaoline{height:auto; line-height:25px; line-height:25px; }
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
        <!--结帐单-->
        <div id="xuanzedayin" title="选择导出列" class="easyui-dialog" style="width: 400px; height: 500px;
        padding-top: 8px;" closed="true" modal="false" iconcls="icon-search">
        <table>
        <tr>
        <td>
        <input onclick="selectAll()" type="checkbox"   name="controlAll" id="controlAll" />全部选择<br>
        <input name="selectedprint" id="jiezhangbiaoti_" type="checkbox" value="1" />结账标题<br>
        <input name="selectedprint" id="suozaifenxiao_" type="checkbox" value="1" />所在分校<br>
        <input name="selectedprint" id="suozaifendian_" type="checkbox" value="1" />所在分点<br>
        <input name="selectedprint" id="bencijizhangshijian_" type="checkbox" value="1" />本次结账时间<br>
        <input name="selectedprint" id="shangcijiezhangshijian_" type="checkbox" value="1" />上次结账时间<br>
        <input name="selectedprint" id="xueyuanyingshouheji_" type="checkbox" value="1" />学员应收合计<br>
        <input name="selectedprint" id="xueyuanyouhuiheji_" type="checkbox" value="1" />学员优惠合计<br>
        <input name="selectedprint" id="xueyuanshishouheji_" type="checkbox" value="1" />学员实收合计<br>
        <input name="selectedprint" id="xueyuantuifeiheji_" type="checkbox" value="1" />学员退费合计<br>
        <input name="selectedprint" id="qitashouruheji_" type="checkbox" value="1" />其他收入合计<br>
        <input name="selectedprint" id="qitazhichuheji_" type="checkbox" value="1" />其他支出合计<br>
        <input name="selectedprint" id="shengyuheji_" type="checkbox" value="1" />剩余合计<br>
        <input name="selectedprint" id="jiezhangmingxi_" type="checkbox" value="1" />结账明细<br>
        <input name="selectedprint" id="jiezhangren_" type="checkbox" value="1" />结账人<br>
        <input name="selectedprint" id="jiluriqi_" type="checkbox" value="1" />记录日期<br>
        <input name="selectedprint" id="jiluren_" type="checkbox" value="1" />记录人<br>

 
        

        <input name="fields_" id="fields_" value="" type="hidden"/><br>
        <input name="titles_" id="titles_" value="" type="hidden" />
        </td>
        </tr>
        </table>
    </div>
    <script src="/resources/Scripts/newadd.js" type="text/javascript"></script>




        

</body>
</html>
