package org.es.service.manager.courseschedule;

import org.es.bean.JsonResult;
import org.es.model.CourseBook;

public interface ICourseBookService {
	boolean insertCourseBook(CourseBook courseBook);
	
	boolean deleteCourseBook(Integer id);
	
	JsonResult getCourseBook(String condition,Integer page,Integer rows);
}
