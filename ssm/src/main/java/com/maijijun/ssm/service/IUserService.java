package com.maijijun.ssm.service;

import com.maijijun.ssm.model.User;

public interface IUserService {

	// 根据 id 寻找对应的 User
	public User findUserById(int id);
}