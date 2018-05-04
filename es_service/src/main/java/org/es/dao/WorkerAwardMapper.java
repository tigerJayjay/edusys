package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.WorkerAward;
import org.es.model.WorkerAwardExample;

public interface WorkerAwardMapper {
    long countByExample(WorkerAwardExample example);

    int deleteByExample(WorkerAwardExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(WorkerAward record);

    int insertSelective(WorkerAward record);

    List<WorkerAward> selectByExample(WorkerAwardExample example);

    WorkerAward selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") WorkerAward record, @Param("example") WorkerAwardExample example);

    int updateByExample(@Param("record") WorkerAward record, @Param("example") WorkerAwardExample example);

    int updateByPrimaryKeySelective(WorkerAward record);

    int updateByPrimaryKey(WorkerAward record);
}