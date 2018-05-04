<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="MyHead">
	<title>添加教材信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/es_manager/resources/Scripts/jquery.min.js" type="text/javascript"></script>
    <script src="/es_manager/resources/Scripts/JScriptCommon.js" type="text/javascript"></script>
    <link href="/es_manager/resources/Content/StyleSheet.css" rel="stylesheet" type="text/css" />
    <script src="/es_manager/resources/Scripts/jquery.validate.min.js" type="text/javascript"></script>
    <script src="/es_manager/resources/Scripts/jquery.validate.unobtrusive.min.js" type="text/javascript"></script>
    <link href="/es_manager/resources/Content/IndexStyle.css" rel="stylesheet" type="text/css" />
    <script src="/es_manager/resources/Res/easyui/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="/es_manager/resources/Res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="/es_manager/resources/Res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
    <link href="/es_manager/resources/Res/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
	<script src="/es_manager/resources/script/jquery.serializejson.js"></script>
    
    <script type="text/javascript">
    
    
    var userDepts = [];
    var userPositions = [];
    $(function(){
    	function yeartime(){
        	var date = new Date();
        	var year = date.getFullYear();
        	var month = date.getMonth()+1;
        	if(month<9){
        		for(var i = year-8;i<year;i++){
        			if(i==year-1){
        				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
        			}else{
        				$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
        			}
        		}
        	}else{
        		for(var i = year-7;i<=year;i++){
        			if(i==year){
        				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
        			}else{
            			$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>")
        			}
        		}
        		
        	}
       	}
        yeartime();      
    })
   function login() {
            $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/es_manager/bookPayInfo/insertBooPayInfo" ,//url,
                contentType: "application/json",
                data:JSON.stringify($('#form1').serializeJSON()),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.status == 200) {
                    	$.messager.alert("提示",result.result);
                    }
                    ;
                },
                error : function() {
                	$.messager.alert("提示!","添加失败!");
                	
                }
            });
        }
    </script>
</head>
<body>
    
<div class="mbx">
     添加 教材
</div>
<form action="#" method="post" onsubmit="return false" id="form1">
    <fieldset>
        <legend>
            <input class="submitcss" type="submit" onclick="login()" id="submit" value="保存" />
            <input class="submitcss" type="button" onclick="BackList('/es_manager/book/bookPay.jsp')" value="返回" />
        </legend>
        <div class="bigdiv">
            <div class="editor-label">
               	<label for="bookno">书号</label>
        	</div>
	        <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="bookno" name="bookno" type="text" value="${role.roleStatus }" />
	        </div>
	        <div class="editor-label">
                <label for="sno">学号</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="sno" name="sno" type="text" value="${role.roleStatus }" />
	        </div>
	         <div class="editor-label">
                <label for="amount">缴费</label>
            </div>
            <div class="editor-field">
	            <input class="text-box single-line" data-val="true" data-val-length="长度不可超过36" data-val-length-max="36" id="amount" name="amount" type="text" value="${role.roleStatus }" />
	        </div>
	       <div class="editor-label">
                <label for="yeartime">学年</label>
            </div>
            <div class="editor-field">
	            <select id="yeartime" name="yeartime"></select>
	        </div>
	        <div class="editor-label">
                <label for="termtime">学期</label>
            </div>
            <div class="editor-field">
	            <select id="termtime" name="termtime">
	              <option value="1">1</option>
	              <option value="2">2</option>
	            </select>
	        </div>
    </fieldset>

    </form>
    <c:remove var="message"/>
</body>
</html>