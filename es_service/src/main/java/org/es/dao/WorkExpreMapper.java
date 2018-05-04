package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.WorkExpre;
import org.es.model.WorkExpreExample;

public interface WorkExpreMapper {
    long countByExample(WorkExpreExample example);

    int deleteByExample(WorkExpreExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(WorkExpre record);

    int insertSelective(WorkExpre record);

    List<WorkExpre> selectByExample(WorkExpreExample example);

    WorkExpre selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") WorkExpre record, @Param("example") WorkExpreExample example);

    int updateByExample(@Param("record") WorkExpre record, @Param("example") WorkExpreExample example);

    int updateByPrimaryKeySelective(WorkExpre record);

    int updateByPrimaryKey(WorkExpre record);
}