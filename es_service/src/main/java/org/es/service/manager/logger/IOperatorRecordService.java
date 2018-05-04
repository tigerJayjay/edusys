package org.es.service.manager.logger;

import org.es.bean.JsonResult;
import org.es.model.OperatorRecord;

/**
 * 操作记录接口
 * @author Administrator
 *
 */
public interface IOperatorRecordService {
	/**
	 * 添加操作记录
	 * @param record
	 * @return
	 */
	boolean insertLogger(OperatorRecord record);
	
	/**
	 * 删除操作记录
	 */
	boolean deleteLogger(Integer no);
	
	/**
	 * 查询操作记录
	 * @param condition
	 * @return
	 */
	JsonResult getLogger(String condition,Integer pageNum,Integer pageSize);
}
