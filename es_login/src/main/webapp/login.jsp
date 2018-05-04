<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>系统登录</title>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/login.css"  rel="stylesheet">
	<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.serializejson.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/login.js"></script>
</head>

<body>
<div class="page .container-fluid">
	<!--页面头部-->
	<div class="top">
	</div>
	<div class="center clearfix">
		<div class="righter">
				<form class="form-horizontal" id="loginform" action="/user/dologin" method="post">
				
				 <span style="color:red">${res.result}</span>
			        <div class="form-group">
			       		 <div class="col-lg-9">
			        		<input type="text" value="" class="form-control" name="account" id="account" placeholder="请输入学号或工号" autofocus>
			   			</div>
			   		</div>
			   		<div class="form-group">
				   		<div class="col-lg-9">
				        	<input type="password" value="" class="form-control" name="password" id="password" placeholder="请输入密码">
				        <div>
			        </div>
			        <br>
			        <div class="form-group">
			        	<div class="col-lg-2">
				   			 <img src="image.jsp" id="img" height="26px" width="100px"/>
			        	</div>
			        </div>
			        <div class="form-group">
			        	<div class="col-lg-7">
				   			 <input type="text" id="checkcode" name="code" class="form-control col-lg-7"  placeholder="请输入验证码">
			        	</div>
			        	<label class="col-lg-5 control-label">
			        		<a id="changeCode" href="javascript:void(0)" onclick="refresh()">看不清，换一张</a>
			        	</label>
			        </div>
			        <div class="form-group">
			        	<label class="radio-inline">
							<input type="radio" name="mark" id="optionsRadios3" value="1" checked>教师
						</label>
						<label class="radio-inline">
							<input type="radio" name="mark" id="optionsRadios4" value="0">学生
						</label>
						<label class="radio-inline">
							<input type="radio" name="mark" id="optionsRadios4" value="2">部门
						</label>
			        </div>
			        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		      </form>
		</div>

	</div>
	<div class="foot">
		
	</div>
</div>
</body>
	
</html>