package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.CourseSelectInfo;
import org.es.model.CourseSelectInfoExample;
import org.es.model.Schedule;
import org.es.service.manager.courseschedule.CourseQueryCondition;
import org.es.service.student.selectcourse.SelectCourseCondition;

public interface CourseSelectInfoMapper {
	int deleteCourseByCondition(SelectCourseCondition condition);
    long countByExample(CourseSelectInfoExample example);

    int deleteByExample(CourseSelectInfoExample example);

    int deleteByPrimaryKey(String selectno);
    List<Map<String,Object>> selectCourseCondition(Schedule condition);
    int insert(CourseSelectInfo record);

    int insertSelective(CourseSelectInfo record);
    List<Map<String,Object>> selectByCondition(SelectCourseCondition condition);
    List<CourseSelectInfo> selectByExample(CourseSelectInfoExample example);

    CourseSelectInfo selectByPrimaryKey(String selectno);

    int updateByExampleSelective(@Param("record") CourseSelectInfo record, @Param("example") CourseSelectInfoExample example);

    int updateByExample(@Param("record") CourseSelectInfo record, @Param("example") CourseSelectInfoExample example);

    int updateByPrimaryKeySelective(CourseSelectInfo record);

    int updateByPrimaryKey(CourseSelectInfo record);
}