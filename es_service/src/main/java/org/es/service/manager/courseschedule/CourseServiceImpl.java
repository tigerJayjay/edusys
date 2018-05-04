package org.es.service.manager.courseschedule;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.CourseMapper;
import org.es.dao.CourseTypeMapper;
import org.es.model.Course;
import org.es.model.CourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
    private CourseMapper courseMapper;
	@Autowired
	private CourseTypeMapper courseTypeMapper;
	@Override
	public boolean insertCourse(Course course) {
		// TODO Auto-generated method stub
		if(courseMapper.insert(course)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCourse(Course course) {
		// TODO Auto-generated method stub
		if(courseMapper.updateByPrimaryKeySelective(course)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCourse(Integer no) {
		if(courseMapper.deleteByPrimaryKey(String.valueOf(no))>0){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JsonResult getCourseByCondition(String condition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		CourseQueryCondition cond = JSONObject.parseObject(condition, CourseQueryCondition.class);
		int total = courseMapper.getCourseByCondition(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> courseByCondition = courseMapper.getCourseByCondition(cond);
		res.setRows(courseByCondition);
		res.setTotal(total);
		return res;
	}

	@Override
	public JsonResult getCourseType() {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		List<CourseType> selectByExample = courseTypeMapper.selectByExample(null);
		res.setRows(selectByExample);
		return res;
	}

	@Override
	public Course getOne(Integer no) {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(String.valueOf(no));
	}

}
