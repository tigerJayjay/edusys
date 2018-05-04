package org.manager.web.student;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.es.bean.JsonResult;
import org.es.dao.CollegeMapper;
import org.es.model.College;
import org.es.model.Student;
import org.es.service.manager.student.IStudentService;
import org.es.util.excelutil.POIUtil;
import org.es.util.format.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
@Api(value="学生操作类",description="对学生信息进行增删改查")
@Controller
@RequestMapping("/usermanager")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	private final String EXCEL_TITLE = "学生信息";
	@Autowired
	private CollegeMapper collegeMapper;
	@ResponseBody
	@RequestMapping("/getCol")
	public JsonResult getCollege(){
		JsonResult res = new JsonResult();
		List<College> selectByExample = collegeMapper.selectByExample(null);
		res.setRows(selectByExample);
		return res;
	}
    @RequestMapping("/toModifyStu")
	public String toModStu(HttpServletRequest request,String sno){
    	Student oneStudent = studentService.getOneStudent(sno);
    	request.setAttribute("stu", oneStudent);
		return "student/modifyStudent";
	}
	/**
	 * 获取学生信息
	 * @return
	 */
	@RequestMapping(value="/getStu",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getStudent(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
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
		JsonResult res = studentService.getStudentByCondition(condition, pageNum, pageSize);
		res.setPage(pageNum);
		res.setTotal(studentService.getCountByCondition(condition));
		res.setPageSize(pageSize);
		return res;
	}
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/updateStu")
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="student",value="要更新的学生信息",paramType="body",dataType="Student")
	})
	public JsonResult updateStudent(HttpSession session,Student student){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("修改成功!");
		
		if(!studentService.updateStudent(student)){
			res.setStatus("500");
			res.setResult("修改失败!");
			return res;
		}
		Student oneStudent = studentService.getOneStudent(student.getSno());
		session.setAttribute("user", oneStudent);
		return res;
	}
	/**
	 * 删除学生信息
	 * @param stuId
	 * @return
	 */
	@RequestMapping(value="/deleteStu",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="stuId",value="要删除的学生学号",paramType="query",dataType="String")
	})
	public JsonResult deleteStudent(String stuId){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("删除成功!");
		if(!studentService.deleteStudent(stuId)){
			res.setStatus("500");
			res.setResult("删除失败!");
			return res;
		}
		return res;
	}
	/**
	 * 添加学生信息
	 * @param stu
	 * @return
	 */
	@RequestMapping(value="/addStu",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="stu",value="要添加的学生信息",paramType="body",dataType="Student")
	})
	public JsonResult addStudent(@RequestBody Student stu){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("添加成功!");
		if(!studentService.addStudent(stu)){
			res.setStatus("500");
			res.setResult("添加失败!");
			return res;
		}
		return res;
	}
	/**
	 * 批量导入学生信息
	 * @param inputExcel
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvalidFormatException 
	 */
	//@RequestMapping(value="/uploadStu",method=RequestMethod.POST,headers="content-type=multipart/form-data")
	@ResponseBody
/*	@ApiImplicitParams({
		@ApiImplicitParam(name="inputExcel",value="批量导入的学生信息excel",allowMultiple=true,paramType="formData",dataType="MultipartFile")
	})*/
	@PostMapping(value="/uploadStu",consumes="multipart/*",headers="content-type=multipart/form-data")
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
		            POIUtil<Student> util = new POIUtil<Student>();
		            List<Student> in = util.in(path+filename, Student.class);
		            int count1 = 0;
		            int count2 = 0;
		            StringBuilder failStudent = new StringBuilder();
		            for(Student s:in){
		            	try{
		            	if(studentService.addStudent(s)){
		            		count1++;
		            	}else{
		            		count2++;
		            		failStudent.append(s.getSno()+";");
		            	}
		            	}catch(DuplicateKeyException e){
		            		res.setStatus("500");
		            		  if(count2>0){
		 		                 res.setResult("存在重复学号"+s.getSno()+"!成功"+count1+"个,失败"+count2+"个,失败学生号是:"+failStudent.toString());
		 		            }else{
		 		            	 res.setResult("存在重复学号"+s.getSno()+"!成功"+count1+"个,失败"+count2+"个");
		 		            }
		            		return res;
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
	/**
	 * 导出学生信息
	 * @return
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/getStuExcel",method=RequestMethod.POST)
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String")
	})
	public void getStudentExcel(String condition,HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException, IOException{
		JsonResult res = new JsonResult();
		List<Student> list = new ArrayList<Student>();
		res  = studentService.getStudentByCondition(condition, null, null);
		 List<Map<String,Object>> data = (List<Map<String, Object>>) res.getRows();
		 for(Map<String,Object> m :data){
			 Set<String> keySet = m.keySet();
			 Iterator<String> it = keySet.iterator();
			 Map<String,Object> mtemp = new HashMap<String,Object>();
			 while(it.hasNext()){
				 String next = it.next();
				 Object object = m.get(next);
				 mtemp.put(next.toLowerCase(), object);
			 }
			 Student stu = new Student();
			 try {
				BeanUtils.populate(stu, mtemp);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 list.add(stu);
		 }
		POIUtil<Student> pu = new POIUtil<Student>();
		HSSFWorkbook hw = pu.out(list);
		 ServletOutputStream outputStream = response.getOutputStream();
		 response.setHeader("Content-Type","application/ms-excel");
		 Date time = new Date();
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(EXCEL_TITLE+DateUtil.date2StringSimple(time)+".xls", "UTF-8"));
        hw.write(outputStream);/*
		 hw.close();*/
		 outputStream.flush();
		 outputStream.close();
	}
	
	/**
	 * 导出模板
	 * @return
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/getStuExcelModel")
	public void getStudentExcelModel(HttpServletResponse response,HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException, IOException{
		 //上传文件路径
		  //上传文件路径
        String path = request.getServletContext().getContextPath();
		 response.setCharacterEncoding("utf-8");
		    response.setContentType("application/ms-excel");
		    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("学生信息模板.xls", "UTF-8"));
		    
		    //用于记录以完成的下载的数据量，单位是byte
		    long downloadedLength = 0l;
		        //打开本地文件流
		        InputStream inputStream = ClassLoader.getSystemResourceAsStream("excel/学生信息模板.xls");
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
