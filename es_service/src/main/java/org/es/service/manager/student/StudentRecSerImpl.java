package org.es.service.manager.student;

import java.util.List;

import org.es.dao.RecordInfoMapper;
import org.es.model.RecordInfo;
import org.es.model.RecordInfoExample;
import org.es.model.RecordInfoExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRecSerImpl implements IStudentRecSer{
	@Autowired
	private RecordInfoMapper recInfoMapper;
	@Override
	public RecordInfo getRecordByStuno(String stuNo) {
		// TODO Auto-generated method stub
		RecordInfoExample riex = new RecordInfoExample();
		Criteria createCriteria = riex.createCriteria();
		createCriteria.andStuUniNoEqualTo(stuNo);
		List<RecordInfo> selectByExample = recInfoMapper.selectByExample(riex);
		if(selectByExample!=null && selectByExample.size()>0){
			return selectByExample.get(0);
		}
		return null;
	}

	@Override
	public RecordInfo getRecordByRecNo(String recNo) {
		// TODO Auto-generated method stub
		return recInfoMapper.selectByPrimaryKey(recNo);
	}

	@Override
	public boolean insertRecord(RecordInfo recInfo) {
		// TODO Auto-generated method stub
		if(recInfoMapper.insert(recInfo)>0){
			return true;
		}
		return false;
	}

}
