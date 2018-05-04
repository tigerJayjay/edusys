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
	
  退费退学

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
    
    
 
<script type='text/javascript'>
    var S_Costs = [];
    var fukuanTypes = [];
    var states=[{id:'0',text:'正常'},{id:'1',text:'作废'}];


    var iframeid="";
    $(function () {
        
    iframeid=top.iframeid


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

        

        shoufeiList("yesflexigridData");
        setTimeout(function () { allCostList(); }, 1000);
        setTimeout(function () { zhichuList(); }, 1000);
        setTimeout(function () { liushuiList(); }, 1000); 
        getStuInfo();

});

function getStuInfo(){
    $.ajax({type:'POST',cache: false,async: true,url:'../../S_Student/getStuInfo',data:"sid=201801170936228934343796e9d44e9",
    success: function (result) 
    {
        if(result!="NO")
        {
            
            $("#sbh").text(result["S_NO"]);
            $("#sname").text(result["S_name"]);
            $("#scard").text(result["scard"]);
            $("#stel").text(result["stel"]);
            $("#chexing").text(result["chexing"]);
            $("#banbie").text(result["banbie"]);
            $("#fenxiao").text(result["fenxiao"]);
            $("#tuijianren").text(result["tuijianren"]);

            $("#xuefei").text(formatCurrency(result["xuefei"]));//班级学费
            $("#qita").text(formatCurrency(result["qitafei"]));//其它费用
            $("#youhui").text(formatCurrency(result["youhui"]));//优惠金额
            $("#ysfeiyong").text(formatCurrency(result["ysfeiyong"]));//应收费用
            $("#ssfeiyong").text(formatCurrency(result["ssfeiyong"]));//实收费用
            $("#qfjine").text(formatCurrency(result["qianfei"]));//欠费金额
            $("#zcjine").text(formatCurrency(result["zcjine"]));//支出金额
            $("#syjine").text(formatCurrency(result["syjine"]));//欠费金额
            $("#tuifei").text(formatCurrency(result["tuifei"]));//退费金额
        }


    }});
    
    
}







    
    		function CostsFormatter(value){
			for(var i=0; i<S_Costs.length; i++){
				if (S_Costs[i].Id == value) 
                {
                        return S_Costs[i].jine;
                }
			}
			return value;
		}

        function CostsText(value){
			for(var i=0; i<S_Costs.length; i++){
				if (S_Costs[i].Id == value) 
                {
                        return S_Costs[i].Text;
                }
			}
			return value;
		}
        //打印时显示的费用名称
                function CostPrintName(value){
			for(var i=0; i<S_Costs.length; i++){
				if (S_Costs[i].Id == value) 
                {
                        return S_Costs[i].printName;
                }
			}
			return value;
		}

        function shouzhi(value){
			for(var i=0; i<S_Costs.length; i++){
				if (S_Costs[i].Id == value) 
                {
                        return S_Costs[i].shouzhi;
                }
			}
			return value;
		}

        function zuofeiSta(value){
            //alert(value);
			for(var i=0; i<states.length; i++){
				if (states[i].text == value) 
                {
                        return states[i].id;
                }
			}
			return value;
		}

    function shoufeiList(obj) {
        var search = "",url="";
        if (obj == "yesflexigridData") {
            search="FK_S_ID&201801170936228934343796e9d44e9^scl_class&2014092713154435710519a5f8dfcd5^SCL_type&支^ischuliStart_Int&0^ischuliEnd_Int&0^";
            url='../../S_COST_LIST/GetDataNoPage';
        }
        if (obj == "noflexigridData") {
//            search="FK_S_ID&201801170936228934343796e9d44e9^scl_class&2014092713154435710519a5f8dfcd5^SCL_type&支^ischuliStart_Int&1^ischuliEnd_Int&1^";
//            alert(search);
        }
        //alert(obj);
        $('#' + obj).datagrid({
            //title: '费用', //列表的标题
            iconCls: 'icon-site',
            width: 'auto',
            height: 'auto',
            nowrap: true,
            striped: true,
            singleSelect:false,
            collapsible: true,
            url: url, //获取数据的url
            queryParams: { search: search},
            sortName: 'PK_ID',
            sortOrder: 'desc',
            //idField: 'PK_ID',
            onClickRow: onClickRow,
            showFooter:true,
            toolbar: [
               ],
            columns: [[

                    {field:'ck',checkbox:true}
                    , { field: 'liushuihao', title: '费用流水号', width: 120,sortable:true}
					, { field: 'FK_SC_ID', title: '费用名称', width: 100,sortable:true,
                    formatter:function(value){
							for(var i=0; i<S_Costs.length; i++){
				                if (S_Costs[i].Id == value) return S_Costs[i].Text;
			                }
			                return value;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'Id',
								textField:'Text',
								data:S_Costs,
								required:true,
                                panelHeight:'auto',
                                editable: false,
                                onSelect:function(record){
                                    var yingshou=formatCurrency(CostsFormatter(record.Id));

                                    $(".yingshou").eq(editIndex).text(yingshou);
                                    alert(yingshou);
                                    $(".shouzhi").eq(editIndex).text(shouzhi(record.Id));

                                    var ed = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'SCL_Real'});
                                    ed.target.numberbox('setValue',yingshou);

                                    var ed2 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'youhui'});
                                    ed2.target.numberbox('setValue','0.00');

                                    

                                    var ed1 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'cashType'});
                                    ed1.target.combobox('setValue','');
                                    }
                                }

						}
                    }
                    , { field: 'SCL_type', title: '收/支', width: 46,align:'center',sortable:true,formatter:function(value){return '<span class="shouzhi">' + value + '</span>';}}
					, { field: 'SS_price', title: '应付', width: 70,sortable:true,formatter: function (value, rec) {
                            return '<span class="yingshou">' + formatCurrency(value) + '</span>';
                        }}
                    , { field: 'SCL_Real', title: '批付', width: 70,sortable:true,formatter: function (value, rec) {
                            return '<span class="shishou">' + formatCurrency(value) + '</span>';
                        }}
                   , { field: 'weishou', title: '未收/未支', width: 70,sortable:true,formatter: function (value, rec) {
                            return '<span class="weishou">' + formatCurrency(value) + "</span>";
                        }}
                     , { field: 'youhui', title: '优惠金额', width: 70,sortable:true,formatter: function (value, rec) {
                            return '<span class="youhui">' + formatCurrency(value) + "</span>";
                        }}
                    , { field: 'cashType', title: '结帐方式', width: 100,align:'left',sortable:true
                    ,
                    formatter:function(value){
							for(var i=0; i<fukuanTypes.length; i++){
								if (fukuanTypes[i].id == value) return fukuanTypes[i].text;
							}
							return value;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'text',
								textField:'text',
                                panelHeight:'auto',
								data:fukuanTypes,
                                editable: false,
                                required:true
							}
						}}
                    
					
                    ,{field:'scl_state',title:'状态',width:60,sortable:true,styler:cellStyler,
                    formatter:function(value){
							for(var i=0; i<states.length; i++){
				                if (states[i].id == value) return states[i].text;
			                }
			                return value;
						},
                    editor:{
							type:'combobox',
							options:{
								valueField:'id',
								textField:'text',
								data:states,
                                panelHeight:'auto',
                                required:true
							}
						}
                    }
                    ,{field:'opertion',title:'记录人',sortable:true,width:60}
                    ,{field:'operttime',title:'记录时间',width:72,sortable:true, formatter: function (value, rec) {
                        if (value) {
                            return dateConvert(value);
                        }}}
                        , { field: 'S_Remark', title: '备注', width: 100,sortable:true,editor:{type:'text'}}
                    ,{field:'PK_ID',hidden:true}
                ]],
            pagination: false,
            rownumbers: true

        });


   if (obj == "yesflexigridData") {


            $('#' + obj).datagrid("addToolbarItem", [

               {
					text:'保存并打印',
					iconCls:'icon-save',
					handler:function(){
						saveAndPrint();
					}
				}
               
                ,'-',{
					text:'刷新',
					iconCls:'icon-ok',
					handler:function(){
						$("#yesflexigridData").datagrid("reload");
					}
				}

            ]);
        }


    }

    function allCostList()
    {    //search="FK_S_ID&201801170936228934343796e9d44e9^scl_class&2014092713154435710519a5f8dfcd5^SCL_type&支^ischuliStart_Int&1^ischuliEnd_Int&1^";

        var search="FK_S_ID&201801170936228934343796e9d44e9^scl_class&2014092713154435710519a5f8dfcd5^SCL_type&支^ischuliStart_Int&1^ischuliEnd_Int&1^heji";
        var url='../../S_COST_LIST/GetDataNoPage1';

        $('#noflexigridData').datagrid({
            //title: '费用', //列表的标题
            iconCls: 'icon-site',
            width: 'auto',
            height: 'auto',
            nowrap: true,
            striped: true,
            singleSelect:false,
            collapsible: true,
            url: url, //获取数据的url
            queryParams: { search: search},
            sortName: 'PK_ID',
            sortOrder: 'desc',
            idField: 'PK_ID',
            toolbar: [{
					text:'刷新',
					iconCls:'icon-ok',
					handler:function(){
						$("#noflexigridData").datagrid("reload");
					}
				}
               ],
            columns: [[

                    { field: 'liushuihao', title: '费用流水号', width: 120,sortable:true}
					, { field: 'FK_SC_ID', title: '费用名称', width: 100,sortable:true}
                    , { field: 'SCL_type', title: '收/支', width: 46,align:'center',sortable:true}
					, { field: 'SS_price', title: '应收', width: 70,sortable:true,align:'right',formatter: function (value, rec) {
                            return  formatCurrency(value);
                        }}
                    , { field: 'SCL_Real', title: '实收', width: 70,sortable:true,align:'right',formatter: function (value, rec) {
                            return  formatCurrency(value);
                        }}
                   , { field: 'weishou', title: '未收', width: 70,sortable:true,align:'right',formatter: function (value, rec) {
                            return  formatCurrency(value);
                        }}
                    , { field: 'youhui', title: '优惠金额', width: 70,sortable:true,align:'right',formatter: function (value, rec) {
                            return  formatCurrency(value);
                        }}
                    ,{field:'youhuiState',title:'优惠状态',width:60,sortable:true}
                    , { field: 'cashType', title: '结帐方式', width: 60,align:'center',sortable:true}
                    
                    ,{field:'scl_state',title:'状态',width:60,sortable:true,styler:cellStyler}
                    
                    ,{field:'opertion',title:'记录人',sortable:true,width:60}
                    ,{field:'operttime',title:'记录时间',width:72,sortable:true, formatter: function (value, rec) {
                        if (value) {
                            return dateConvert(value);
                        }}}
                        , { field: 'S_Remark', title: '备注', width: 100,sortable:true,editor:{type:'text'}}
                ]],
            pagination: false,
            rownumbers: true

        });
    }

        function zhichuList()
    {

        var search="FK_S_ID&201801170936228934343796e9d44e9^ischuliStart_Int&1^ischuliEnd_Int&1^scl_class&201405101025384131826872b7513ef^heji";
        var url='../../S_COST_LIST/GetDataNoPage1';

        $('#zhichuData').datagrid({
            //title: '费用', //列表的标题
            iconCls: 'icon-site',
            width: 'auto',
            height: 'auto',
            nowrap: true,
            striped: true,
            singleSelect:false,
            collapsible: true,
            url: url, //获取数据的url
            queryParams: { search: search},
            sortName: 'PK_ID',
            sortOrder: 'desc',
            idField: 'PK_ID',
//            toolbar: [{
//					text:'提交申请优惠',
//					iconCls:'icon-edit',
//					handler:function(){
//						sqYouhui();
//					}}
//               ],
            columns: [[

                    { field: 'liushuihao', title: '费用流水号', width: 120,sortable:true}
					, { field: 'FK_SC_ID', title: '费用名称', width: 100,sortable:true}
                    , { field: 'SCL_type', title: '收/支', width: 46,align:'center',sortable:true}
					, { field: 'SS_price', title: '应支', width: 70,sortable:true,align:'right',formatter: function (value, rec) {
                            return  formatCurrency(value);
                        }}
                    , { field: 'SCL_Real', title: '实支', width: 70,sortable:true,align:'right',formatter: function (value, rec) {
                            return  formatCurrency(value);
                        }}
                   , { field: 'weishou', title: '未支', width: 70,sortable:true,align:'right',formatter: function (value, rec) {
                            return  formatCurrency(value);
                        }}
//                    , { field: 'youhui', title: '优惠金额', width: 70,sortable:true,align:'right',formatter: function (value, rec) {
//                            return  formatCurrency(value);
//                        }}
//                    ,{field:'youhuiState',title:'优惠状态',width:60,sortable:true}
                    , { field: 'cashType', title: '结帐方式', width: 60,align:'center',sortable:true}
                    
                    ,{field:'scl_state',title:'状态',width:60,sortable:true,styler:cellStyler}
                    
                    ,{field:'opertion',title:'记录人',sortable:true,width:60}
                    ,{field:'operttime',title:'记录时间',width:72,sortable:true, formatter: function (value, rec) {
                        if (value) {
                            return dateConvert(value);
                        }}}
                        , { field: 'S_Remark', title: '备注', width: 100,sortable:true,editor:{type:'text'}}
                ]],
            pagination: false,
            rownumbers: true

        });
    }

    function kaipiao(){
            if (endEditing()){
                $('#yesflexigridData').datagrid('acceptChanges');
            }

            var rows = $('#yesflexigridData').datagrid('getSelections'); 
            if (rows.length == 0) {
                $.messager.alert('操作提示', '请选择数据!', 'warning');
                return false;
            }

           
        
        var bianhao="",jiaolai="",jine=0,beizhu="";
        for(var i=0;i<rows.length;i++){ 
            
            if(rows[i].scl_state=="正常")
            {
                jiaolai+="<span class=xiangmu>" + CostPrintName(rows[i].FK_SC_ID) + "(￥" + formatCurrency(-rows[i].SCL_Real) + ");</span>";
                jine=yunshuan(jinreplace(jine),"+",jinreplace(rows[i].SCL_Real));
                if(rows[i].S_Remark!=null && rows[i].S_Remark!="")
                {
                    beizhu+=rows[i].S_Remark + ";"
                }
            }
            
        }
        
      var shoudao=$("#sname").text() + "&nbsp;(手机:" + $("#stel").text() + "&nbsp;身份证:" + $("#scard").text() + "&nbsp;车型:" + $("#chexing").text() + "&nbsp;推荐人:" + $("#tuijianren").text() + ")";
        //alert(jiaolai);
        //alert(jine);
        //alert(beizhu);
        //获取票据号
        $.ajax({type:"POST",async:false,cache:false,url:"../../ReceiptBill/getPiaoju",data:'sid=201801170936228934343796e9d44e9&rbclass=stuShouru',success:function(res){
       
        if (res != "") {
            if(res.indexOf("登录超时")>=0)
            {
                $.messager.alert('操作提示', '登录超时，请重新登录！', 'info',function(){top.location.href="/";});
            }
            else
            {
               bianhao=res;
               
            }
        }
        }});
         $("#kaipiaoriqi").text('2018-01-30');//开票日期
         
         $("#fenxiao2").text($("#fenxiao").text());
         
         $("#shoudao").html(shoudao);
         $("#jiaolai").html(jiaolai);
         $("#bianhao").text(bianhao);//票据编号
         
         $("#daxie").html(convertCurrency(formatCurrency(0-jine)) + "&nbsp;&nbsp;" + "(￥" + formatCurrency(0-jine) + ")");
          
         $("#beizhu").val(beizhu);
         $("#jiaokuanren").html($("#sname").text());             
         
         $('#shoufeimodel').dialog("open");
         $('#printbutton').linkbutton('enable');    //禁用按钮
    }





    var editIndex = undefined;
        function endEditing(){
            if (editIndex == undefined){return true}
           if ($('#yesflexigridData').datagrid('validateRow', editIndex)){
              
                var columns = $('#yesflexigridData').datagrid("options").columns; 
                var rows = $('#yesflexigridData').datagrid("getRows"); // 这段代码是// 对某个单元格赋值
               
               $('#yesflexigridData').datagrid('endEdit', editIndex);
            
               editIndex = undefined;
               return true;
           } else {
                return false;
        }
        }
        function onClickRow(index){

        //alert(editIndex);

        var rows = $('#yesflexigridData').datagrid("getRows", index);

        //alert($('#yesflexigridData input:checkbox').eq(index).checked);

        if(typeof(rows[index].PK_ID)=="undefined")
        {
            addscid();
        }
        else
        {
            $("#yesflexigridData").datagrid('removeEditor', 'FK_SC_ID');
        }
           if (editIndex != index){
                if (endEditing()){
                    $('#yesflexigridData').datagrid('selectRow', index)
                            .datagrid('beginEdit', index);
                    editIndex = index;
              } else {
                   $('#yesflexigridData').datagrid('selectRow', editIndex);
               }
           }
       }

       function addscid(){
                   $("#yesflexigridData").datagrid('addEditor',
            {
            field:'FK_SC_ID',
            						editor:{
							type:'combobox',
							options:{
								valueField:'Id',
								textField:'Text',
								data:S_Costs,
								required:true,
                                editable: false,
                                onSelect:function(record){
                                    var yingshou=formatCurrency(CostsFormatter(record.Id));

                                    $(".yingshou").eq(editIndex).text(yingshou);

                                    $(".shouzhi").eq(editIndex).text(shouzhi(record.Id));

                                    var ed = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'SCL_Real'});
                                    ed.target.numberbox('setValue',yingshou);

                                    var ed1 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'cashType'});
                                    ed1.target.combobox('setValue','');

                                    var ed2 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'youhui'});
                                    ed2.target.numberbox('setValue','0.00');
                                    }
                                }

						}
            }
            );
       }

  

        function append(){
            //alert(endEditing());
           if (endEditing()){
               //$('#yesflexigridData').datagrid('appendRow',{ck:'',FK_SC_ID:'',SS_price:''});
               //$('#yesflexigridData').datagrid('endEdit', editIndex);
               $('#yesflexigridData').datagrid('insertRow',{
                            index: 0, 
                            row: {
							ck:'',
							FK_SC_ID:'123',
							SS_price:'',
                            SCL_Real:'',
                            weishou:'',
                            cashType:'',
                            cashType:'',
                            S_Remark:''
                            }
						});

              editIndex = $('#yesflexigridData').datagrid('getRows').length-1;
              $('#yesflexigridData').datagrid('selectRow', editIndex)
                       .datagrid('beginEdit', editIndex);
            }
      }
   
       function trimRight(s){ 
            if(s == null) return ""; 
            var whitespace = new String(" \t\n\r"); 
            var str = new String(s); 
            if (whitespace.indexOf(str.charAt(str.length-1)) != -1){ 
            var i = str.length - 1; 
            while (i >= 0 && whitespace.indexOf(str.charAt(i)) != -1){ 
            i--; 
            } 
            str = str.substring(0, i+1); 
            } 
            return str; 
        } 

        //确认打印
        var isOK="0"
        var isbuda="no"

        function budaPiaoju(){
            isbuda="yes";
            var rows = $('#liushuiList').datagrid('getSelections');
            if(rows.length==1)
            {
                var xiangmu=[];
                xiangmu=rows[0].rb_mingxi.split(';');
                var strjl="";
                for(var i=0;i<xiangmu.length-1;i++)
                {
                    strjl+="<span class=xiangmu>" + xiangmu[i] + ";</span>";
                }
                 $("#shoujutitle").html(rows[0].rb_title);
                 $("#kaipiaoriqi").html(dateConvert(rows[0].rb_riqi));
                 $("#bianhao").html(rows[0].rb_bianhao);
                 $("#shoudao").html(rows[0].rb_taitou);
                 $("#jiaolai").html(strjl);
                 $("#daxie").html(rows[0].rb_jine);
                 $("#zhidanren").html(rows[0].rb_opert);
                 $("#shoukuanren").html(rows[0].rb_shoukuan);
                 $("#jiaokuanren").html(rows[0].rb_jiaokuan);
                 $("#beizhu").html(rows[0].rb_remark);
                 $("#buda").html("&nbsp;(补打)");

                 $('#shoufeimodel').dialog("open");
//                 $.post("../../ReceiptBill/budaPiaoju",{bianhao:rows[0].rb_bianhao},function(res){
//                 
//                    if(res=="OK")
//                    {
//                        $('#shoufeimodel').dialog("open");
//                        //$("#liushuiList").datagrid("reload");
//                    }
                    
                 //});

                 
            }
            else{
                $.messager.alert('系统提示：','请选择数据！','info');
            }
        }


        function querenprint() { 
        //把数据嵌套在 一个 div 里，获得 div
//         if(isOK=="1")
//         { 
//            return false;
//         }
        //如果是补打
        if(isbuda=="yes")
        {
            var rows = $('#liushuiList').datagrid('getSelections');
            var bianhao="";
           // if(rows !=null&& rows !=undefined&&rows!=""){
                bianhao=rows[0].rb_bianhao;
           // }
            $.post("../../ReceiptBill/budaPiaoju",{bianhao:bianhao},function(res){
                 
                if(res=="OK")
                {
                    //$('#shoufeimodel').dialog("open");
                    $("#shouju").printArea();
 //                   $("#liushuiList").datagrid("reload");
//                    $("#liushuiList").datagrid("clearSelections");
                    
                }
            });

        }
        else
        {
                 var rows = $("#pkids").val().split(',');
                 var pkids=[]; 
                 for(var i=0;i<rows.length;i++){
                    pkids.push(rows[i]);
                 }

                  if(ischuli(pkids.join(','))==false)
                {
                    $('#shoufeimodel').dialog("close");
                    $.messager.alert("系统提示：","选择的费用已经处理，请重新选择!","info");
                    $("#yesflexigridData").datagrid("reload");
                    $("#noflexigridData").datagrid("reload");
                    $("#liushuiList").datagrid("reload");
               
                    return false;
                }
                else
                {
        

                         //获取票据号
                $.ajax({type:"POST",async:false,cache:false,url:"../../ReceiptBill/getPiaoju",data:'sid=201801170936228934343796e9d44e9&rbclass=stuShouru',success:function(res){
                if (res != "") {
                    if(res.indexOf("登录超时")>=0)
                    {
                        $.messager.alert('操作提示', '登录超时，请重新登录！', 'info',function(){top.location.href="/";});
                    }
                    else
                    {
                        //alert(res);
                       $("#bianhao").html(res);
                    }
                }
                }});


                 //alert($("#pkids").val());
         

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


         

                 //alert(beizhu);

                 $.messager.confirm('操作提示', "确认要打印吗？", function (r) {
                 
                 if(r){
                 
                 //progressComm();

                 $('#printbutton').linkbutton('disable');    //禁用按钮

                 $.post("../../ReceiptBill/querenprint",{pkids:pkids.join(','),
                 shoujutitle:shoujutitle,riqi:riqi,bianhao:bianhao,shoudao:shoudao,jiaolai:jiaolai,daxie:daxie,zhidan:zhidan,shoukuan:shoukuan,jiaokuan:jiaokuan,beizhu:beizhu,sid:'201801170936228934343796e9d44e9',sclclass:'tuixue'},
                    function(res){
                        $('#shoufeimodel').dialog("close");
                        if(res=="OK")
                        {
                            //$('#printbutton').linkbutton('enable');    //禁用按钮
                            //$.messager.progress('close');
                            getStuInfo();
                            //isOK="1";
                            //alert("ok");
                            $("#yesflexigridData").datagrid("reload");
                            $("#noflexigridData").datagrid("reload");

                            $("#liushuiList").datagrid("reload");
                            $("#liushuiList").datagrid("clearSelections");

                            
                    
                            $.messager.alert('系统提示：','开票成功！','info');

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
  }

    //判断费用是否已经被处理

    function ischuli(pkids)
    {
    var istrue=true;
      if(pkids!="")
      {
          $.ajax({type:"POST",async:false,cache:false,url:"../../S_COST_LIST/ischuli",data:"pkids=" + pkids,
          success:function(res){
               if(res=="NO")
               {
                istrue=false;
               }
               
          }
        });  
      }
      return istrue;  
    }

        function isprint(bianhao)
    {
    var istrue=true;
      if(pkids!="")
      {
          $.ajax({type:"POST",async:false,cache:false,url:"../../ReceiptBill/isprint",data:"bianhao=" + bianhao,
          success:function(res){
               if(res=="NO")
               {
                istrue=false;
               }
               
          }
        });  
      }
      return istrue;  
    }

    function saveAndPrint()
    {
        accept();
    }


       function accept(){
            
            isbuda="no";
            
            if (endEditing()){
               $('#yesflexigridData').datagrid('acceptChanges');

               //保存修改'getChanges'
            var rows = $('#yesflexigridData').datagrid('getSelections'); 



            if (rows.length == 0) {
                $.messager.alert('操作提示', '请选择数据!', 'warning');
                return false;
            }


            var sid='201801170936228934343796e9d44e9';//学员ID
            var scid=[];//费用ID
            var sctype=[]; //收支
            var yingshou=[];//应收
            var shishou=[];//实收
            var weishou=[];//未收
            var fukuan=[];//付款方式
            var remark=[]; //备注
            var pkids=[]; //收支记录
            var sclState=[];//费用状态
            var youhui=[];//优惠
            var isyouhui=true;
            
            

            var isfukuan=true;
            for(var i=0;i<rows.length;i++)
            {

            if(jinreplace(rows[i].youhui)>jinreplace(rows[i].weishou))//如果优惠大于未收金额
            {
                isyouhui=false;
            }

                     if(typeof(rows[i].PK_ID)=="undefined")
                    {
                        pkids.push("null");
                    }
                    else
                    {
                        pkids.push(rows[i].PK_ID);
                    }
                    
                scid.push(CostsID(rows[i].FK_SC_ID));//费用ID
                sctype.push(rows[i].SCL_type);//收支


                yingshou.push(jinreplace(rows[i].SS_price));//应收
                shishou.push(jinreplace(rows[i].SCL_Real));//实收
                weishou.push(jinreplace(rows[i].weishou));//未收
                youhui.push(jinreplace(rows[i].youhui));//优惠
                if(rows[i].cashType=="")
                {
                    isfukuan=false;
                }
                else
                {
                    fukuan.push(rows[i].cashType);//付款方式
                }
                

                remark.push(rows[i].S_Remark);//备注
                sclState.push(zuofeiSta(rows[i].scl_state));//作废
            }

             if(isyouhui==false)
            {
                $.messager.alert("系统提示：","优惠金额不能大于未收金额，请核对!","info");
                return false;
            }

            if(isfukuan==false)
            {
                $.messager.alert("系统提示：","请选择结帐方式!","info");
                return false;
            }

            //alert(zuofei.join(','));
            
            //alert(ischuli(pkids.join(',')));

            if(ischuli(pkids.join(','))==false)
            {
               $.messager.alert("系统提示：","选择的费用已经处理，请重新选择!","info");
               $("#yesflexigridData").datagrid("reload");
               return false;
            }
            else{ 
            if (rows.length>0) {
            
                $.messager.confirm('操作提示', "确认要保存这 " + rows.length + " 项吗？", function (r) {
                if (r) {
                                       
                $.post("../../S_COST_LIST/saveUpdatetuixue",{sid:sid,pkids:pkids.join(','),scid:scid.join(','),sctype: sctype.join(','),yingshou:yingshou.join(','),shishou:shishou.join(','),weishou:weishou.join(','),youhui:youhui.join(','),fukuan:fukuan.join(','),remark:remark.join(','),sclState:sclState.join(',')},
                    function(res){
                        var res1=res.split('||');
                        if(res1[0]=="OK"){
                        $("#pkids").val(res1[1]);
                       
                      
                        $("#yesflexigridData").datagrid("reload");
                            kaipiao();
                        
                           
                        }
                        else
                        {
                            if(res.indexOf("登录超时")>=0)
                            {
                                $.messager.alert('操作提示', '登录超时，请重新登录！', 'info',function(){top.location.href="/";});
                            }
                            else
                            {
                                $.messager.alert('操作提示','操作失败，请稍后重试！','info');
                            }
                            
                        }
                    });
                
                }});

                     
            }
            }
               //保存修改
          }
       }

       function jinreplace(value){
           var returnvalue=trimRight(trimLeft(value));
           if(returnvalue.indexOf(",")>=0){
                returnvalue=returnvalue.replace(",","");
           }
           return returnvalue;
       }

       //去掉左边的空白 
        function trimLeft(s){ 
            if(s == null) { 
            return ""; 
            } 
            var whitespace = new String(" \t\n\r"); 
            var str = new String(s); 
            if (whitespace.indexOf(str.charAt(0)) != -1) { 
            var j=0, i = str.length; 
            while (j < i && whitespace.indexOf(str.charAt(j)) != -1){ 
            j++; 
            } 
            str = str.substring(j, i); 
            } 
            return str; 
        } 


        function reject(){
           $('#yesflexigridData').datagrid('rejectChanges');
            editIndex = undefined;
       }
       function getChanges(){
           var rows = $('#yesflexigridData').datagrid('getChanges');
           //alert(rows.length+' rows are changed!');
       }


    $.extend($.fn.datagrid.methods, {
    addEditor : function(jq, param) {
        if (param instanceof Array) {
            $.each(param, function(index, item) {
                var e = $(jq).datagrid('getColumnOption', item.field);
                e.editor = item.editor;
            });
        } else {
            var e = $(jq).datagrid('getColumnOption', param.field);
            e.editor = param.editor;
        }
    },
    removeEditor : function(jq, param) {
        if (param instanceof Array) {
            $.each(param, function(index, item) {
                var e = $(jq).datagrid('getColumnOption', item);
                e.editor = {};
            });
        } else {
            var e = $(jq).datagrid('getColumnOption', param);
            e.editor = {};
        }
    }
});

		function CostsFormatter(value){
			for(var i=0; i<S_Costs.length; i++){
				if (S_Costs[i].Id == value) return S_Costs[i].jine;
			}
			return value;
		}

       function CostsID(value){
			for(var i=0; i<S_Costs.length; i++){
				if (S_Costs[i].Text == value) return S_Costs[i].Id;
			}
			return value;
		}






    function liushuiList() {
        $('#liushuiList').datagrid(
                        {

                            //title: '费用', //列表的标题
                            iconCls: 'icon-site',
                            width: 'auto',
                            height: 'auto',
                            nowrap: true,
                            striped: true,
                            collapsible: true,
                            url: '../../ReceiptBill/GetData', //获取数据的url
                            queryParams: { search: 'rb_sid&201801170936228934343796e9d44e9^rb_class&stuTuixue^' },
                            sortName: 'PK_ID',
                            sortOrder: 'desc',
                            idField: 'PK_ID',
                            singleSelect: true,
                            toolbar: [
//                     {
//                         text: '查询',
//                         iconCls: 'icon-search',
//                         handler: function () {
//                             flexiQuery();
//                         }
//                     },
                     {
                         text: '补打票据',
                         iconCls: 'icon-search',
                         handler: function () {
                             return budaPiaoju();
                         }
                     }],
                            columns: [[


					{ field: 'rb_bianhao', title: '票据编号', width: 80 }
                    ,{ field: 'rb_title', title: '票据名称', width: 160 }
					,{ field: 'rb_riqi', title:  '开票日期', width: 80
                    , formatter: function (value, rec) {
                        if (value) {
                            return dateConvert(value);
                        } 
                    } 
}
                    ,{ field: 'rb_taitou', title:  '票据抬头', width: 160 }
					,{ field: 'rb_mingxi', title:  '票据明细', width: 160 }
					,{ field: 'rb_jine', title:  '票据金额', width: 120 }
					,{ field: 'rb_opert', title:  '开票人', width: 67 }
					,{ field: 'rb_shoukuan', title:  '收款人', width: 67 }
					,{ field: 'rb_jiaokuan', title:  '缴款人', width: 67 }
                    , { field: 'fenxiao', title: '开票分校', width: 80 }
                     , { field: 'fendian', title: '开票分点', width: 80 }
					,{ field: 'rb_remark', title:  '备注说明', width: 120 }
					,{ field: 'CreateTime', title:  '记录时间', width: 76
                    , formatter: function (value, rec) {
                        if (value) {
                            return dateConvert(value);
                        } 
                    } 
}
					,{ field: 'CreatePerson', title:  '记录人', width: 67 }
					,{ field: 'rb_cishu', title:  '打印次数', width: 67 }
                ]],
                            pagination: true,
                            rownumbers: true

                        });
    }

    //提交申请优惠操作
    var scl_pkids=[];
    function sqYouhui(){

        var rows = $('#noflexigridData').datagrid('getSelections'); 
        if (rows.length == 0) {
            $.messager.alert('操作提示', '请选择数据!', 'warning');
            return false;
        }

        var bianhao="",jiaolai="",jine=0,beizhu="";
        
        for(var i=0;i<rows.length;i++){ 
            
            if(rows[i].PK_ID=="")
            {
                $.messager.alert('操作提示', '请选择正确的记录，请核对!', 'warning');
                return false;
            }


            if(rows[i].scl_state=="正常")
            {
                jiaolai +="<span>" + CostsText(rows[i].FK_SC_ID) + "(￥" + formatCurrency(rows[i].youhui) + ");&nbsp;&nbsp;</span>";
                jine=yunshuan(jinreplace(jine),"+",jinreplace(rows[i].youhui));
                if(rows[i].S_Remark!=null && rows[i].S_Remark!="")
                {
                    beizhu+=rows[i].S_Remark + ";"
                }
                scl_pkids.push(rows[i].PK_ID);
            }
            
        }
        //alert(jine);
       var shoudao=$("#sname").text() + "&nbsp;&nbsp;(联系方式：" + $("#stel").text() + "&nbsp;&nbsp;身份证号：" + $("#scard").text() + ")";

         $("#sqRiqi").text('2018-01-30');//开票日期
         
         $("#sqStu").html(shoudao);
         $("#sqYouh").html(jiaolai);
         $("#sqDaxie").html(convertCurrency(formatCurrency(jine)) + "&nbsp;&nbsp;" + "(￥" + formatCurrency(jine) + ")");
         $("#sqBeizhu").val(beizhu);
         $('#sqYhd').dialog("open");
    }

    function querenShenq(){
    
            var rows = $('#noflexigridData').datagrid('getSelections'); 
        if (rows.length == 0) {
            $.messager.alert('操作提示', '请选择数据!', 'warning');
            return false;
        }

        var isyouhui=true
        for(var i=0;i<rows.length;i++){

            if(rows[i].youhuiState!="未优惠" && rows[i].youhuiState!="")
            {
                isyouhui=false;
            }  
        }

        if(isyouhui==false)
        {
            $.messager.alert('操作提示', '费用已经提交申请，请核对!', 'warning');
            return false;
        }

                 var sqRiqi=$("#sqRiqi").text();
                 var sqRen=$("#sqRen").text();
                 var sqStu=$("#sqStu").text();
                 var sqYouh=$("#sqYouh").text();
                 var sqDaxie=$("#sqDaxie").text();
                 var sqBeizhu=$("#sqBeizhu").text();
                 var youhuiType=$("#youhuiType").val();

                 if(youhuiType=="")
                 {
                    $.messager.alert('系统提示:','请选择优惠方式！','info');
                    return false;
                 }

                 $.messager.confirm('操作提示', "确认要提交申请吗？", function (r) {
                 
                 if(r){
                 
                 $.post("../../../S_App/querenShenq",{sqRiqi:sqRiqi,sqRen:sqRen,sqStu:sqStu,sqYouh:sqYouh,sqDaxie:sqDaxie,sqBeizhu:sqBeizhu,scl_pkids:scl_pkids.join(","),youhuiType:youhuiType,sid:'201801170936228934343796e9d44e9',saclass:'shoufei'},
                    function(res){
                        if(res=="OK")
                        {
                            getStuInfo();
                            //isOK="1";
                            //alert("ok");

                            $("#noflexigridData").datagrid("reload");
                            $("#noflexigridData").datagrid("clearSelections");

                            $('#sqYhd').dialog("close");
                    
                            $.messager.alert('系统提示：','申请优惠成功！','info');                    
                        }
                        else{
                            $.messager.alert('系统提示：',res,'info');
                        }
                    }
                 );
                  }

                 });

    }

//    function youhuiopter()
//    {
//        $('#sqYhd').dialog("open");
//    }

                </script>

    <style type="text/css">

body{ padding:0px; margin:0px;}
.text-box 
{
	width:115px;
}
#checkFK_SC_IDStr input
{ text-align:right;
  }
  #checkFK_SC_IDStr td
  { text-align:center;
    }
    #SCL_NO
    {
    	width:190px;
    	}
    	#SCL_REMARK
    	{
    		width:290px;
    }

</style>

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
	#content #right1 span{display:block; margin-top:2px; margin-bottom:2px; width:20px; padding-left:4px;}
	
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

<script src="/resources/Scripts/jquery.PrintArea.js" type="text/javascript"></script>

      <base target = "_self">
</head>
<body>
    
<div class="easyui-panel" fit="true" style="width:985px;height:563px;padding:5px;" border="false">
   <div class="easyui-layout" data-options="fit:true">  
        <div data-options="region:'center'" border="false" >  
<div class="easyui-tabs" data-options="tabWidth:160" fit="true">
       <div title="待退学费" style="padding:5px;">
            <table id="yesflexigridData" fit="true"></table>
        </div>
       <div title="已退学费" style="padding:5px;">
            <table id="noflexigridData" fit="true"></table>
       </div>
       
       <div title="退学票据列表" style="padding:5px;">
            <table id="liushuiList" fit="true"></table>
       </div>
   </div>  
        </div>   
        <div data-options="region:'west',split:true" style="width:220px;padding:5px;" title="学员费用信息">  
                <style type="text/css">
            .piaoh2{ text-align:center; height:24px; height:24px; padding:0px; margin:0px; font-size:16px;}
            .piaoline{ height:18px; line-height:18px; margin-top:5px;}
            .line1{ border-bottom:#000 1px solid;padding-bottom:5px;}
            .center{ text-align:center;}
            .piaolin span{ font-size:12px; font-family:宋体;}
        </style>

        <div class="piaoline"><span>学员编号：</span><span id="sbh"></span></div>
        <div class="piaoline"><span>学员姓名：</span><span id="sname"></span></div>
        <div class="piaoline"><span>身份号码：</span><span id="scard"></span></div>
        <div class="piaoline"><span>手机号码：</span><span id="stel"></span></div>
        <div class="piaoline"><span>准驾车型：</span><span id="chexing"></span></div>
        <div class="piaoline"><span>推 荐 人：</span><span id="tuijianren"></span></div>
        <div class="piaoline"><span>报名分校：</span><span id="fenxiao"></span></div>
        <div class="piaoline line1"><span>所学班别：</span><span id="banbie"></span></div>
        <div class="piaoline"><span>班别费用：</span><span id="xuefei"></span></div>
        <div class="piaoline"><span>其它费用：</span><span id="qita"></span></div>
        <div class="piaoline"><span>应收费用：</span><span id="ysfeiyong"></span></div>
        <div class="piaoline"><span>实收费用：</span><span id="ssfeiyong" style="color:Green"></span></div>
        <div class="piaoline"><span>欠费金额：</span><span id="qfjine" style="color:Red"></span></div>
        <div class="piaoline"><span>优惠金额：</span><span id="youhui"></span></div>
        <div class="piaoline line1"><span>退费金额：</span><span id="tuifei" style="color:blue"></span></div>
        <div class="piaoline"><span>支出金额：</span><span id="zcjine"></span></div>
        <div class="piaoline"><span>剩余金额：</span><span id="syjine"></span></div>
        </div>
    </div>
</div>

    <!--费用流水查询-->
    <div id="divQuery" title="查询列表" class="easyui-dialog" closed="true" modal="false"
        iconcls="icon-search">
        <div class="input">
            <div class="editor-label-search">
                <label for="SCL_NO">费用流水号</label>
            </div>
            <div class="editor-field-search">
                <input type='text' id='SCL_NO' />
            </div>
        </div>
        
    </div>
    <!--费用流水查询-->
<!--收费单据-->
        <div id="shoufeimodel" class="easyui-window" title="学员退学单据" data-options="modal:true,closed:true,minimizable:false,collapsible:false,maximizable:false,iconCls:'icon-print'" style="width:800px;height:460px;padding:10px;">
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
	#content #right1{ float:left;width:20px; padding-top:42px; font-size:12px;}
	#content #right1 span{display:block; margin-top:2px; margin-bottom:2px; width:20px; padding-left:4px;}
	
	#title1{overflow:hidden;zoom:1; height:30px; line-height:30px;}
	#title1 .left{ display:block;float:left; margin-left:32px; font-size:12px;}
	#title1 .right{ display:block;float:right;margin-right:32px; font-size:12px;}
	
	#content123{ border:#000 1px solid;height:auto; min-height:180px; }
	#content123 .line ul li{ display:block; height:auto;}
	#content123 .line{ overflow:hidden;zoom:1;}
	#content123 .line .left1{ float:left; width:92px; margin-left:15px; line-height:32px; text-align:left;font-size:12px;}
	#content123 .line .right1{ float:right; text-align:left;line-height:23px; padding-top:6px; width:576px; margin-right:10px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;margin-right:10px; font-size:12px}
	#content123 .line .right1 span{ float:left;text-align:left;font-size:12px; }
	#content123 .line .left2{ float:left; width:60px; margin-left:10px; line-height:37px; text-align:left;font-size:12px;}
	#content123 .line .right2{ float:left; text-align:left;line-height:23px; padding-top:6px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;font-size:12px;}
	#content123 .textarea{ border:0px; height:30px; width:100%;overflow:auto;background-attachment:fixed;background-repeat:no-repeat;}
	
	#content123 .line .right1 .xiangmu{display:block; width:170px; font-size:10px}
	
	.tishi{height:auto; font-size:10px; line-height:15px; text-align:left; overflow:hidden;zoom:1; margin-top:6px;font-size:10px;}
	.tishi .span1{ display:block; float:left;width:80px;margin-left:30px;font-size:10px;}
	.tishi .span2{ display:block; float:left;width:566px;font-size:10px;}
	.width100{ width:100px;}
	.textarea{ font-size:12px; color:#000; font-weight:800;}
	#content123 .line .noneline{ border-bottom:0px;}
</style>
	<div id="title" ><span id="shoujutitle">北京博奥创软科技有限公司收款凭据</span></div>
    <div id="content">
    	<ul>
        	<div style="text-align:center"><input type=text value="学员退学单据" style="text-align:center; border=0px; font-size:15px; height:30px; line-height:30px; font-weight:bolder;" /></div> 
            <li id="right">
            	<div id="title1"><span class="left">开票日期：<span id="kaipiaoriqi"></span></span><span class="right">NO：<span id="bianhao"></span><span id="buda"></span></span></div>
                <div id="content123">
                	<div class="line">
                        <ul>
                            <li class="left1">退学人：</li>
                            <li class="right1" id="shoudao">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="line">
                         <ul>
                            <li class="left1">支&nbsp;&nbsp;付：</li>
                            <li class="right1" id="jiaolai"> </li>
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
                            <li class="right2" id="zhidanren">王新超 (<span id="fenxiao2"></span>)</li>
                            <li class="left2">付款人：</li>
                            <li class="right2" id="shoukuanren">王新超</li>
                            <li class="left2">收款人：</li>
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
        <div class="piaoline center"><a href="javascript:void(0);" onclick="querenprint();" id="printbutton" class="easyui-linkbutton" data-options="iconCls:'icon-print'">确认打印</a></div>
</div>

<!--申请优惠单格式-->
<div id="sqYhd" class="easyui-dialog" title="申请优惠单" data-options="modal:true,closed:true,minimizable:false,collapsible:false,maximizable:false,iconCls:'icon-ok'" style="width:720px;height:400px;padding:10px;">
<div id="youhuidan">
<style type="text/css">

	div,ul,li{ margin:0px; padding:0px; list-style:none;}
	
	#youhuidan{width:670px;  margin:0 auto; font-family:新宋体;}
	#youhuidan #sqtitle{text-align:center; font-size:18px; height:30px; line-height:30px; font-weight:bolder;}
	
	#youhuidan #sqcontent{ overflow:hidden;zoom:1; font-size:14px; font-weight:800;}
	#youhuidan #sqcontent ul li{ display:block;}
	#youhuidan #sqcontent #sqleft{ float:left; width:20px; line-height:26px;}
	#youhuidan #sqcontent #sqleft span{ display:block; position:relative; top:70px; height:60px; width:20px;}
	#youhuidan #sqcontent #sqright{ float:right;width:640px;}
	
	#youhuidan #sqtitle1{overflow:hidden;zoom:1; height:30px; line-height:30px;}
	#youhuidan #sqtitle1 .left{ display:block;float:left; margin-left:32px;}
	#youhuidan #sqtitle1 .right{ display:block;float:right;margin-right:32px;}
	
	#youhuidan #sqcontent123{ border:#000 1px solid; height:200px; padding-top:10px;}
	#youhuidan #sqcontent123 .line ul li{ display:block; height:auto;}
	#youhuidan #sqcontent123 .line{ overflow:hidden;zoom:1;}
	#youhuidan #sqcontent123 .line .left1{ float:left; width:88px; margin-left:30px; line-height:37px; text-align:left;}
	#youhuidan #sqcontent123 .line .right1{ float:right; text-align:left;line-height:23px; padding-top:6px; width:500px; border-bottom:#000 1px solid; margin-right:20px; overflow:hidden;zoom:1;}
	#youhuidan #sqcontent123 .line .right1 span{ float:left; text-align:left; margin-right:10px;}
	#youhuidan #sqcontent123 .line .left2{ float:left; width:60px; margin-left:10px; line-height:37px; text-align:left;}
	#youhuidan #sqcontent123 .line .right2{ float:left; text-align:left;line-height:23px; padding-top:6px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;}
	#youhuidan #sqcontent123 .textarea{ border:0px; height:30px; width:100%;overflow:auto;background-attachment:fixed;background-repeat:no-repeat;}
	
	#youhuidan .tishi{height:auto; line-height:23px; text-align:left; overflow:hidden;zoom:1; margin-top:6px;}
	#youhuidan .tishi .span1{ display:block; float:left;width:80px;margin-left:30px;}
	#youhuidan .tishi .span2{ display:block; float:left;width:500px;}
	#youhuidan .width100{ width:100px;}
	#youhuidan .textarea{ font-size:14px; color:#000; font-weight:800;}
</style>
	<div id="sqtitle" >北京博奥创软科技有限公司收款凭据申请优惠单</div>
    <div id="sqcontent">
    	<ul>
        	<li id="sqleft"><span>申请优惠单</span></li>
            <li id="sqright">
            	<div id="sqtitle1"><span class="left">优惠方式：<select id="youhuiType" name="youhuiType" style="font-size:14px; font-weight:900; border:#000 1px solid; width:160px;"><option value="">请选择优惠方式</option>
<option value="优惠卷">优惠卷</option>
<option value="熟人介绍">熟人介绍</option>
<option value="其他方式">其他方式</option>
</select></span><span class="right">申请人：<span id="sqRen">王新超</span>&nbsp;&nbsp;&nbsp;&nbsp;申请日期：<span id="sqRiqi">2014-04-22</span></span></div>
                <div id="sqcontent123">
                	<div class="line">
                	  <ul>
                        <li class="left1">兹有学员：</li>
                          <li class="right1" id="sqStu">&nbsp;</li>
                        </ul>
                  </div>
                    <div class="line">
                         <ul>
                            <li class="left1">申请优惠：</li>
                            <li class="right1" id="sqYouh">&nbsp; </li>
                        </ul>
                    </div>
                    <div class="line">
                        <ul>
                            <li class="left1">合计(大写)：</li>
                            <li class="right1" id="sqDaxie">&nbsp;</li>
                        </ul>
                    </div>
                    <div class="line">
                        <ul>
                            <li class="left1">备注说明：</li>
                            <li class="right1"><textarea name="sqBeizhu" id="sqBeizhu" class="textarea" cols="" rows=""></textarea></li>
                        </ul>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
<div class="piaoline center"><a href="javascript:void(0);" onclick="querenShenq();" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确认申请</a></div>
</div>
<!--申请优惠单格式-->
    <script src="/resources/Res/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    

</body>
</html>