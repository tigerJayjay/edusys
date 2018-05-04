
$(function(){
$("#loginform").submit(function(){
	var username = $("#username").val();
	var password = $("#password").val();
	var checkcode = $("#checkcode").val();
	if(username==""){
		alert("用户名不能为空！");
		return false;
	}
	if(password==""){
		alert("密码不能为空！");
		return false;
	}
	if(checkcode==""){
		alert("验证码不能为空!");
		return false;
	}
	var role;
	$("input:radio").each(function(){
		if($(this).attr("checked")){
			role = $(this).val();
		}
	})
/*	$.ajax({
		url:"LoginServlet",
		data:{"username":username,"password":password,"role":role,"code":checkcode},
		type:"post",
		dataType:"text",
		success:function(result){
			if(result=="loginSuccess"){
				location.href="/educationalSystem/student/main.jsp";
			}else if(result=="codeError"){
				alert("验证码输入有误!");
			}else if(result=="loginFalse"){
				alert("账户名或密码输入有误!");
			}
		}
	})*/
})
});
//刷新验证码图片
function refresh(){
	var img = document.getElementById("img");
	img.src = "/image.jsp?X="+Math.random();                                                                                                                                                                                                                                                                                                                                
}
