package org.es.service.manager.student;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.model.Student;

public interface IStudentService {
	/**
	 * 获取所有学生信息
	 * @return
	 */
	List<Student> getAllStudent();
	/**
	 * 按条件分页获取学生信息
	 * @param condition
	 * @return
	 */
	JsonResult getStudentByCondition(String condition,Integer pageNum,Integer pageSize);
	
	/**
	 * 获取按条件查询的总数
	 * @param condition
	 * @return
	 */
	Integer getCountByCondition(String condition);
	
	/**
	 * 按照学号获取学生信息
	 * @param studentNo 学生学号
	 * @return 返回学生详细信息
	 */
	Student getOneStudent(String studentNo);
	
	/**
	 * 更新学生信息
	 * @param student 待更新学生信息
	 * @return 返回是否成功
	 */
	boolean updateStudent(Student student);
	
	/**
	 * 删除学生信息
	 * @param studentNo 待删除学生学号
	 * @return 返回是否删除成功
	 */
	boolean deleteStudent(String studentNo);
	
	/**
	 * 添加学生信息
	 * @param student 待添加学生信息
	 * @return 返回是否添加成功
	 */
	boolean addStudent(Student student);
	
}
