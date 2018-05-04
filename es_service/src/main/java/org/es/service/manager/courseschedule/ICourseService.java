package org.es.service.manager.courseschedule;

import org.es.bean.JsonResult;
import org.es.model.Course;

/**
 * 课程操作接口
 * @author Administrator
 *
 */
public interface ICourseService {
	Course getOne(Integer no);
	boolean insertCourse(Course course);
	
	boolean updateCourse(Course course);
	
	boolean deleteCourse(Integer no);
	
	JsonResult getCourseByCondition(String condition,Integer pageNum,Integer pageSize);
	
	JsonResult getCourseType();
}
