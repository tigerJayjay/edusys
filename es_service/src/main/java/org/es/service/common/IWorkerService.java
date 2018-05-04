package org.es.service.common;

import org.es.model.Worker;
import org.es.model.WorkerAward;

/**
 * 教职工操作接口
 * @author Administrator
 *
 */
public interface IWorkerService {
	/**
	 * 插入教职工
	 * @param worker
	 * @return
	 */
    boolean insertWorker(Worker worker);
    
    /**
     * 删除编号删除教职工
     * @param workerNo
     * @return
     */
    boolean deleteWorker(Integer workerNo);
    
    /**
     * 通过教职工工号查询教职工
     * @param worker
     * @return
     */
    Worker getWorker(String worker);
}
