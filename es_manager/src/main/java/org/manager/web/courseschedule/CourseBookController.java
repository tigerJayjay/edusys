package org.manager.web.courseschedule;

import org.es.bean.JsonResult;
import org.es.model.CourseBook;
import org.es.service.manager.courseschedule.ICourseBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/courseBook")
public class CourseBookController {
	@Autowired
	private ICourseBookService courseBookService;
	@RequestMapping("/addCourseBook")
	@ResponseBody
	JsonResult addCoBo(@RequestBody CourseBook cb){
		JsonResult res = new JsonResult();
		if(courseBookService.insertCourseBook(cb)){
			res.setStatus("200");
			res.setResult("添加成功");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	
	@RequestMapping("/deleteCourseBook")
	@ResponseBody
	JsonResult deleteCoBo(Integer id){
		JsonResult res = new JsonResult();
		if(courseBookService.deleteCourseBook(id)){
			res.setStatus("200");
			res.setResult("删除成功");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	
	@RequestMapping("/getCourseBook")
	@ResponseBody
	JsonResult getCoBo(String condition,Integer page,Integer rows){
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
		return courseBookService.getCourseBook(condition, page, rows);
	}
}
