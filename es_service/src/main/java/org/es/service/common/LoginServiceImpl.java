package org.es.service.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.AuthorityMapper;
import org.es.dao.LoginUserMapper;
import org.es.dao.RoleAuthoMapper;
import org.es.dao.RoleMapper;
import org.es.dao.UserRoleMapper;
import org.es.model.Authority;
import org.es.model.LoginUser;
import org.es.model.LoginUserExample;
import org.es.model.LoginUserExample.Criteria;
import org.es.model.Role;
import org.es.model.RoleAutho;
import org.es.model.RoleAuthoExample;
import org.es.model.UserRole;
import org.es.model.UserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class LoginServiceImpl implements ILoginService{
	@Autowired
	private LoginUserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleAuthoMapper roleAuthMapper;
	@Autowired
	private AuthorityMapper authoMapper;
	/**
	 * 登录
	 */
	@Override
	public LoginUser login(LoginUser user) {
		// TODO Auto-generated method stub
		LoginUserExample userExa = new LoginUserExample();
		Criteria createCriteria = userExa.createCriteria();
		createCriteria.andAccountEqualTo(user.getAccount()).andPasswordEqualTo(user.getPassword());
		List<LoginUser> selectByExample = userMapper.selectByExample(userExa);
		if(selectByExample!=null && selectByExample.size()>0){
			LoginUser res = selectByExample.get(0);
			List<Role> roles = new ArrayList<Role>();
			roles = getRoles(res);
			for(Role r:roles){
				List<Authority> authoritys = getAuthoritys(r);
				r.setAuthList(authoritys);
			}
			res.setRoleList(roles);
			return res;
		}
		return null;
	}
	/**
	 * 获取用户角色信息
	 */
	@Override
	public List<Role> getRoles(LoginUser user) {
		// TODO Auto-generated method stub
		UserRoleExample urExa = new UserRoleExample();
		org.es.model.UserRoleExample.Criteria createCriteria = urExa.createCriteria();
		createCriteria.andUserNoEqualTo(user.getNo());
		List<UserRole> selectByExample = userRoleMapper.selectByExample(urExa);
		List<Role> res = new ArrayList<Role>();
		if(selectByExample!=null && selectByExample.size()>0){
			for(UserRole ur:selectByExample){
				Role selectByPrimaryKey = roleMapper.selectByPrimaryKey(ur.getRolNo());
				res.add(selectByPrimaryKey);
			}
		}
		return res;
	}
	/**
	 * 获取角色权限信息
	 */
	@Override
	public List<Authority> getAuthoritys(Role role) {
		// TODO Auto-generated method stub
		RoleAuthoExample raExa = new RoleAuthoExample();
		org.es.model.RoleAuthoExample.Criteria createCriteria = raExa.createCriteria();
		createCriteria.andRolNoEqualTo(role.getNo());
		List<RoleAutho> selectByExample = roleAuthMapper.selectByExample(raExa);
		List<Authority> res = new ArrayList<Authority>();
		if(selectByExample!=null && selectByExample.size()>0){
			for(RoleAutho ra:selectByExample){
				Authority selectByPrimaryKey = authoMapper.selectByPrimaryKey(ra.getAuthNo());
				res.add(selectByPrimaryKey);
			}
		}
		return res;
	}
	/**
	 * 修改密码
	 */
	@Override
	public boolean modPass(LoginUser user) {
		// TODO Auto-generated method stub
		int updateByPrimaryKeySelective = userMapper.updateByPrimaryKeySelective(user);
		if(updateByPrimaryKeySelective>0){
			return true;
		}
		return false;
	}
	@Override
	public LoginUser findUserByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}
	@Override
	public JsonResult findUsersByConidtion(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		// TODO Auto-generated method stub
		LoginUser parse = (LoginUser) JSONObject.parseObject(condition, LoginUser.class);
		int total = userMapper.selectByConditon(parse).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String,Object>> list = userMapper.selectByConditon(parse);
		res.setRows(list);
		res.setTotal(total);
		return res;
	}
	@Override
	public boolean addUser(LoginUser record) {
		// TODO Auto-generated method stub
		if(userMapper.insert(record)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		if(userMapper.deleteByPrimaryKey(userId)>0){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean allocationUserRole(List<UserRole> list, Integer userId) {
		// TODO Auto-generated method stub
		int count = 0;
		try{
			UserRoleExample exa = new UserRoleExample();
			org.es.model.UserRoleExample.Criteria createCriteria = exa.createCriteria();
			createCriteria.andUserNoEqualTo(userId);
			userRoleMapper.deleteByExample(exa);
			if(list != null && list.size() > 0){
				for (UserRole userRole : list) {
					int n = userRoleMapper.insert(userRole);
					count += n;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(count == 0){
			return false;
		}
		return true;
	}
	@Override
	public JsonResult showRole(Integer userId) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		List<Role> rolesSelected = userMapper.getRolesSelected(userId);
		res.setRows(rolesSelected);
		return res;
	}
	@Override
	public LoginUser getOne(Integer no) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(no);
	}

}
