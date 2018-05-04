package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.Schedule;
import org.es.model.ScheduleExample;

public interface ScheduleMapper {
    long countByExample(ScheduleExample example);

    int deleteByExample(ScheduleExample example);

    int deleteByPrimaryKey(String scheNo);

    int insert(Schedule record);

    int insertSelective(Schedule record);
    
    List<Map<String,Object>> getScheduleByConditionMerge(Schedule condition);
    
    List<Map<String,Object>> getScheduleByConditionSpread(Schedule condition);

    List<Map<String,Object>> getScheduleByCondition(Schedule condition);
    List<Schedule> selectByExample(ScheduleExample example);

    Schedule selectByPrimaryKey(String scheNo);

    int updateByExampleSelective(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByExample(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}