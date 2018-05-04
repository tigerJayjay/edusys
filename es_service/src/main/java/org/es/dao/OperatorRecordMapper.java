package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.OperatorRecord;
import org.es.model.OperatorRecordExample;
import org.es.service.manager.logger.OperatorQueryCondition;

public interface OperatorRecordMapper {
    long countByExample(OperatorRecordExample example);

    int deleteByExample(OperatorRecordExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(OperatorRecord record);

    int insertSelective(OperatorRecord record);
    List<Map<String,Object>> selectByCondition(OperatorQueryCondition condition);
    List<OperatorRecord> selectByExample(OperatorRecordExample example);

    OperatorRecord selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") OperatorRecord record, @Param("example") OperatorRecordExample example);

    int updateByExample(@Param("record") OperatorRecord record, @Param("example") OperatorRecordExample example);

    int updateByPrimaryKeySelective(OperatorRecord record);

    int updateByPrimaryKey(OperatorRecord record);
}