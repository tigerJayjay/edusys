package org.manager.web.courseschedule;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.es.bean.JsonResult;
import org.es.model.Schedule;
import org.es.model.ScoreInfo;
import org.es.service.manager.courseschedule.IScheduleService;
import org.es.util.excelutil.POIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api("排课操作类")
@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	private IScheduleService scheduleService;
	@RequestMapping("/toModifySchedule")
	public String toModifySchedule(HttpServletRequest request,String no){
		Schedule one = scheduleService.getOne(no);
		request.setAttribute("schedule", one);
		return "examSchedule/updSchedule";
	}
	@RequestMapping(value="/getScheduleSpread",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getScheduleSpread(String condition,Integer pageNum,Integer pageSize){
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
		return scheduleService.getScheduleByConditionSpread(condition, pageNum, pageSize);
	}
	@RequestMapping(value="/getScheduleMerge",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getScheduleMerge(String condition,Integer pageNum,Integer pageSize){
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
		return scheduleService.getScheduleByConditionMerge(condition, pageNum, pageSize);
	}
	
	@RequestMapping(value="/getSchedule",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getSchedule(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
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
		return scheduleService.getScheduleByCondition(condition, pageNum, pageSize);
	}
	/**
	 * 更新排课信息
	 * @param scheduledent
	 * @return
	 */
	@ApiOperation("更新排课信息")
	@RequestMapping(value="/updateSchedule",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="schedule",value="要更新的排课信息",paramType="body",dataType="Schedule")
	})
	public JsonResult updateSchedule(@RequestBody Schedule schedule){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("修改成功!");
		
		if(!scheduleService.updateSchedule(schedule)){
			res.setStatus("500");
			res.setResult("修改失败!");
			return res;
		}
		return res;
	}
	/**
	 * 删除排课信息
	 * @param scheduleId
	 * @return
	 */
	@ApiOperation("删除排课信息")
	@RequestMapping(value="/deleteSchedule",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="scheduleId",value="要删除的排课编号",paramType="query",dataType="Integer")
	})
	public JsonResult deleteSchedule(Integer scheduleId){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("删除成功!");
		if(!scheduleService.deleteSchedule(scheduleId)){
			res.setStatus("500");
			res.setResult("删除失败!");
			return res;
		}
		return res;
	}
	/**
	 * 添加排课信息
	 * @param schedule
	 * @return
	 */
	@ApiOperation("添加排课信息")
	@RequestMapping(value="/addSchedule",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="schedule",value="要添加的排课信息",paramType="body",dataType="Schedule")
	})
	public JsonResult addSchedule(@RequestBody Schedule schedule){
		JsonResult res = new JsonResult();
		schedule.setMargin(schedule.getCapacity());
		res.setStatus("200");
		res.setResult("添加成功!");
		if(!scheduleService.insertSchedule(schedule)){
			res.setStatus("500");
			res.setResult("添加失败!");
			return res;
		}
		return res;
	}
	
	/**
	 * 批量导入排课信息
	 * @param inputExcel
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvalidFormatException 
	 */
	@ResponseBody
	@PostMapping(value="/uploadSchedule",consumes="multipart/*",headers="content-type=multipart/form-data")
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
		            POIUtil<Schedule> util = new POIUtil<Schedule>();
		            List<Schedule> schedules = util.in(path+filename, Schedule.class);
		            int count1 = 0;
		            int count2 = 0;
		            StringBuilder failStudent = new StringBuilder();
		            for(Schedule s :schedules){
		            	if(scheduleService.insertSchedule(s)){
		            		count1++;
		            	}else{
		            		count2++;
		            		failStudent.append("工号:"+s.getJobno()+"课程号:"+s.getCourseNo()+"学年:"+s.getYeartime()+"学期:"+s.getTermtime()+";");
		            	}
		            }
		            res.setStatus("200");
		            if(count2>0){
		                 res.setResult("成功"+count1+"个,失败"+count2+"个,失败信息:"+failStudent.toString());
		            }else{
		            	 res.setResult("成功"+count1+"个,失败"+count2+"个");
		            }
		        } else {
		           res.setStatus("500");
		           res.setResult("请选择文件!");
		        }
		return res;
	}
	
	/**
	 * 导出模板
	 * @return
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/getCoExcelModel")
	public void getCoExcelModel(HttpServletResponse response,HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException, IOException{
		 //上传文件路径
		  //上传文件路径
        String path = request.getServletContext().getContextPath();
		 response.setCharacterEncoding("utf-8");
		    response.setContentType("application/ms-excel");
		    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("排课信息模板.xls", "UTF-8"));
		    
		    //用于记录以完成的下载的数据量，单位是byte
		    long downloadedLength = 0l;
		        //打开本地文件流
		        InputStream inputStream = ClassLoader.getSystemResourceAsStream("excel/排课信息模板.xls");
		        //激活下载操作
		        ServletOutputStream os = response.getOutputStream();
		        
		        //循环写入输出流
		        byte[] b = new byte[2048];
		        int length;
		        while ((length = inputStream.read(b)) > 0) {
		            os.write(b, 0, length);
		            downloadedLength += b.length;
		        }
		        // 这里主要关闭。
		        os.flush();
		        os.close();
	}
}
