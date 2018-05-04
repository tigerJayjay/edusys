package org.student.web;

import org.es.bean.JsonResult;
import org.es.service.manager.exam.IScoreInfoService;
import org.es.service.manager.exam.ScoreInfoQueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ScoreController {
	@Autowired
	private IScoreInfoService scoreService;
	
	@RequestMapping("/getScoreInfo")
	@ResponseBody
	public JsonResult getScoreInfo(String condition,Integer pageNum,Integer pageSize){
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
		return scoreService.getScoreInfoByCondition(condition, pageNum, pageSize);
	}
}
