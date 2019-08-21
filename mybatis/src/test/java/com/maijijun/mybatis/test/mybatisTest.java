package com.maijijun.mybatis.test;

import com.maijijun.mybatis.domains.MybatisEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class mybatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		//mybatis配置文件
		String resource = "mybatis-config.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建工厂会话，传入mybatis配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
		}

		@Test
		public void findUserById() throws IOException {
			//1.通过工厂获得SqlSession
			SqlSession sqlSession = this.getSqlSessionFactory().openSession();
			//2.通过SqlSession操作数据库
			MybatisEntity mybatisEntity = sqlSession.selectOne("mybatisTest.findUserById",3);
			//3.释放资源
			sqlSession.close();
			System.out.println(mybatisEntity.getSex());

		}

}

