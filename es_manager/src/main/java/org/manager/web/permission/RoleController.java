package org.manager.web.permission;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.es.bean.JsonResult;
import org.es.model.Role;
import org.es.model.RoleAutho;
import org.es.service.common.IAuthorityService;
import org.es.service.common.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IAuthorityService authorityService;
	/**
	 * 显示角色列表
	 */
	@RequestMapping("/showRole")
	@ResponseBody
	public JsonResult showRole(Integer page,Integer rows,Integer no){
		JsonResult result = roleService.getRoles(page, rows, no);
		return result;
	}
	/**
	 * 添加角色信息
	 */
	@ApiOperation("添加角色")
	@RequestMapping("/addRole")
	@ResponseBody
	public String addUser(String roleName,String authoNo){
		String message = null;
		String[] split = authoNo.split(",");
		List<RoleAutho> list = new ArrayList<RoleAutho>();
		Role record = new Role();
		record.setRoleName(roleName);
		if(record != null){
			if(roleService.insertRole(record)){
			    int roleNo = record.getNo();
			    for(int i=0;i<split.length;i++){
			    	if(!"".equals(split[i])){
				    	RoleAutho ra = new RoleAutho();
				    	ra.setAuthNo(Integer.valueOf(split[i]));
				    	ra.setRolNo(roleNo);
				    	list.add(ra);
			    	}
			    }
			    roleService.allocationPermission(list, roleNo);
				message = "添加成功！";
			}else{
				message = "添加失败！";
			}
		}
		return message;
	}
	/**
	 * 删除角色信息
	 */
	@ApiOperation("删除角色")
	@RequestMapping("/deleteRole")
	@ResponseBody
	public String deleteUser(Integer roleNo,HttpSession session) throws Exception{
		String msg = null;
		int n = 0;
		try{
			if(roleService.deleteRole(roleNo)){
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
	 * 去修改页面
	 */
	@RequestMapping("/toModifyRole")
	public ModelAndView toModifyUser(Integer roleId) throws Exception{
		Role role = roleService.getOne(roleId);
		ModelAndView model = new ModelAndView();
		model.setViewName("systemmanager/updRole");
		model.addObject("role",role);
		return model;
	}
	/**
	 * 修改角色信息
	 */
	@ApiOperation("修改角色")
	@RequestMapping("/modifyRole")
	@ResponseBody
	public String modifyUser(Role role,HttpSession session) throws Exception{
		int n = 0;
		String message = null;
		if(role != null){
			if(roleService.updateRole(role)){
				message = "修改成功！";
			}else{
				message = "修改失败！";
			}
		}
		session.setAttribute("message", message);
		return message;
	}
	/**
	 * 去分配权限页面
	 */
	@ApiOperation("分配权限")
	@RequestMapping("/toSetSysMenu")
	@ResponseBody
	public ModelAndView AllocationPermission(int roleNo) throws Exception{
		ModelAndView model = new ModelAndView();
		model.addObject("roleId", roleNo);
		model.setViewName("systemmanager/allocationAhtho");
		return model;
	}
	/**
	 * 显示权限列表，并且勾选当前用户已拥有权限
	 */
	@RequestMapping("/SetSysMenu")
	@ResponseBody
	public JsonResult toAllocationPermission(int roleId) throws Exception{
		JsonResult result = new JsonResult();
		result = roleService.getAuthoritySelected(roleId);
		return result;
	}
	/**
	 * 给角色添加权限，执行保存操作
	 */
	@ApiOperation("添加权限")
	@RequestMapping("/saveRolePermission")
	@ResponseBody
	public String saveRolePermission(int roleId,String ids) throws Exception {
		List<RoleAutho> list = new ArrayList<RoleAutho>();
		String message = null;
		int n = 0;
		if(ids != null && !"".equals(ids)){
			String[] permissionIds = ids.split(",");
			for (String str : permissionIds) {
				if(str != null && !"".equals(str)){
					RoleAutho rolePermission = new RoleAutho();
					rolePermission.setAuthNo(Integer.valueOf(str));
					rolePermission.setRolNo(roleId);
					list.add(rolePermission);
				}
			}
		}
		if(roleService.allocationPermission(list, roleId)){
			message = "OK";
		}else{
			message = "";
		}
		return message;
	}
	
}
