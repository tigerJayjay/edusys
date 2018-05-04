package org.es.service.common;

import org.es.bean.JsonResult;
import org.es.model.WorkerAward;

/**
 * 获奖情况接口
 * @author Administrator
 *
 */
public interface IWorkerAwardService {
	WorkerAward selectOneAward(Integer no);
	/**
	 * 添加获奖信息
	 * @param workerAward
	 * @return
	 */
	boolean insertAward(WorkerAward workerAward);
	
	/**
	 * 删除获奖信息
	 * @param awardNo
	 * @return
	 */
	boolean deleteAward(Integer awardNo);
	
	/**
	 * 通过教职工号获取获奖信息
	 * @param workerNo
	 * @return
	 */
	JsonResult getAward(Integer workerNo);
	
	/**
	 * 更新获奖信息
	 * @param workerAward
	 * @return
	 */
	boolean updateAward(WorkerAward workerAward);
}
