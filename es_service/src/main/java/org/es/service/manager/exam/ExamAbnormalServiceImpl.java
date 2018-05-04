package org.es.service.manager.exam;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.ExamAbnormalMapper;
import org.es.dao.ScoreInfoMapper;
import org.es.model.ExamAbnormal;
import org.es.model.ScoreInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class ExamAbnormalServiceImpl implements IExamAbnormalService{
	@Autowired
	private ExamAbnormalMapper examAbnormalMapper;
	@Autowired
	private ScoreInfoMapper scoreInfoMapper;
	@Override
	public boolean insertExamAbnormal(ExamAbnormal examAbnormal) {
		// TODO Auto-generated method stub
		if(examAbnormalMapper.insert(examAbnormal)>0){
			return true;
		}
		return false;
	}
 
	@Override
	public boolean deleteExamAbnormal(Integer no) {
		// TODO Auto-generated method stub
		if(examAbnormalMapper.deleteByPrimaryKey(no)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateExamAbnormal(ExamAbnormal examAbnormal) {
		// TODO Auto-generated method stub
		if(examAbnormalMapper.updateByPrimaryKeySelective(examAbnormal)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getExamAbnormalByCondition(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res =  new JsonResult();
		ExamAboQueryCondition cond  = JSONObject.parseObject(condition,ExamAboQueryCondition.class);
		int total = examAbnormalMapper.selectExamAboByCondition(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> selectExamAboByCondition = examAbnormalMapper.selectExamAboByCondition(cond);
		res.setTotal(total);
		res.setRows(selectExamAboByCondition);
		return res;
	}

	@Override
	public ExamAbnormal getOne(Integer no) {
		// TODO Auto-generated method stub
		return examAbnormalMapper.selectByPrimaryKey(no);
	}

}
