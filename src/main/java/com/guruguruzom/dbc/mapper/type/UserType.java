package com.guruguruzom.dbc.mapper.type;

import java.util.List;

import com.guruguruzom.dbc.domain.UserDto;

public class UserType {
	public String setUsers(List<UserDto> userDtos) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("INSERT INTO user (name, id) VALUES ");
		for(UserDto userDto : userDtos) {
			sqlBuilder.append("('").append(userDto.name).append("','").append(userDto.id).append("'),");
		}
		
		return cutLastIndex(sqlBuilder);
	}
	
	private String cutLastIndex(StringBuilder sqlBuilder) {
		String sqlTemp = sqlBuilder.toString();
		String sql = sqlBuilder.substring(0, sqlTemp.length()-1);
		return sql;
	}
}
