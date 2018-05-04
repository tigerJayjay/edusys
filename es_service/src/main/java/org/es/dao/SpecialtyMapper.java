package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.Specialty;
import org.es.model.SpecialtyExample;

public interface SpecialtyMapper {
    long countByExample(SpecialtyExample example);

    int deleteByExample(SpecialtyExample example);

    int deleteByPrimaryKey(String speNo);

    int insert(Specialty record);

    int insertSelective(Specialty record);

    List<Specialty> selectByExample(SpecialtyExample example);

    Specialty selectByPrimaryKey(String speNo);

    int updateByExampleSelective(@Param("record") Specialty record, @Param("example") SpecialtyExample example);

    int updateByExample(@Param("record") Specialty record, @Param("example") SpecialtyExample example);

    int updateByPrimaryKeySelective(Specialty record);

    int updateByPrimaryKey(Specialty record);
}