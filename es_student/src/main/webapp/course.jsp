<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>课表查询</title>
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
<script type="text/javascript">
$(function(){
	function yeartime(){
    	var date = new Date();
    	var year = date.getFullYear();
    	var month = date.getMonth()+1;
    	if(month<9){
    		for(var i = year-4;i<year;i++){
    			if(i==year-1){
    				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
    			}else{
    				$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
    			}
    		}
    	}else{
    		for(var i = year-3;i<=year;i++){
    			if(i==year){
    				$("#yeartime").append("<option selected value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>");
    			}else{
        			$("#yeartime").append("<option value='"+i+"-"+(i-0+1)+"'>"+i+"-"+(i-0+1)+"</option>")
    			}
    		}
    		
    	}
   	}
	yeartime();
	var search = $("#queryCondition").serialize();
	search = search.replace(/&/g,",");
	search = search.replace(/=/g,":");
	search = decodeURIComponent(search,true);
	 $.post("/es_student/selectCourse/getSelectInfo",{condition:search},function(result){
		 $.each(result.rows,function(i,e1){
				var room = e1.place;
				var weekDay = e1.weekno;
				var segment = e1.jie.substring(e1.jie.lastIndexOf("-")-1,e1.jie.lastIndexOf("-"));
				$("#table1").find("tr").eq(segment).find("td").eq((weekDay-0+1)).attr("rowspan","2").append(room+"<br>"+e1.course_name+"<br>"+e1.start_week+"-"+e1.end_week+"周"+e1.jie+"节"+"<br>"+e1.tname);
				$("#table1").find("tr").eq((segment-0+1)).find("td").eq((weekDay-0+1)).remove();
			
			})
		},"json")
})
function query(){
	$("#table1").find("tr:gt(0)").find("td:gt(1)").empty();
	var search = $("#queryCondition").serialize();
	search = search.replace(/&/g,",");
	search = search.replace(/=/g,":");
	search = decodeURIComponent(search,true);
	 $.post("/es_student/selectCourse/getSelectInfo",{condition:search},function(result){
		 $.each(result.rows,function(i,e1){
				var room = e1.place;
				var weekDay = e1.weekno;
				var segment = e1.jie.substring(e1.jie.lastIndexOf("-")-1,e1.jie.lastIndexOf("-"));
				$("#table1").find("tr").eq(segment).find("td").eq((weekDay-0+1)).attr("rowspan","2").append(room+"<br>"+e1.course_name+"<br>"+e1.start_week+"-"+e1.end_week+e1.jie+"<br>"+e1.tname);
				$("#table1").find("tr").eq((segment-0+1)).find("td").eq((weekDay-0+1)).remove();
			
			})
		},"json")
}
</script>
</head>
<body>
	<div class="page .container-fluid">
		<jsp:include page="stutop.jsp"></jsp:include>
		<div class="content">
			<div class="panel panel-primary">
				<div class="panel-heading">
					
					<form id="queryCondition">
						 <input id="college" name="college" type="hidden" value="${user.college}">
						 <input id="specialty" name="specialty" type="hidden" value="${user.classname}">
						 <input id="sno" name="sno" type="hidden" value="${user.sno}"/>	
						
						 <input id="classno" name="classno" type="hidden" value="${user.classNo}">
						         
					 	 <input id="grade" name="grade" type="hidden" value="${user.grade }">
					 		
					 	<input type="hidden" id="mark" name="mark" value="1"/>
					 	学年: <select id="yeartime" name="yeartime">
						
							</select>
					学期:<select id="termtime" name="termtime">
						<option value="1">1</option>
						<option value="2" selected>2</option>
					</select> 
						
					</form>
					<button type="submit" id="search" class="btn btn-default btn-sm" onclick="query();">查找</button>
				</div>
				<div class="panel-body">
					<table id="table1" class="table table-bordered" bordercolor="Black"
						border="0" width="100%">
						<tr>
							<td colspan="2" rowspan="1" width="2%">时间</td>
							<td align="Center" width="14%">星期一</td>
							<td align="Center" width="14%">星期二</td>
							<td align="Center" width="14%">星期三</td>
							<td align="Center" width="14%">星期四</td>
							<td align="Center" width="14%">星期五</td>
							<td class="noprint" align="Center" width="14%">星期六</td>
							<td class="noprint" align="Center" width="14%">星期日</td>
						</tr>

						<tr>
							<td rowspan="4" width="1%">上午</td>
							<td width="1%">第1节</td>
							<td align="Center" width="7%">&nbsp;</td>
							<td align="Center" width="7%">&nbsp;</td>
							<td align="Center" width="7%">&nbsp;</td>
							<td align="Center" width="7%">&nbsp;</td>
							<td align="Center" width="7%">&nbsp;</td>
							<td class="noprint" align="Center" width="7%">&nbsp;</td>
							<td class="noprint" align="Center" width="7%">&nbsp;</td>
						</tr>
						<tr>
							<td>第2节</td>
							<td align="Center"></td>
							<td align="Center"></td>
							<td align="Center"></td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						</tr>
						<tr>
							<td>第3节</td>
							<td align="Center"></td>
							<td align="Center">&nbsp;</td>
							<td align="Center"></td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						<tr>
							<td>第4节</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						</tr>
						<tr>
							<td rowspan="4" width="1%">下午</td>
							<td>第6节</td>
							<td align="Center">&nbsp;</td>
							<td align="Center"></td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center"></td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						</tr>
						<tr>
							<td>第6节</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						</tr>
						<tr>
							<td>第7节</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						</tr>
						<tr>
							<td>第8节</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						</tr>
						<tr>
							<td rowspan="2" width="1%">晚上</td>
							<td>第9节</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						</tr>
						<tr>
							<td>第10节</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
							<td class="noprint" align="Center">&nbsp;</td>
						</tr>
					</table>
					<br>

								</div>

								</div>
								<div class="footer">
								
								</div>
								</div> 

</body>
</html>