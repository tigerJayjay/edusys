package org.manager.web.book;

import javax.servlet.http.HttpServletRequest;

import org.es.bean.JsonResult;
import org.es.model.Book;
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
@Api("教材操作类")
@Controller
@RequestMapping("/bookmanager")
public class BookController {
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("/toModifyBook")
	public String toModifyBook(HttpServletRequest request,Integer no){
		Book book = bookService.getOneBook(no);
		request.setAttribute("book", book);
		return "book/updBook";
	}
	@RequestMapping(value="/getBook",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取教材信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页码",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页多少条",paramType="query",dataType="Integer")
	})
	public JsonResult getBook(String condition,Integer page,Integer rows){
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
		JsonResult bookByCondition = bookService.getBookByCondition(condition, page, rows);
		return bookByCondition;
	}
	@RequestMapping(value="insertBook",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="添加教材信息")
	@ApiImplicitParam(name="book",value="教材信息",paramType="body",dataType="Book")
	public JsonResult insertBook(@RequestBody Book book){
		JsonResult res = new JsonResult();
		if(bookService.insertBook(book)){
			res.setStatus("200");
			res.setResult("添加成功!");
		}else{
			res.setStatus("500");
			res.setResult("添加失败!");
		}
		return res;
	}
	@RequestMapping(value="deleteBook",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="删除教材信息")
	@ApiImplicitParam(name="bookNo",value="教材编码",paramType="query",dataType="Integer")
	public JsonResult deleteBook(Integer bookNo){
		JsonResult res = new JsonResult();
		if(bookService.deleteBook(bookNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	@RequestMapping(value="updateBook",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="更新教材信息")
	@ApiImplicitParam(name="book",value="教材信息",paramType="body",dataType="Book")
	public JsonResult updateBook(@RequestBody Book book){
		JsonResult res = new JsonResult();
		if(bookService.updateBook(book)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
}
