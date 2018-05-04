package org.manager.web.book;

import javax.servlet.http.HttpServletRequest;

import org.es.bean.JsonResult;
import org.es.model.BooPayInfo;
import org.es.service.manager.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api("缴费信息操作类")
@Controller
@RequestMapping("/bookPayInfo")
public class BookPayInfoController {
	@Autowired
    private IBookService bookService;
	@RequestMapping("/toModifyBookPay")
	public String toModifyBookPay(HttpServletRequest request,Integer no){
		BooPayInfo payInfo = bookService.getOneBookPay(no);
		request.setAttribute("payInfo", payInfo);
		return "book/updBookPay";
	}
	@RequestMapping(value="/getBooPayInfo",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取教材缴费信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页码",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页多少条",paramType="query",dataType="Integer")
	})
	public JsonResult getBooPayInfo(String condition,Integer pageNum,Integer pageSize){
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
		JsonResult bookByCondition = bookService.getBookPayInfo(condition,pageNum,pageSize);
		return bookByCondition;
	}
	@RequestMapping(value="insertBooPayInfo",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="添加教材缴费信息")
	@ApiImplicitParam(name="bookPayInfo",value="教材缴费信息",paramType="body",dataType="BooPayInfo")
	public JsonResult insertBooPayInfo(@RequestBody BooPayInfo bookPayInfo){
		JsonResult res = new JsonResult();
		if(bookService.insertBookPayInfo(bookPayInfo)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	@RequestMapping(value="deleteBooPayInfo",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="删除教材缴费信息")
	@ApiImplicitParam(name="bookPayInfoNo",value="教材缴费编码",paramType="query",dataType="Integer")
	public JsonResult deleteBook(Integer bookPayInfoNo){
		JsonResult res = new JsonResult();
		if(bookService.deleteBookPayInfo(bookPayInfoNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	@RequestMapping(value="updateBooPayInfo",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="更新教材缴费信息")
	@ApiImplicitParam(name="bookPayInfo",value="教材缴费信息",paramType="body",dataType="BooPayInfo")
	public JsonResult updateBook(@RequestBody BooPayInfo bookPayInfo){
		JsonResult res = new JsonResult();
		if(bookService.updateBookPayInfo(bookPayInfo)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
}
