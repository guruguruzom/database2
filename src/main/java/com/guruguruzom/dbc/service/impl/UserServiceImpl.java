package com.guruguruzom.dbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guruguruzom.dbc.mapper.UserMapper;
import com.guruguruzom.dbc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired private UserMapper userMapper;
	
	@Override
	public int getUserCount()
	{
		int userCount = userMapper.getUserCount();
		return userCount;
	}

}
