package org.es.service.manager.teacher;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.model.CheckContent;
import org.es.model.EvaluateCon;

/**
 * 考评业务接口
 * @author Administrator
 *
 */
public interface ITeacherCheckService {
    /**
     * 获取考评统计信息
     */
	JsonResult getCheckResult(String condition,Integer pageNum,Integer pageSize);
	
	/**
	 * 添加考评信息
	 */
	boolean insertEvaluate(EvaluateCon eva);
	
	/**
	 * 显示考评内容
	 */
	JsonResult getCheckContent();
	
	boolean insertCheckContent(CheckContent content);
	
	boolean deleteCheckContent(Integer no);
	
	/**
	 * 按学年删除考评信息（启用定时器按时调用）
	 * @param yearTime
	 * @return
	 */
	boolean deleteEvaluate(String yearTime);
}
