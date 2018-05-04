package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.ScoreInfo;
import org.es.model.ScoreInfoExample;
import org.es.service.manager.exam.ScoreInfoQueryCondition;

public interface ScoreInfoMapper {
    long countByExample(ScoreInfoExample example);

    int deleteByExample(ScoreInfoExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(ScoreInfo record);

    int insertSelective(ScoreInfo record);

    List<ScoreInfo> selectByExample(ScoreInfoExample example);

    List<Map<String,Object>> selectScoreInfoByCondition(ScoreInfoQueryCondition condition);
    ScoreInfo selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") ScoreInfo record, @Param("example") ScoreInfoExample example);

    int updateByExample(@Param("record") ScoreInfo record, @Param("example") ScoreInfoExample example);

    int updateByPrimaryKeySelective(ScoreInfo record);

    int updateByPrimaryKey(ScoreInfo record);
}