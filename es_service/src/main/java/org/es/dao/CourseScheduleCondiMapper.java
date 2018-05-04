package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.CourseScheduleCondi;
import org.es.model.CourseScheduleCondiExample;

public interface CourseScheduleCondiMapper {
    long countByExample(CourseScheduleCondiExample example);

    int deleteByExample(CourseScheduleCondiExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(CourseScheduleCondi record);

    int insertSelective(CourseScheduleCondi record);

    List<CourseScheduleCondi> selectByExample(CourseScheduleCondiExample example);

    CourseScheduleCondi selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") CourseScheduleCondi record, @Param("example") CourseScheduleCondiExample example);

    int updateByExample(@Param("record") CourseScheduleCondi record, @Param("example") CourseScheduleCondiExample example);

    int updateByPrimaryKeySelective(CourseScheduleCondi record);

    int updateByPrimaryKey(CourseScheduleCondi record);
}