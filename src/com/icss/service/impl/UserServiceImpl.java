package com.icss.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.icss.dao.IUserDao;
import com.icss.model.User;
import com.icss.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;
	
	@Override
	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(uid);
	}

}
