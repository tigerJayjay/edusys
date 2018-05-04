package org.es.service.manager.manager;

import org.es.bean.JsonResult;
import org.es.dao.AdminPeopleMapper;
import org.es.model.AdminPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements IManagerService{
	@Autowired
	private AdminPeopleMapper adminMapper;
	@Override
	public boolean insertManager(AdminPeople admin) {
		// TODO Auto-generated method stub
		if(adminMapper.insert(admin)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateManager(AdminPeople admin) {
		// TODO Auto-generated method stub
		if(adminMapper.updateByPrimaryKeySelective(admin)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteManager(String no) {
		// TODO Auto-generated method stub
		if(adminMapper.deleteByPrimaryKey(no)>0){
			return true;
		}
		return false;
	}

	@Override
	public AdminPeople getAdmin(String no) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(no);
	}

	@Override
	public JsonResult getAdminByCondition(AdminPeople condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
