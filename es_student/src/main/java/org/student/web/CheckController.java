package org.student.web;

import org.es.bean.JsonResult;
import org.es.model.EvaluateCon;
import org.es.service.manager.teacher.ITeacherCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckController {
	@Autowired
	private ITeacherCheckService checkService;
	@RequestMapping("/check")
	@ResponseBody
	public JsonResult check(String content,String select,String yeartime,String termtime,String sno,String tno){
		JsonResult res= new JsonResult();
		res.setResult("提交成功!");
		String[] contents = content.split(",");
		String[] selects = select.split(",");
		for(int i=1;i<contents.length;i++){
			EvaluateCon eva = new EvaluateCon();
			eva.setCheckNo(Integer.valueOf(contents[i]));
			eva.setSelectNo(Integer.valueOf(selects[i]));
			eva.setSno(sno);
			eva.setTermtime(Integer.valueOf(termtime));
			eva.setYeartime(yeartime);
			String[] split = tno.split(",");
			eva.setTno(split[0]);
			eva.setCourseNo(split[1]);
			if(!checkService.insertEvaluate(eva)){
				res.setResult("提交失败!");
				return res;
			}	
		}
		return res;
	}
}
