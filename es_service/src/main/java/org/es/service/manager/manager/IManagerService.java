package org.es.service.manager.manager;

import org.es.bean.JsonResult;
import org.es.model.AdminPeople;

public interface IManagerService {
	boolean insertManager(AdminPeople admin);
	boolean updateManager(AdminPeople admin);
	boolean deleteManager(String no);
	AdminPeople getAdmin(String no);
	JsonResult getAdminByCondition(AdminPeople condition);
}
