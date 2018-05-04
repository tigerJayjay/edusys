package org.manager.web.student;

import org.es.bean.JsonResult;
import org.es.service.manager.student.IClassesService;
import org.es.service.manager.student.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;

@Api(value="班级操作类")
@Controller
@RequestMapping("/classes")
public class ClassesController {
	@Autowired
	private IClassesService classesService;
	@RequestMapping("/getClaBySpe")
	@ResponseBody
	JsonResult getSpeByCol(String speNo,String colNo){
		return classesService.getClassesBySpe(speNo);
	}
}
