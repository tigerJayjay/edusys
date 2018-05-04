package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.Course;
import org.es.model.CourseExample;
import org.es.service.manager.courseschedule.CourseQueryCondition;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(String courseNo);

    int insert(Course record);

    int insertSelective(Course record);
    List<Map<String,Object>> getCourseByCondition(CourseQueryCondition condition);
    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(String courseNo);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}