package com.maijijun.ssm.dao;

import com.maijijun.ssm.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

	User  findUserById(int id);
}
