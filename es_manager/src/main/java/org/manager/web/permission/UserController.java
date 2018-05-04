package org.manager.web.permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.es.bean.JsonResult;
import org.es.model.LoginUser;
import org.es.model.UserRole;
import org.es.service.common.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private ILoginService userService;
	@RequestMapping("/toModifyUser")
	public String toModifyUser(HttpServletRequest request,Integer no){
		LoginUser one = userService.getOne(no);
		request.setAttribute("loginUser", one);
		return "systemmanager/updUser.jsp";
	}
	/**
	 * 显示用户列表
	 */
	@RequestMapping("/showUsers")
	@ResponseBody
	public JsonResult showUsers(String condition,Integer page,Integer rows){
		/*"userId&141006114,userName&,userStatus&开启,"*/
		//将查询条件分割成数组，遍历数据，再分割后放在map中
		if(condition!=null){
			String[] split = condition.split(",");
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			for(int i = 0;i<split.length;i++){
				String[] split2 = split[i].split(":");
				if(split2.length<2){
					continue;
				}else{
					split[i] = split2[0]+":"+"'"+split2[1]+"'";
					sb.append(split[i]+",");
				}
			}
			condition = sb.toString().substring(0,sb.toString().length()-1);
			condition +="}";
		}
		JsonResult result = userService.findUsersByConidtion(condition, page, rows);
		return result;
	}
	
	/**
	 * 添加用户
	 */
	@ApiOperation("添加用户")
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(@RequestParam("account") String account,@RequestParam("password") String password,
			@RequestParam("roleNo") Integer roleNo){
		LoginUser record = new LoginUser();
		record.setAccount(account);
		record.setPassword(password);
		String message = null;
		if(record != null){
			if(userService.addUser(record)){
				UserRole userRole = new UserRole();
				userRole.setRolNo(roleNo);
				userRole.setUserNo(record.getNo());
				List<UserRole> list = new ArrayList<UserRole>();
				list.add(userRole);
				userService.allocationUserRole(list, record.getNo());
				message = "添加成功！";
			}else{
				message = "添加失败！";
			}
		}
		return message;
	}
	/**
	 * 删除用户
	 */
	@ApiOperation("删除用户")
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String deleteUser(Integer no) throws Exception{
		String msg = null;
		int n = 0;
		try{
			if(userService.deleteUser(no)){
				msg = "OK";
			}else{
				msg = "";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;
	}
	/**
	 * 去修改用户页面
	 */
	@RequestMapping("/Account/toModifyUser")
	public ModelAndView toModifyUser(Integer userId) throws Exception{
		LoginUser user = userService.findUserByPrimaryKey(userId);
		ModelAndView model = new ModelAndView();
		model.setViewName("Account/modifyUser");
		model.addObject(user);
		return model;
	}
	/**
	 * 修改用户
	 */
	@ApiOperation("修改用户")
	@RequestMapping("/modifyUser")
	@ResponseBody
	public String modifyUser(LoginUser user) throws Exception{
		String message = null;
		if(user != null){
			if(userService.modPass(user)){
				message = "修改成功！";
			}else{
				message = "修改失败！";
			}
		}
		return message;
	}
	/**
	 * 去分配权限页面
	 */
	@RequestMapping("toAllocationRole")
	@ResponseBody
	public ModelAndView toAllocationRole(int userId) throws Exception{
		ModelAndView model = new ModelAndView();
		model.addObject("userId", userId);
		model.setViewName("systemmanager/AllocationRole");
		return model;
	}
	/**
	 * 显示当前所有角色列表，并且勾选当前用户已拥有角色
	 */
	@RequestMapping("/AllocationUserRole")
	@ResponseBody
	public JsonResult showRole(Integer userId) throws Exception {
		return userService.showRole(userId);
	}
	/**
	 * 给用户添加角色，执行保存操作
	 */
	@ApiOperation("添加角色")
	@RequestMapping("/saveUserRole")
	@ResponseBody
	public String saveUserRole(Integer userId,String ids) throws Exception {
		List<UserRole> list = new ArrayList<UserRole>();
		String message = null;
		if(ids != null && !"".equals(ids)){
			String[] roleIds = ids.split(",");
			for (String str : roleIds) {
				if(str != null && !"".equals(str)){
					UserRole userRole = new UserRole();
					userRole.setUserNo(userId);
					userRole.setRolNo(Integer.valueOf(str));
					list.add(userRole);
				}
			}
		}
		if(userService.allocationUserRole(list, userId)){
			message = "OK";
		}else{
			message = "";
		}
		return message;
	}
}
