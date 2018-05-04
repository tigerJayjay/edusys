package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.RoleAutho;
import org.es.model.RoleAuthoExample;

public interface RoleAuthoMapper {
    long countByExample(RoleAuthoExample example);

    int deleteByExample(RoleAuthoExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(RoleAutho record);

    int insertSelective(RoleAutho record);

    List<RoleAutho> selectByExample(RoleAuthoExample example);

    RoleAutho selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") RoleAutho record, @Param("example") RoleAuthoExample example);

    int updateByExample(@Param("record") RoleAutho record, @Param("example") RoleAuthoExample example);

    int updateByPrimaryKeySelective(RoleAutho record);

    int updateByPrimaryKey(RoleAutho record);
}