package org.es.service.manager.student;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.CollegeMapper;
import org.es.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
@Service
public class CollegeServiceImpl implements ICollegeService{
	@Autowired
    private CollegeMapper collegeMapper;
	@Override
	public boolean insertCollege(College college) {
		// TODO Auto-generated method stub
		if(collegeMapper.insert(college)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCollege(College college) {
		// TODO Auto-generated method stub
		if(collegeMapper.updateByPrimaryKeySelective(college)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCollege(Integer no) {
		if(collegeMapper.deleteByPrimaryKey(String.valueOf(no))>0){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JsonResult getCollegeByCondition(String condition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<College> collegeByCondition = collegeMapper.selectByExample(null);
		res.setData(collegeByCondition);
		return res;
	}

}
