package org.manager.web.classroom;

import org.es.bean.JsonResult;
import org.es.model.Classroom;
import org.es.model.RoomUseInfo;
import org.es.service.manager.classroom.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
@Api("教室操作类")
@Controller
@RequestMapping("/classRoom")
public class ClassRoomController {
	@Autowired
	private IClassRoomService classRoomService;
	
	/**
	 * 获取全部教室信息
	 * @return
	 */
	@RequestMapping(value="/getClassRoom",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getClassroom(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
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
		return classRoomService.getClassRoomByCondition(condition, pageNum, pageSize);
	}

	/**
	 * 获取可用教室信息
	 * @return
	 */
	@RequestMapping(value="/getUsableclassRoom",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询条件json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页条数",paramType="query",dataType="Integer")
	})
	public JsonResult getUsableClassroom(String condition,@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
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
		return classRoomService.getUsableClassRoomByCondition(condition, pageNum, pageSize);
	}
	
	

	/**
	 * 更新教室信息
	 * @param classRoomdent
	 * @return
	 */
	@RequestMapping(value="/updateClassRoom",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="classRoom",value="要更新的教室信息",paramType="body",dataType="Classroom")
	})
	public JsonResult updateClassroom(@RequestBody Classroom classRoom){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("修改成功!");
		
		if(!classRoomService.updateClassRoom(classRoom)){
			res.setStatus("500");
			res.setResult("修改失败!");
			return res;
		}
		return res;
	}
	/**
	 * 删除教室信息
	 * @param classRoomId
	 * @return
	 */
	@RequestMapping(value="/deleteClassRoom",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="classRoomId",value="要删除的教室编号",paramType="query",dataType="Integer")
	})
	public JsonResult deleteClassroom(Integer classRoomId){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("删除成功!");
		if(!classRoomService.deleteClassRoom(classRoomId)){
			res.setStatus("500");
			res.setResult("删除失败!");
			return res;
		}
		return res;
	}
	/**
	 * 添加教室信息
	 * @param classRoom
	 * @return
	 */
	@RequestMapping(value="/addClassRoom",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="classRoom",value="要添加的教室信息",paramType="body",dataType="Classroom")
	})
	public JsonResult addClassroom(@RequestBody Classroom classRoom){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("添加成功!");
		if(!classRoomService.insertClassRoom(classRoom)){
			res.setStatus("500");
			res.setResult("添加失败!");
			return res;
		}
		return res;
	}
	
	
	/**
	 * 添加教室使用信息
	 * @param classRoom
	 * @return
	 */
	@RequestMapping(value="/addClassRoomUseInfo",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="classRoom",value="要添加的教室使用信息",paramType="body",dataType="Classroom")
	})
	public JsonResult addClassRoomUseInfo(@RequestBody RoomUseInfo useInfo){
		JsonResult res = new JsonResult();
		res.setStatus("200");
		res.setResult("添加成功!");
		if(!classRoomService.insertRoomUseInfo(useInfo)){
			res.setStatus("500");
			res.setResult("添加失败!");
			return res;
		}
		return res;
	}
}
