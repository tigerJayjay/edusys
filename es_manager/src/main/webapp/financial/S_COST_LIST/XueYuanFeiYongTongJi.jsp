<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head id="MyHead">
<script src="/resources/Scripts/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<script src="/resources/Scripts/jquery.easyui.min-1.3.5.js"
	type="text/javascript"></script>
<script src="/resources/Scripts/jquery.datagrid.js"
	type="text/javascript"></script>
<script src="/resources/Scripts/JScriptIndex.js" type="text/javascript"></script>
<link href="/resources/Content/Default.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/Content/IndexStyle.css" rel="stylesheet"
	type="text/css" />

<link href="/resources/Res/easyui/themes/icon.css" rel="stylesheet"
	type="text/css" />
<script src="/resources/Res/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<link href="/resources/Res/easyui/themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<title>学员费用统计</title>
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
	$(function() {
		$
				.extend(
						$.fn.datagrid.methods,
						{
							addToolbarItem : function(jq, items) {
								return jq
										.each(function() {
											var dpanel = $(this).datagrid(
													'getPanel');
											var toolbar = dpanel
													.children("div.datagrid-toolbar");
											if (!toolbar.length) {
												toolbar = $(
														"<div class=\"datagrid-toolbar\"><table cellspacing=\"0\" cellpadding=\"0\"><tr></tr></table></div>")
														.prependTo(dpanel);
												$(this).datagrid('resize');
											}
											var tr = toolbar.find("tr");
											for (var i = 0; i < items.length; i++) {
												var btn = items[i];
												if (btn == "-") {
													$(
															"<td><div class=\"datagrid-btn-separator\"></div></td>")
															.appendTo(tr);
												} else {
													var td = $("<td></td>")
															.appendTo(tr);
													var b = $(
															"<a href=\"javascript:void(0)\"></a>")
															.appendTo(td);
													b[0].onclick = eval(btn.handler
															|| function() {
															});
													b.linkbutton($.extend({},
															btn, {
																plain : true
															}));
												}
											}
										});
							},
							removeToolbarItem : function(jq, param) {
								return jq
										.each(function() {
											var dpanel = $(this).datagrid(
													'getPanel');
											var toolbar = dpanel
													.children("div.datagrid-toolbar");
											var cbtn = null;
											if (typeof param == "number") {
												cbtn = toolbar.find("td").eq(
														param).find(
														'span.l-btn-text');
											} else if (typeof param == "string") {
												cbtn = toolbar
														.find("span.l-btn-text:contains('"
																+ param + "')");
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
	$(function() {
		$("#fenxiaoID")
				.combobox(
						{
							editable : false,
							onSelect : function(record) {

								$
										.ajax({
											type : "POST",
											url : '../SysPerson/getSelData/@table=StudentSource&colum=models&pid='
													+ record.value,
											dataType : 'json',
											success : function(jsonstr) {
												// 修改ajax返回的值
												jsonstr.push({
													'id' : '',
													'text' : '全部',
													"selected" : true
												});
												$("#fendianID").combobox({
													data : jsonstr,
													panelHeight : 'auto',
													editable : true,
													valueField : 'id',
													textField : 'text'
												});
											}
										});
							}
						});
		$("#S_laiyuan").combobox(
				{
					onSelect : function(record) {
						//alert(record.value);
						var url = '../S_Employees/getS_Employees/@zubieID='
								+ record.value;
						//alert(url);
						$("#S_TuiJianRen").combobox({
							url : url,
							valueField : 'id',
							textField : 'text'
						}).combobox('clear');
						//$('#S_TuiJianRen').combobox('select', "请选择");
					}
				});
		$('#flexigridData').datagrid({
			//title: '学员', //列表的标题
			iconCls : 'icon-site',
			width : 'auto',
			height : 'auto',
			nowrap : true,
			striped : true,
			collapsible : true,
			url : '/financial/getStatistics', //获取数据的url
			sortName : 'PK_ID',
			sortOrder : 'desc',
			idField : 'PK_ID',
			singleSelect : true,
			toolbar : "#yesSearch",
			columns : [ [

			{
				field : 'stuId',
				title : '学员编号',
				width : 150,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'stuName',
				title : '姓名',
				width : 100,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'stuCardId',
				title : '身份证号',
				width : 180,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'shouldIncome',
				title : '应收',
				width : 80,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'actualIncome',
				title : '实收',
				width : 80,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'arrearage',
				title : '欠费',
				width : 80,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'expenditure',
				title : '支出',
				width : 80,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'returnFee',
				title : '退费',
				width : 80,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'fenxiao',
				title : '报名分校',
				width : 150,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			}, {
				field : 'fendian',
				title : '报名分点',
				width : 150,
				align : 'center',
				styler : function(value, row, index) {
					return '';
				}
			} ] ],
			pageList : [ 10, 50, 100 ],
			pagination : true,
			pagePosition:"top",
			rownumbers : true

		});

	});

	function flexiArchives() {
		var rows = $('#flexigridData').datagrid('getSelections');
		if (rows.length != 1) {
			$.messager.alert('操作提示', '请选择一条数据!', 'warning');
			return false;
		}
		parent.addTab("档案:" + rows[0].S_name, "../S_Archives/IndexNew/"
				+ rows[0].PK_ID + "?rd=" + Math.random(), "tu1001", true,
				rows[0].PK_ID);

	}
	function flexiQuery() {
		var str = "yes"
		search1 = '';

		var wordvalue = document.getElementById(str + "wordvalue").value; //关键字
		var searchType = $("#" + str + "searchType").combobox("getValue"); //查询条件

		var fenxiaoID = $("#fenxiaoID").combobox("getValue");
		var fendianID = $("#fendianID").combobox("getText");

		if (wordvalue != "") {
			search1 += searchType + ":" + wordvalue + ","
		}

		if (fenxiaoID != "") {
			search1 += "fenxiao:" + fenxiaoID + ",";
		}

		if (fendianID != "") {
			search1 += "fendian:" + fendianID + ",";
		}

		var shifouqianfei = $("#shifouqianfei").combobox("getValue");
		if (shifouqianfei != "") {
			search1 += "shifouqianfei:" + shifouqianfei + ",";
		}
		$('#flexigridData').datagrid('reload', {
			searchCondition : search1
		});
	}
	//“导出EXCEL”按钮     在6.0版本中修改
	function flexiExport() {

		$.messager
				.confirm(
						'操作提示',
						"确认要导出EXCEL！",
						function(r) {

							if (r) {
								progress();
								var str = "yes"
								search1 = '';

								var wordvalue = document.getElementById(str
										+ "wordvalue").value; //关键字

								var S_regdateStart_Time = document
										.getElementById(str
												+ "S_regdateStart_Time").value; //关键字
								var S_regdateEnd_Time = document
										.getElementById(str
												+ "S_regdateEnd_Time").value; //关键字

								var searchType = $("#" + str + "searchType")
										.combobox("getValue"); //查询条件

								var fenxiaoID = $("#fenxiaoID").combobox(
										"getValue");
								var fendianID = $("#fendianID").combobox(
										"getValue");

								if (wordvalue != "") {
									search1 += searchType + "&" + wordvalue
											+ "^"
								}
								//修改财务审核完继续在学员界面显示
								//            else{
								//                search1 +="S_FinanAuditStart_Int&1^S_FinanAuditEnd_Int&2^";
								//            }

								if (S_regdateStart_Time != "") {
									search1 += "S_regdateStart_Time&"
											+ S_regdateStart_Time + "^"
								}
								if (S_regdateEnd_Time != "") {
									search1 += "S_regdateEnd_Time&"
											+ S_regdateEnd_Time + "^"
								}

								if (fenxiaoID != "") {
									search1 += "FK_DIC_from&" + fenxiaoID + "^";
								}

								if (fendianID != "") {
									search1 += "FenXiaoBuMenId&" + fendianID
											+ "^";
								}

								var S_laiyuan = $("#S_laiyuan").combobox(
										"getValue");
								var S_TuiJianRen = $("#S_TuiJianRen").combobox(
										"getValue");
								var S_Carmodels = $("#S_Carmodels").combobox(
										"getValue");

								if (S_laiyuan != "") {
									search1 += "S_laiyuan&" + S_laiyuan + "^";
								}

								if (S_TuiJianRen != "") {
									search1 += "S_TuiJianRen&" + S_TuiJianRen
											+ "^";
								}

								if (S_Carmodels != "") {
									search1 += "S_Carmodels&" + S_Carmodels
											+ "^";
								}

								if (search1 != "") {
									search1 += "FK_DIC_Start&noway^allstu";
								} else {
									search1 += "FK_DIC_Start&noway^";
								}
								//将查询条件按照分隔符拼接成字符串

								//            $('#divQuery').find(":text,:selected,select,textarea,:hidden,:checked,:password").each(function () {
								//                search = search + this.id + "&" + this.value + "^";
								//            });

								var p = $('#flexigridData').datagrid('options').columns[0];
								var p0 = $('#flexigridData')
										.datagrid('options').frozenColumns[0];
								var field = []; //所有的列名
								var title = []; //所有的标题名称

								//alert(p0.lenth);

								$(p0).each(function() {
									if (this.title != null) {
										field.push(this.field);
										title.push(this.title);
									}

								});

								$(p).each(function() {
									if (this.title != null) {
										field.push(this.field);
										title.push(this.title);
									}

								});
								//alert(search1);
								var titlestr = removeHTMLTag(title.join(","))
								//alert(titlestr);
								//alert(field.join(","));
								$.post("../A_Report/fenxiExport1", {
									title : titlestr,
									field : field.join(","),
									sortName : $('#flexigridData').datagrid(
											'options').sortName,
									sortOrder : $('#flexigridData').datagrid(
											'options').sortOrder,
									search : search1
								}, function(res) {
									//alert(res);
									$.messager.progress('close');
									window.location.href = res;
								});
							}

						});
	}
	function progress() {
		var win = $.messager.progress({
			title : '请等待',
			text : '数据正在处理中'
		});
	}
</script>
<script src="/resources/Res/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

<base target="_self">
</head>
<body class="easyui-layout" style="padding: 3px;">
	<table id="flexigridData" fit="true">
	</table>


	<div id="yesSearch" style="padding: 5px; height: auto">
		<div>
			查询条件：<select class="easyui-combobox" panelHeight="auto"
				id="yessearchType" style="width: 80px;">
				<option value="stuCardId">身份证号</option>
				<option value="stuName">学员姓名</option>
				<option value="stuId">学员编号</option>
				<option value="stuRecoderId">档案编号</option>
			</select> &nbsp;关&nbsp;&nbsp;键&nbsp;字：<input class="input-textbox"
				id="yeswordvalue" style="width: 80px" /> &nbsp;是否欠费：<select
				class="easyui-combobox" data-val="true" id="shifouqianfei"
				name="jdqf" style="width: 100px;">
				<option value="" selected="selected">请选择</option>
				<option value="shi">是</option>
				<option value="fou">否</option>
			</select> 报名分校：<select class="easyui-combobox" id="fenxiaoID" name="fenxiaoID"
				style="width: 80px;"><option value="">请选择</option>
				<option value="分校一">分校一</option>
				<option value="分校二">分校二</option>
				<option value="分校三">分校三</option>
				<option value="分校四">分校四</option>
			</select> &nbsp;报名分点：<select class="easyui-combobox" data-val="true"
				data-val-length="长度不可超过50" data-val-length-max="50" id="fendianID"
				name="fendianID" style="width: 100px;">
				<option value="分点一">分点一</option>
				<option value="分点二">分点二</option>
				<option value="分点三">分点三</option>
				<option value="分点四">分点四</option>
				</select> <a
				href="javascript:void(0);" onclick="flexiQuery();"
				class="easyui-linkbutton" iconCls="icon-search">查询</a> &nbsp;<a
				href="javascript:exports();" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'">导出EXCEL</a>
			<form id="exportdiv" method="post" action="/financial/export">
				<input type="hidden" name="json" id="json"> <input
					type="hidden" name="title" id="title">
			</form>
		</div>
	</div>




</body>
</html>
