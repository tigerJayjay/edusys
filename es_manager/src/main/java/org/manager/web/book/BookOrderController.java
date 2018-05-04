package org.manager.web.book;

import org.es.bean.JsonResult;
import org.es.model.BookOrder;
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
@Api("教材订购类")
@Controller
@RequestMapping("/bookOrder")
public class BookOrderController {
	@Autowired
    private IBookService bookService;
	
	@RequestMapping(value="/getBookOrder",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取教材订购信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页码",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页多少条",paramType="query",dataType="Integer")
	})
	public JsonResult getBookOrder(String condition,Integer pageNum,Integer pageSize){
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
		JsonResult bookByCondition = bookService.getBookOrder(condition,pageNum,pageSize);
		return bookByCondition;
	}
	@RequestMapping(value="insertBookOrder",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="添加教材订购信息")
	@ApiImplicitParam(name="bookOrder",value="教材订购信息",paramType="body",dataType="BookOrder")
	public JsonResult insertBookOrder(@RequestBody BookOrder bookOrder){
		JsonResult res = new JsonResult();
		if(bookService.insertBookOrder(bookOrder)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	@RequestMapping(value="deleteBookOrder",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="删除教材订购信息")
	@ApiImplicitParam(name="bookOrderNo",value="教材订购编码",paramType="query",dataType="Integer")
	public JsonResult deleteBook(Integer bookOrderNo){
		JsonResult res = new JsonResult();
		if(bookService.deleteBookOrder(bookOrderNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	@RequestMapping(value="updateBookOrder",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="更新教材订购信息")
	@ApiImplicitParam(name="bookOrder",value="教材订购信息",paramType="body",dataType="Book")
	public JsonResult updateBook(@RequestBody BookOrder bookOrder){
		JsonResult res = new JsonResult();
		if(bookService.updateBookOrder(bookOrder)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
}
