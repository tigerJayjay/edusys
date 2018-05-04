//接收
function getQueryString(name) {  
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
var r = window.location.search.substr(1).match(reg); 
if (r != null) return unescape(r[2]); return ''; 
}
function   showModalShould(me, url, dialogWidth,dialogHeight,callback) {       // 学员费用
	//if (dialogWidth == null || dialogWidth == "undefined" || dialogWidth == "") {
     //   dialogWidth = 968;
  //  }
	//if (dialogHeight == null || dialogHeight == "undefined" || dialogHeight == "") {
      //  dialogWidth = 500;
   // }
   // var reValue = window.showModalDialog(url, window, "dialogHeight:"+dialogHeight+"px; dialogWidth:" + dialogWidth + "px;  status:off; scroll:auto;location:yes;status:yes");
 showWindow("学员收费", url, dialogWidth, dialogHeight, true, false,true);
	
}

function photos(value){
	if(value != null && value != "undefined" && value!=""){
		if(value.indexOf(".")<0){
			return "<div class=\"thumb\"><img id=\"ImgS_photos\" src=\"../templates/Default/DefaultHead.gif\"  width=\"10\" height=\"12\" style=\"border:0px; cursor:hand\"  /></div>";
			}else{
		return "<div class=\"thumb\"><img id=\"ImgS_photos\" src=\"" +value + "\"   width=\"10\" height=\"12\"  style=\"border:0px; cursor:hand\"  /></div>";
			}
		}else{
			
			return "<div class=\"thumb\"><img id=\"ImgS_photos\" src=\"../templates/Default/DefaultHead.gif\"   width=\"10\" height=\"12\"  style=\"border:0px; cursor:hand\"  /></div>";
			}
}
//日期
function dateConvert(value) {
    //alert(value);
    /*if (value != null && value != "undefined" && value != "null" && value != "NULL") {
        var reg = new RegExp('/', 'g');
        var d = eval('new ' + value.replace(reg, ''));

        return new Date(d).format('yyyy-MM-dd');
    }
    else {
        return "";
    }*/
	if (value == null || value == '') {  
        return '';  
    }  
    var dt;  
    if (value instanceof Date) {  
        dt = value;  
    } else {  
        dt = new Date(value);  
    }  
  
    return dt.format("yyyy-MM-dd");

}
//时间
function dateConvert1(value) {
    //alert(value);
    /*if (value != null && value != "undefined" && value != "null" && value != "NULL") {
        var reg = new RegExp('/', 'g');
        var d = eval('new ' + value.replace(reg, ''));

        return new Date(d).format('yyyy-MM-dd hh:mm:ss');
    }
    else {
        return "";
    }*/
	if (value == null || value == '') {  
        return '';  
    }  
    var dt;  
    if (value instanceof Date) {  
        dt = value;  
    } else {  
        dt = new Date(value);  
    }  
  
    return dt.format("yyyy-MM-dd hh:mm:ss");

}

function returnParent(value) {//获取子窗体返回值
    var parent = window.dialogArguments; //获取父页面
    //parent.location.reload(); //刷新父页面
    if (parent != null && parent != "undefined") {
        window.returnValue = value; //返回值
        window.close(); //关闭子页面
    }
    return;
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

function showWindow(title, href, width, height, modal, minimizable, maximizable) {
    var openWin = window.top.$('<div id="myWinId" class="easyui-window" closed="true"></div>').appendTo(window.top.document.body);
   // var openWin = $('<div id="myWinId" class="easyui-window" closed="true"></div>').appendTo(document.body);
    openWin.window({
         title: title,
        width: width === undefined ? 600 : width,
        height: height === undefined ? 400 : height,
        content: '<iframe scrolling="auto" frameborder="0"  src="' + href + '" style="width:100%;height:99%;"></iframe>',
        //href: href === undefined ? null : href,
         modal: modal === undefined ? true : modal,
         minimizable: minimizable === undefined ? false : minimizable,
        maximizable: maximizable === undefined ? false : maximizable,
        shadow: false,
         cache: false,
        closed: false,
         collapsible: false,
        resizable: false,
        loadingMessage: '正在加载数据，请稍等片刻......',
         onClose : function(){  
            openWin.window("destroy"); 
        } 
     });
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



 //学员档案
 function flexiArchives(){
	 
	 
            var arr = $('#flexigridData').datagrid('getSelections');
				var url = window.location.href;
	
	
            if (arr.length == 1) {
                //window.location.href = "../S_Should/ShouldList/" + arr[0].PK_ID;
				
					 if (url.indexOf("S_App") > 0) {//
						 	 var idValue="";
						     $.ajax({
                        type: "post",
                        url: "../S_App/GetFileVal",
                        data: { query: arr[0].PK_ID, Fname: "FK_S_ID" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                            idValue = res;
                        }
                    });
							 
				window.parent.showMyWindow("学员档案", "S_Archives/index/" + idValue + "?rd=" + Math.random(), 1000, 600, true, false, true);
					 }
					 else if(url.indexOf("S_COST_LIST") > 0){//费用流水
						 var idValue="";
						     $.ajax({
                        type: "post",
                        url: "../S_COST_LIST/GetFileVal",
                        data: { query: arr[0].PK_ID, Fname: "FK_S_ID" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                            idValue = res;
                        }
                    });
						window.parent.showMyWindow("学员档案", "S_Archives/index/" + idValue+ "?rd=" + Math.random(), 1000, 600, true, false, true);
						 }
						 else if(url.indexOf("C_PSSchoolHoursList") > 0){//学时管理
							 
							 	 var idValue="";
						     $.ajax({
                        type: "post",
                        url: "../C_PSSchoolHoursList/GetFileVal",
                        data: { query: arr[0].PK_ID, Fname: "CP_Sid" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                            idValue = res;
                        }
                         });
						window.parent.showMyWindow("学员档案", "S_Archives/index/" + idValue+ "?rd=" + Math.random(), 1000, 600, true, false, true);
							 
							 
							 }
					 else
					 {
						 var parent = window.dialogArguments; //获取父页面
						   if (parent == "undefined" || parent == null) {
					window.parent.showMyWindow("学员档案", "S_Archives/index/" + arr[0].PK_ID + "@CostDisplay=4&rd=" + Math.random(), 1000, 600, true, false, true);
						   }else{
							   
						  var reValue = window.showModalDialog("../S_Archives/index/" + arr[0].PK_ID + "@CostDisplay=4&rd=" + Math.random(), window, "dialogHeight:600px; dialogWidth:800px;  status:off; scroll:auto;location:yes;status:yes");
							   }
					 }
           

            } else {
                $.messager.alert('操作提示', '请选择一条数据!', 'warning');
            }
            return false;
	 
	 }
	 //教练档案
	 function EmployeesFile(){
		  var arr = $('#flexigridData').datagrid('getSelections');
		 var url = window.location.href;
		 	 if (url.indexOf("C_PSSchoolHoursList") > 0) {//
						 	 var idValue="";
						     $.ajax({
                        type: "post",
                        url: "../C_PSSchoolHoursList/GetFileVal",
                        data: { query: arr[0].PK_ID, Fname: "SE_Id" },
                        async: false,
                        success: function (res) {
                            //data = eval("(" + res + ")"); 
                            idValue = res;
                        }
                    });
							 
				window.parent.showMyWindow("教练档案", "S_Archives/EmployeesFile/" + idValue + "?rd=" + Math.random(), 1000, 600, true, false, true);
					 }
				else{
					
			window.parent.showMyWindow("教练档案", "S_Archives/EmployeesFile/" + arr[0].PK_ID + "?rd=" + Math.random(), 1000, 600, true, false, true);
					
					}
}
//格式化金额
function formatCurrency(num) {
    if (!num && typeof(num)!="undefined" && num!=0)
    num = num.toString().replace(/\$|\,/g, '');
    if (isNaN(num))
        num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    cents = num % 100;
    num = Math.floor(num / 100).toString();
    if (cents < 10)
        cents = "0" + cents;
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
        num = num.substring(0, num.length - (4 * i + 3)) + ',' +
    num.substring(num.length - (4 * i + 3));
    return (((sign) ? '' : '-') + num + '.' + cents);
}

//人民币金额转大写程序 JavaScript版     
//CopyRight Bardo QI     

function numToCny(num) {
    var capUnit = ['万', '亿', '万', '圆', ''];
    var capDigit = { 2: ['角', '分', ''], 4: ['仟', '佰', '拾', ''] };
    var capNum = ['零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'];
    if (((num.toString()).indexOf('.') > 16) || (isNaN(num)))
        return '';
    num = (Math.round(num * 100) / 100).toString();
    num = ((Math.pow(10, 19 - num.length)).toString()).substring(1) + num;
    var i, ret, j, nodeNum, k, subret, len, subChr, CurChr = [];
    for (i = 0, ret = ''; i < 5; i++, j = i * 4 + Math.floor(i / 4)) {
        nodeNum = num.substring(j, j + 4);
        for (k = 0, subret = '', len = nodeNum.length; ((k < len) && (parseInt(nodeNum.substring(k)) != 0)); k++) {
            CurChr[k % 2] = capNum[nodeNum.charAt(k)] + ((nodeNum.charAt(k) == 0) ? '' : capDigit[len][k]);
            if (!((CurChr[0] == CurChr[1]) && (CurChr[0] == capNum[0])))
                if (!((CurChr[k % 2] == capNum[0]) && (subret == '') && (ret == '')))
                    subret += CurChr[k % 2];
        }
        subChr = subret + ((subret == '') ? '' : capUnit[i]);
        if (!((subChr == capNum[0]) && (ret == '')))
            ret += subChr;
    }
    ret = (ret == '') ? capNum[0] + capUnit[3] : ret;
    return ret;
}
//js 带小数点运算
function yunshuan(a, how, b) {//正确浮点运算   
    if (a.toString().indexOf(".") < 0 && b.toString().indexOf(".") < 0) {//没小数   
        return eval(a + how + b);
    }
    //至少一个有小数   
    var alen = a.toString().split(".");
    if (alen.length == 1) {//没有小数   
        alen = 0;
    } else {
        alen = alen[1].length;
    }
    var blen = b.toString().split(".");
    if (blen.length == 1) {
        blen = 0;
    } else {
        blen = blen[1].length;
    }
    if (blen > alen) alen = blen;
    blen = "1";
    for (; alen > 0; alen--) {//创建一个相应的倍数   
        blen = blen + "0";
    }
    switch (how) {
        case "+":
            return (a * blen + b * blen) / blen;
            break;
        case "-":
            return (a * blen - b * blen) / blen;
            break;
        case "*":
            return ((a * blen) * (b * blen)) / (blen * blen);
            break;
        default:
            alert("你要求的\t" + how + "\t运算未完成!");
            return eval(a + how + b);
    }
}

function convertCurrency(currencyDigits) {   
// Constants:   
var MAXIMUM_NUMBER = 99999999999.99;   
// Predefine the radix characters and currency symbols for output:   
var CN_ZERO = "零";   
var CN_ONE = "壹";   
var CN_TWO = "贰";   
var CN_THREE = "叁";   
var CN_FOUR = "肆";   
var CN_FIVE = "伍";   
var CN_SIX = "陆";   
var CN_SEVEN = "柒";   
var CN_EIGHT = "捌";   
var CN_NINE = "玖";   
var CN_TEN = "拾";   
var CN_HUNDRED = "佰";   
var CN_THOUSAND = "仟";   
var CN_TEN_THOUSAND = "万";   
var CN_HUNDRED_MILLION = "亿";   
var CN_SYMBOL = "";   
var CN_DOLLAR = "元";   
var CN_TEN_CENT = "角";   
var CN_CENT = "分";   
var CN_INTEGER = "整";   
  
// Variables:   
var integral; // Represent integral part of digit number.   
var decimal; // Represent decimal part of digit number.   
var outputCharacters; // The output result.   
var parts;   
var digits, radices, bigRadices, decimals;   
var zeroCount;   
var i, p, d;   
var quotient, modulus;   
  
// Validate input string:   
currencyDigits = currencyDigits.toString();   
if (currencyDigits == "") {   
  alert("Empty input!");   
  return "";   
}   
if (currencyDigits.match(/[^,.\d]/) != null) {   
  alert("Invalid characters in the input string!");   
  return "";   
}   
if ((currencyDigits).match(/^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/) == null) {   
  alert("Illegal format of digit number!");   
  return "";   
}   
  
// Normalize the format of input digits:   
currencyDigits = currencyDigits.replace(/,/g, ""); // Remove comma delimiters.   
currencyDigits = currencyDigits.replace(/^0+/, ""); // Trim zeros at the beginning.   
// Assert the number is not greater than the maximum number.   
if (Number(currencyDigits) > MAXIMUM_NUMBER) {   
  alert("Too large a number to convert!");   
  return "";   
}   
  
// Process the coversion from currency digits to characters:   
// Separate integral and decimal parts before processing coversion:   
parts = currencyDigits.split(".");   
if (parts.length > 1) {   
  integral = parts[0];   
  decimal = parts[1];   
  // Cut down redundant decimal digits that are after the second.   
  decimal = decimal.substr(0, 2);   
}   
else {   
  integral = parts[0];   
  decimal = "";   
}   
// Prepare the characters corresponding to the digits:   
digits = new Array(CN_ZERO, CN_ONE, CN_TWO, CN_THREE, CN_FOUR, CN_FIVE, CN_SIX, CN_SEVEN, CN_EIGHT, CN_NINE);   
radices = new Array("", CN_TEN, CN_HUNDRED, CN_THOUSAND);   
bigRadices = new Array("", CN_TEN_THOUSAND, CN_HUNDRED_MILLION);   
decimals = new Array(CN_TEN_CENT, CN_CENT);   
// Start processing:   
outputCharacters = "";   
// Process integral part if it is larger than 0:   
if (Number(integral) > 0) {   
  zeroCount = 0;   
  for (i = 0; i < integral.length; i++) {   
   p = integral.length - i - 1;   
   d = integral.substr(i, 1);   
   quotient = p / 4;   
   modulus = p % 4;   
   if (d == "0") {   
    zeroCount++;   
   }   
   else {   
    if (zeroCount > 0)   
    {   
     outputCharacters += digits[0];   
    }   
    zeroCount = 0;   
    outputCharacters += digits[Number(d)] + radices[modulus];   
   }   
   if (modulus == 0 && zeroCount < 4) {   
    outputCharacters += bigRadices[quotient];   
   }   
  }   
  outputCharacters += CN_DOLLAR;   
}   
// Process decimal part if there is:   
if (decimal != "") {   
  for (i = 0; i < decimal.length; i++) {   
   d = decimal.substr(i, 1);   
   if (d != "0") {   
    outputCharacters += digits[Number(d)] + decimals[i];   
   }   
  }   
}   
// Confirm and return the final output string:   
if (outputCharacters == "") {   
  outputCharacters = CN_ZERO + CN_DOLLAR;   
}   
if (decimal == "") {   
  outputCharacters += CN_INTEGER;   
}   
outputCharacters = CN_SYMBOL + outputCharacters;   
return outputCharacters;
}


//js过滤HTML标签以及空格
function removeHTMLTag(str) {
    str = str.replace(/<\/?[^>]*>/g, ''); //去除HTML tag
    str = str.replace(/[ | ]*\n/g, '\n'); //去除行尾空白
    //str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
    str = str.replace(/ /ig, ''); //去掉 
    return str;
}

function cellStyler(value) {
    if (value == "作废") {
        return 'color:red;';
    }
}

function progressComm2() {
    var win = $.messager.progress({
        title: '请等待',
        text: '数据正在提交中'
    });
}

function progressJisuan() {
    var win = $.messager.progress({
        title: '请等待',
        text: '数据正在计算中'
    });
}

function getStrLength1(str) {

    var cArr = str.match(/[^\x00-\xff]/ig);

    return str.length + (cArr == null ? 0 : cArr.length);

}
  
      