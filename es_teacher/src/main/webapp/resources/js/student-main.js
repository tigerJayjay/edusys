$(function(){
	$(".nav>li").on({
		click:function(){
			$(".nav>li").each(function(i,e){
				$(e).removeClass("active");
			})
			$(this).addClass("active");
		}
	})
	$("#modpassword").click(function(){
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
		$.post("/user/modPass",{account:studentnumber,newPass:newpassword,oldPass:oldpassword},function(res){{}
			$.messager.alert("提示",res.result);
			if(res.status=='200'){
				location.href='/login.jsp'
			}
		},"json")
	})

})