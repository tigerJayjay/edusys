package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.CourseBook;
import org.es.model.CourseBookExample;

public interface CourseBookMapper {
    long countByExample(CourseBookExample example);

    int deleteByExample(CourseBookExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(CourseBook record);
    List<Map<String,Object>> selectByCondition(CourseBook cb);
    int insertSelective(CourseBook record);

    List<CourseBook> selectByExample(CourseBookExample example);

    CourseBook selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") CourseBook record, @Param("example") CourseBookExample example);

    int updateByExample(@Param("record") CourseBook record, @Param("example") CourseBookExample example);

    int updateByPrimaryKeySelective(CourseBook record);

    int updateByPrimaryKey(CourseBook record);
}