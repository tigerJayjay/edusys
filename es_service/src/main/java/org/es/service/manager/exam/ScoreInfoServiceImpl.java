package org.es.service.manager.exam;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.es.bean.JsonResult;
import org.es.dao.ExamStatusMapper;
import org.es.dao.ScoreInfoMapper;
import org.es.model.ExamStatus;
import org.es.model.ScoreInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

@Service
public class ScoreInfoServiceImpl implements IScoreInfoService{
	@Autowired
    private ScoreInfoMapper scoreInfoMapper;
	@Autowired
	private ExamStatusMapper examStatusMapper;
	@Override
	public boolean insertScoreInfo(ScoreInfo scoreInfo) {
		// TODO Auto-generated method stub
		if(scoreInfoMapper.insert(scoreInfo)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteScoreInfo(Integer no) {
		// TODO Auto-generated method stub
		if(scoreInfoMapper.deleteByPrimaryKey(no)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateScoreInfo(ScoreInfo scoreInfo) {
		// TODO Auto-generated method stub
		if(scoreInfoMapper.updateByPrimaryKeySelective(scoreInfo)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getScoreInfoByCondition(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		ScoreInfoQueryCondition cond = JSONObject.parseObject(condition,ScoreInfoQueryCondition.class);
		if(pageNum!=null && pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> selectScoreInfoByCondition = scoreInfoMapper.selectScoreInfoByCondition(cond);
		res.setRows(selectScoreInfoByCondition);
		return res;
	}

	@Override
	public boolean insertExamStatus(ExamStatus examStatus) {
		// TODO Auto-generated method stub
		if(examStatusMapper.insert(examStatus)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteExamStatus(Integer no) {
		// TODO Auto-generated method stub
		if(examStatusMapper.deleteByPrimaryKey(no)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateExamStatus(ExamStatus examStatus) {
		// TODO Auto-generated method stub
		if(examStatusMapper.updateByPrimaryKeySelective(examStatus)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getExamStatusByCondition(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		if(pageNum!=null && pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<ExamStatus> selectByExample = examStatusMapper.selectByExample(null);
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		if(selectByExample!=null){
 			for(ExamStatus es:selectByExample){
 				Map<String,Object> map = new HashMap<String,Object>();
 				try {
					BeanUtils.populate(es, map);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 				data.add(map);
			}
		}
		res.setData(data);
		return res;
	}

}
