package org.es.service.student.selectcourse;

import org.es.bean.JsonResult;
import org.es.model.CourseSelectInfo;

public interface ISelectCourse {
	boolean insertSelectCourse(CourseSelectInfo selectInfo);
	
	boolean deleteSelectCourse(String sno,Integer scheNo);
	
	JsonResult getByCondition(String condition);
	
	JsonResult getSelectedCondition(String condition);
}
