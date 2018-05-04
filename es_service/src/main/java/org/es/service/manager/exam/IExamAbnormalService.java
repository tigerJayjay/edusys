package org.es.service.manager.exam;

import org.es.bean.JsonResult;
import org.es.model.ExamAbnormal;

/**
 * 考场异常情况操作接口
 * @author Administrator
 *
 */
public interface IExamAbnormalService {
	ExamAbnormal getOne(Integer no);
	  /**
     * 添加考场异常信息
     */
	boolean insertExamAbnormal(ExamAbnormal examAbnormal);
	/**
	 * 删除考场异常信息
	 */
	boolean deleteExamAbnormal(Integer no);
	/**
	 * 更新考场异常信息
	 */
	boolean updateExamAbnormal(ExamAbnormal examAbnormal);
	/**
	 * 查询考场异常信息
	 */
	JsonResult getExamAbnormalByCondition(String condition,Integer pageNum,Integer pageSize);
}
