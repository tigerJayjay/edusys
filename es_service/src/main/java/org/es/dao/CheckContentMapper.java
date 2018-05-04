package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.CheckContent;
import org.es.model.CheckContentExample;

public interface CheckContentMapper {
    long countByExample(CheckContentExample example);

    int deleteByExample(CheckContentExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(CheckContent record);

    int insertSelective(CheckContent record);

    List<CheckContent> selectByExample(CheckContentExample example);

    CheckContent selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") CheckContent record, @Param("example") CheckContentExample example);

    int updateByExample(@Param("record") CheckContent record, @Param("example") CheckContentExample example);

    int updateByPrimaryKeySelective(CheckContent record);

    int updateByPrimaryKey(CheckContent record);
}