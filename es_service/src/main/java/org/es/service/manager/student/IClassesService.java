package org.es.service.manager.student;

import org.es.bean.JsonResult;
import org.es.model.Classes;

public interface IClassesService {

	boolean insertClasses(Classes classes);
	
	boolean updateClasses(Classes classes);
	
	boolean deleteClasses(Integer no);
	
	JsonResult getClassesByCondition(String condition,Integer pageNum,Integer pageSize);
	
	JsonResult getClassesBySpe(String speNo);
}
