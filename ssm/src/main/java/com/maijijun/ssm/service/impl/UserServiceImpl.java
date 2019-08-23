package com.maijijun.ssm.service.impl;

import com.maijijun.ssm.dao.IUserDao;
import com.maijijun.ssm.model.User;
import com.maijijun.ssm.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	public User findUserById(int userId) {
		return this.userDao.findUserById(userId);
	}
}
