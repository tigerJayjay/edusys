package org.es.service.manager.exam;

import org.es.bean.JsonResult;
import org.es.model.ExamStatus;
import org.es.model.ScoreInfo;

/**
 * 成绩操作接口
 * @author Administrator
 *
 */
public interface IScoreInfoService {
    /**
     * 添加成绩信息
     */
	boolean insertScoreInfo(ScoreInfo scoreInfo);
	/**
	 * 删除成绩信息
	 */
	boolean deleteScoreInfo(Integer no);
	/**
	 * 更新成绩信息
	 */
	boolean updateScoreInfo(ScoreInfo scoreInfo);
	/**
	 * 查询成绩信息
	 */
	JsonResult getScoreInfoByCondition(String condition,Integer pageNum,Integer pageSize);
	
	  /**
     * 添加成绩状态信息
     */
	boolean insertExamStatus(ExamStatus examStatus);
	/**
	 * 删除成绩状态信息
	 */
	boolean deleteExamStatus(Integer no);
	/**
	 * 更新成绩状态信息
	 */
	boolean updateExamStatus(ExamStatus examStatus);
	/**
	 * 查询成绩状态信息
	 */
	JsonResult getExamStatusByCondition(String condition,Integer pageNum,Integer pageSize);
	
	
}
