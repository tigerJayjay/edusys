package org.es.service.manager.exam;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.ExamArrangementMapper;
import org.es.dao.ExamArrangementStatisMapper;
import org.es.dao.RoomUseInfoMapper;
import org.es.model.ExamArrangement;
import org.es.model.ExamArrangementExample;
import org.es.model.ExamArrangementStatis;
import org.es.model.RoomUseInfo;
import org.es.model.RoomUseInfoExample;
import org.es.model.RoomUseInfoExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import sun.tools.tree.ArrayAccessExpression;
@Service
public class ExamArrangeServiceImpl implements IExamArrangeService{
	@Autowired
    private ExamArrangementMapper examArrangementMapper;
	@Autowired
	private RoomUseInfoMapper roomUseInfoMapper;
	@Autowired
	private ExamArrangementStatisMapper arrangeStatisMapper;
	/**
	 * 批量考场安排
	 */
	@Override
	public JsonResult insertExamArrange(ExamArrangementStatis examArrangeStatis) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		//保存结果信息
		StringBuilder sb = new StringBuilder();
		sb.append("操作完成!");
		//保存失败数
		int count = 0;
		//座位号
		int i = 1;
		//保存学号信息
		ExamArrangementStatis selectByPrimaryKey = arrangeStatisMapper.selectByPrimaryKey(examArrangeStatis.getNo());
		List<String> studentNos = examArrangementMapper.getStudentByCourseNo(selectByPrimaryKey.getCourseNo());
		if(studentNos!=null){
			for(String s:studentNos){
				ExamArrangement examArrange = new ExamArrangement();
				examArrange.setExamno(examArrangeStatis.getNo());
				examArrange.setSno(s);
				examArrange.setSeatNumber(i);
				if(examArrangementMapper.insert(examArrange)<1){
					if(count<1){
						sb.append("保存失败的学生号和座号:");
					}
					sb.append("{"+s+":"+i+"}");
					++count;
					
				}
				++i;
			}
		}
		res.setResult(sb.toString());
		return res;
	}

	@Override
	public boolean deleteExamArrange(Integer examArrange) {
		// TODO Auto-generated method stub
		if(examArrangementMapper.deleteByPrimaryKey(examArrange)>0){
			
			return true;
		}
		return false;
	}

	@Override
	public boolean updateExamArrange(ExamArrangement examArrange) {
		// TODO Auto-generated method stub
		if(examArrangementMapper.updateByPrimaryKeySelective(examArrange)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getExamArrange(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		ExamArrangement examArran = JSONObject.parseObject(condition, ExamArrangement.class);
		int total = examArrangementMapper.selectByCondition(examArran).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
	    List<Map<String,Object>> list = examArrangementMapper.selectByCondition(examArran);
	    res.setStatus("200");
	    res.setRows(list);
	    res.setTotal(total);
	    return res;
	}
    /**
     * 单挑考场安排插入
     */
	@Override
	public boolean insertExamArrangeOne(ExamArrangement examArrange) {
		// TODO Auto-generated method stub
		
		if(examArrangementMapper.insert(examArrange)>0){
			
			return true;
		}
		return false;
	}
	
	private RoomUseInfo setRoomInfo(ExamArrangementStatis examArrange){
		RoomUseInfo useInfo = new RoomUseInfo();
		useInfo.setStartWeek(examArrange.getWeekno());
		useInfo.setEndWeek(examArrange.getWeekno());
		useInfo.setWeekth(examArrange.getWeekth());
		useInfo.setJie(examArrange.getSchooltime());
		useInfo.setRoomNo(Integer.valueOf(examArrange.getExamPlace()));
		useInfo.setMemo("考试使用");
		return useInfo;
		
	}

	@Override
	public ExamArrangement getOne(Integer no) {
		// TODO Auto-generated method stub
		return examArrangementMapper.selectByPrimaryKey(no);
	}

	@Override
	public JsonResult getExamArrangeStatis(String condition, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		ExamArrangementStatis examArran = JSONObject.parseObject(condition, ExamArrangementStatis.class);
		int total = arrangeStatisMapper.selectByCondition(examArran).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
	    List<Map<String,Object>> list = arrangeStatisMapper.selectByCondition(examArran);
	    res.setStatus("200");
	    res.setRows(list);
	    res.setTotal(total);
	    return res;
	}

	@Override
	public ExamArrangementStatis getOneStatis(Integer no) {
		// TODO Auto-generated method stub
		return arrangeStatisMapper.selectByPrimaryKey(no);
	}

	@Override
	public boolean insertExamArrangeStatis(ExamArrangementStatis arrangeStatis) {
		// TODO Auto-generated method stub
		RoomUseInfo useInfo = setRoomInfo(arrangeStatis);
		if(arrangeStatisMapper.insert(arrangeStatis)>0){
			roomUseInfoMapper.insert(useInfo);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteExamArrangeStatis(Integer arrangeStatis) {
		// TODO Auto-generated method stub
		ExamArrangementStatis arrange = arrangeStatisMapper.selectByPrimaryKey(arrangeStatis);
		if(arrangeStatisMapper.deleteByPrimaryKey(arrangeStatis)>0){
			if(arrange!=null){
				RoomUseInfoExample ruie = new RoomUseInfoExample();
				Criteria crarrangeteCriteria = ruie.createCriteria();
				crarrangeteCriteria.andRoomNoEqualTo(Integer.valueOf(arrange.getExamPlace()));
				crarrangeteCriteria.andStartWeekEqualTo(arrange.getWeekno());
				crarrangeteCriteria.andEndWeekEqualTo(arrange.getWeekno());
				crarrangeteCriteria.andWeekthEqualTo(arrange.getWeekth());
				crarrangeteCriteria.andJieEqualTo(arrange.getSchooltime());
				roomUseInfoMapper.deleteByExample(ruie);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateExamArrangeStatis(ExamArrangementStatis arrangeStatis) {
		// TODO Auto-generated method stub
		//先删除原来的教室使用情况
		RoomUseInfoExample ruie = new RoomUseInfoExample();
		Criteria createCriteria = ruie.createCriteria();
		createCriteria.andRoomNoEqualTo(Integer.valueOf(arrangeStatis.getExamPlace()));
		createCriteria.andStartWeekEqualTo(arrangeStatis.getWeekno());
		createCriteria.andEndWeekEqualTo(arrangeStatis.getWeekno());
		createCriteria.andWeekthEqualTo(arrangeStatis.getWeekth());
		createCriteria.andJieEqualTo(arrangeStatis.getSchooltime());
		roomUseInfoMapper.deleteByExample(ruie);
		RoomUseInfo useInfo = setRoomInfo(arrangeStatis);
		if(arrangeStatisMapper.updateByPrimaryKeySelective(arrangeStatis)>0){
			roomUseInfoMapper.insert(useInfo);
			return true;
		}
		return false;
	}

	@Override
	public List<ExamArrangement> getArrangeDetail(Integer no) {
		// TODO Auto-generated method stub
		ExamArrangementExample exa = new ExamArrangementExample();
		org.es.model.ExamArrangementExample.Criteria createCriteria = exa.createCriteria();
		createCriteria.andExamnoEqualTo(no);
		List<ExamArrangement> selectByExample = examArrangementMapper.selectByExample(exa);
		return selectByExample;
	}

}
