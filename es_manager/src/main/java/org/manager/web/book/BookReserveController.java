package org.manager.web.book;

import java.util.List;

import org.es.bean.JsonResult;
import org.es.dao.BookReserveMapper;
import org.es.dao.CourseBookMapper;
import org.es.model.Book;
import org.es.model.BookReserve;
import org.es.model.BookReserveExample;
import org.es.model.CourseBook;
import org.es.model.CourseBookExample;
import org.es.model.CourseBookExample.Criteria;
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
/**
 * 教材预定信息操作类
 * @author Administrator
 *
 */
@Api("教材预定信息操作类")
@Controller
@RequestMapping("/bookReserve")
public class BookReserveController {
	@Autowired
    private IBookService bookService;
	@Autowired
	private CourseBookMapper courseBookMapper;
	@Autowired
	private BookReserveMapper bookReserveMapper;
	@RequestMapping(value="/getBookReserve",method=RequestMethod.POST)
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(name="condition",value="查询json字符串",paramType="query",dataType="String"),
		@ApiImplicitParam(name="pageNum",value="当前页码",paramType="query",dataType="Integer"),
		@ApiImplicitParam(name="pageSize",value="一页多少条",paramType="query",dataType="Integer")
	})
	public JsonResult getBookReserve(String condition,Integer pageNum,Integer pageSize){
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
		JsonResult bookByCondition = bookService.getBookReserve(condition,pageNum,pageSize);
		return bookByCondition;
	}
	@RequestMapping(value="insertBookReserve",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="添加教材预定信息")
	@ApiImplicitParam(name="bookReserve",value="教材预定信息",paramType="body",dataType="BookReserve")
	public JsonResult insertBookReserve(String sno,String yeartime,Integer termtime,String courseNo,Integer reserve){
		BookReserve bookReserve = new BookReserve();
		//获取教材号
		Integer bookNo = null;
		CourseBookExample exa = new CourseBookExample();
		Criteria cri = exa.createCriteria();
		cri.andCourseNoEqualTo(courseNo);
		List<CourseBook> courseBook = courseBookMapper.selectByExample(exa);
		if(courseBook!=null&&courseBook.size()>0){
			bookNo = courseBook.get(0).getBookNo();
		}

		Book book = bookService.getOneBook(bookNo);
		//先删除之前的预定信息
		BookReserveExample bookexa = new BookReserveExample();
		org.es.model.BookReserveExample.Criteria bookCri = bookexa.createCriteria();
		bookCri.andBookNoEqualTo(bookNo);
		bookCri.andSnoEqualTo(sno);
		bookCri.andYeartimeEqualTo(yeartime);
		bookCri.andTermtimeEqualTo(termtime);
		bookReserveMapper.deleteByExample(bookexa);
		JsonResult res = new JsonResult();
		//插入新的预定信息
		if(reserve==1){
			bookReserve.setBookNo(bookNo);
			bookReserve.setSno(sno);
			bookReserve.setTermtime(termtime);
			bookReserve.setYeartime(yeartime);
			bookReserve.setPayable(book.getPrice());
			bookReserve.setPayin(0d);
			bookReserve.setPaystatus(0);
			if(bookService.insertBookReserve(bookReserve)){
				res.setStatus("200");
				res.setResult("添加成功!");
			}else{
				res.setStatus("500");
				res.setResult("添加失败!");
			}
		}
		return res;
	}
	@RequestMapping(value="deleteBookReserve",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="删除教材预定信息")
	@ApiImplicitParam(name="bookReserveNo",value="教材预定编码",paramType="query",dataType="Integer")
	public JsonResult deleteBook(Integer bookReserveNo){
		JsonResult res = new JsonResult();
		if(bookService.deleteBookReserve(bookReserveNo)){
			res.setStatus("200");
			res.setResult("删除成功!");
		}else{
			res.setStatus("500");
			res.setResult("删除失败!");
		}
		return res;
	}
	@RequestMapping(value="updateBookReserve",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="更新教材预定信息")
	@ApiImplicitParam(name="bookReserve",value="教材预定信息",paramType="body",dataType="Book")
	public JsonResult updateBook(@RequestBody BookReserve bookReserve){
		JsonResult res = new JsonResult();
		if(bookService.updateBookReserve(bookReserve)){
			res.setStatus("200");
			res.setResult("更新成功!");
		}else{
			res.setStatus("500");
			res.setResult("更新失败!");
		}
		return res;
	}
}
