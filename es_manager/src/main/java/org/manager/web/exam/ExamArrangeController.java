package org.manager.web.exam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.es.bean.JsonResult;
import org.es.model.ExamArrangement;
import org.es.model.ExamArrangementStatis;
import org.es.service.manager.exam.IExamArrangeService;
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

@Api("考试安排管理类")
@Controller
@RequestMapping("/examArrange")
public class ExamArrangeController {
	@Autowired
    private IExamArrangeService examArrangeService;
	@RequestMapping("/toModifyExamArrange")
	public String toModifyExamArrange(HttpServletRequest request,Integer no){
		ExamArrangementStatis one = examArrangeService.getOneStatis(no);
		request.setAttribute("arrange", one);
		return "exam/updateExamArrange";
	}
	@RequestMapping("toDetail")
	public String toDetail(HttpSession session,Integer no){
		session.setAttribute("arrangeNo", no);
		return "exam/examArrangeDetail";
	}
	
	@RequestMapping("toUpdateDetail")
	public String toUpdateDetail(HttpServletRequest request,Integer no){
		ExamArrangement one = examArrangeService.getOne(no);
		request.setAttribute("arrangeDetail", one);
		return "exam/updateDetail";
	}
	@ApiOperation("获取考试安排信息")
	@ResponseBody
	@RequestMapping(value="/getArrange",method=RequestMethod.POST)
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="json查询条件",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页面",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="每页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getExamArrange(String condition, Integer page, Integer rows) {
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
		return examArrangeService.getExamArrangeStatis(condition, page, rows);
	}
	
	@ApiOperation("获取考试安排详情信息")
	@ResponseBody
	@RequestMapping(value="/getArrangeDetail",method=RequestMethod.POST)
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="json查询条件",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页面",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="每页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getExamArrangeDetail(String condition, @RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize) {
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
		return examArrangeService.getExamArrange(condition, pageNum, pageSize);
	}
	
	/**
	 * 添加一条信息
	 * @param examArrange
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertExamArrangeOne",method=RequestMethod.POST)
	@ApiOperation("添加一条考试安排信息")
	@ApiImplicitParam(name="examArrange",value="考试安排信息",paramType="body",dataType="ExamArrangement")
	public JsonResult insertExamArrangeOne(@RequestBody ExamArrangementStatis examArrange){
		JsonResult res = new JsonResult();
		if(examArrangeService.insertExamArrangeStatis(examArrange)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	
	@ResponseBody
	@RequestMapping(value="/insertExamArrangeDetail",method=RequestMethod.POST)
	@ApiOperation("添加一条考试安排详细信息")
	@ApiImplicitParam(name="examArrange",value="考试安排信息",paramType="body",dataType="ExamArrangement")
	public JsonResult insertExamArrangeDetail(@RequestBody ExamArrangement examArrange){
		JsonResult res = new JsonResult();
		if(examArrangeService.insertExamArrangeOne(examArrange)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	/**
	 * 批量添加考试安排详情信息
	 * @param examArrange
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertExamArrange",method=RequestMethod.POST)
	@ApiOperation("批量添加考试安排信息")
	@ApiImplicitParam(name="examno",value="考试安排条件",paramType="query",dataType="Integer")
	public JsonResult insertExamArrange(Integer examno){
		ExamArrangementStatis oneStatis = examArrangeService.getOneStatis(examno);
		return examArrangeService.insertExamArrange(oneStatis);
	}
	
	/**
	 * 删除考试安排详情信息
	 * @param examNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteExamArrangeDetail")
	@ApiOperation("删除考试安排信息")
	@ApiImplicitParam(name="examNo",value="考试安排信息编号",paramType="query",dataType="Integer")
	public JsonResult deleteExamArrangeDetail(Integer no){
		JsonResult res = new JsonResult();
		if(examArrangeService.deleteExamArrange(no)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	/**
	 * 删除考试安排信息
	 * @param examNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteExamArrange",method=RequestMethod.POST)
	@ApiOperation("删除考试安排信息")
	@ApiImplicitParam(name="examNo",value="考试安排信息编号",paramType="query",dataType="Integer")
	public JsonResult deleteExamArrange(Integer examNo){
		JsonResult res = new JsonResult();
		if(examArrangeService.deleteExamArrangeStatis(examNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	/**
	 * 更新考试安排信息
	 * @param examArrange
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateExamArrange",method=RequestMethod.POST)
	@ApiOperation("更新考试安排信息")
	@ApiImplicitParam(name="examArrange",value="考试安排信息",paramType="body",dataType="ExamArrangement")
	public JsonResult updateExamArrangeOne(@RequestBody ExamArrangementStatis examArrange){
		JsonResult res = new JsonResult();
		if(examArrangeService.updateExamArrangeStatis(examArrange)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
	
	/**
	 * 更新考试安排详情信息
	 * @param examArrange
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateExamArrangeDetail",method=RequestMethod.POST)
	@ApiOperation("更新考试安排信息")
	@ApiImplicitParam(name="examArrange",value="考试安排信息",paramType="body",dataType="ExamArrangement")
	public JsonResult updateExamArrangeDetailOne(@RequestBody ExamArrangement examArrange){
		JsonResult res = new JsonResult();
		if(examArrangeService.updateExamArrange(examArrange)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
}
