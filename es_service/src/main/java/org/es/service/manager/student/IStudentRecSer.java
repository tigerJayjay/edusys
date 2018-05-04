package org.es.service.manager.student;

import org.es.model.RecordInfo;

/**
 * 学生档案接口
 * @author Administrator
 *
 */
public interface IStudentRecSer {
	/**
	 * 通过学号获取学生档案信息
	 * @param stuNo
	 * @return
	 */
	RecordInfo getRecordByStuno(String stuNo);
	
	/**
	 * 通过档案号获取学生档案信息
	 * @param recNo
	 * @return
	 */
	RecordInfo getRecordByRecNo(String recNo);
	
	/**
	 * 添加档案信息
	 * @param recInfo
	 * @return
	 */
	boolean insertRecord(RecordInfo recInfo);
	
}
