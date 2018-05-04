package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.ExamArrangement;
import org.es.model.ExamArrangementExample;
import org.es.model.ExamArrangementStatis;

public interface ExamArrangementMapper {
    long countByExample(ExamArrangementExample example);

    int deleteByExample(ExamArrangementExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(ExamArrangement record);
    List<Map<String,Object>> selectByCondition(ExamArrangement arrangeStatis);
    List<String> getStudentByCourseNo(String no);
    int insertSelective(ExamArrangement record);

    List<ExamArrangement> selectByExample(ExamArrangementExample example);

    ExamArrangement selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") ExamArrangement record, @Param("example") ExamArrangementExample example);

    int updateByExample(@Param("record") ExamArrangement record, @Param("example") ExamArrangementExample example);

    int updateByPrimaryKeySelective(ExamArrangement record);

    int updateByPrimaryKey(ExamArrangement record);
}