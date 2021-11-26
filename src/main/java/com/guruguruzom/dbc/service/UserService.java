package com.guruguruzom.dbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.guruguruzom.dbc.mapper.UserMapper;


public interface UserService {
	
	int getUserCount();

}
