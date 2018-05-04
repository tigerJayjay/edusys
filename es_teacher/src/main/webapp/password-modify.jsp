<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>密码修改</title>
			<link href="resources/css/bootstrap.min.css" rel="stylesheet">
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
    <div style="width: 500px;height: 500px;margin:auto;text-align: center;" class="panel panel-default">
      <div class="panel-heading">修改密码</div>
        <div class="panel-body" style="width: 210px;margin:auto;margin-top: 30px">
          <form class="form-horizontal" role="form" action="#" onsubmit="return false" id="modform">
            <input type="hidden" value="modPass" name="opr">
            <div class="form-group">
              <div class="col-sm-12">
                <input type="email" class="form-control" name="account" id="studentnumber" value="${login.account}" readonly="true">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-12">
                  <input type="password" class="form-control" name="oldPass" id="oldpassword" placeholder="请输入原密码">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-12">
                  <input type="password" class="form-control" name="newPass" id="newpassword" placeholder="输入新密码">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-12">
                  <input type="password" class="form-control" id="renewpassword" placeholder="确认新密码">
              </div>
            </div>
           <button class="btn btn-lg btn-primary btn-block" id="modpassword" >确定更改</button>
         </form>
        </div>
    </div>
  </div>
	<div class="footer"></div>
</div>
</body>
</html>