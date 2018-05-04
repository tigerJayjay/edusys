package org.es.service.manager.student;

import org.es.bean.JsonResult;
import org.es.model.Specialty;

public interface ISpecialtyService {
	boolean insertSpecialty(Specialty specialty);
	
	boolean updateSpecialty(Specialty specialty);
	
	boolean deleteSpecialty(Integer no);
	
	JsonResult getSpecialtyByCondition(String condition,Integer pageNum,Integer pageSize);
	
	JsonResult getSpecialtyByCol(String colNo);
}
