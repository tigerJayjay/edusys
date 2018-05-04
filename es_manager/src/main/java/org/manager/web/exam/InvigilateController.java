package org.manager.web.exam;

import javax.servlet.http.HttpServletRequest;

import org.es.bean.JsonResult;
import org.es.model.Invigilate;
import org.es.service.manager.exam.IInvigilateService;
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
@Api("监考安排操作类")
@Controller
@RequestMapping("/invigilate")
public class InvigilateController {
	@Autowired
     private IInvigilateService invigilateService;
	
	@RequestMapping("/toModifyInvigilate")
	public String toModifyInvigilate(HttpServletRequest request,Integer no){
		Invigilate one = invigilateService.getOne(no);
		request.setAttribute("invigilate", one);
		return "exam/updateInvigilate";
	}
	@ResponseBody
	@RequestMapping(value="/getInvigilate",method=RequestMethod.POST)
	@ApiOperation(value="获取监考安排信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页码",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页多少条",paramType="query",dataType="Integer")
	})
	public JsonResult getInvigilate(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
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
		JsonResult invigilateByCondition = invigilateService.getInvigilate(condition, pageNum, pageSize);
		return invigilateByCondition;
	}
	@ResponseBody
	@RequestMapping(value="/insertInvigilate",method=RequestMethod.POST)
	@ApiOperation(value="添加监考安排信息")
	@ApiImplicitParam(name="invigilate",value="监考安排信息",paramType="body",dataType="Invigilate")
	public JsonResult insertInvigilate(@RequestBody Invigilate invigilate){
		JsonResult res = new JsonResult();
		if(invigilateService.insertInvigilate(invigilate)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	@ResponseBody
	@RequestMapping(value="/deleteInvigilate",method=RequestMethod.POST)
	@ApiOperation(value="删除监考安排信息")
	@ApiImplicitParam(name="invigilateNo",value="监考安排编码",paramType="query",dataType="Integer")
	public JsonResult deleteInvigilate(Integer invigilateNo){
		JsonResult res = new JsonResult();
		if(invigilateService.deleteInvigilate(invigilateNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	@ResponseBody
	@RequestMapping(value="/updateInvigilate",method=RequestMethod.POST)
	@ApiOperation(value="更新监考安排信息")
	@ApiImplicitParam(name="invigilate",value="监考安排信息",paramType="body",dataType="Invigilate")
	public JsonResult updateInvigilate(@RequestBody Invigilate invigilate){
		JsonResult res = new JsonResult();
		if(invigilateService.updateInvigilate(invigilate)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
}
