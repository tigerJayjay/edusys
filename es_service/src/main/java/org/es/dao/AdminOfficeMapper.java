package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.AdminOffice;
import org.es.model.AdminOfficeExample;

public interface AdminOfficeMapper {
    long countByExample(AdminOfficeExample example);

    int deleteByExample(AdminOfficeExample example);

    int deleteByPrimaryKey(String officeNo);

    int insert(AdminOffice record);

    int insertSelective(AdminOffice record);

    List<AdminOffice> selectByExample(AdminOfficeExample example);

    AdminOffice selectByPrimaryKey(String officeNo);

    int updateByExampleSelective(@Param("record") AdminOffice record, @Param("example") AdminOfficeExample example);

    int updateByExample(@Param("record") AdminOffice record, @Param("example") AdminOfficeExample example);

    int updateByPrimaryKeySelective(AdminOffice record);

    int updateByPrimaryKey(AdminOffice record);
}