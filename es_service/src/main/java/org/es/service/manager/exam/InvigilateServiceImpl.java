package org.es.service.manager.exam;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.InvigilateMapper;
import org.es.model.Invigilate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class InvigilateServiceImpl implements IInvigilateService{
	@Autowired
    private InvigilateMapper invigilateMapper;
	@Override
	public boolean insertInvigilate(Invigilate invigilate) {
		// TODO Auto-generated method stub
		if(invigilateMapper.insert(invigilate)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteInvigilate(Integer no) {
		// TODO Auto-generated method stub
		if(invigilateMapper.deleteByPrimaryKey(no)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateInvigilate(Invigilate invigilate) {
		// TODO Auto-generated method stub
		if(invigilateMapper.updateByPrimaryKey(invigilate)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getInvigilate(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		InvigilateQueryCondition cond = JSONObject.parseObject(condition, InvigilateQueryCondition.class);
		int total = invigilateMapper.selectByCondition(cond).size();
		if(pageNum!=null && pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> selectByCondition = invigilateMapper.selectByCondition(cond);
		if(selectByCondition!=null){
			res.setStatus("200");
			res.setRows(selectByCondition);
			res.setTotal(total);
			
		}else{
			res.setStatus("500");
			res.setResult("查询无结果!");
		}
		return res;
	}

	@Override
	public Invigilate getOne(Integer no) {
		// TODO Auto-generated method stub
		return invigilateMapper.selectByPrimaryKey(no);
	}

}
