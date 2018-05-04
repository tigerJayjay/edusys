
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
	
  学员收费

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
    
    
 <script src="/resources/Scripts/PingjiaComm.js" type="text/javascript"></script>
<script type='text/javascript'>
    var S_Costs = [];
    var fukuanTypes = [];
    var states=[{id:'0',text:'待收费'},{id:'1',text:'已收费'}];


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
        getStuInfo();
        setTimeout(function () { allCostList(); }, 1000);
        setTimeout(function () { zhichuList(); }, 1000);
        setTimeout(function () { liushuiList(); }, 1000); 

});
    function liushuiList() {
    	var stuName = $("#sname").text();
        $('#liushuiList').datagrid(
                        {

                            //title: '费用', //列表的标题
                            iconCls: 'icon-site',
                            width: 'auto',
                            height: 'auto',
                            nowrap: true,
                            striped: true,
                            collapsible: true,
                            url: '/financial/getTicket', //获取数据的url
                            queryParams: { queryCondition: 'ftPayee:'+stuName },
                            sortName: 'PK_ID',
                            sortOrder: 'desc',
                            idField: 'PK_ID',
                            singleSelect: true,
                            toolbar: [
		                    /*  {
		                         text: '补打票据',
		                         iconCls: 'icon-search',
		                         handler: function () {
		                             return budaPiaoju();
		                         }
		                     } */],
                            columns: [[


					{ field: 'ftId', title: '票据编号', width: 80 }
                    ,{ field: 'ftClass', title: '票据名称', width: 160 }
					,{ field: 'ftDate', title:  '开票日期', width: 80}
                    ,{ field: 'ftRise', title:  '票据抬头', width: 160 }
					,{ field: 'ftDetail', title:  '备注', width: 160 }
					,{ field: 'ftAmount', title:  '票据金额', width: 120 }
					,{ field: 'ftBiller', title:  '收款人', width: 67 }
					,{ field: 'ftPayee', title:  '缴款人', width: 67 }
                    , { field: 'ftFenxiao', title: '开票分校', width: 80 }
                     , { field: 'frFendian', title: '开票分点', width: 80 }
					,{ field: 'rb_remark', title:  '备注说明', width: 120 }
                ]],
                            pagination: true,
                            rownumbers: true

                        });
    }
function getStuInfo(){
    $.post('/financial/getStuInfo',{stuId:'${stuId}'},
    function (result) 
    {
        if(result!="NO")
        {
            
            $("#sbh").text(result["stuId"]);
            $("#sname").text(result["stuName"]);
            $("#scard").text(result["stuCardId"]);
            $("#stel").text(result["stuPhone"]);
            $("#chexing").text(result["stuDriverType"]);
            $("#banbie").text(result["stuClassType"]);
            $("#fenxiao").text(result["stuAssignsSchool"]);
            $("#fendian").text(result["stuAssigns"]);
            $("#tuijianren").text(result["stuReferees"]);

            $("#xuefei").text(formatCurrency(result["stuCharge"]));//班级学费
            //$("#qita").text(formatCurrency(result["qitafei"]));//其它费用
            //$("#youhui").text(formatCurrency(result["youhui"]));//优惠金额
            $("#ysfeiyong").text(result["stuShouldCharge"]);//应收费用
            $("#ssfeiyong").text(result["stuCharge"]);//实收费用
            //$("#qfjine").text(formatCurrency(result["qianfei"]));//欠费金额
            //$("#zcjine").text(formatCurrency(result["zcjine"]));//支出金额
            //$("#syjine").text(formatCurrency(result["syjine"]));//欠费金额
           // $("#tuifei").text(formatCurrency(result["tuifei"]));//退费金额
        }


    },"json");
    
    
}

    //“查询”按钮，弹出查询框
    function flexiQuery() {
        $('#divQuery').dialog({
            buttons: [{
                text: '查询',
                iconCls: 'icon-ok',
                handler: function () {
                    //将查询条件按照分隔符拼接成字符串
                    var search = "";
                    $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
                        search = search + this.id + "&" + this.value + "^";
                    });
                    //alert(search);
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
				if (S_Costs[i].Text == value || S_Costs[i].Id == value) 
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
        	 search="{'freStuId':'"+'${stuId}'+"','freState':'待处理'}";
             url='/financial/GetDataBukaofei';
        }
        if (obj == "noflexigridData") {
            //search="FK_S_ID&2017122609452520593433a7f47d7f5^ischuliStart_Int&1^ischuliEnd_Int&1^";
            //url='../../S_COST_LIST/GetDataNoPage1';
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
            queryParams: { searchCondition: search},
            sortName: 'PK_ID',
            sortOrder: 'desc',
            //idField: 'PK_ID',
            onClickRow: onClickRow,
            showFooter:true,
            toolbar: [
               ],
            columns: [[

                    {field:'ck',checkbox:true}
                    , { field: 'freId', title: '费用流水号', width: 120,sortable:true}
					, { field: 'freClass', title: '费用名称', width: 100,sortable:true,
						editor:{
							type:'combobox',
							options:{
								url:"/financial/getStuType",
								valueField:'value',
								textField:'text',
								required:true,
                                panelHeight:'auto',
                                editable: false,
                               onSelect:function(record){
                                    var yingshou=record.value;
                                    var dest = yingshou.substring(yingshou.indexOf(',')+1,yingshou.length);
                                    if(dest==0){
                                    	dest = "支";
                                    }
                                    if(dest==1){
                                    	dest="收";
                                    }
                                    var ed1 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'freIncomePay'});
                                    ed1.target.numberbox('setValue','');
                                    //alert(yingshou);
                                    $(".shouzhi").eq(editIndex).text(shouzhi(dest));
                                    } 
                                }

						},formatter:function(value){ if(value==undefined){value=''}
						return '<span class="freClass">' + value.split(',')[0] + '</span>';}
                    }
                    , { field: 'freShouzhi', title: '收/支', width: 46,align:'center',sortable:true,formatter:function(value){ if(value==undefined){value=''}
return '<span class="shouzhi">' + value + '</span>';}}
					, { field: 'freIncomePay', title: '应收/应付', width: 70,sortable:true,align:'right', editor:{
	                    type:'numberbox',
	                    options:{
	                        value:0,
	                        precision:2,
	                        min:0,
	                       onChange:function(value){
	                                if(editIndex!=undefined && editIndex !=null){
	                                 var edshishou = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'freIncomePay'});//获取当前youhui输入框对象
	                                 edshishou.target.numberbox('setValue',value);//为youhui输入框 赋值
	                            }
	                    
	                        }
					
					     },formatter: function (value) { if(value==undefined){value=''}
	                            return '<span class="yingshou">' + value + '</span>';
	                        }
	                    }
					}
                    , { field: 'freRealincomeRealpay', title: '实收/实付', width: 70,sortable:true,
                    editor:{
                    type:'numberbox',
                    options:{
                        value:0,
                        precision:2,
                        min:0,groupSeparator:',',
                        onChange:function(value){
                                if(editIndex!=undefined && editIndex !=null){
                                
                                          /*   var yingshou=$(".freIncomePay").eq(editIndex).text();
                                             if(parseInt(value)>parseInt(yingshou))
                                                    {
                                                        value=rows[editIndex].SCL_Real;
                                                        var edshishou = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                                        edshishou.target.numberbox('setValue',value);//为youhui输入框 赋值
                                                        $.messager.alert("操作提示","系统提示：实收金额不能大于应收金额，请核对！","info");
                                                        return false;
                                                    }

                                            var weishou=yingshou-value;
                                            $(".freUnincome").eq(editIndex).text(weishou); */
                                }
                            }
                        }},align:'right',formatter: function (value) { if(value==undefined){value=''};
                            return '<span class="freRealincomeRealpay">' + value + "</span>";
                        }}
                   , { field: 'freUnincome', title: '未收/未支', width: 70,sortable:true,align:'right',formatter: function (value) { if(value==undefined){value=''};
                       return '<span class="freUnincome">' + value + "</span>";
                   }}
                     , { field: 'freDiscount', title: '优惠金额', width: 70,sortable:true,align:'right', editor:{
                    type:'numberbox',
                    options:{
                        value:0,
                        precision:2,
                        min:0,groupSeparator:',',
                        onChange:function(value){
                                if(editIndex!=undefined && editIndex !=null){
                                     var rows=$('#yesflexigridData').datagrid('getRows');//获取所有行
                                     if(rows[editIndex].youhuiState=="<font color='green'>通过</font>")//根据 index  获取 当前行的数据
                                     {
                                        value=rows[editIndex].youhui;
                                        var edyouhui = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                        edyouhui.target.numberbox('setValue',value);//为youhui输入框 赋值
                                     }else{ 
                                     
                                                var yingshou=$(".freIncomePay").eq(editIndex).text().replace(',','');//   应收
                                                if(yingshou!="")
                                                {
                                                     value=value.replace(',','')
                                                     if(parseInt(value)>parseInt(yingshou))
                                                    {
                                                        value=rows[editIndex].youhui;
                                                        var edyouhui = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                                        edyouhui.target.numberbox('setValue',value);//为youhui输入框 赋值
                                                        $.messager.alert("操作提示","系统提示：优惠金额不能大于应收金额，请核对！","info");
                                                        
                                                        return false;
                                                    }
                                                    var ed1 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});
                                
                                                    ed1.target.numberbox('setValue',yingshou-value);
                                                }
                                           }
                                    
                                 }
                            }
                        
                        }},align:'right',formatter: function (value, rec) { if(value==undefined){value=''};
                            return '<span class="freDiscount">' + value+ '</span>';
                        }}
                    , { field: 'frePaystyle', title: '结帐方式', width: 100,align:'left',sortable:true
                   ,
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
                    
					
                    ,{field:'freState',title:'状态',width:60,sortable:true,styler:cellStyler
                    }
                    ,{field:'freRecordPerson',title:'记录人',sortable:true,width:60}
                    ,{field:'freTime',title:'记录时间',width:72,sortable:true}, 
                    { field: 'S_Remark', title: '备注', width: 200,sortable:true,editor:{type:'text'}}
                    ,{field:'PK_ID',hidden:true}
                    
                ]],
            pagination: true,
            rownumbers: true

        });


   if (obj == "yesflexigridData") {


            $('#' + obj).datagrid("addToolbarItem", [

{
					text:'增加费用',
					iconCls:'icon-add',
					handler:function(){
						insert();
					}
				}
                 ,
                '-',{
					text:'删除费用',
					iconCls:'icon-remove',
					handler:function(){
						removeit();
					}
				}
                ,'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						saveAndPrint();
					}
				}
                ,'-',
                {
					text:'确认处理',
					iconCls:'icon-edit',
					handler:function(){
                        dayin();
						//querenshoufei();
					}}
               
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
    function dayin(){
    	 var rows = $('#yesflexigridData').datagrid("getSelections");
         if(rows.length>1){
        	 $.messager.alert('系统提示','请选择一条信息!','info');
        	 return false;
         }
         if(rows[0].freShouzhi=='支'){
        	 querenshoufei();
        	 return false;
         }
    	 $("#kaipiaoriqi").text(new Date().format("yyyy-MM-dd hh:mm:ss"));//开票日期
         $("#shoudao").html($("#sname").text());
         $("#jiaolai").html(rows[0].freRealincomeRealpay);
         $("#bianhao").text(new Date().getTime());//票据编号
         $("#daxie").html(convertCurrency(rows[0].freRealincomeRealpay));
         $('#shoufeimodel').dialog("open");
         //$("#shoujuClass").val("代收费票据");
    }
    //确认收费
    function querenshoufei(){
    	 var rows = $('#yesflexigridData').datagrid("getSelections");
    	 if(rows.length==0){
    		 $.messager.alert('系统提示:','请选择一条数据!','info');
    		 return false;
    	 }
    	 var freIds = [];
    	 var freShouzhis = [];
    	 for(var i = 0;i<rows.length;i++){
    		 freIds.push(rows[i].freId);
    		 freShouzhis.push(rows[i].freShouzhi);
    	 }
    	 $.post("/financial/queren",{freIds:freIds.join(','),freShouzhis:freShouzhis.join(',')},function(res){
    		 if(res=="OK"){
    			 $('#yesflexigridData').datagrid("reload");
    			 $('#noflexigridData').datagrid("reload");
    			 $("#zhichuData").datagrid("reload");
    			 $("#liushuiList").datagrid("reload");
    			 $.messager.alert('系统提示：','操作成功!','info');
    		 }else{
    			 $.messager.alert('系统提示:','操作失败!','info');
    		 }
    	 },"json")
    }
 
    function allCostList()
    {

    	var search="{'freStuId':'"+'${stuId}'+"','freState':'已收费'}";
        var url='/financial/GetDataBukaofei';
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
            queryParams: { searchCondition: search},
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

                          {field:'ck',checkbox:true}
                          , { field: 'freId', title: '费用流水号', width: 120,sortable:true}
      					, { field: 'freClass', title: '费用名称', width: 100,sortable:true,
      						editor:{
      							type:'combobox',
      							options:{
      								url:"/financial/getStuType",
      								valueField:'value',
      								textField:'text',
      								required:true,
                                      panelHeight:'auto',
                                      editable: false,
                                     onSelect:function(record){
                                          var yingshou=record.value;
                                          var dest = yingshou.substring(yingshou.indexOf(',')+1,yingshou.length);
                                          if(dest==0){
                                          	dest = "支";
                                          }
                                          if(dest==1){
                                          	dest="收";
                                          }
                                          var ed1 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'freIncomePay'});
                                          ed1.target.numberbox('setValue','');
                                          //alert(yingshou);
                                          $(".shouzhi").eq(editIndex).text(shouzhi(dest));
                                          } 
                                      }

      						},formatter:function(value){ if(value==undefined){value=''}
      						return '<span class="freClass">' + value.split(',')[0] + '</span>';}
                          }
                          , { field: 'freShouzhi', title: '收', width: 46,align:'center',sortable:true,formatter:function(value){ if(value==undefined){value=''}
      return '<span class="shouzhi">' + value + '</span>';}}
      					, { field: 'freIncomePay', title: '应收', width: 70,sortable:true,align:'right', editor:{
      	                    type:'numberbox',
      	                    options:{
      	                        value:0,
      	                        precision:2,
      	                        min:0,
      	                       onChange:function(value){
      	                                if(editIndex!=undefined && editIndex !=null){
      	                                 var edshishou = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'freIncomePay'});//获取当前youhui输入框对象
      	                                 edshishou.target.numberbox('setValue',value);//为youhui输入框 赋值
      	                            }
      	                    
      	                        }
      					
      					     },formatter: function (value) { if(value==undefined){value=''}
      	                            return '<span class="yingshou">' + value + '</span>';
      	                        }
      	                    }
      					}
                          , { field: 'freRealincomeRealpay', title: '实收', width: 70,sortable:true,
                          editor:{
                          type:'numberbox',
                          options:{
                              value:0,
                              precision:2,
                              min:0,groupSeparator:',',
                              onChange:function(value){
                                      if(editIndex!=undefined && editIndex !=null){
                                      
                                                /*   var yingshou=$(".freIncomePay").eq(editIndex).text();
                                                   if(parseInt(value)>parseInt(yingshou))
                                                          {
                                                              value=rows[editIndex].SCL_Real;
                                                              var edshishou = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                                              edshishou.target.numberbox('setValue',value);//为youhui输入框 赋值
                                                              $.messager.alert("操作提示","系统提示：实收金额不能大于应收金额，请核对！","info");
                                                              return false;
                                                          }

                                                  var weishou=yingshou-value;
                                                  $(".freUnincome").eq(editIndex).text(weishou); */
                                      }
                                  }
                              }},align:'right',formatter: function (value) { if(value==undefined){value=''};
                                  return '<span class="freRealincomeRealpay">' + value + "</span>";
                              }}
                         , { field: 'freUnincome', title: '未收', width: 70,sortable:true,align:'right',formatter: function (value) { if(value==undefined){value=''};
                             return '<span class="freUnincome">' + value + "</span>";
                         }}
                           , { field: 'freDiscount', title: '优惠金额', width: 70,sortable:true,align:'right', editor:{
                          type:'numberbox',
                          options:{
                              value:0,
                              precision:2,
                              min:0,groupSeparator:',',
                              onChange:function(value){
                                      if(editIndex!=undefined && editIndex !=null){
                                           var rows=$('#yesflexigridData').datagrid('getRows');//获取所有行
                                           if(rows[editIndex].youhuiState=="<font color='green'>通过</font>")//根据 index  获取 当前行的数据
                                           {
                                              value=rows[editIndex].youhui;
                                              var edyouhui = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                              edyouhui.target.numberbox('setValue',value);//为youhui输入框 赋值
                                           }else{ 
                                           
                                                      var yingshou=$(".freIncomePay").eq(editIndex).text().replace(',','');//   应收
                                                      if(yingshou!="")
                                                      {
                                                           value=value.replace(',','')
                                                           if(parseInt(value)>parseInt(yingshou))
                                                          {
                                                              value=rows[editIndex].youhui;
                                                              var edyouhui = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                                              edyouhui.target.numberbox('setValue',value);//为youhui输入框 赋值
                                                              $.messager.alert("操作提示","系统提示：优惠金额不能大于应收金额，请核对！","info");
                                                              
                                                              return false;
                                                          }
                                                          var ed1 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});
                                      
                                                          ed1.target.numberbox('setValue',yingshou-value);
                                                      }
                                                 }
                                          
                                       }
                                  }
                              
                              }},align:'right',formatter: function (value, rec) { if(value==undefined){value=''};
                                  return '<span class="freDiscount">' + value+ '</span>';
                              }}
                          , { field: 'frePaystyle', title: '结帐方式', width: 100,align:'left',sortable:true
                         ,
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
                          
      					
                          ,{field:'freState',title:'状态',width:60,sortable:true,styler:cellStyler
                          }
                          ,{field:'freRecordPerson',title:'记录人',sortable:true,width:60}
                          ,{field:'freTime',title:'记录时间',width:72,sortable:true}, 
                          { field: 'S_Remark', title: '备注', width: 200,sortable:true,editor:{type:'text'}}
                          ,{field:'PK_ID',hidden:true}
                          
                      ]],
            pagination: true,
            rownumbers: true

        });
    }

    //支出
     function zhichuList()
    {

    	var search="{'freStuId':'"+'${stuId}'+"','freState':'已支出'}";
        var url='/financial/GetDataBukaofei';
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
            queryParams: { searchCondition: search},
            sortName: 'freId',
            sortOrder: 'desc',
            idField: 'freId',
            toolbar: [{
					text:'刷新',
					iconCls:'icon-ok',
					handler:function(){
						$("#zhichuData").datagrid("reload");
					}
				}
               ],
               columns: [[

                          {field:'ck',checkbox:true}
                          , { field: 'freId', title: '费用流水号', width: 120,sortable:true}
      					, { field: 'freClass', title: '费用名称', width: 100,sortable:true,
      						editor:{
      							type:'combobox',
      							options:{
      								url:"/financial/getStuType",
      								valueField:'value',
      								textField:'text',
      								required:true,
                                      panelHeight:'auto',
                                      editable: false,
                                     onSelect:function(record){
                                          var yingshou=record.value;
                                          var dest = yingshou.substring(yingshou.indexOf(',')+1,yingshou.length);
                                          if(dest==0){
                                          	dest = "支";
                                          }
                                          if(dest==1){
                                          	dest="收";
                                          }
                                          var ed1 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'freIncomePay'});
                                          ed1.target.numberbox('setValue','');
                                          //alert(yingshou);
                                          $(".shouzhi").eq(editIndex).text(shouzhi(dest));
                                          } 
                                      }

      						},formatter:function(value){ if(value==undefined){value=''}
      						return '<span class="freClass">' + value.split(',')[0] + '</span>';}
                          }
                          , { field: 'freShouzhi', title: '支', width: 46,align:'center',sortable:true,formatter:function(value){ if(value==undefined){value=''}
      return '<span class="shouzhi">' + value + '</span>';}}
      					, { field: 'freIncomePay', title: '应付', width: 70,sortable:true,align:'right', editor:{
      	                    type:'numberbox',
      	                    options:{
      	                        value:0,
      	                        precision:2,
      	                        min:0,
      	                       onChange:function(value){
      	                                if(editIndex!=undefined && editIndex !=null){
      	                                 var edshishou = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'freIncomePay'});//获取当前youhui输入框对象
      	                                 edshishou.target.numberbox('setValue',value);//为youhui输入框 赋值
      	                            }
      	                    
      	                        }
      					
      					     },formatter: function (value) { if(value==undefined){value=''}
      	                            return '<span class="yingshou">' + value + '</span>';
      	                        }
      	                    }
      					}
                          , { field: 'freRealincomeRealpay', title: '实付', width: 70,sortable:true,
                          editor:{
                          type:'numberbox',
                          options:{
                              value:0,
                              precision:2,
                              min:0,groupSeparator:',',
                              onChange:function(value){
                                      if(editIndex!=undefined && editIndex !=null){
                                      
                                                /*   var yingshou=$(".freIncomePay").eq(editIndex).text();
                                                   if(parseInt(value)>parseInt(yingshou))
                                                          {
                                                              value=rows[editIndex].SCL_Real;
                                                              var edshishou = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                                              edshishou.target.numberbox('setValue',value);//为youhui输入框 赋值
                                                              $.messager.alert("操作提示","系统提示：实收金额不能大于应收金额，请核对！","info");
                                                              return false;
                                                          }

                                                  var weishou=yingshou-value;
                                                  $(".freUnincome").eq(editIndex).text(weishou); */
                                      }
                                  }
                              }},align:'right',formatter: function (value) { if(value==undefined){value=''};
                                  return '<span class="freRealincomeRealpay">' + value + "</span>";
                              }}
                         , { field: 'freUnincome', title: '未付', width: 70,sortable:true,align:'right',formatter: function (value) { if(value==undefined){value=''};
                             return '<span class="freUnincome">' + value + "</span>";
                         }}
                           , { field: 'freDiscount', title: '优惠金额', width: 70,sortable:true,align:'right', editor:{
                          type:'numberbox',
                          options:{
                              value:0,
                              precision:2,
                              min:0,groupSeparator:',',
                              onChange:function(value){
                                      if(editIndex!=undefined && editIndex !=null){
                                           var rows=$('#yesflexigridData').datagrid('getRows');//获取所有行
                                           if(rows[editIndex].youhuiState=="<font color='green'>通过</font>")//根据 index  获取 当前行的数据
                                           {
                                              value=rows[editIndex].youhui;
                                              var edyouhui = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                              edyouhui.target.numberbox('setValue',value);//为youhui输入框 赋值
                                           }else{ 
                                           
                                                      var yingshou=$(".freIncomePay").eq(editIndex).text().replace(',','');//   应收
                                                      if(yingshou!="")
                                                      {
                                                           value=value.replace(',','')
                                                           if(parseInt(value)>parseInt(yingshou))
                                                          {
                                                              value=rows[editIndex].youhui;
                                                              var edyouhui = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});//获取当前youhui输入框对象
                                                              edyouhui.target.numberbox('setValue',value);//为youhui输入框 赋值
                                                              $.messager.alert("操作提示","系统提示：优惠金额不能大于应收金额，请核对！","info");
                                                              
                                                              return false;
                                                          }
                                                          var ed1 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'frePaystyle'});
                                      
                                                          ed1.target.numberbox('setValue',yingshou-value);
                                                      }
                                                 }
                                          
                                       }
                                  }
                              
                              }},align:'right',formatter: function (value, rec) { if(value==undefined){value=''};
                                  return '<span class="freDiscount">' + value+ '</span>';
                              }}
                          , { field: 'frePaystyle', title: '结帐方式', width: 100,align:'left',sortable:true
                         ,
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
                          
      					
                          ,{field:'freState',title:'状态',width:60,sortable:true,styler:cellStyler
                          }
                          ,{field:'freRecordPerson',title:'记录人',sortable:true,width:60}
                          ,{field:'freTime',title:'记录时间',width:72,sortable:true}, 
                          { field: 'S_Remark', title: '备注', width: 200,sortable:true,editor:{type:'text'}}
                          ,{field:'PK_ID',hidden:true}
                          
                      ]],
            pagination: true,
            rownumbers: true

        });
    }
    function kaipiao(isDaishoufei){
            if (endEditing()){
                $('#yesflexigridData').datagrid('acceptChanges');
            }

            var rows = $('#yesflexigridData').datagrid('getSelections'); 
            if (rows.length == 0) {
                $.messager.alert('操作提示', '请选择数据!', 'warning');
                return false;
            }

        
        var bianhao="",jiaolai="",jine=0,beizhu="",zuofeixiang="",weishou="",youhui="",yingshou="";
        var printName="";
        for(var i=0;i<rows.length;i++){ 
            //alert(jinreplace(rows[i].SCL_Real));
            if(rows[i].scl_state=="正常" || removeHTMLTag(rows[i].scl_state)=="0")
            {
                jiaolai+="<span class=xiangmu>" + CostPrintName(rows[i].FK_SC_ID) + "(￥" + formatCurrency(rows[i].SCL_Real) + ");</span>";
                jine=yunshuan(jinreplace(jine),"+",jinreplace(rows[i].SCL_Real));
                weishou=yunshuan(jinreplace(weishou),"+",jinreplace(rows[i].weishou));
                youhui=yunshuan(jinreplace(youhui),"+",jinreplace(rows[i].youhui));
                yingshou=yunshuan(jinreplace(yingshou),"+",jinreplace(rows[i].SS_price));
                if(rows[i].S_Remark!=null && rows[i].S_Remark!="")
                {
                    beizhu+=rows[i].S_Remark + ";"
                }
            }

            if(removeHTMLTag(rows[i].scl_state)=="作废" || removeHTMLTag(rows[i].scl_state)=="1")
            {
                zuofeixiang+="<span style='text-decoration:line-through;'>" + CostPrintName(rows[i].FK_SC_ID) + "(￥" + formatCurrency(rows[i].SCL_Real) + ");</span>"; 
            }

        }
        
        //alert(yingshou);
        if(zuofeixiang!="")
        {
            zuofeixiang="<br /><div><span>作废项：</span>" + zuofeixiang + "</div>";
        }

        jiaolai+=zuofeixiang;

        //alert(jine);
      var shoudao=$("#sname").text() + "&nbsp;(手机:" + $("#stel").text() + "&nbsp;身份证:" + $("#scard").text() + "&nbsp;车型:" + $("#chexing").text() + "&nbsp;推荐人:" + $("#tuijianren").text() + ")";
        //alert(jiaolai);
        //alert(jine);
        //alert(beizhu);
        //获取票据号
        if(isDaishoufei){

                $.ajax({type:"POST",async:false,cache:false,url:"../../ReceiptBill/getPiaoju",data:'sid=2017122609452520593433a7f47d7f5&rbclass=stuDaiShou',success:function(res){
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
                 $("#kaipiaoriqi").text('2018-01-28');//开票日期
         
                 $("#fenxiao2").text($("#fenxiao").text());
                 
                 $("#shoudao").html(shoudao);
                 $("#jiaolai").html(jiaolai);
                 $("#bianhao").text(bianhao);//票据编号
                 $("#daxie").html(convertCurrency(formatCurrency(jine)));
                 $("#beizhu").val(beizhu);
                 //$("#shoujuClass").val("代收费票据");
                 $('#shoufeimodel').dialog("open");
                 $('#printbutton').linkbutton('enable');    //禁用按钮
         }else{
                $.ajax({type:"POST",async:false,cache:false,url:"../../ReceiptBill/getPiaoju",data:'sid=2017122609452520593433a7f47d7f5&rbclass=stuShouru',success:function(res){
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
                 $("#kaipiaoriqi").text('2018-01-28');//开票日期
         
                 $("#fenxiao2").text($("#fenxiao").text());

                 $("#shoudao").html(shoudao);
                 $("#jiaolai").html(jiaolai);
                 $("#bianhao").text(bianhao);//票据编号

                 yingshou=$("#xuefei").text();

                 if(weishou==0 && youhui==0)
                 {
                    //$("#daxie").html("实收"+convertCurrency(formatCurrency(jine)) + "<br />" + "(应收:￥" + formatCurrency(yingshou) + " 实收:￥" + formatCurrency(jine) + " 未收:￥" + formatCurrency(weishou) + " 优惠:￥" + formatCurrency(youhui) +")");
                 $("#daxie").html(convertCurrency(formatCurrency(jine)) + " 小写:￥" +formatCurrency(jine));
                 }
                 if(weishou!=0 && youhui==0)
                 {
                    //$("#daxie").html("实收"+convertCurrency(formatCurrency(jine)) + "<br />" + "(应收:￥" + formatCurrency(jine) + " 实收:￥" + formatCurrency(jine) + " 未收:￥" + formatCurrency(0) + " 优惠:￥" + formatCurrency(0) +")");
                 $("#daxie").html(convertCurrency(formatCurrency(jine)) + " 小写:￥" +formatCurrency(jine));
                 }

                 //if(weishou!=0 && youhui!=0 && weishou==youhui)
                 if(weishou==0 && youhui!=0)
                 {
                    //$("#daxie").html("实收"+convertCurrency(formatCurrency(jine)) + "<br />" + "(应收:￥" + formatCurrency(yingshou) + " 实收:￥" + formatCurrency(jine) + " 未收:￥" + formatCurrency(weishou) + " 优惠:￥" + formatCurrency(youhui) +")");
                 $("#daxie").html(convertCurrency(formatCurrency(jine)) + " 小写:￥" +formatCurrency(jine));
                 }

                 if(weishou!=0 && youhui!=0 && weishou>youhui)
                 {
                    //$("#daxie").html("实收"+convertCurrency(formatCurrency(jine)) + "<br />" + "(应收:￥" + formatCurrency(jine) + " 实收:￥" + formatCurrency(jine) + " 未收:￥" + formatCurrency(weishou-youhui) + " 优惠:￥" + formatCurrency(youhui) +")");
                 $("#daxie").html(convertCurrency(formatCurrency(jine)) + " 小写:￥" +formatCurrency(jine));
                 }
                 $("#daxie").html(convertCurrency(formatCurrency(jine)) + " 小写:￥" +formatCurrency(jine));
                 $("#beizhu").val(beizhu);
                  //$("#shoujuClass").val("学员收费票据");
                 $('#shoufeimodel').dialog("open");
                 $('#printbutton').linkbutton('enable');    //禁用按钮
         }
    }





    var editIndex = undefined;
        function endEditing(){
            if (editIndex == undefined){return true}
           if ($('#yesflexigridData').datagrid('validateRow', editIndex)){
               //var ed = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'FK_SC_ID'});
                //var value = $(ed.target).combobox('getValue');
                //ed.target.combobox('setValue',value);

                //$('#yesflexigridData').datagrid('getRows')[editIndex]['Text'] = Text;
                //alert(ed1.PK_ID);

                //  得到columns对象
                var columns = $('#yesflexigridData').datagrid("options").columns; 
                var rows = $('#yesflexigridData').datagrid("getRows"); // 这段代码是// 对某个单元格赋值
                //var row = $('#yesflexigridData').datagrid("selectRow", lastIndex).datagrid("getSelected");
                //alert(editIndex);
                //row.SS_price="123";
                rows[editIndex][columns[0][4].field]=$(".yingshou").eq(editIndex).text();
                rows[editIndex][columns[0][3].field]=$(".shouzhi").eq(editIndex).text();
                rows[editIndex][columns[0][6].field]=$(".weishou").eq(editIndex).text();
                //var row = $('#yesflexigridData').datagrid("selectRow", editIndex).datagrid("getSelected");

                //$('#yesflexigridData').datagrid('updateRow', row);
               $('#yesflexigridData').datagrid('endEdit', editIndex);
               //alert($(".yingshou").eq(editIndex).text());
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

     /*   function addscid(){
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
                                    ed1.target.combobox('setValue','现金');

                                    var ed2 = $('#yesflexigridData').datagrid('getEditor', {index:editIndex,field:'youhui'});
                                    ed2.target.numberbox('setValue','0.00');
                                    }
                                }

						}
            }
            );
       } */

       		function insert(){

            if (endEditing()){

            var index = 0;

			$('#yesflexigridData').datagrid('insertRow', {
                            index: 0, 
                            row: {
							ck:'true',
							freId:'',
							freClass:'',
							freIncomePay:'',
							shouzhi:'',
							freRealincomeRealpay:'',
							freUnincome:'',
							freDiscount:'',
                            frePaystyle:'现金',
                            S_Remark:'',
                            freState:'待处理'
                            }
						});
               // addscid();
            editIndex =index;
			$('#yesflexigridData').datagrid('selectRow',index);
			$('#yesflexigridData').datagrid('beginEdit',index);
            }
            else
            {
                $.messager.alert('系统提示：','请选择费用','warning');
                return false;
            }
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
      function removeit(){


           if (editIndex == undefined){
                $.messager.alert('系统提示：','请选择一条记录操作！','warning');
                return false;
           }

           var rows = $('#yesflexigridData').datagrid('getSelections');

           if(typeof(rows[0].PK_ID)=="undefined")
            {
                    $('#yesflexigridData').datagrid('cancelEdit', editIndex)
                   .datagrid('deleteRow', editIndex);
                    editIndex = undefined;
            }
            else{
                $.messager.alert('系统提示：','此费用已经生成，不能删除！','info');
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
//                 alert(rows[0].rb_class);
//                 if(rows[0].rb_class=="代收费"){
//                  //$("#shoujuClass").val("代收费票据");
//                 }else{
//                 
//                  $("#shoujuClass").val("学员收费票据");
//                 }
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

        //打印收费单
        function querenprint() { 
        	$("#printbutton").linkbutton("disable");
        	var rows = $('#yesflexigridData').datagrid("getSelections");
        	 var ftDates = $("#kaipiaoriqi").text();//开票日期
             var ftPayee = $("#shoudao").html();//缴款人
             var ftAmount = $("#daxie").html();//实收
             var ftId = $("#bianhao").text();//票据编号
             var ftFenxiao = $("#fenxiao").text();//分校
             var frFendian = $("#fendian").text();//分点
             var ftClass = rows[0].freClass;//分类
             var ftDetail = $("#beizhu").val();
             var ftRise = $("#shoudao").html();
             $.post("/financial/querenprint",{ftDetail:ftDetail,ftDates:ftDates,ftPayee:ftPayee,ftAmount:ftAmount,ftId:ftId,ftFenxiao:ftFenxiao,frFendian:frFendian,ftClass:ftClass,ftRise:ftRise},function(res){
            	 if(res=="OK"){
            		 $.messager.alert('操作提示','票据保存成功','info');
            		 
            		 $('#shoufeimodel').dialog("close");
            		 querenshoufei();
            		 $("#shouju").printArea();
            	 }
             },"json")
        }

//得到柜员牌内保存的第一条记录,然后删除柜员牌内的第一条记录
function on_click_DllGetRecordOnTopAndAutoDelete() {
    var result = getrecord();
    var judgeState = getJudgeState(result);
//    alert(judgeState);
    if (judgeState != "") {
        $.post("../../pingjia_record/JiluPingjia", { judgeState: judgeState, stuid: '2017122609452520593433a7f47d7f5', pingjia_calss: '报名收费' });
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
            scl_pkids=[];

            isbuda="no";
            var DSFrows=[];
            var QTrows=[];
            var isDaiShouFei=false;
            if (endEditing()){
               $('#yesflexigridData').datagrid('acceptChanges');

               //保存修改'getChanges'
            var rows = $('#yesflexigridData').datagrid('getSelections'); 

            if (rows.length == 0) {
                alert("请选择数据!");
                return false;
            }

           


            var freStuId='${stuId}';//学员ID
            var freClass=[];//分类
            var yingshou=[];//应收
            var freRealincomeRealpay=[];//实收
            var freUnincome=[];//未收
            var prePaystyle=[];//付款方式
            var freState=[];//费用状态
            var freDiscount=[];//优惠
            var freShouzhi=[];//收支
            

            var isfukuan=true;
            for(var i=0;i<rows.length;i++)
            {
 
                freClass.push(rows[i].freClass);//分类
                yingshou.push(rows[i].freIncomePay);//应收


                freRealincomeRealpay.push(rows[i].freRealincomeRealpay);//实收
                freUnincome.push(rows[i].freUnincome);//未收
                prePaystyle.push(rows[i].frePaystyle);//付款方式
                freState.push(rows[i].freState);//费用状态
                freDiscount.push(rows[i].freDiscount);//优惠
                freShouzhi.push(rows[i].freShouzhi);//收支
          }
            if (rows.length>0) {
                
                $.post("/financial/saveUpdate",{freStuId:freStuId,freClass:freClass.join(';'),freIncomePay:yingshou.join(';'),freRealincomeRealpay:freRealincomeRealpay.join(';'),
                	freUnincome:freUnincome.join(';'),frePaystyle:prePaystyle.join(';'),freState:freState.join(';'),freDiscount:freDiscount.join(';'),freShouzhi:freShouzhi.join(';')},
                    function(res){
                        if(res=="OK"){
                        $("#yesflexigridData").datagrid("reload");
                        getStuInfo();
                        $.messager.alert('操作提示','保存成功!','info');
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
       }



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


    function tongjifeiyong()
    {
    $.messager.confirm('操作提示', "确认要统计费用吗？", function (r) {
        if(r)
        {
        $.post("../../S_COST_LIST/tongjifeiyong", { stuid: '2017122609452520593433a7f47d7f5' }, function (res) {

                           if (res == "OK") {
                               //移除删除的数据
                               $.messager.alert('操作提示', '操作成功!', 'info');

                               getStuInfo();

                           }
                           else {
                               $.messager.alert('操作提示', res, 'info');
                           }
                       });
        }
    });
        
    }
       }


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
	
	#content123 .line .right1 .xiangmu{display:block; width:300px;}
	
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
       <div title="待处理流水" style="padding:5px;">
            <table id="yesflexigridData" fit="true"></table>
        </div>
       <div title="已收费流水" style="padding:5px;">
            <table id="noflexigridData" fit="true"></table>
       </div>
       <div title="已支出流水" style="padding:5px;">
            <table id="zhichuData" fit="true"></table>
       </div>
       <div title="收费票据列表" style="padding:5px;">
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
        <div class="piaoline"><span>报名分点：</span><span id="fendian"></span></div>
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
 <div id="shoufeimodel" class="easyui-window" title="学员收费单据" data-options="modal:true,closed:true,minimizable:false,collapsible:false,maximizable:false,iconCls:'icon-print'" style="width:800px;height:460px;padding:10px;">
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
	#title1 .left{ display:block;float:left; margin-left:32px; font-size:14px;}
	#title1 .right{ display:block;float:right;margin-right:32px; font-size:14px;}
	
	#content123{ border:#000 1px solid;height:auto; min-height:180px; }
	#content123 .line ul li{ display:block; height:auto;}
	#content123 .line{ overflow:hidden;zoom:1;}
	#content123 .line .left1{ float:left; width:92px; margin-left:15px; line-height:32px; text-align:left;font-size:15px;}
	#content123 .line .right1{ float:right; text-align:left;line-height:23px; padding-top:6px; width:576px; margin-right:10px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;margin-right:10px; font-size:14px}
	#content123 .line .right1 span{ float:left;text-align:left;font-size:14px; }
	#content123 .line .left2{ float:left; width:60px; margin-left:10px; line-height:37px; text-align:left;font-size:14px;}
	#content123 .line .right2{ float:left; text-align:left;line-height:23px; padding-top:6px; border-bottom:#000 1px solid; margin-right:10px; overflow:hidden;zoom:1;font-size:14px;}
	#content123 .textarea{ border:0px; height:30px; width:100%;overflow:auto;background-attachment:fixed;background-repeat:no-repeat;}
	
	#content123 .line .right1 .xiangmu{display:block; width:300px; font-size:14px}
	
	.tishi{height:auto; font-size:10px; line-height:15px; text-align:left; overflow:hidden;zoom:1; margin-top:6px;font-size:10px;}
	.tishi .span1{ display:block; float:left;width:80px;margin-left:30px;font-size:10px;}
	.tishi .span2{ display:block; float:left;width:566px;font-size:10px;}
	.width100{ width:100px;}
	.textarea{ font-size:12px; color:#000; font-weight:800;}
	#content123 .line .noneline{ border-bottom:0px;}
</style>
	<div id="title" ><span id="shoujutitle">收款凭据</span></div>
    <div id="content">
    	<ul>
        	
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
                            <li class="right1" id="jiaolai"> </li>
                        </ul>
                    </div>
                    <div class="line">
                        <ul>
                            <li class="left1">合计(大写)：</li>
                            <li class="right1" id="daxie">&nbsp;</li>
                        </ul>
                    </div>
                    <div id="divyuyue">
                    </div>
                    <div class="line">
                        <ul>
                            <li class="left1">单位公章：</li>
                            <li class="left2">制单人：</li>
                            <li class="right2" id="zhidanren">王新超 (<span id="fenxiao2"></span>)</li>
                            <li class="left2">收款人：</li>
                            <li class="right2" id="shoukuanren">王新超</li>
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
    <object classid="clsid:DE7E4ED4-BB95-457B-BDBA-43F6DEF595EE" id="AppOcx" width="0" height="0"></object>
</body>
</html>
