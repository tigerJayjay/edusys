//接收
function getQueryString(name) {  
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
var r = window.location.search.substr(1).match(reg); 
if (r != null) return unescape(r[2]);return null; 
}

//费用显示
        function checkDisplay() {
            var SC_displayStr = "";
            var check = document.getElementsByName("checkdisplay");
         var SC_displayObj=   document.getElementById("SC_display");
        for (var i = 0; i < check.length; i++) {
            var DisplayVal = "";
            if (check[i].checked == true) {
                DisplayVal = "1";
               
            } else {
                DisplayVal = "0";
            }

            SC_displayStr = SC_displayStr + "," + DisplayVal;
        }
        SC_displayObj.value = SC_displayStr;
        } 
		
		
		
function dateConvert(value) {
    var reg = new RegExp('/', 'g');
    var d = eval('new ' + value.replace(reg, ''));
    return new Date(d).format('yyyy-MM-dd')
}
$(function () {
    //时间格式化
    Date.prototype.format = function (format) {
        /*
        * eg:format="yyyy-MM-dd hh:mm:ss";
        */
        if (!format) {
            format = "yyyy-MM-dd hh:mm:ss";
        }

        var o = {
            "M+": this.getMonth() + 1, // month
            "d+": this.getDate(), // day
            "h+": this.getHours(), // hour
            "m+": this.getMinutes(), // minute
            "s+": this.getSeconds(), // second
            "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
            "S": this.getMilliseconds()
            // millisecond
        };

        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        }

        for (var k in o) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    };
    $.extend($.fn.datagrid.methods, {

        addToolbarItem: function (jq, items) {

            return jq.each(function () {

                var toolbar = $(this).parent().prev("div.datagrid-toolbar");

                for (var i = 0; i < items.length; i++) {

                    var item = items[i];
                    var btn = $("<a href=\"javascript:void(0)\"></a>");
                    btn[0].onclick = eval(item.handler || function () { });
                    btn.css("float", "left").appendTo(toolbar).linkbutton($.extend({}, item, { plain: true }));
                }
                toolbar = null;

            });

        },

        removeToolbarItem: function (jq, param) {

            return jq.each(function () {
                var btns = $(this).parent().prev("div.datagrid-toolbar").children("a");
                var cbtn = null;
                if (typeof param == "number") {
                    cbtn = btns.eq(param);
                } else if (typeof param == "string") {

                    var text = null;
                    btns.each(function () {
                        text = $(this).data().linkbutton.options.text;
                        if (text == param) {
                            cbtn = $(this);
                            text = null;
                            return;
                        }
                    });
                }

                if (cbtn) {
                    var prev = cbtn.prev()[0];
                    var next = cbtn.next()[0];
                    if (prev && next && prev.nodeName == "DIV" && prev.nodeName == next.nodeName) {
                        $(prev).remove();
                    } else if (next && next.nodeName == "DIV") {
                        $(next).remove();
                    } else if (prev && prev.nodeName == "DIV") {
                        $(prev).remove();
                    }
                    cbtn.remove();
                    cbtn = null;
                }
            });
        }
    });
})
function isNumber(id) {

    if (isNaN(Number(id.value))) {

        alert("非法数字");
        id.value = "";

    }
}
//多级联动
function bindDropDownList(id, parentid) {

    if ($(parentid).val() != "") {

        var url = "/Home/GetSysFieldByParent";
        $.ajaxSetup({ cache: false });
        $.getJSON(url, { id: id.substring(1), parentid: parentid.substring(1), value: $(parentid).val() }, function (data) {
            if (data == null) {
                return;
            }
            $.each(data, function (i, item) {
                if (item == null) {
                    return;
                }
                $("<option></option>")
                        .val(item["Value"])
                        .text(item["Text"])
                        .appendTo($(id));
            });
        });
    }
}
 

//function menuClick(url) {
//    if (url == "undefined" || url == "") { return; }
//    $("#frmMain").attr("src", '../../' + url);
//    return;
//}
//function getclick(ok) {
//}
//function GetEyeSize() {
//    return { width: document.documentElement.clientWidth, height: document.documentElement.clientHeight };
//}
//IFrame 调用页面后, 自动适应高度的代码.SetWinHeight(this);

function deleteTable(table, hidden) { //删除table和隐藏的值
    var tableId = document.getElementById(table); //获取表格
    tableId.parentNode.removeChild(tableId); //删除table
    // tableId.style.display = "none";//table隐藏isNaN(Number())
    var hiddenValue = document.getElementById(hidden); //获取隐藏的控件

    //  hiddenValue.value+="";

    if (hiddenValue.value.indexOf(table) > -1) {
        hiddenValue.value = hiddenValue.value.replace(table, ""); //为隐藏控件赋值
    }
}
function deleteTableTr(obj,tableTr, hidden) { //删除table和隐藏的值
   // var TrId = document.getElementById(tableTr); //获取表格
 var TrId = obj; //获取表格
    TrId.parentNode.removeChild(TrId); //删除table
    // tableId.style.display = "none";//table隐藏isNaN(Number())
    var hiddenValue = document.getElementById(hidden); //获取隐藏的控件
    //  hiddenValue.value+="";

    if (hiddenValue.value.indexOf(tableTr) > -1) {
        hiddenValue.value = hiddenValue.value.replace(tableTr, ""); //为隐藏控件赋值
    }
}
//
//申请费用
function   showModalApp(me, url, dialogWidth,dialogHeight,callback) {       // 学员费用
	if (dialogWidth == null || dialogWidth == "undefined" || dialogWidth == "") {
      dialogWidth = 968;
   }
	if (dialogHeight == null || dialogHeight == "undefined" || dialogHeight == "") {
       dialogWidth = 500;
    }
    var reValue = window.showModalDialog(url+'?rd='+Math.random(), window, "dialogHeight:"+dialogHeight+"px; dialogWidth:" + dialogWidth + "px;  status:off; scroll:auto;location:yes;status:yes");
    if (reValue == null || reValue == "undefined" || reValue == "") {
        return; //如果返回值为空，就返回
    }
	if(reValue=='yes'){
		window.location.reload(); 
		}
	
}
function showModalMany(me, url, dialogWidth,callback) { //弹出窗体，多选   
    if (dialogWidth == null || dialogWidth == "undefined" || dialogWidth == "") {
        dialogWidth = 968;
    }
    var reValue = window.showModalDialog(url, window, "dialogHeight:500px; dialogWidth:" + dialogWidth + "px;  status:off; scroll:auto");

    if (reValue == null || reValue == "undefined" || reValue == "") {
        return; //如果返回值为空，就返回
    }
	
	
    var index = reValue.split("^"); //分割符 ^ 的位置
    if (index[0] == null || index[0] == "undefined" || index[0].length < 1) {
        return;
    }
    var hid = index[0].split('&'); //为隐藏控件赋值
    var view = index[1].split('&'); //显示值
    var content = ""; //需要添加到check中的内容
    var h = "";
    for (var i = 0; i < hid.length - 1; i++) {
        if (hid[i] != "undefined" && hid[i] != "" && view[i + 1] != "undefined" && view[i + 1] != "") {
            
			var tableId = document.getElementById(hid[i] + "&" + view[i + 1]); //获取表格
			if(tableId==null)
			{
			h += "^" + hid[i] + "&" + view[i + 1];
            content += '<table  id="' + hid[i] + "&" + view[i + 1] + '" class="deleteStyle"><tr><td><img src="../../../Images/deleteimge.png" title="点击删除"  alt="删除" onclick=" deleteTable(' + "'" + hid[i] + "&" + view[i + 1] + "'," + "'" + me + "'" + ');" /></td><td>' + view[i + 1] + '</td></tr></table>';
			}
        }
    }
    var hidden = document.getElementById(me); //获取隐藏的控件
    hidden.value += h; //为隐藏控件赋值
    var c = document.getElementById("check" + me);
    c.innerHTML += content;
	if(callback!=null)
	{
		callback()
	}
}
function showModalManyInput(me, url, dialogWidth,callback) { //弹出窗体，多选    Input文本框
    if (dialogWidth == null || dialogWidth == "undefined" || dialogWidth == "") {
        dialogWidth = 968;
    }
    var reValue = window.showModalDialog(url, window, "dialogHeight:500px; dialogWidth:" + dialogWidth + "px;  status:off; scroll:auto");

    if (reValue == null || reValue == "undefined" || reValue == "") {
        return; //如果返回值为空，就返回
    }
	
    var index = reValue.split("^"); //分割符 ^ 的位置
    if (index[0] == null || index[0] == "undefined" || index[0].length < 1) {
        return;
    }
    var hid = index[0].split('&'); //为隐藏控件赋值
    var view = index[1].split('&'); //显示值
	var SC_DVALUE=index[2].split('&'); //默认值
	var SC_price=0;
	
    var content = ""; //需要添加到check中的内容
    var h = "";
    for (var i = 0; i < hid.length - 1; i++) {
        if (hid[i] != "undefined" && hid[i] != "" && view[i + 1] != "undefined" && view[i + 1] != "") {
             if (SC_DVALUE[i+1] == null || SC_DVALUE[i+1] == "undefined" || SC_DVALUE[i+1].length < 1) {
				 SC_price=0;
				 }else{
					  SC_price=SC_DVALUE[i+1];
					 }
			var tableId = document.getElementById(hid[i] + "&" + view[i + 1]); //获取表格
			if(tableId==null)
			{
			h += "^" + hid[i] + "&" + view[i + 1];
            content += '<table  id="' + hid[i] + "&" + view[i + 1] + '" class="deleteStyle"><tr><td><img src="../../../Images/deleteimge.png" title="点击删除"  alt="删除" onclick=" deleteTable(' + "'" + hid[i] + "&" + view[i + 1] + "'," + "'" + me + "'" + ');" /></td><td >' + view[i + 1] + '</td><td width="85px"  align="right"> <input id="SC_price'+ hid[i]+'" name="SC_price'+ hid[i]+'" type="text"  value="'+SC_price+'" style="width:50px" />元 </td></tr></table>';
			
			//document.getElementById("SC_price"+hid[i]+"").value=SC_DVALUE[i];
			}
        }
    }
    var hidden = document.getElementById(me); //获取隐藏的控件
    hidden.value += h; //为隐藏控件赋值
    var c = document.getElementById("check" + me);
    c.innerHTML += content;
	if(callback!=null)
	{
		callback()
	}
}
function showModalManyShouldInput(me, url, dialogWidth,callback) { //弹出窗体，多选    学员缴费文本框
    if (dialogWidth == null || dialogWidth == "undefined" || dialogWidth == "") {
        dialogWidth = 968;
    }
    var reValue = window.showModalDialog(url+'&rd='+Math.random(), window, "dialogHeight:500px; dialogWidth:" + dialogWidth + "px;  status:off; scroll:auto");
 
    if (reValue == null || reValue == "undefined" || reValue == "") {
        return; //如果返回值为空，就返回
    }
	
    var index = reValue.split("^"); //分割符 ^ 的位置
    if (index[0] == null || index[0] == "undefined" || index[0].length < 1) {
        return;
    }
    var hid = index[0].split('&'); //为隐藏控件赋值
    var view = index[1].split('&'); //显示值
	var SC_DVALUE=index[2].split('&'); //默认值
	var SC_typeArr=index[3].split('&'); //收支
	var SC_price=0;
	var SC_type="";//收支
	var SC_typeVal="";//收支
	var Totalprice=0;
    var content = ""; //需要添加到check中的内容
    var h = "";
    for (var i = 0; i < hid.length - 1; i++) {
        if (hid[i] != "undefined" && hid[i] != "" && view[i + 1] != "undefined" && view[i + 1] != "") {
             if (SC_DVALUE[i+1] == null || SC_DVALUE[i+1] == "undefined" || SC_DVALUE[i+1].length < 1) {
				 SC_price=0;
				 }else{
					  SC_price=SC_DVALUE[i+1];
					 }
					 SC_typeVal=SC_typeArr[i+1];
					
			//var tableId = document.getElementById(hid[i] + "&" + view[i + 1]); //获取表格
			//if(tableId==null)
			//{
				var c = document.getElementById("check" + me);
				var rowDefault=parseInt(document.getElementById("rowDefault").value);//值唯一
				
				 var rows=c.rows.length+1;//行数
				  var hidTitle= hid[i]+"~"+String(rowDefault);//pk_id
				  
				 var ViewItle= view[i + 1];//名称
				 var ViewItleStr= hidTitle +"&"+ViewItle;
				newline=c.insertRow();
				
			h += "^" + hidTitle + "&" + ViewItle+rowDefault;
			//newline.id=ViewItleStr;
			newline.insertCell(0).setAttribute("bgcolor","#FFFFFF");
			newline.insertCell(1).setAttribute("bgcolor","#FFFFFF");
			newline.insertCell(2).setAttribute("bgcolor","#FFFFFF");
			//'onclick=" deleteTable(' + "'" + hid[i] + "&" + view[i + 1] + "'," + "'" + me + "'" + ');"'
			newline.insertCell(0).innerHTML='<img src="../../../Images/deleteimge.png" title="点击删除"  alt="删除" onclick=" deleteTableTr(this.parentNode.parentNode,'+"'"+ViewItleStr+"',"+"'"+ me+"'"+');" />';
	    if (SC_typeVal == "支")
        {
            SC_type = '<font color="#FF0000" >' + SC_typeVal + '</font>';
		}else{
			 SC_type=SC_typeVal;
			}
		 //alert(SC_typeVal);
			newline.insertCell(1).innerHTML=ViewItle+'('+SC_type+')';
			newline.insertCell(2).innerHTML='<input type="hidden" id="SC_type'+hidTitle+'" name="SC_type'+hidTitle+'" value="'+ SC_typeVal+'" /><input id="SC_price'+ hidTitle+'" name="SC_price'+ hidTitle+'" type="text"  value="'+SC_price+'" style="width:50px" />元';
			newline.insertCell(3).innerHTML='0';
			newline.insertCell(4).innerHTML='0';
			newline.insertCell(5).innerHTML='<input id="S_Remark'+ hidTitle+'" name="S_Remark'+ hidTitle+'" type="text"  value="" style="width:50px" />';;
			//document.getElementById("SC_price"+hid[i]+"").value=SC_DVALUE[i];
		//	}
		document.getElementById("rowDefault").value=(rowDefault+1);
        }
    }
    var hidden = document.getElementById(me); //获取隐藏的控件
    hidden.value += h; //为隐藏控件赋值
  //  var c = document.getElementById("check" + me);
   // c.outerHTML += content;
	if(callback!=null)
	{
		callback()
	}
}
function showTreeOnlyEdit(me, url) { //弹出窗体 ,单选
    var hidden = document.getElementById(me); //获取隐藏的控件
    if (hidden.value != null && hidden.value.length > 0) {
        alert("此处为单选，请先删除已有的选项，再次尝试选择。");
        return;
    }
    var reValue = window.showModalDialog(url, window, "dialogHeight:500px; dialogWidth:987px;  status:off; scroll:auto");

    if (reValue == null || reValue == "undefined" || reValue == "") {
        return; //如果返回值为空，就返回
    }
    var index = reValue.split("&"); //分割符 ^ 的位置
    if (index[0] == null || index[0] == "undefined" || index[0].length < 1) {
        return;
    }
    if (index[1] == null || index[1] == "undefined" || index[1].length < 1) {
        return;
    }
    var hid = index[0]; //为隐藏控件赋值
    var view = index[1]; //显示值
    var content = ""; //需要添加到check中的内容

    var href = window.location.href;
    var ref = href.substr(href.lastIndexOf('/') + 1);

    if (hid != null) {
        if (ref == hid) {
            alert("请不要选择同一条数据。");
            return;
        }
        if (hid != "undefined" && hid != "" && view != "undefined" && view != "") {

            content += '<table  id="' + hid + "&" + view
            + '" class="deleteStyle"><tr><td><img src="../../../Images/deleteimge.png" title="点击删除"  alt="删除" onclick=" deleteTable('
            + "'" + hid + "&" + view
             + "'," + "'" + me + "'" + ');" /></td><td>' + view
              + '</td></tr></table>';

            hidden.value = hid; //为隐藏控件赋值
            var c = document.getElementById("check" + me);
            c.innerHTML += content;
            return;
        }
    }
    alert("请只选择一条数据。");
    return;
}
//上传照片 
function showModalUploaderPic(me, url, dialogWidth, dialogHeight, callback) {

    //alert("aaaaaaaa");
	if (dialogWidth == null || dialogWidth == "undefined" || dialogWidth == "") {
        dialogWidth = 968;
    }
	if (dialogHeight == null || dialogHeight == "undefined" || dialogHeight == "") {
        dialogWidth = 500;
    }
    var reValue = window.showModalDialog(url, window, "dialogHeight:"+dialogHeight+"px; dialogWidth:" + dialogWidth + "px;  status:off; scroll:auto;location:yes;status:yes");

    if (reValue == null || reValue == "undefined" || reValue == "") {
        return; //如果返回值为空，就返回
    }
	
	var Img= document.getElementById("Img" + me);
	Img.src=reValue;
	
	var hidden=document.getElementById(me);
		hidden.value = reValue;
	if(callback!=null)
	{
		callback()
	}
	}
function showModalOnly(me, url) { //弹出窗体 ,单选
    var hidden = document.getElementById(me); //获取隐藏的控件
    if (hidden != null && hidden.value != null && hidden.value.length > 0) {
        alert("此处为单选，请先删除已有的选项，再次尝试选择。");
        return;
    }
    var reValue = window.showModalDialog(url, window, "dialogHeight:500px; dialogWidth:987px;  status:off; scroll:auto");

    if (reValue == null || reValue == "undefined" || reValue == "") {
        return; //如果返回值为空，就返回
    }
    var index = reValue.split("^"); //分割符 ^ 的位置
    if (index[0] == null || index[0] == "undefined" || index[0].length < 1) {
        return;
    }
    var hid = index[0].split('&'); //为隐藏控件赋值
    var view = index[1].split('&'); //显示值
    var content = ""; //需要添加到check中的内容

    if (hid != null && hid.length == 2) {
        var i = 0;

        if (hid[i] != "undefined" && hid[i] != "" && view[i + 1] != "undefined" && view[i + 1] != "") {

            content += '<table  id="' + hid[i]
            + '" class="deleteStyle"><tr><td><img src="../../../Images/deleteimge.png" title="点击删除"  alt="删除" onclick=" deleteTable('
            + "'" + hid[i] + "'," + "'" + me + "'" + ');" /></td><td>' + view[i + 1] + '</td></tr></table>';

            hidden.value = hid[i]; //为隐藏控件赋值
            var c = document.getElementById("check" + me);
            c.innerHTML += content;
            return;
        }
    }
    alert("请只选择一条数据。");
    return;
}

function isInt(t) {
    t.value = t.value.replace(/[^0-9]/g, '')
}
//必需是整数
function isInter(str){
 if(str==""){
	 return false;
	 }
	 if(!(/(^[1-9]\d*$)/.test(str))){
		 	 return false;
		 
		 }
return true;
}

function dia() {
    if ($("#dialo").dialog("isOpen")) {
        $("#dialo").dialog({
            autoOpen: true,

            buttons: {
                "确定": function () {
                    $("#dialo").dialog("close");
                }
            }
        });
    }
}
function BackList(url) {

    window.location.href =  url;
}
function manyTreeChecked(node, checked, hidControl, treeId) {
    var hidArr = $('#' + hidControl).val().split(',');
    //debugger;
    //alert(hidArr.join(','));
    if (checked) {
        hidArr.push(node.id);
        var nodeChildren = $('#' + treeId).tree("getChildren", node.target);
        if (nodeChildren != null) {
            for (var i = 0; i < nodeChildren.length; i++) {
                treeChecked(nodeChildren[i].id,treeId,"tree-checkbox1");
                hidArr.push(nodeChildren[i].id);
            }
        }
    }
    else {
        //debugger;
        for (var i = 0; i < hidArr.length; i++) {
            if (hidArr[i] == node.id) {
                hidArr.splice(i, 1);
            }
        }
        var nodeChildren = $('#' + treeId).tree("getChildren", node.target);
        if (nodeChildren != null) {
            for (var i = 0; i < nodeChildren.length; i++) {
                treeChecked(nodeChildren[i].id, treeId, "tree-checkbox0");
                for (var j = 0; j < hidArr.length; j++) {
                    if (hidArr[j] == nodeChildren[i].id) {
                        hidArr.splice(j, 1);
                    }
                }
            }
        }
    }
    $('#' + hidControl).val(hidArr.join(','));
}
function bindmanyTreeChecked(checkData, hidControl, treeId) {
    if (checkData == null || checkData == "" || checkData == "undefined") {
        return;
    }
    var menuids = checkData.split(',');
    var hidArr = $('#' + hidControl).val().split(',');
    for (i = 0; i < menuids.length; i++) {
        treeChecked(menuids[i], treeId, "tree-checkbox1");
        hidArr.push(menuids[i]);
    }
    $('#' + hidControl).val(hidArr.join(','));
}
function bindSonTreeChecked(oldData, newData, treeId) {
    if (oldData == null || oldData == "" || oldData == "undefined") {
        return;
    }
    var menuids = oldData.split(',');
    var sonids = newData.split(',');
    for (i = 0; i < menuids.length; i++) {
        for (j = 0; j < sonids.length; j++) {
            if (menuids[i] == sonids[j]) {
                treeChecked(menuids[i], treeId, "tree-checkbox1");
                break;
            }
        }
    }
}
function treeChecked(node, treeId, className) {
    var nodeid = $("#" + treeId).tree("find", node);
    if (nodeid) {
        var ck = $(nodeid.target).find('.tree-checkbox');
        ck.removeClass("tree-checkbox0 tree-checkbox1 tree-checkbox2");
        ck.addClass(className);
    }
}


function progressComm() {
    var win = $.messager.progress({
        title: '请等待',
        text: '数据正在提交中'
    });
}
