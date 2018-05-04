package org.es.service.manager.courseschedule;

import org.es.bean.JsonResult;
import org.es.model.Schedule;

/**
 * 排课接口
 * @author Administrator
 *
 */
public interface IScheduleService {
	String selectCourseNo(String scheNo);
	
	Schedule getOne(String no);
	
    boolean insertSchedule(Schedule schedule);
	
	boolean updateSchedule(Schedule schedule);
	
	boolean deleteSchedule(Integer no);
	
	JsonResult getScheduleByConditionSpread(String condition,Integer pageNum,Integer pageSize);
	
	JsonResult getScheduleByConditionMerge(String condition,Integer pageNum,Integer pageSize);
	
	JsonResult getScheduleByCondition(String condition,Integer pageNum,Integer pageSize);
}	
