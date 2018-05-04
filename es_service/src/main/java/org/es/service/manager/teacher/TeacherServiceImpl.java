package org.es.service.manager.teacher;

import java.util.ArrayList;
import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.TeacherMapper;
import org.es.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class TeacherServiceImpl implements ITeacherService{
	@Autowired
	private TeacherMapper teacherMapper;
	@Override
	public boolean insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		if(teacherMapper.insert(teacher)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTeacher(String tno) {
		// TODO Auto-generated method stub
		if(teacherMapper.deleteByPrimaryKey(tno)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		if(teacherMapper.updateByPrimaryKeySelective(teacher)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getTeacherByCondition(String condition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stubStudentQueryCondition parseObject = JSONObject.parseObject(condition, StudentQueryCondition.class);
		JsonResult res = new JsonResult();
		TeacherQueryCondition parseObject = JSONObject.parseObject(condition, TeacherQueryCondition.class);
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Teacher> selectByCondition = new ArrayList<Teacher>();
		selectByCondition = teacherMapper.selectByCondition(parseObject);
		res.setRows(selectByCondition);
		return res;
	}

	@Override
	public Integer getCountByCondition(String condition) {
		// TODO Auto-generated method stub
		TeacherQueryCondition parseObject = JSONObject.parseObject(condition, TeacherQueryCondition.class);
		Integer res = teacherMapper.selectCountByCondition(parseObject);
		return res;
	}

	@Override
	public Teacher getOneTeacher(String tno) {
		// TODO Auto-generated method stub
		
		return 	teacherMapper.selectByPrimaryKey(tno);
	}

}
