package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.TeacherCourse;
import org.es.model.TeacherCourseExample;

public interface TeacherCourseMapper {
    long countByExample(TeacherCourseExample example);

    int deleteByExample(TeacherCourseExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(TeacherCourse record);

    int insertSelective(TeacherCourse record);

    List<TeacherCourse> selectByExample(TeacherCourseExample example);

    TeacherCourse selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") TeacherCourse record, @Param("example") TeacherCourseExample example);

    int updateByExample(@Param("record") TeacherCourse record, @Param("example") TeacherCourseExample example);

    int updateByPrimaryKeySelective(TeacherCourse record);

    int updateByPrimaryKey(TeacherCourse record);
}