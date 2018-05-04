package org.es.service.common;

import java.util.ArrayList;
import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.WorkerAwardMapper;
import org.es.model.WorkerAward;
import org.es.model.WorkerAwardExample;
import org.es.model.WorkerAwardExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WorkerAwardServiceImpl implements IWorkerAwardService{
	@Autowired
	private WorkerAwardMapper awardMapper;
	@Override
	public boolean insertAward(WorkerAward workerAward) {
		// TODO Auto-generated method stub
		if(awardMapper.insert(workerAward)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAward(Integer awardNo) {
		// TODO Auto-generated method stub
		if(awardMapper.deleteByPrimaryKey(awardNo)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getAward(Integer workerNo) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		WorkerAwardExample waexa = new WorkerAwardExample();
		Criteria createCriteria = waexa.createCriteria();
		createCriteria.andWorkerNoEqualTo(workerNo);
		List<WorkerAward> list = new ArrayList<WorkerAward>();
		list = awardMapper.selectByExample(waexa);
		res.setRows(list);
		return res;
	}

	@Override
	public boolean updateAward(WorkerAward workerAward) {
		// TODO Auto-generated method stub
		if(awardMapper.updateByPrimaryKey(workerAward)>0){
			return true;
		}
		return false;
	}

	@Override
	public WorkerAward selectOneAward(Integer no) {
		// TODO Auto-generated method stub
		return awardMapper.selectByPrimaryKey(no);
	}

}
