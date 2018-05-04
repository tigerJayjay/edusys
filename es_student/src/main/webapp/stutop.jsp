<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="top">
	
</div>
<nav class="navbar navbar-default">
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li class="active"><a href="/es_student/main.jsp">首页</a></li>
        <li>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">网上选课<span class="caret"></span></a>
          <shiro:hasPermission name="选课">
          <ul class="dropdown-menu">
            <li><a href="/es_student/selectcourse.jsp">学生选课</a></li>
            <li><a href="#">全校公共选修课</a></li>
          </ul>
          </shiro:hasPermission>
      </li>
       <li>
        	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">教学质量评价<span class="caret"></span></a>
          <shiro:hasPermission name="评教">
	          <ul class="dropdown-menu">
	            <li><a target="_blank" href="/es_student/checkteacher.jsp">评教</a></li>
	          </ul>
          </shiro:hasPermission>
      </li>
         <li> 
         	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">信息修改 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/es_student/password-modify.jsp">修改密码</a></li>
            <li><a href="/es_student/stuinfo.jsp">个人信息</a></li>
          </ul>
        </li>
        <li >
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">信息查询 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/es_student/score.jsp">成绩查询</a></li>
            <li><a href="/es_student/course.jsp">课表查询</a></li>
            <li><a href="/es_student/exam.jsp">考试安排查询</a></li>
            <li><a href="/es_student/selcourse-result.jsp">选课查询</a></li>
          </ul>
        </li>
      </ul>
     <p class="navbar-text navbar-right"><a href="/user/logout" class="navbar-link">退出</a></p>
     <p class="navbar-text navbar-right">欢迎您！${user.sname}同学</p>
    </div><!-- /.navbar-collapse -->
</nav>