package org.manager.web.teacher;

import javax.servlet.http.HttpServletRequest;

import org.es.bean.JsonResult;
import org.es.model.CheckContent;
import org.es.model.Teacher;
import org.es.model.WorkExpre;
import org.es.model.Worker;
import org.es.model.WorkerAward;
import org.es.service.common.IWorkerAwardService;
import org.es.service.common.IWorkerExpreService;
import org.es.service.common.IWorkerService;
import org.es.service.manager.teacher.ITeacherCheckService;
import org.es.service.manager.teacher.ITeacherService;
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
@Api("教师操作类")
@Controller
@RequestMapping("/teachermanager")
public class TeacherController {
	@Autowired
    private ITeacherService teacherService;
	@Autowired
    private IWorkerAwardService awardService;
	@Autowired
	private IWorkerService workerService;
	@Autowired
	private ITeacherCheckService evaService;
	//教职工工作经历业务接口
	@Autowired
	private IWorkerExpreService expreService;
	
	@Autowired
	private ITeacherCheckService teacherCheckService;
	
	@RequestMapping("/toModifyTea")
	public String toModifyTea(HttpServletRequest request,String tno){
		Teacher teacher = teacherService.getOneTeacher(tno);
		request.setAttribute("teacher",teacher);
		return "teacher/modifyTeacher";
	}
	@RequestMapping("/toModifyExpre")
	public String toModifyExpre(HttpServletRequest request,Integer no){
		WorkExpre expre  = expreService.getOneWorkExpre(no);
		request.setAttribute("expre",expre);
		return "teacher/modifyExpre";
	}
	
	@RequestMapping("/toModifyAwa")
	public String toModifyAwa(HttpServletRequest request,Integer no){
		WorkerAward award = awardService.selectOneAward(no);
		request.setAttribute("award",award);
		return "teacher/modifyAward";
	}
	/**
	 * 获取教师信息
	 * @return
	 */
	@ApiOperation("获取教师信息")
	@RequestMapping(value="/getTea",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getTeacher(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
		JsonResult res = new JsonResult();
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
		res = teacherService.getTeacherByCondition(condition, pageNum, pageSize);
		res.setPage(pageNum);
		res.setPageSize(pageSize);
		res.setTotal(teacherService.getCountByCondition(condition));
		return res;
	}
	/**
	 * 获取教师获奖信息
	 * @return
	 */
	@ApiOperation("获取教师获奖信息")
	@RequestMapping(value="/getAward",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="tno",value="教师工号",paramType="query",dataType="String")
	public JsonResult getAward(String tno,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
		JsonResult res = new JsonResult();
		res = awardService.getAward(Integer.valueOf(tno));
		res.setPage(pageNum);
		res.setPageSize(pageSize);
		res.setTotal(res.getRows().size());
		return res;
	}
	/**
	 * 添加教师获奖信息
	 * @return
	 */
	@ApiOperation("添加教师获奖信息")
	@RequestMapping(value="/insertAward",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="workAward",value="获奖信息",dataType="WorkerAward")
	public JsonResult addTeacherAward(@RequestBody WorkerAward workAward){
		JsonResult res = new JsonResult();
		if(awardService.insertAward(workAward)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	
	/**
	 * 删除教师获奖信息
	 * @return
	 */
	@ApiOperation("删除教师获奖信息")
	@RequestMapping(value="/deleteAward",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="awardNo",value="获奖信息编号",dataType="Integer",paramType="query")
	public JsonResult deleteTeacherAward(Integer awardNo){
		JsonResult res = new JsonResult();
		if(awardService.deleteAward(awardNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	
	/**
	 * 更新教师获奖信息
	 * @return
	 */
	@ApiOperation("更新教师获奖信息")
	@RequestMapping(value="/updateAward",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="workAward",value="获奖信息",dataType="WorkerAward")
	public JsonResult updateTeacherAward(@RequestBody WorkerAward workAward){
		JsonResult res = new JsonResult();
		if(awardService.updateAward(workAward)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
	
	/**
	 * 更新教师信息
	 * @return
	 */
	@ApiOperation("更新教师信息")
	@RequestMapping(value="/updateTea",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="teacher",value="教师信息",dataType="Teacher")
	public JsonResult updateTeacher(@RequestBody Teacher teacher){
		JsonResult res = new JsonResult();
		if(teacherService.updateTeacher(teacher)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
	
	/**
	 * 删除教师信息
	 * @return
	 */
	@ApiOperation("删除教师信息")
	@RequestMapping(value="/deleteTea",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="tno",value="教师工号",dataType="String",paramType="query")
	public JsonResult deleteTeacher(String tno){
		JsonResult res = new JsonResult();
		if(teacherService.deleteTeacher(tno)){
			workerService.deleteWorker(Integer.valueOf(tno));
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	
	/**
	 * 添加教师信息
	 * @return
	 */
	@ApiOperation("添加教师信息")
	@RequestMapping(value="/insertTea",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="teacher",value="教师信息",dataType="Teacher")
	public JsonResult addTeacher(@RequestBody Teacher teacher){
		JsonResult res = new JsonResult();
		Worker worker = new Worker();
		worker.setWorkerNo(teacher.getJobno());
		if(teacherService.insertTeacher(teacher)&&workerService.insertWorker(worker)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	
	/**
	 * 获取考评统计信息
	 */
	@RequestMapping(value="/checkResult",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取考评统计信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getCheckResult(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
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
		return evaService.getCheckResult(condition, pageNum, pageSize);
	}
	
	@RequestMapping(value="/getCheckContent",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult getCheckContent(){
		JsonResult res = teacherCheckService.getCheckContent();
		res.setTotal(res.getRows().size());
		return res;
	}
	@ApiOperation("添加考评内容")
	@RequestMapping(value="/insertContent",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult insertContent(String content){
		JsonResult res = new JsonResult();
		CheckContent content1 = new CheckContent();
		content1.setContent(content);
		if(teacherCheckService.insertCheckContent(content1)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	@ApiOperation("删除考评内容")
	@RequestMapping(value="/deleteContent",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult deleteContent(Integer no){
		JsonResult res = new JsonResult();
		if(teacherCheckService.deleteCheckContent(no)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	
	/**
	 * 获取教职工工作经历
	 */
	@RequestMapping(value="/getWorkExpre",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取教职工工作经历")
	@ApiImplicitParam(name="workerNo",value="教职工工号",paramType="query",dataType="String")
	public JsonResult getWorkExpre(String workerNo,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
		JsonResult res = new JsonResult();
		res = expreService.getWorkExpre(workerNo);
		res.setPage(pageNum);
		res.setPageSize(pageSize);
		res.setTotal(res.getRows().size());
		return res ;
	}
	
	
	/**
	 * 添加教师工作信息
	 * @return
	 */
	@ApiOperation("添加教师工作")
	@RequestMapping(value="/insertExpre",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="workExpre",value="工作信息",dataType="WorkExpre")
	public JsonResult addTeacherAward(@RequestBody WorkExpre workExpre){
		JsonResult res = new JsonResult();
		if(expreService.insertWorkExpre(workExpre)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	
	/**
	 * 删除教师工作信息
	 * @return
	 */
	@ApiOperation("删除教师工作信息")
	@RequestMapping(value="/deleteExpre",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="expreNo",value="工作经历编号",dataType="Integer",paramType="query")
	public JsonResult deleteTeacherExpre(Integer expreNo){
		JsonResult res = new JsonResult();
		if(expreService.deleteWorkExpre(expreNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	
	/**
	 * 更新教师工作信息
	 * @return
	 */
	@ApiOperation("更新教师工作信息")
	@RequestMapping(value="/updateExpre",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParam(name="workExpre",value="工作信息",dataType="WorkExpre")
	public JsonResult updateTeacherAward(@RequestBody WorkExpre workExpre){
		JsonResult res = new JsonResult();
		if(expreService.updateWorkExpre(workExpre)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
}
