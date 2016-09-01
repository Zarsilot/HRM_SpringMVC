package com.icss.dao;

import javax.annotation.Resource;

import com.icss.model.User;

@Resource
public interface IUserDao {
	public User selectUserById(int uid);
}
