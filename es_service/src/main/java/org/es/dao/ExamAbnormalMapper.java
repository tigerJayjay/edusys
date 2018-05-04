package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.ExamAbnormal;
import org.es.model.ExamAbnormalExample;
import org.es.service.manager.exam.ExamAboQueryCondition;

public interface ExamAbnormalMapper {
    long countByExample(ExamAbnormalExample example);

    int deleteByExample(ExamAbnormalExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(ExamAbnormal record);

    int insertSelective(ExamAbnormal record);

    List<Map<String,Object>> selectExamAboByCondition(ExamAboQueryCondition condition);
    
    List<ExamAbnormal> selectByExample(ExamAbnormalExample example);

    ExamAbnormal selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") ExamAbnormal record, @Param("example") ExamAbnormalExample example);

    int updateByExample(@Param("record") ExamAbnormal record, @Param("example") ExamAbnormalExample example);

    int updateByPrimaryKeySelective(ExamAbnormal record);

    int updateByPrimaryKey(ExamAbnormal record);
}