package org.es.service.manager.student;

import org.es.bean.JsonResult;
import org.es.model.College;

public interface ICollegeService {
	boolean insertCollege(College college);
	
	boolean updateCollege(College college);
	
	boolean deleteCollege(Integer no);
	
	JsonResult getCollegeByCondition(String condition,Integer pageNum,Integer pageSize);
}
