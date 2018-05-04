package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.BooPayInfo;
import org.es.model.BooPayInfoExample;
import org.es.service.manager.book.BookQueryCondition;

public interface BooPayInfoMapper {
    long countByExample(BooPayInfoExample example);

    int deleteByExample(BooPayInfoExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(BooPayInfo record);

    int insertSelective(BooPayInfo record);
    
    List<Map<String,Object>> selectBookPayInfoByCondition(BookQueryCondition condition);
    
    List<BooPayInfo> selectByExample(BooPayInfoExample example);

    BooPayInfo selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") BooPayInfo record, @Param("example") BooPayInfoExample example);

    int updateByExample(@Param("record") BooPayInfo record, @Param("example") BooPayInfoExample example);

    int updateByPrimaryKeySelective(BooPayInfo record);

    int updateByPrimaryKey(BooPayInfo record);
}