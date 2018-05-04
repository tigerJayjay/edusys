<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>欢迎来到郑州航院教务管理系统</title>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/student-main.css">
	<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/student-main.js"></script>
</head>
<body>
<div class="page .container-fluid">
	<jsp:include page="stutop.jsp"></jsp:include>
	<div class="content">
    <div class="panel panel-primary">
      <div class="panel-heading">
         <h3 class="panel-title">系统公告</h3>
      </div>
      <div class="panel-body">
         <table class="table table-bordered">
              <tr class="thead">
                  <td class="col-lg-2">标题</td>
                  <td class="col-lg-7">内容</td>
                  <td class="col-lg-1">发布单位</td>
                  <td class="col-lg-2">发布时间</td>
              </tr>
              <tr>
                  <td><a href="#">教务管理系统操作指南</a></td>
                  <td>教务管理系统操作指南...</td>
                  <td>教务处</td>
                  <td>2013-10-25</td>
              </tr> 
              <tr>
                  <td><a href="#">教务管理系统操作指南</a></td>
                  <td>教务管理系统操作指南...</td>
                  <td>教务处</td>
                  <td>2013-10-25</td>
              </tr> 
              <tr>
                  <td><a href="#">教务管理系统操作指南</a></td>
                  <td>教务管理系统操作指南...</td>
                  <td>教务处</td>
                  <td>2013-10-25</td>
              </tr>
         </table>
      </div>
    </div>
    
  </div>
	<div class="footer"></div>
</div>
</body>
</html>