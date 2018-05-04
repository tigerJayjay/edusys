package org.es.service.common;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.RoleAuthoMapper;
import org.es.dao.RoleMapper;
import org.es.dao.UserRoleMapper;
import org.es.model.Role;
import org.es.model.RoleAutho;
import org.es.model.RoleAuthoExample;
import org.es.model.RoleAuthoExample.Criteria;
import org.es.model.UserRole;
import org.es.model.UserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
@Service
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleAuthoMapper roleAuthoMapper;
	@Override
	public boolean insertRole(Role role) {
		// TODO Auto-generated method stub
		if(roleMapper.insert(role)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRole(Integer roleNo) {
		// TODO Auto-generated method stub
		if(roleMapper.deleteByPrimaryKey(roleNo)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateRole(Role role) {
		// TODO Auto-generated method stub
		if(roleMapper.updateByPrimaryKeySelective(role)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getRoles(Integer pageNum,Integer pageSize,Integer no) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		int total = roleMapper.selectByConditon(no).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String,Object>> selectByExample = roleMapper.selectByConditon(no);
		res.setRows(selectByExample);
		res.setTotal(total);
		return res;
	}

	@Override
	public Role getOne(Integer roleNo) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(roleNo);
	}

	@Override
	public JsonResult getAuthoritySelected(Integer no) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		List<Map<String, Object>> ahthSelected = roleMapper.getAuthSelected(no);
		res.setRows(ahthSelected);
		   
		return res;
	}

	@Override
	public boolean allocationPermission(List<RoleAutho> list, Integer roleNo) {
		// TODO Auto-generated method stub
		int count = 0;
		try{
			RoleAuthoExample exa = new RoleAuthoExample();
			Criteria createCriteria = exa.createCriteria();
			createCriteria.andRolNoEqualTo(roleNo);
			roleAuthoMapper.deleteByExample(exa);
			if(list != null && list.size() > 0){
				for (RoleAutho roleAutho : list) {
					int n = roleAuthoMapper.insert(roleAutho);
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

}
