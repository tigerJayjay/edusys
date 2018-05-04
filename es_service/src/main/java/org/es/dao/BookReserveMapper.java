package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.BookReserve;
import org.es.model.BookReserveExample;
import org.es.service.manager.book.BookQueryCondition;

public interface BookReserveMapper {
    long countByExample(BookReserveExample example);

    int deleteByExample(BookReserveExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(BookReserve record);

    int insertSelective(BookReserve record);
    
    List<Map<String,Object>> selectBookReserveByCondition(BookQueryCondition condition);
    
    List<BookReserve> selectByExample(BookReserveExample example);

    BookReserve selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") BookReserve record, @Param("example") BookReserveExample example);

    int updateByExample(@Param("record") BookReserve record, @Param("example") BookReserveExample example);

    int updateByPrimaryKeySelective(BookReserve record);

    int updateByPrimaryKey(BookReserve record);
}