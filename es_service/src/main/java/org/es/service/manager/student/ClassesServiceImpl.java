package org.es.service.manager.student;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.ClassesMapper;
import org.es.model.Classes;
import org.es.model.ClassesExample;
import org.es.model.ClassesExample.Criteria;
import org.es.model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
@Service
public class ClassesServiceImpl implements IClassesService{
	@Autowired
    private ClassesMapper classesMapper;
	@Override
	public boolean insertClasses(Classes classes) {
		// TODO Auto-generated method stub
		if(classesMapper.insert(classes)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateClasses(Classes classes) {
		// TODO Auto-generated method stub
		if(classesMapper.updateByPrimaryKeySelective(classes)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteClasses(Integer no) {
		if(classesMapper.deleteByPrimaryKey(String.valueOf(no))>0){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JsonResult getClassesByCondition(String condition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Classes> classesByCondition = classesMapper.selectByExample(null);
		res.setData(classesByCondition);
		return res;
	}

	@Override
	public JsonResult getClassesBySpe(String speNo) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		ClassesExample exa = new ClassesExample();
		Criteria createCriteria = exa.createCriteria();
		createCriteria.andSpeNoEqualTo(speNo);
		List<Classes> selectByExample = classesMapper.selectByExample(exa);
		res.setRows(selectByExample);
		return res;
	}

}
