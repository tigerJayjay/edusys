package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.RoomUseInfo;
import org.es.model.RoomUseInfoExample;

public interface RoomUseInfoMapper {
    long countByExample(RoomUseInfoExample example);

    int deleteByExample(RoomUseInfoExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(RoomUseInfo record);

    int insertSelective(RoomUseInfo record);

    List<RoomUseInfo> selectByExample(RoomUseInfoExample example);

    RoomUseInfo selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") RoomUseInfo record, @Param("example") RoomUseInfoExample example);

    int updateByExample(@Param("record") RoomUseInfo record, @Param("example") RoomUseInfoExample example);

    int updateByPrimaryKeySelective(RoomUseInfo record);

    int updateByPrimaryKey(RoomUseInfo record);
}