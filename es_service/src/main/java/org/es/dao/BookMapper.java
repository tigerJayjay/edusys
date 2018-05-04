package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.Book;
import org.es.model.BookExample;
import org.es.service.manager.book.BookQueryCondition;

public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bookNo);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);
    
    List<Map<String,Object>> selectBookByCondition(BookQueryCondition condition);
    
    Book selectByPrimaryKey(Integer bookNo);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}