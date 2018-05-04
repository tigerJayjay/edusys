package org.es.service.common;

import org.es.bean.JsonResult;
import org.es.model.Authority;

public interface IAuthorityService {
boolean insertAuthority(Authority authority);
	
	boolean deleteAuthority(Integer authorityNo);
	
	boolean updateAuthority(Authority authority);
	
	JsonResult getAuthoritys(Integer pageNum,Integer pageSize);
	
	Authority getOne(Integer authorityNo);
	
}
