package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.ExamStatus;
import org.es.model.ExamStatusExample;

public interface ExamStatusMapper {
    long countByExample(ExamStatusExample example);

    int deleteByExample(ExamStatusExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(ExamStatus record);

    int insertSelective(ExamStatus record);

    List<ExamStatus> selectByExample(ExamStatusExample example);

    ExamStatus selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") ExamStatus record, @Param("example") ExamStatusExample example);

    int updateByExample(@Param("record") ExamStatus record, @Param("example") ExamStatusExample example);

    int updateByPrimaryKeySelective(ExamStatus record);

    int updateByPrimaryKey(ExamStatus record);
}