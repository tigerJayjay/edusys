package org.es.service.manager.student;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.StudentMapper;
import org.es.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentMapper.selectByExample(null);
	}



	@Override
	public Student getOneStudent(String studentNo) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(studentNo);
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentMapper.updateByPrimaryKeySelective(student)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudent(String studentNo) {
		// TODO Auto-generated method stub
		if(studentMapper.deleteByPrimaryKey(studentNo)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentMapper.insertSelective(student)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getStudentByCondition(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		StudentQueryCondition parseObject = JSONObject.parseObject(condition, StudentQueryCondition.class);
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String,Object>> selectByCondition = studentMapper.selectByCondition(parseObject);
		res.setStatus("200");
		res.setRows(selectByCondition);
		return res;
	}



	@Override
	public Integer getCountByCondition(String condition) {
		// TODO Auto-generated method stub
		StudentQueryCondition parseObject = JSONObject.parseObject(condition, StudentQueryCondition.class);
		Integer selectCountByCondition = 0;
		selectCountByCondition = studentMapper.selectCountByCondition(parseObject);
		return selectCountByCondition;
	}
}
