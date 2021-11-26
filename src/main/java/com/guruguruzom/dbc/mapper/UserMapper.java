package com.guruguruzom.dbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import com.guruguruzom.dbc.domain.UserDto;
import com.guruguruzom.dbc.mapper.type.UserType;

@Mapper
public interface UserMapper {
	@Select("SELECT 1")
	public int getUserCount();
	
	@SelectProvider(type=UserType.class, method = "setUsers")
	@SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userSeq", before=false, resultType=int.class)
	public String setUsers(List<UserDto> users);
}
