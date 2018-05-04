package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.Role;
import org.es.model.RoleExample;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(Role record);
    List<Map<String,Object>> selectByConditon(Integer no);
    int insertSelective(Role record);
    List<Map<String,Object>> getAuthSelected(Integer no);
    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}