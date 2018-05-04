package org.es.service.manager.book;

import java.util.List;
import java.util.Map;

import org.es.bean.JsonResult;
import org.es.dao.BooPayInfoMapper;
import org.es.dao.BookMapper;
import org.es.dao.BookOrderMapper;
import org.es.dao.BookReserveMapper;
import org.es.model.BooPayInfo;
import org.es.model.Book;
import org.es.model.BookOrder;
import org.es.model.BookReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
@Service
public class BookServiceImpl implements IBookService{
	@Autowired
    private BookMapper bookMapper;
	@Autowired
    private BookOrderMapper bookOrderMapper;
	@Autowired
    private BooPayInfoMapper bookPayInfoMapper;
	@Autowired
    private BookReserveMapper bookReserveMapper;
	@Override
	public boolean insertBook(Book book) {
		// TODO Auto-generated method stub
		if(bookMapper.insert(book)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getBookByCondition(String condition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		BookQueryCondition cond = (BookQueryCondition)JSONObject.parseObject(condition, BookQueryCondition.class);
		int total = bookMapper.selectBookByCondition(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String,Object>> selectBookByCondition = bookMapper.selectBookByCondition(cond);
		if(selectBookByCondition==null){
			res.setStatus("500");
			res.setResult("无查询结果!");
		}else{
			res.setRows(selectBookByCondition);
			res.setStatus("200");
			res.setTotal(total);
		}
		return res;
	}

	@Override
	public boolean deleteBook(Integer bookNo) {
		// TODO Auto-generated method stub
		if(bookMapper.deleteByPrimaryKey(bookNo)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		if(bookMapper.updateByPrimaryKeySelective(book)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertBookReserve(BookReserve bookReserve) {
		// TODO Auto-generated method stub
		if(bookReserveMapper.insert(bookReserve)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBookReserve(Integer bookReserveId) {
		// TODO Auto-generated method stub
		if(bookReserveMapper.deleteByPrimaryKey(bookReserveId)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBookReserve(BookReserve bookReserve) {
		// TODO Auto-generated method stub
		if(bookReserveMapper.updateByPrimaryKey(bookReserve)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getBookReserve(String bookQueryCondition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		BookQueryCondition cond = (BookQueryCondition)JSONObject.parseObject(bookQueryCondition, BookQueryCondition.class);
		int total = bookReserveMapper.selectBookReserveByCondition(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String,Object>> selectBookByCondition = bookReserveMapper.selectBookReserveByCondition(cond);
		if(selectBookByCondition==null){
			res.setStatus("500");
			res.setResult("无查询结果!");
		}else{
			res.setStatus("200");
			res.setRows(selectBookByCondition);
			res.setTotal(total);
		}
		return res;
	}

	@Override
	public boolean insertBookOrder(BookOrder bookOrder) {
		// TODO Auto-generated method stub
		if(bookOrderMapper.insert(bookOrder)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBookOrder(Integer bookOrderId) {
		// TODO Auto-generated method stub
		if(bookOrderMapper.deleteByPrimaryKey(bookOrderId)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBookOrder(BookOrder bookOrder) {
		// TODO Auto-generated method stub
		if(bookOrderMapper.updateByPrimaryKey(bookOrder)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getBookOrder(String bookQueryCondition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		BookQueryCondition cond = (BookQueryCondition)JSONObject.parseObject(bookQueryCondition, BookQueryCondition.class);
		int total = bookOrderMapper.selectBookOrderByCondition(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String,Object>> selectBookByCondition = bookOrderMapper.selectBookOrderByCondition(cond);
		if(selectBookByCondition==null){
			res.setStatus("500");
			res.setResult("无查询结果!");
		}else{
			res.setRows(selectBookByCondition);
			res.setStatus("200");
			res.setTotal(total);
		}
		return res;
	}

	@Override
	public boolean insertBookPayInfo(BooPayInfo bookPayInfo) {
		// TODO Auto-generated method stub
		if(bookPayInfoMapper.insert(bookPayInfo)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBookPayInfo(Integer bookPayInfoNo) {
		// TODO Auto-generated method stub
		if(bookPayInfoMapper.deleteByPrimaryKey(bookPayInfoNo)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBookPayInfo(BooPayInfo bookPayInfo) {
		// TODO Auto-generated method stub
		if(bookPayInfoMapper.updateByPrimaryKeySelective(bookPayInfo)>0){
			return true;
		}
		return false;
	}

	@Override
	public JsonResult getBookPayInfo(String bookQueryCondition,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		JsonResult res = new JsonResult();
		BookQueryCondition cond = (BookQueryCondition)JSONObject.parseObject(bookQueryCondition, BookQueryCondition.class);
		int total = bookPayInfoMapper.selectBookPayInfoByCondition(cond).size();
		if(pageNum!=null&&pageSize!=null){
			PageHelper.startPage(pageNum,pageSize);
		}
		List<Map<String,Object>> selectBookByCondition = bookPayInfoMapper.selectBookPayInfoByCondition(cond);
		if(selectBookByCondition==null){
			res.setStatus("500");
			res.setResult("无查询结果!");
		}else{
			res.setStatus("200");
			res.setRows(selectBookByCondition);
			res.setTotal(total);
		}
		return res;
	}

	@Override
	public Book getOneBook(Integer no) {
		// TODO Auto-generated method stub
		return bookMapper.selectByPrimaryKey(no);
	}

	@Override
	public BooPayInfo getOneBookPay(Integer no) {
		// TODO Auto-generated method stub
		return bookPayInfoMapper.selectByPrimaryKey(no);
	}

}
