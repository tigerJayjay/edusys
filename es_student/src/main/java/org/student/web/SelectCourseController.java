package org.student.web;

import javax.servlet.http.HttpSession;

import org.es.bean.JsonResult;
import org.es.model.CourseSelectInfo;
import org.es.model.Student;
import org.es.service.student.selectcourse.ISelectCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/selectCourse")
public class SelectCourseController {
	@Autowired
	private ISelectCourse selectCourseService;
	@RequestMapping("/insert")
	@ResponseBody
	public JsonResult insertSelectCourse(HttpSession session,String scheNo){
		
		Student stu = (Student)session.getAttribute("user");
		String[] split = scheNo.split("&");
		if(split.length>1&&split[1]!=null&&!"".equals(split[1])){
			selectCourseService.deleteSelectCourse(stu.getSno(), Integer.valueOf(split[1]));
		}
		CourseSelectInfo info = new CourseSelectInfo();
		info.setScheNo(split[0]);
		info.setSno(stu.getSno());
		JsonResult res = new JsonResult();
		if(selectCourseService.insertSelectCourse(info)){
			res.setResult("选择成功!");
		}else{
			res.setResult("选择失败!");
		}
		return res;
	}
	@RequestMapping("/getSelectInfo")
	@ResponseBody
	public JsonResult selectByCondition(String condition){
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
	return selectCourseService.getSelectedCondition(condition);
	}
	
	
}
