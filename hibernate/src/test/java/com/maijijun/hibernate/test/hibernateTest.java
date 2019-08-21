package com.maijijun.hibernate.test;

import com.maijijun.hibernate.bean.HibrenateTableEntity;
import com.maijijun.hibernate.utils.HBUtils;
import org.hibernate.*;
import org.junit.jupiter.api.Test;

public class hibernateTest {
//	@Test
//	public void  add(){
//
//		// 加载Hibernate默认配置文件
//		Configuration configuration = new Configuration().configure();
//		// 用Configuration创建SessionFactory
//		SessionFactory factory = configuration.buildSessionFactory();
//		// 创建Session
//		Session session = factory.openSession();
//		// 开启事务
//		Transaction transaction = session.beginTransaction();
//		// 实例化持久化类
//		HibrenateTableEntity hibernate_test = new HibrenateTableEntity();
//		hibernate_test.setName("maijijun");
//		hibernate_test.setAge(13);
//		hibernate_test.setHeight(178);
//		hibernate_test.setWeight(200);
//		hibernate_test.setSex("男");
//		// 保存
//		session.save(hibernate_test);
//		// 提交事务
//		transaction.commit();
//		// 关闭Session，释放资源
//		session.close();
//		factory.close();
//	}
	@Test
	public void insert(){
		//1.获取session对象
		Session session = HBUtils.getSession();
		//2.开启事务
		Transaction transaction=session.beginTransaction();
		//3.实例化持久化类
		HibrenateTableEntity hibernate_insert = new HibrenateTableEntity();
		hibernate_insert.setName("maijijun");
		hibernate_insert.setAge(13);
		hibernate_insert.setHeight(156);
		hibernate_insert.setWeight(200);
		hibernate_insert.setSex("男");
		//4.保存
		session.save(hibernate_insert);
		//5.提交事务
		transaction.commit();
		//6.释放资源
		session.close();
	}
	@Test
	public void delete(){
		//1.获取session对象
		Session session = HBUtils.getSession();
		//2.开启事务
		Transaction transaction=session.beginTransaction();
		//3.删除数据库中的数据,删除id=2的那一条数据
		HibrenateTableEntity hibernate_del = session.get(HibrenateTableEntity.class,2);
		session.delete(hibernate_del);
		//5.提交事务
		transaction.commit();
		//6.释放资源
		session.close();
	}
	@Test
	public void update(){
		//1.获取session对象
		Session session = HBUtils.getSession();
		//2.开启事务
		Transaction transaction=session.beginTransaction();
		//3.修改数据库第三条信息
		HibrenateTableEntity hibernate_update = session.get(HibrenateTableEntity.class,3);
		hibernate_update.setSex("女");
		session.update(hibernate_update);
		//5.提交事务
		transaction.commit();
		//6.释放资源
		session.close();
	}
	@Test
	public void query(){
		//1.获取session对象
		Session session = HBUtils.getSession();
		//2.开启事务
		Transaction transaction=session.beginTransaction();
		//3.查找数据库第三条信息
		HibrenateTableEntity hibernate_query = session.get(HibrenateTableEntity.class,3);
		//5.提交事务
		transaction.commit();
		//6.释放资源
		session.close();
		System.out.println(hibernate_query.getSex());
	}
}
