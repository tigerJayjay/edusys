package org.manager.web.student;

import org.es.bean.JsonResult;
import org.es.service.manager.student.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;

@Api(value="专业操作类")
@Controller
@RequestMapping("/specialty")
public class SpecialtyController {
	@Autowired
	private ISpecialtyService specialtyService;
	@RequestMapping("/getSpeByCol")
	@ResponseBody
	JsonResult getSpeByCol(String colNo){
		return specialtyService.getSpecialtyByCol(colNo);
	}
}
