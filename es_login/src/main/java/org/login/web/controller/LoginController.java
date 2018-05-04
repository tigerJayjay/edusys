package org.login.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.es.bean.JsonResult;
import org.es.model.AdminPeople;
import org.es.model.Authority;
import org.es.model.LoginUser;
import org.es.model.Role;
import org.es.model.Student;
import org.es.model.Teacher;
import org.es.service.common.ILoginService;
import org.es.service.common.IWorkerAwardService;
import org.es.service.common.IWorkerExpreService;
import org.es.service.manager.manager.IManagerService;
import org.es.service.manager.student.IStudentService;
import org.es.service.manager.teacher.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api(value="LoginController",description="登录接口")
@Controller
@RequestMapping("/user")
public class LoginController {
	private final Integer STUDENT_MARK = 0;//学生标志
	private final Integer TEACHER_MARK = 1;//教师标志
	private final Integer MANAGER_MARK = 2;//管理员标志
	private final String LOGIN = "系统登录";//系统登录权限
	@Autowired
	private ILoginService loginService;
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ITeacherService teacherService;
	@Autowired
	private IManagerService managerService;
	@Autowired
	private IWorkerExpreService workerExpreService;
	@Autowired
	private IWorkerAwardService workerAwardService;
	 @RequestMapping("/logout")
	  public String logOut(HttpSession session) {
	        Subject subject = SecurityUtils.getSubject();
	        subject.logout();
	        return "redirect:/login.jsp";
	    }
	@ApiOperation(value="登录",notes="根据用户输入用户名、密码、验证码来登录")
	@ApiImplicitParams({
		@ApiImplicitParam(name="loginUser",value="登录用户对象",required=true,dataType="LoginUser"),
		/*@ApiImplicitParam(name="code",value="用户输入验证码",dataType="String")*/
	})
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String login(LoginUser loginUser,HttpSession request,String code,Integer mark){
		JsonResult res = new JsonResult();
		UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getAccount(),loginUser.getPassword());
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		//比对session中验证码和用户输入验证码是否匹配
		String sessionCode = (String) session.getAttribute("code");
		if(!code.equalsIgnoreCase(sessionCode)){
			res.setStatus("500");
			res.setResult("验证码输入有误!");
			request.setAttribute("res", res);
			return "redirect:/login.jsp";
		}
		try{
			subject.login(token);
			LoginUser user = (LoginUser)subject.getPrincipal();
			List<Role> roles = loginService.getRoles(user);
			if(!isLogin(roles)){
				res.setStatus("500");
				res.setResult("没有登录权限，请与管理员联系!");
				request.setAttribute("res", res);
				return "redirect:/login.jsp";
			}
			session.setAttribute("login", user);
			res.setStatus("200");
			if(mark==STUDENT_MARK){
				if(checkUser(roles,mark)){
					Student oneStudent = studentService.getOneStudent(user.getAccount());
					session.setAttribute("user", oneStudent);
					return "redirect:/es_student/Home.jsp";
				}
			}
			if(mark==TEACHER_MARK){
				if(checkUser(roles,mark)){
					Teacher oneTeacher = teacherService.getOneTeacher(user.getAccount());
					session.setAttribute("user", oneTeacher);
					JsonResult workExpre = workerExpreService.getWorkExpre(oneTeacher.getJobno());
					session.setAttribute("expres", workExpre.getRows());
					JsonResult award = workerAwardService.getAward(Integer.valueOf(oneTeacher.getJobno()));
					session.setAttribute("awards", award.getRows());
					return "redirect:/es_teacher/Home.jsp";
				}
			}
			if(mark==MANAGER_MARK){
				if(checkUser(roles,mark)){
					AdminPeople admin = managerService.getAdmin(user.getAccount());
					session.setAttribute("user", admin);
					return "redirect:/es_manager/Home.jsp";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			res.setStatus("500");
			res.setResult("登录失败!");
		}
		res.setStatus("500");
		res.setResult("登录失败!");
		request.setAttribute("res", res);
		return "redirect:/login.jsp";
	}
	@ApiOperation(value="修改密码",notes="根据用户输入用户名、密码、新密码更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name="account",value="用户账号",required=true,paramType="query",dataType="String"),
		@ApiImplicitParam(name="oldPass",value="用户旧密码",paramType="query",dataType="String"),
		@ApiImplicitParam(name="newPass",value="用户新密码",paramType="query",dataType="String")
	})
	@ResponseBody
	@RequestMapping(value="/modPass",method=RequestMethod.POST)
	public JsonResult modPass(String account,
			String oldPass,
			String newPass){
		JsonResult res = new JsonResult();
		LoginUser user = new LoginUser();
		user.setAccount(account);
		user.setPassword(oldPass);
		res.setStatus("200");
		res.setResult("修改成功!");
		res.setUrl("localhost:8084/login.jsp");
		if(oldPass==null){
			res.setStatus("500");
			res.setResult("请输入原密码!");
			return res;
			
		}else if(newPass==null){
			res.setStatus("500");
			res.setResult("请输入新密码!");
			return res;
		}
		LoginUser login = loginService.login(user);
		if(login==null){
			res.setStatus("500");
			res.setResult("原密码有误!");
			return res;
		}
		login.setPassword(newPass);
		if(!loginService.modPass(login)){
			res.setStatus("500");
			res.setResult("修改失败!");
			return res;
		}
		return res;
	}
	
	private boolean  checkUser(List<Role> role,int mark){
		for(Role r:role){
			if(r.getNo()==mark){
				return true;
			}
		}
		return false;
	}
	
	private boolean isLogin(List<Role> roles){
		for(Role r:roles){
			List<Authority> authoritys = loginService.getAuthoritys(r);
			for(Authority a:authoritys){
				if(LOGIN.equals(a.getAuthName())){
					return true;
				}
			}
		}
		return false;
	}
}
