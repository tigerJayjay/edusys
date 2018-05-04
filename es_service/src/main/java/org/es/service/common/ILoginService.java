package org.es.service.common;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.model.Authority;
import org.es.model.LoginUser;
import org.es.model.Role;
import org.es.model.UserRole;

/**
 * 登录业务接口
 * @author Administrator
 *
 */
public interface ILoginService {
	LoginUser getOne(Integer no);
	/**
	 * 用户登录
	 */
	public  LoginUser login(LoginUser user);
	
	/**
	 * 获取用户所有角色
	 */
	public List<Role> getRoles(LoginUser user);
	
	/**
	 * 获取角色所有权限
	 */
	public List<Authority> getAuthoritys(Role role);
	
	/**
	 * 修改密码
	 * @return
	 */
	public boolean modPass(LoginUser user); 
	
	
	/**
	 * 通过主键查找用户
	 */
	LoginUser findUserByPrimaryKey(Integer userId);
	/**
	 * 按条件分页查询用户信息
	 */
	JsonResult findUsersByConidtion(String condition,Integer pageNum,Integer pageSize);
	
	JsonResult showRole(Integer userId);
	/**
	 * 添加用户
	 */
	boolean addUser(LoginUser record);
	/**
	 * 通过主键删除用户
	 */
	boolean deleteUser(Integer  userId);
	
	/**
	 * 给用户添加角色,给用户分配角色
	 */
	boolean allocationUserRole(List<UserRole> list,Integer userId);
	
	
	
}
