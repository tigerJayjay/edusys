package org.es.service.manager.courseschedule;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.ScheduleMapper;
import org.es.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class ScheduleServiceImpl implements IScheduleService{
	@Autowired
    private ScheduleMapper scheduleMapper;
	@Override
	public boolean insertSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		if(scheduleMapper.insert(schedule)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		if(scheduleMapper.updateByPrimaryKeySelective(schedule)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSchedule(Integer no) {
		if(scheduleMapper.deleteByPrimaryKey(String.valueOf(no))>0){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JsonResult getScheduleByConditionSpread(String condition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		Schedule cond = JSONObject.parseObject(condition, Schedule.class);
		int total = scheduleMapper.getScheduleByCondition(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> scheduleByCondition = scheduleMapper.getScheduleByConditionSpread(cond);
		res.setRows(scheduleByCondition);
		res.setTotal(total);
		return res;
	}

	@Override
	public JsonResult getScheduleByConditionMerge(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		Schedule cond = JSONObject.parseObject(condition, Schedule.class);
		int total = scheduleMapper.getScheduleByConditionMerge(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> scheduleByCondition = scheduleMapper.getScheduleByConditionMerge(cond);
		res.setTotal(total);
		res.setRows(scheduleByCondition);
		return res;
	}

	@Override
	public JsonResult getScheduleByCondition(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		Schedule cond = JSONObject.parseObject(condition, Schedule.class);
		int total = scheduleMapper.getScheduleByCondition(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> scheduleByCondition = scheduleMapper.getScheduleByCondition(cond);
		res.setTotal(total);
		res.setRows(scheduleByCondition);
		return res;
	}

	@Override
	public Schedule getOne(String no) {
		// TODO Auto-generated method stub
		return scheduleMapper.selectByPrimaryKey(no);
	}

	@Override
	public String selectCourseNo(String scheNo) {
		// TODO Auto-generated method stub
		Schedule selectByPrimaryKey = scheduleMapper.selectByPrimaryKey(scheNo);
		return selectByPrimaryKey.getCourseNo();
	}
}
