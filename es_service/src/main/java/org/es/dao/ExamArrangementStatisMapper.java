package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.ExamArrangement;
import org.es.model.ExamArrangementStatis;
import org.es.model.ExamArrangementStatisExample;

public interface ExamArrangementStatisMapper {
    long countByExample(ExamArrangementStatisExample example);

    int deleteByExample(ExamArrangementStatisExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(ExamArrangementStatis record);

    int insertSelective(ExamArrangementStatis record);

    List<Map<String,Object>> selectByCondition(ExamArrangementStatis condition);
    List<ExamArrangementStatis> selectByExample(ExamArrangementStatisExample example);

    ExamArrangementStatis selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") ExamArrangementStatis record, @Param("example") ExamArrangementStatisExample example);

    int updateByExample(@Param("record") ExamArrangementStatis record, @Param("example") ExamArrangementStatisExample example);

    int updateByPrimaryKeySelective(ExamArrangementStatis record);

    int updateByPrimaryKey(ExamArrangementStatis record);
}