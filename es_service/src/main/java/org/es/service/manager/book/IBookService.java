package org.es.service.manager.book;
import java.util.List;

import org.es.bean.JsonResult;
import org.es.model.BooPayInfo;
import org.es.model.Book;
import org.es.model.BookOrder;
import org.es.model.BookReserve;
/**
 * 教材操作接口
 * @author Administrator
 *
 */
public interface IBookService {
	Book getOneBook(Integer no);
	/**
	 * 添加教材信息
	 */
	boolean insertBook(Book book);
	/**
	 * 查询教材信息
	 */
	JsonResult getBookByCondition(String condition,Integer pageNum,Integer pageSize);
	/**
	 * 删除教材信息
	 */
	boolean deleteBook(Integer bookNo);
	/**
	 * 更新教材信息
	 */
	boolean updateBook(Book book);
	
	/**
	 * 添加预定教材信息
	 */
	boolean insertBookReserve(BookReserve bookReserve);
	/**
	 * 删除预定教材信息
	 */
	boolean deleteBookReserve(Integer bookReserveId);
	/**
	 * 修改预定教材信息
	 */
	boolean updateBookReserve(BookReserve bookReserve);
	/**
	 * 查询教材预定信息
	 */
	JsonResult getBookReserve(String bookQueryCondition,Integer pageNum,Integer pageSize);
	/**
	 * 添加教材购买信息
	 */
	boolean insertBookOrder(BookOrder bookOrder);
	/**
	 * 删除教材购买信息
	 */
	boolean deleteBookOrder(Integer bookOrderId);
    /**
     * 修改教材购买信息
     */
	boolean updateBookOrder(BookOrder bookOrder);
	/**
	 * 查询教材购买信息
	 */
	JsonResult getBookOrder(String bookQueryCondition,Integer pageNum,Integer pageSize);
	
	BooPayInfo getOneBookPay(Integer no);
	/**
	 * 增加教材缴费信息
	 */
	boolean insertBookPayInfo(BooPayInfo bookPayInfo);
	/**
	 * 删除教材缴费信息
	 */
	boolean deleteBookPayInfo(Integer bookPayInfoNo);
	/**
	 * 更新教材缴费信息
	 */
	boolean updateBookPayInfo(BooPayInfo bookPayInfo);
	/**
	 * 查询教材缴费信息
	 */
	JsonResult getBookPayInfo(String bookQueryCondition,Integer pageNum,Integer pageSize);
}


