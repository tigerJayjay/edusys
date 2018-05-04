package org.es.service.manager.student;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.SpecialtyMapper;
import org.es.model.Specialty;
import org.es.model.SpecialtyExample;
import org.es.model.SpecialtyExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
@Service
public class SpecialtyServiceImpl implements ISpecialtyService{
	@Autowired
    private SpecialtyMapper specialtyMapper;
	@Override
	public boolean insertSpecialty(Specialty specialty) {
		// TODO Auto-generated method stub
		if(specialtyMapper.insert(specialty)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSpecialty(Specialty specialty) {
		// TODO Auto-generated method stub
		if(specialtyMapper.updateByPrimaryKeySelective(specialty)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSpecialty(Integer no) {
		if(specialtyMapper.deleteByPrimaryKey(String.valueOf(no))>0){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JsonResult getSpecialtyByCondition(String condition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Specialty> specialtyByCondition = specialtyMapper.selectByExample(null);
		res.setData(specialtyByCondition);
		return res;
	}

	@Override
	public JsonResult getSpecialtyByCol(String colNo) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		SpecialtyExample exa = new SpecialtyExample();
		Criteria createCriteria = exa.createCriteria();
		createCriteria.andColNoEqualTo(colNo);
		List<Specialty> selectByExample = specialtyMapper.selectByExample(exa);
		res.setRows(selectByExample);
		return res;
	}

}
