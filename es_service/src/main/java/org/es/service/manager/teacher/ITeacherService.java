package org.es.service.manager.teacher;

import org.es.bean.JsonResult;
import org.es.model.Teacher;

/**
 * 教师操作接口
 * @author Administrator
 *
 */
public interface ITeacherService {
	Teacher getOneTeacher(String tno);
	/**
	 * 增加教师信息
	 * @param teacher
	 * @return
	 */
	boolean insertTeacher(Teacher teacher);
	
	/**
	 * 删除教师信息
	 * @param tno
	 * @return
	 */
	boolean deleteTeacher(String tno);
	
	/**
	 * 更新教师信息
	 * @param teacher
	 * @return
	 */
	boolean updateTeacher(Teacher teacher);
	
	/**
	 * 按条件查询教室信息
	 * @param condition
	 * @return
	 */
	JsonResult getTeacherByCondition(String condition,Integer pageNum,Integer pageSize);
	
	/**
	 * 按条件获取教师数量
	 * @param condition
	 * @return
	 */
	Integer getCountByCondition(String condition);
}
