package org.es.service.manager.exam;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.model.ExamArrangement;
import org.es.model.ExamArrangementStatis;

/**
 * 考试安排操作接口
 * @author Administrator
 *
 */
public interface IExamArrangeService {
	ExamArrangement getOne(Integer no);
	List<ExamArrangement> getArrangeDetail(Integer no);
	/**
	 * 添加单条考场安排详情
	 */
	boolean insertExamArrangeOne(ExamArrangement examArrange);
	/**
	 * 批量添加考试安排详情
	 */
	JsonResult insertExamArrange(ExamArrangementStatis examArrange);
	/**
	 * 删除考试安排详情
	 */
	boolean deleteExamArrange(Integer examArrange);
	/**
	 * 更新考试安排详情
	 */
	boolean updateExamArrange(ExamArrangement examArrange);
	/**
	 * 获取考试安排详情
	 */
	JsonResult getExamArrange(String condition,Integer pageNum,Integer pageSize);
	
	JsonResult getExamArrangeStatis(String condition,Integer pageNum,Integer pageSize);
	ExamArrangementStatis getOneStatis(Integer no);
	
	boolean insertExamArrangeStatis(ExamArrangementStatis arrangeStatis);
	
	boolean deleteExamArrangeStatis(Integer arrangeStatis);
	
	boolean updateExamArrangeStatis(ExamArrangementStatis arrangeStatis);
}
