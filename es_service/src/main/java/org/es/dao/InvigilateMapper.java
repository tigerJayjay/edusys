package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.Invigilate;
import org.es.model.InvigilateExample;
import org.es.service.manager.exam.InvigilateQueryCondition;

public interface InvigilateMapper {
    long countByExample(InvigilateExample example);

    int deleteByExample(InvigilateExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(Invigilate record);

    int insertSelective(Invigilate record);
    List<Map<String,Object>> selectByCondition(InvigilateQueryCondition condition);
    List<Invigilate> selectByExample(InvigilateExample example);

    Invigilate selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") Invigilate record, @Param("example") InvigilateExample example);

    int updateByExample(@Param("record") Invigilate record, @Param("example") InvigilateExample example);

    int updateByPrimaryKeySelective(Invigilate record);

    int updateByPrimaryKey(Invigilate record);
}