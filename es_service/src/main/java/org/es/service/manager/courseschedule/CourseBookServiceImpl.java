package org.es.service.manager.courseschedule;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.CourseBookMapper;
import org.es.model.CourseBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class CourseBookServiceImpl implements ICourseBookService{
	@Autowired
	private CourseBookMapper courseBookMapper;
	@Override
	public boolean insertCourseBook(CourseBook courseBook) {
		// TODO Auto-generated method stub
		if(courseBookMapper.insert(courseBook)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCourseBook(Integer id) {
		// TODO Auto-generated method stub
		if(courseBookMapper.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getCourseBook(String condition, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		CourseBook cb = (CourseBook)JSONObject.parseObject(condition,CourseBook.class);
		int total = courseBookMapper.selectByCondition(cb).size();
		if(page!=null&&rows!=null){
			PageHelper.startPage(page,rows);
		}
		List<Map<String, Object>> selectByCondition = courseBookMapper.selectByCondition(cb);
		res.setResult("200");
		res.setRows(selectByCondition);
		res.setTotal(total);
		return res;
	}

}
