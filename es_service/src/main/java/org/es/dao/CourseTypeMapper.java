package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.CourseType;
import org.es.model.CourseTypeExample;

public interface CourseTypeMapper {
    long countByExample(CourseTypeExample example);

    int deleteByExample(CourseTypeExample example);

    int deleteByPrimaryKey(Integer couseno);

    int insert(CourseType record);

    int insertSelective(CourseType record);

    List<CourseType> selectByExample(CourseTypeExample example);

    CourseType selectByPrimaryKey(Integer couseno);

    int updateByExampleSelective(@Param("record") CourseType record, @Param("example") CourseTypeExample example);

    int updateByExample(@Param("record") CourseType record, @Param("example") CourseTypeExample example);

    int updateByPrimaryKeySelective(CourseType record);

    int updateByPrimaryKey(CourseType record);
}