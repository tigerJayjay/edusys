package org.es.service.manager.logger;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.OperatorRecordMapper;
import org.es.model.OperatorRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class OperatorRecordServiceImpl implements IOperatorRecordService{
	@Autowired
    private OperatorRecordMapper operatorRecordMapper;
	@Override
	public boolean insertLogger(OperatorRecord record) {
		// TODO Auto-generated method stub
		if(operatorRecordMapper.insert(record)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteLogger(Integer no) {
		// TODO Auto-generated method stub
		if(operatorRecordMapper.deleteByPrimaryKey(no)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getLogger(String condition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		OperatorQueryCondition cond = JSONObject.parseObject(condition, OperatorQueryCondition.class);
		int total = operatorRecordMapper.selectByCondition(cond).size();
		if(pageNum!=null && pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> selectByCondition = operatorRecordMapper.selectByCondition(cond);
		res.setRows(selectByCondition);
		res.setTotal(total);
		return res;
	}

}
