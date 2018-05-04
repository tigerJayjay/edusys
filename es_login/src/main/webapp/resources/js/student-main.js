$(function(){
	$(".nav>li").on({
		click:function(){
			$(".nav>li").each(function(i,e){
				$(e).removeClass("active");
			})
			$(this).addClass("active");
		}
	})
	$("#modform").submit(function(){
		var studentnumber = $("#studentnumber").val();
		var oldpassword = $("#oldpassword").val();
		var newpassword = $("#newpassword").val();
		var renewpassword = $("#renewpassword").val();
		if(oldpassword==""){
			alert("原密码不能为空!");
			return false;
		}
		if(newpassword==""){
			alert("新密码不能为空!");
			return false;
		}
		if(newpassword!=renewpassword){
			alert("两次新密码不同!");
			return false;
		}
		/*$.ajax({
			url:"/educationalSystem/StudentServlet",
			data:{"studentnumber":studentnumber,"oldpassword":oldpassword,"newpassword":newpassword,"opr":"modPass"},
			type:"post",
			dataType:"text",
			success:function(result){
				if("modsucess"==result){
					alert("请重新登录!");
					location.href="/educationalSystem/login.jsp";
				}
				if("oldfail"==result){
					alert("原密码不正确!");
					return;
				}
			}
		})*/
	})

})