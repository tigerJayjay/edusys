package org.es.service.student.selectcourse;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.CourseSelectInfoMapper;
import org.es.model.CourseSelectInfo;
import org.es.model.CourseSelectInfoExample;
import org.es.model.CourseSelectInfoExample.Criteria;
import org.es.model.Schedule;
import org.es.service.manager.courseschedule.CourseQueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class SelectCourseImpl implements ISelectCourse{
	@Autowired
	private CourseSelectInfoMapper courseSelectMapper;
	@Override
	public boolean insertSelectCourse(CourseSelectInfo selectInfo) {
		// TODO Auto-generated method stub
		if(courseSelectMapper.insert(selectInfo)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSelectCourse(String sno, Integer scheNo) {
		// TODO Auto-generated method stub
		CourseSelectInfoExample exa = new CourseSelectInfoExample();
		Criteria createCriteria = exa.createCriteria();
		createCriteria.andScheNoEqualTo(String.valueOf(scheNo));
		createCriteria.andSnoEqualTo(sno);
		if(courseSelectMapper.deleteByExample(exa)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getByCondition(String condition) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		SelectCourseCondition cond = (SelectCourseCondition)JSONObject.parseObject(condition, SelectCourseCondition.class);
		List<Map<String, Object>> selectByCondition = courseSelectMapper.selectByCondition(cond);
		res.setRows(selectByCondition);
		return res;
	}

	@Override
	public JsonResult getSelectedCondition(String condition) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		Schedule cond = (Schedule)JSONObject.parseObject(condition, Schedule.class);
		List<Map<String, Object>> selectByCondition = courseSelectMapper.selectCourseCondition(cond);
		res.setRows(selectByCondition);
		return res;
	}

}
