package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.Student;
import org.es.model.StudentExample;
import org.es.service.manager.student.StudentQueryCondition;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String sno);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);
    
    List<Map<String,Object>> selectByCondition(StudentQueryCondition condition);
    
    Integer selectCountByCondition(StudentQueryCondition condition);

    Student selectByPrimaryKey(String sno);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}