package com.maijiju.ssm.test;

import com.maijijun.ssm.dao.IUserDao;
import com.maijijun.ssm.model.User;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	@Autowired
	private IUserDao userDao;
	@Test
	public void testFindUserById(){
		int id =4;

		User user =userDao.findUserById(id);
		System.out.println(user.getId()+":"+user.getUsername());
	}

}
