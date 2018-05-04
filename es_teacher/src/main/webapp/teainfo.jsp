<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<script src="/es_teacher/resources/Scripts/jquery-1.8.3.min.js"
		type="text/javascript"></script>
	<script src="/es_teacher/resources/Scripts/jquery.easyui.min-1.3.5.js"
		type="text/javascript"></script>
	<script src="/es_teacher/resources/Scripts/jquery.datagrid.js"
		type="text/javascript"></script>
	<script src="/es_teacher/resources/Scripts/JScriptIndex.js"
		type="text/javascript"></script>
	<link href="/es_teacher/resources/Content/default.css" rel="stylesheet"
		type="text/css" />
	<link href="/es_teacher/resources/Content/IndexStyle.css"
		rel="stylesheet" type="text/css" />
	<link href="/es_teacher/resources/Res/easyui/themes/icon.css"
		rel="stylesheet" type="text/css" />
	<script
		src="/es_teacher/resources/Res/easyui/locale/easyui-lang-zh_CN.js"
		type="text/javascript"></script>
	<link href="/es_teacher/resources/Res/easyui/themes/default/easyui.css"
		rel="stylesheet" type="text/css" />
	
</head>

<body>
<div class="page .container-fluid">
<jsp:include page="stutop.jsp"></jsp:include>
<div class="content">
		<table class="table table-bordered" width="100%" align="center">
			<tr><td>工号:${user.jobno}</td><td>婚否:
				<c:if test="${user.maritalstatus==0}">
					未婚
			</c:if>
			<c:if test="${user.maritalstatus==1}">
				已婚
			</c:if>
			</td></tr>
			<tr><td>姓名:${user.tname }</td><td>工作时间:<fmt:formatDate value="${user.entrytime }" pattern="yyyy-MM-dd"/></td></tr>
			<tr><td>最高学历:${user.maxdegree}</td><td>籍贯:${user.nativeplace }</td></tr>
			<tr><td>学院:${user.college }</td><td>性别:
			<c:if test="${user.gender==0}">
				女
			</c:if>
			<c:if test="${user.gender==1}">
				男
			</c:if>
			</td></tr>
			<tr><td>生日:<fmt:formatDate value="${user.birthdate }" pattern="yyyy-MM-dd"/></td><td>电话:${user.phone }</td></tr>
			<tr><td>邮箱:${user.email}</td><td></td></tr>			
		</table>
		
		<table class="table table-bordered" width="100%" align="center">
			<thead>
				<tr><td colspan="5" style="text-align: center">工作经历</td></tr>
			</thead>
			<c:if test="${fn:length(expres)==0}">
				<tr><td colspan="5" style="text-align: center">无</td></tr>
			</c:if>
			<c:forEach items="${expres}" var="expre">
				<tr><td>开始时间：<fmt:formatDate value="${expre.begintime}" pattern="yyyy-MM-dd"/></td><td>结束时间：<fmt:formatDate value="${expre.endtime}" pattern="yyyy-MM-dd"/></td><td>公司：${expre.compony}</td>
				<td>职位：${expre.positions}</td>
				<td>描述：${expre.des}</td>
				</tr>
			</c:forEach>
		</table>
		<table class="table table-bordered" width="100%" align="center">
			<thead>
				<tr><td colspan="3" style="text-align: center">奖励信息</td></tr>
			</thead>
			<c:if test="${fn:length(awards)==0}">
				<tr><td colspan="3" style="text-align: center">无</td></tr>
			</c:if>
			<c:forEach items="${awards}" var="award">
				<tr><td>时间：<fmt:formatDate value="${award.awardtime}" pattern="yyyy-MM-dd"/></td><td>姓名：${award.workName}</td><td>描述：${award.des}</td></tr>
			</c:forEach>
		</table>
</div>		
</div>

</body>
</html>