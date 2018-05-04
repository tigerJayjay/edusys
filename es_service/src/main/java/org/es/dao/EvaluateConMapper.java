package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.EvaluateCon;
import org.es.model.EvaluateConExample;
import org.es.service.manager.teacher.TeaCheckQueryCondition;
import org.es.service.manager.teacher.TeacherCheckResult;

public interface EvaluateConMapper {
    long countByExample(EvaluateConExample example);

    int deleteByExample(EvaluateConExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(EvaluateCon record);
    
    List<TeacherCheckResult> getCheckResult(TeaCheckQueryCondition condition);
    
    int insertSelective(EvaluateCon record);

    List<EvaluateCon> selectByExample(EvaluateConExample example);

    EvaluateCon selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") EvaluateCon record, @Param("example") EvaluateConExample example);

    int updateByExample(@Param("record") EvaluateCon record, @Param("example") EvaluateConExample example);

    int updateByPrimaryKeySelective(EvaluateCon record);

    int updateByPrimaryKey(EvaluateCon record);
}