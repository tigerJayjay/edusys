<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
   <link href="../css/bootstrap.min.css" rel="stylesheet">
<div class="top">
	
</div>
<nav class="navbar navbar-default">
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li class="active"><a href="/es_student/main.jsp">首页</a></li>
        <li>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人信息管理<span class="caret"></span></a>
          
          <ul class="dropdown-menu">
            <li><a href="/es_teacher/teainfo.jsp">个人信息</a></li>
            <li><a href="/es_teacher/password-modify.jsp">修改密码</a></li>
          </ul>
      </li>
       <li>
        	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">教学质量评价<span class="caret"></span></a>
         
	          <ul class="dropdown-menu">
	            <li><a  href="/es_teacher/checkResult.jsp">查看评教结果</a></li>
	          </ul>
      </li>
         <li> 
         	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">工作安排 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/es_teacher/invigilate.jsp">监考安排</a></li>
            <shiro:hasPermission name="录成绩">
            <li><a href="/es_teacher/scoreinfo.jsp">成绩录入</a></li>
            </shiro:hasPermission>
          </ul>
        </li>
        <li >
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">信息查询 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/es_teacher/course.jsp">教学课表查询</a></li>
          </ul>
        </li>
      </ul>
     <p class="navbar-text navbar-right"><a href="/user/logout" class="navbar-link">退出</a></p>
     <p class="navbar-text navbar-right">欢迎您！${user.tname}老师</p>
    </div><!-- /.navbar-collapse -->
</nav>