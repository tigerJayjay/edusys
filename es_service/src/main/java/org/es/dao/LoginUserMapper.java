package org.es.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.es.model.LoginUser;
import org.es.model.LoginUserExample;
import org.es.model.Role;

public interface LoginUserMapper {
    long countByExample(LoginUserExample example);

    int deleteByExample(LoginUserExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);
    List<Map<String,Object>> selectByConditon(LoginUser condition);
    List<LoginUser> selectByExample(LoginUserExample example);
    List<Role> getRolesSelected(Integer userId);
    LoginUser selectByPrimaryKey(Integer no);
    
    LoginUser selectByModel(LoginUser user);

    int updateByExampleSelective(@Param("record") LoginUser record, @Param("example") LoginUserExample example);

    int updateByExample(@Param("record") LoginUser record, @Param("example") LoginUserExample example);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);
}