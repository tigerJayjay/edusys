package org.es.service.common;

import java.util.ArrayList;
import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.WorkExpreMapper;
import org.es.model.WorkExpre;
import org.es.model.WorkExpreExample;
import org.es.model.WorkExpreExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WorkExpreServiceImpl implements IWorkerExpreService{
	@Autowired
    private WorkExpreMapper workExpreMapper;
	@Override
	public boolean insertWorkExpre(WorkExpre workExpre) {
		// TODO Auto-generated method stub
		if(workExpreMapper.insert(workExpre)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateWorkExpre(WorkExpre workExpre) {
		// TODO Auto-generated method stub
		if(workExpreMapper.updateByPrimaryKey(workExpre)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteWorkExpre(Integer workNo) {
		// TODO Auto-generated method stub
		if(workExpreMapper.deleteByPrimaryKey(workNo)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getWorkExpre(String workerNo) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		List<WorkExpre> list = new ArrayList<WorkExpre>();
		WorkExpreExample wee = new WorkExpreExample();
		Criteria createCriteria = wee.createCriteria();
		createCriteria.andWorkerNoEqualTo(Integer.valueOf(workerNo));
		list = workExpreMapper.selectByExample(wee);
		res.setRows(list);
		return res;
	}

	@Override
	public WorkExpre getOneWorkExpre(Integer no) {
		// TODO Auto-generated method stub
		return workExpreMapper.selectByPrimaryKey(no);
	}

}
