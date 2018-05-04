package org.manager.web.exam;

import javax.servlet.http.HttpServletRequest;

import org.es.bean.JsonResult;
import org.es.model.ExamAbnormal;
import org.es.service.manager.exam.IExamAbnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api("考场异常信息操作类")
@RequestMapping("/examAbnormal")
public class ExamAbnoController {
	@Autowired
	private IExamAbnormalService examAbnormalService;
	@RequestMapping("/toModifyExamAbnor")
	public String toModifyExamAbnor(HttpServletRequest request,Integer no){
		ExamAbnormal one = examAbnormalService.getOne(no);
		request.setAttribute("abnor", one);
		return "exam/updateAbnor";
	}
	@ResponseBody
	@RequestMapping(value="/getExamAbnormal",method=RequestMethod.POST)
	@ApiOperation(value="获取考试异常信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页码",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页多少条",paramType="query",dataType="Integer")
	})
	public JsonResult getExamAbnormal(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
		if(condition!=null){
			String[] split = condition.split(",");
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			for(int i = 0;i<split.length;i++){
				String[] split2 = split[i].split(":");
				if(split2.length<2){
					continue;
				}else{
					split[i] = split2[0]+":"+"'"+split2[1]+"'";
					sb.append(split[i]+",");
				}
			}
			condition = sb.toString().substring(0,sb.toString().length()-1);
			condition +="}";
		}
		JsonResult examAbnormalByCondition = examAbnormalService.getExamAbnormalByCondition(condition, pageNum, pageSize);
		return examAbnormalByCondition;
	}
	@ResponseBody
	@RequestMapping(value="insertExamAbnormal",method=RequestMethod.POST)
	@ApiOperation(value="添加考试异常信息")
	@ApiImplicitParam(name="examAbnormal",value="考试异常信息",paramType="body",dataType="ExamAbnormal")
	public JsonResult insertExamAbnormal(@RequestBody ExamAbnormal examAbnormal){
		JsonResult res = new JsonResult();
		if(examAbnormalService.insertExamAbnormal(examAbnormal)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	@ResponseBody
	@RequestMapping(value="deleteExamAbnormal",method=RequestMethod.POST)
	@ApiOperation(value="删除考试异常信息")
	@ApiImplicitParam(name="examAbnormalNo",value="考试异常编码",paramType="query",dataType="Integer")
	public JsonResult deleteExamAbnormal(Integer examAbnormalNo){
		JsonResult res = new JsonResult();
		if(examAbnormalService.deleteExamAbnormal(examAbnormalNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	@ResponseBody
	@RequestMapping(value="updateExamAbnormal",method=RequestMethod.POST)
	@ApiOperation(value="更新考试异常信息")
	@ApiImplicitParam(name="examAbnormal",value="考试异常信息",paramType="body",dataType="ExamAbnormal")
	public JsonResult updateExamAbnormal(@RequestBody ExamAbnormal examAbnormal){
		JsonResult res = new JsonResult();
		if(examAbnormalService.updateExamAbnormal(examAbnormal)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
}
