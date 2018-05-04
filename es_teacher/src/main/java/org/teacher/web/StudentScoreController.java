package org.teacher.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.es.bean.JsonResult;
import org.es.model.ScoreInfo;
import org.es.model.Student;
import org.es.service.manager.exam.IScoreInfoService;
import org.es.service.student.selectcourse.ISelectCourse;
import org.es.util.excelutil.POIUtil;
import org.es.util.format.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class StudentScoreController {
	@Autowired
	private ISelectCourse selectCourseServcie;
	@Autowired
	private IScoreInfoService scoreService;
	@RequestMapping("/getSelectInfo")
	@ResponseBody
	public JsonResult getByCondition(String condition){
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
		res = selectCourseServcie.getByCondition(condition);
		return res;
	}
	
	@RequestMapping("/export")
	public void export(String json,String title,HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException, IOException{
		System.out.println(json);
		List parseArray2 = null;
		parseArray2 = JSONObject.parseArray(json, ScoreInfo.class);
		POIUtil<ScoreInfo> pu = new POIUtil<ScoreInfo>();
		HSSFWorkbook hw = pu.out(parseArray2);
		 ServletOutputStream outputStream = response.getOutputStream();
		 response.setHeader("Content-Type","application/ms-excel");
		 Date time = new Date();
         response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(title+DateUtil.date2StringSimple(time)+".xls", "UTF-8"));
         
         hw.write(outputStream);/*
		 hw.close();*/
		 outputStream.flush();
		 outputStream.close();
	}
	
	
	/**
	 * 批量导入学生成绩信息
	 * @param inputExcel
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvalidFormatException 
	 */
	@ResponseBody
	@PostMapping(value="/uploadStuScore",consumes="multipart/*",headers="content-type=multipart/form-data")
	public JsonResult addStudentByExcel(@RequestBody MultipartFile inputExcel,HttpServletRequest request) throws IllegalStateException, IOException, InstantiationException, IllegalAccessException, InvalidFormatException{
		JsonResult res = new JsonResult();
				//如果文件不为空，写入上传路径
		        if(inputExcel!=null&&!inputExcel.isEmpty()) {
		            //上传文件路径
		            String path = request.getServletContext().getRealPath("/excel/");
		            //上传文件名
		            String filename = inputExcel.getOriginalFilename();
		            File filepath = new File(path,filename);
		            //判断路径是否存在，如果不存在就创建一个
		            if (!filepath.getParentFile().exists()) { 
		                filepath.getParentFile().mkdirs();
		            }
		            File srcFile =  new File(path + File.separator + filename);
		            //将上传文件保存到一个目标文件当中
		            inputExcel.transferTo(srcFile);
		            POIUtil<ScoreInfo> util = new POIUtil<ScoreInfo>();
		            List<ScoreInfo> scores = util.in(path+filename, ScoreInfo.class);
		            int count1 = 0;
		            int count2 = 0;
		            StringBuilder failStudent = new StringBuilder();
		            for(ScoreInfo s :scores){
		            	if(scoreService.insertScoreInfo(s)){
		            		count1++;
		            	}else{
		            		count2++;
		            		failStudent.append(s.getSno()+";");
		            	}
		            }
		            res.setStatus("200");
		            if(count2>0){
		                 res.setResult("成功"+count1+"个,失败"+count2+"个,失败学生号是:"+failStudent.toString());
		            }else{
		            	 res.setResult("成功"+count1+"个,失败"+count2+"个");
		            }
		        } else {
		           res.setStatus("500");
		           res.setResult("请选择文件!");
		        }
		return res;
	}
}
