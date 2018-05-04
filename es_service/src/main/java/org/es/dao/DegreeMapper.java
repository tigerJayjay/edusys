package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.Degree;
import org.es.model.DegreeExample;

public interface DegreeMapper {
    long countByExample(DegreeExample example);

    int deleteByExample(DegreeExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(Degree record);

    int insertSelective(Degree record);

    List<Degree> selectByExample(DegreeExample example);

    Degree selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") Degree record, @Param("example") DegreeExample example);

    int updateByExample(@Param("record") Degree record, @Param("example") DegreeExample example);

    int updateByPrimaryKeySelective(Degree record);

    int updateByPrimaryKey(Degree record);
}