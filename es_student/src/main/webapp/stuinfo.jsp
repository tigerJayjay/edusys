<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>个人信息</title>
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/student-main.css">
	<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/student-main.js"></script>
	<script src="/es_student/resources/Scripts/jquery-1.8.3.min.js"
		type="text/javascript"></script>
	<script src="/es_student/resources/Scripts/jquery.easyui.min-1.3.5.js"
		type="text/javascript"></script>
	<script src="/es_student/resources/Scripts/jquery.datagrid.js"
		type="text/javascript"></script>
	<script src="/es_student/resources/Scripts/JScriptIndex.js"
		type="text/javascript"></script>
	<link href="/es_student/resources/Content/default.css" rel="stylesheet"
		type="text/css" />
	<link href="/es_student/resources/Content/IndexStyle.css"
		rel="stylesheet" type="text/css" />
	<link href="/es_student/resources/Res/easyui/themes/icon.css"
		rel="stylesheet" type="text/css" />
	<script
		src="/es_student/resources/Res/easyui/locale/easyui-lang-zh_CN.js"
		type="text/javascript"></script>
	<link href="/es_student/resources/Res/easyui/themes/default/easyui.css"
		rel="stylesheet" type="text/css" />
	<script type="text/javascript" language="javaScript">
		function submit(){
			var sno = $("#sno").val();
			var emergency = $("#emergency").val();
			var emergencyPhone = $("#emergencyphone").val();
			$.post("/es_manager/usermanager/updateStu",{sno:sno,emergency:emergency,emergencyphone:emergencyPhone},function(res){
				$.messager.alert("提示",res.result);
			},"json")
		}
	</script>
</head>

<body>
<div class="page .container-fluid">
<jsp:include page="stutop.jsp"></jsp:include>
<div class="content">
		<table class="table table-bordered" width="100%" align="center">
			<input type="hidden" id="sno" name="sno" value="${user.sno}">
			<tr><td>学号:${user.sno}</td><td>班级:${user.classNo}</td></tr>
			<tr><td>姓名:${user.sname }</td><td>入学时间:${user.entranceTime }</td></tr>
			<tr><td>年级:${user.grade}</td><td>专业:${user.classname}</td></tr>
			<tr><td>学院:${user.college }</td><td>性别:
			<c:if test="${user.gender==0}">
				女
			</c:if>
			<c:if test="${user.gender==1}">
				男
			</c:if>
			</td></tr>
			<tr><td>生日:${user.birthdate }</td><td>电话:${user.phonenumber }</td></tr>
			<tr><td>邮箱:${user.email}</td><td>紧急联系人:<input id="emergency" name="emergency" type="text" value="${user.emergency}"></td></tr>
			<tr><td>紧急联系人联系方式:<input type="text" id="emergencyphone" name="emergencyphone" value="${user.emergencyphone }"></td><td></td></tr>
			<tr>
				<td colspan="8">
					<button class="btn btn-primary btn-lg"  id="submitButton" onclick="submit();">提交</button>
				</td>
			</tr>					
		</table>
</div>		
</body>
</html>