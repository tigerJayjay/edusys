package org.es.service.common;

import java.util.List;

import org.es.dao.WorkerMapper;
import org.es.model.Worker;
import org.es.model.WorkerAward;
import org.es.model.WorkerExample;
import org.es.model.WorkerExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WorkerServiceImpl implements IWorkerService{
	@Autowired
    private WorkerMapper workerMapper;
	@Override
	public boolean insertWorker(Worker worker) {
		// TODO Auto-generated method stub
		if(workerMapper.insert(worker)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteWorker(Integer workerNo) {
		// TODO Auto-generated method stub
		if(workerMapper.deleteByPrimaryKey(workerNo)>0){
			return true;
		}
		return false;
	}

	@Override
	public Worker getWorker(String worker) {
		// TODO Auto-generated method stub
		WorkerExample we = new WorkerExample();
		Criteria createCriteria = we.createCriteria();
		createCriteria.andWorkerNoEqualTo(worker);
		List<Worker> selectByExample = workerMapper.selectByExample(we);
		if(selectByExample!=null && selectByExample.size()>0){
			return selectByExample.get(0);
		}
		return null;
	}

}
