package com.dlmu.graduation.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dlmu.graduation.dao.entity.Users;
import com.dlmu.graduation.dao.entity.UsersExample;

public interface UsersMapper {
	
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}