package org.es.service.manager.teacher;

import java.util.ArrayList;
import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.CheckContentMapper;
import org.es.dao.EvaluateConMapper;
import org.es.dao.SelectionMapper;
import org.es.model.CheckContent;
import org.es.model.EvaluateCon;
import org.es.model.EvaluateConExample;
import org.es.model.EvaluateConExample.Criteria;
import org.es.model.Selection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class TeacherCheckServiceImpl implements ITeacherCheckService{
	@Autowired
    private EvaluateConMapper evaMapper;
	@Autowired
	private SelectionMapper selectionMapper;
	@Autowired
	private CheckContentMapper checkConMapper;
	@Override
	public JsonResult getCheckResult(String condition,Integer pageNum,Integer pageSize) {
		JsonResult res = new JsonResult();
		// TODO Auto-generated method stub
		TeaCheckQueryCondition parse = (TeaCheckQueryCondition) JSONObject.parseObject(condition, TeaCheckQueryCondition.class);
		int total = evaMapper.getCheckResult(parse).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<TeacherCheckResult> checkResult = new ArrayList<TeacherCheckResult>();
		checkResult = evaMapper.getCheckResult(parse);
		res.setRows(checkResult);
		res.setTotal(total);
		return res;
	}

	@Override
	public boolean insertEvaluate(EvaluateCon eva) {
		// TODO Auto-generated method stub
		if(evaMapper.insert(eva)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getCheckContent() {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		List<CheckContent> checkContents = new ArrayList<CheckContent>();
		checkContents = checkConMapper.selectByExample(null);
		List<Selection> selections = selectionMapper.selectByExample(null);
		for(CheckContent c:checkContents){
			if(c!=null){
				c.setSelections(selections);
			}
		}
		res.setRows(checkContents);
		return res;
	}

	@Override
	public boolean deleteEvaluate(String yearTime) {
		// TODO Auto-generated method stub
		EvaluateConExample evaExa = new EvaluateConExample();
		Criteria createCriteria = evaExa.createCriteria();
		createCriteria.andYeartimeEqualTo(yearTime);
		if(evaMapper.deleteByExample(evaExa)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertCheckContent(CheckContent content) {
		// TODO Auto-generated method stub
		if(checkConMapper.insert(content)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCheckContent(Integer no) {
		// TODO Auto-generated method stub
		if(checkConMapper.deleteByPrimaryKey(no)>0){
			return true;
		}
		return false;
	}

}
