package org.es.service.manager.exam;

import org.es.bean.JsonResult;
import org.es.model.Invigilate;

/**
 * 监考安排
 * @author Administrator
 *
 */
public interface IInvigilateService {
	
	Invigilate getOne(Integer no);
    /**
     *添加监考安排
     */
	boolean insertInvigilate(Invigilate invigilate);
	/**
	 * 删除考试安排
	 */
	boolean deleteInvigilate(Integer no);
	/**
	 * 修改考试安排
	 */
	boolean updateInvigilate(Invigilate invigilate);
	/**
	 * 获取考试安排
	 */
	JsonResult getInvigilate(String condition,Integer pageNum,Integer pageSize);
}
