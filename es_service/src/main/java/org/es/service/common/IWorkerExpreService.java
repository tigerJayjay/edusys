package org.es.service.common;

import org.es.bean.JsonResult;
import org.es.model.WorkExpre;

/**
 * 教职工工作经历接口
 * @author Administrator
 *
 */
public interface IWorkerExpreService {
	WorkExpre getOneWorkExpre(Integer no);
    /**
     * 增加工作经历
     */
	boolean insertWorkExpre(WorkExpre workExpre);
	
	
	/**
	 * 修改工作经历
	 */
	boolean updateWorkExpre(WorkExpre workExpre);
	
	/**
	 * 删除工作经历
	 */
	boolean deleteWorkExpre(Integer workNo);
	
	/**
	 * 获取某个教职工工作经历
	 * @return
	 */
	JsonResult getWorkExpre(String workerNo);
}
