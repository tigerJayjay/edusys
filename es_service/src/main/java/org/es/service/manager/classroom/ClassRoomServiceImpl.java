package org.es.service.manager.classroom;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.ClassroomMapper;
import org.es.dao.RoomUseInfoMapper;
import org.es.model.Classroom;
import org.es.model.RoomUseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

@Service
public class ClassRoomServiceImpl implements IClassRoomService{
	@Autowired
    private ClassroomMapper classRoomMapper;
	
	@Autowired
	private RoomUseInfoMapper useInfoMapper;
	@Override
	public boolean insertClassRoom(Classroom classRoom) {
		// TODO Auto-generated method stub
		if(classRoomMapper.insert(classRoom)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteClassRoom(Integer no) {
		// TODO Auto-generated method stub
		if(classRoomMapper.deleteByPrimaryKey(no)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateClassRoom(Classroom classRoom) {
		// TODO Auto-generated method stub
		if(classRoomMapper.updateByPrimaryKeySelective(classRoom)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getUsableClassRoomByCondition(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();

		RoomUseInfo parseObject = JSONObject.parseObject(condition,RoomUseInfo.class);
		int total = classRoomMapper.selectByCondition(parseObject).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> selectByCondition = classRoomMapper.selectByCondition(parseObject);
		res.setTotal(total);
		res.setRows(selectByCondition);
		res.setPage(pageNum);
		res.setPageSize(pageSize);
		return res;
	}

	@Override
	public JsonResult getClassRoomByCondition(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		Classroom parseObject = JSONObject.parseObject(condition,Classroom.class);
		int total = classRoomMapper.selectAllByCondition(parseObject).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String, Object>> selectByCondition = classRoomMapper.selectAllByCondition(parseObject);
		res.setRows(selectByCondition);
		res.setTotal(total);
		return res;
	}

	@Override
	public boolean insertRoomUseInfo(RoomUseInfo useInfo) {
		// TODO Auto-generated method stub
		if(useInfoMapper.insert(useInfo)>0){
			return true;
		}
		return false;
	}
	

}
