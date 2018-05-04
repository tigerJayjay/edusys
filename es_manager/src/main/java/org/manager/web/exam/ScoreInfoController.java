package org.manager.web.exam;

import org.es.bean.JsonResult;
import org.es.model.ScoreInfo;
import org.es.service.manager.exam.IScoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api("成绩操作类")
@Controller
@RequestMapping("/scoreInfo")
public class ScoreInfoController {
	@Autowired
    private IScoreInfoService scoreInfoService;
	
	@RequestMapping(value="/getScoreInfo",method=RequestMethod.POST)
	@ApiOperation(value="获取成绩信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页码",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页多少条",paramType="query",dataType="Integer")
	})
	public JsonResult getScoreInfo(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
		JsonResult scoreInfoByCondition = scoreInfoService.getScoreInfoByCondition(condition, pageNum, pageSize);
		return scoreInfoByCondition;
	}
	@RequestMapping(value="insertScoreInfo",method=RequestMethod.POST)
	@ApiOperation(value="添加成绩信息")
	@ApiImplicitParam(name="scoreInfo",value="成绩信息",paramType="body",dataType="ScoreInfo")
	public JsonResult insertScoreInfo(@RequestBody ScoreInfo scoreInfo){
		JsonResult res = new JsonResult();
		if(scoreInfoService.insertScoreInfo(scoreInfo)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	@RequestMapping(value="deleteScoreInfo",method=RequestMethod.POST)
	@ApiOperation(value="删除成绩信息")
	@ApiImplicitParam(name="scoreInfoNo",value="成绩编码",paramType="query",dataType="Integer")
	public JsonResult deleteScoreInfo(Integer scoreInfoNo){
		JsonResult res = new JsonResult();
		if(scoreInfoService.deleteScoreInfo(scoreInfoNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	@RequestMapping(value="updateScoreInfo",method=RequestMethod.POST)
	@ApiOperation(value="更新成绩信息")
	@ApiImplicitParam(name="scoreInfo",value="成绩信息",paramType="body",dataType="ScoreInfo")
	public JsonResult updateScoreInfo(@RequestBody ScoreInfo scoreInfo){
		JsonResult res = new JsonResult();
		if(scoreInfoService.updateScoreInfo(scoreInfo)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
	@RequestMapping(value="/getExamStatus",method=RequestMethod.POST)
	@ApiOperation(value="获取成绩状态信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页码",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页多少条",paramType="query",dataType="Integer")
	})
	public JsonResult getExamStatus(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
		JsonResult examStatusByCondition = scoreInfoService.getScoreInfoByCondition(condition, pageNum, pageSize);
		return examStatusByCondition;
	}
}
