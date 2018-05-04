package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.AdminPeople;
import org.es.model.AdminPeopleExample;

public interface AdminPeopleMapper {
    long countByExample(AdminPeopleExample example);

    int deleteByExample(AdminPeopleExample example);

    int deleteByPrimaryKey(String jobNo);

    int insert(AdminPeople record);

    int insertSelective(AdminPeople record);

    List<AdminPeople> selectByExample(AdminPeopleExample example);

    AdminPeople selectByPrimaryKey(String jobNo);

    int updateByExampleSelective(@Param("record") AdminPeople record, @Param("example") AdminPeopleExample example);

    int updateByExample(@Param("record") AdminPeople record, @Param("example") AdminPeopleExample example);

    int updateByPrimaryKeySelective(AdminPeople record);

    int updateByPrimaryKey(AdminPeople record);
}