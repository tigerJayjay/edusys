package org.es.service.common;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.model.Role;
import org.es.model.RoleAutho;

public interface IRoleService {
	boolean insertRole(Role role);
	
	boolean deleteRole(Integer roleNo);
	
	boolean updateRole(Role role);
	
	JsonResult getRoles(Integer pageNum,Integer pageSize,Integer no);
	
	JsonResult getAuthoritySelected(Integer no);
	
	Role getOne(Integer roleNo);
	
	boolean allocationPermission(List<RoleAutho> list,Integer roleNo);
}
