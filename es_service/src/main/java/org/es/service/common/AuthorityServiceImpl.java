package org.es.service.common;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.AuthorityMapper;
import org.es.model.Authority;
import org.es.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
@Service
public class AuthorityServiceImpl implements IAuthorityService{
	@Autowired
	private AuthorityMapper authorityMapper;
	@Override
	public boolean insertAuthority(Authority authority) {
		// TODO Auto-generated method stub
		if(authorityMapper.insert(authority)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAuthority(Integer authorityNo) {
		// TODO Auto-generated method stub
		if(authorityMapper.deleteByPrimaryKey(authorityNo)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAuthority(Authority authority) {
		// TODO Auto-generated method stub
		if(authorityMapper.updateByPrimaryKeySelective(authority)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getAuthoritys(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		int total = authorityMapper.selectByExample(null).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Authority> selectByExample = authorityMapper.selectByExample(null);
		res.setRows(selectByExample);
		res.setTotal(total);
		return null;
	}

	@Override
	public Authority getOne(Integer authorityNo) {
		// TODO Auto-generated method stub
		return authorityMapper.selectByPrimaryKey(authorityNo);
	}

}
