package org.manager.web.courseschedule;

import javax.servlet.http.HttpServletRequest;

import org.es.bean.JsonResult;
import org.es.model.Course;
import org.es.service.manager.courseschedule.ICourseService;
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
@Api("课程操作类")
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	@RequestMapping("/toModifyCourse")
	public String toModifyCourse(HttpServletRequest request,Integer no){
		Course one = courseService.getOne(no);
		request.setAttribute("course", one);
		return "examSchedule/updCourse";
	}
	@RequestMapping(value="/getCourseTypes",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult getCourseType(){
		return courseService.getCourseType();
	}
	@RequestMapping(value="/getCourse",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getCourse(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
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
		return courseService.getCourseByCondition(condition, pageNum, pageSize);
	}
	/**
	 * 更新课程信息
	 * @param coursedent
	 * @return
	 */
	@ApiOperation("更新课程信息")
	@RequestMapping(value="/updateCourse",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="course",value="要更新的课程信息",paramType="body",dataType="Course")
	})
	public JsonResult updateCourse(@RequestBody Course course){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("修改成功!");
		
		if(!courseService.updateCourse(course)){
			res.setStatus("500");
			res.setResult("修改失败!");
			return res;
		}
		return res;
	}
	/**
	 * 删除课程信息
	 * @param courseId
	 * @return
	 */
	@ApiOperation("删除课程信息")
	@RequestMapping(value="/deleteCourse",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="courseId",value="要删除的课程编号",paramType="query",dataType="Integer")
	})
	public JsonResult deleteCourse(Integer courseId){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("删除成功!");
		if(!courseService.deleteCourse(courseId)){
			res.setStatus("500");
			res.setResult("删除失败!");
			return res;
		}
		return res;
	}
	/**
	 * 添加课程信息
	 * @param course
	 * @return
	 */
	@ApiOperation("添加课程信息")
	@RequestMapping(value="/addCourse",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="course",value="要添加的课程信息",paramType="body",dataType="Course")
	})
	public JsonResult addCourse(@RequestBody Course course){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("添加成功!");
		if(!courseService.insertCourse(course)){
			res.setStatus("500");
			res.setResult("添加失败!");
			return res;
		}
		return res;
	}
	
}
