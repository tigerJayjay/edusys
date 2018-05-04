package org.es.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.es.model.RecordInfo;
import org.es.model.RecordInfoExample;

public interface RecordInfoMapper {
    long countByExample(RecordInfoExample example);

    int deleteByExample(RecordInfoExample example);

    int deleteByPrimaryKey(String recordno);

    int insert(RecordInfo record);

    int insertSelective(RecordInfo record);

    List<RecordInfo> selectByExample(RecordInfoExample example);

    RecordInfo selectByPrimaryKey(String recordno);

    int updateByExampleSelective(@Param("record") RecordInfo record, @Param("example") RecordInfoExample example);

    int updateByExample(@Param("record") RecordInfo record, @Param("example") RecordInfoExample example);

    int updateByPrimaryKeySelective(RecordInfo record);

    int updateByPrimaryKey(RecordInfo record);
}