package com.maijijun.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 本类封装了操作hibernate的相关方法
 *
 */
public class HBUtils {
	// 产生session对象的工厂
	private static SessionFactory sessionFactory;

	// 静态代码块，生成工厂，使用静态代码块的原因：使整个WEB项目只有一个SessionFactory，节省资源
	static {
		// 配置加载类，用于加载主配置跟orm元数据
		Configuration conf = new Configuration();
		// 读取指定的配置文件hibernate.cfg.xml
		conf = conf.configure();
		// 根据配置信息创建sessionFactory对象
		sessionFactory = conf.buildSessionFactory();
	}

	// 获取session
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
