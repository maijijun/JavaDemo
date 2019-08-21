package com.maijijun.demo;


import com.rabbitmq.client.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.util.IllegalFormatCodePointException;
import java.util.Queue;
import java.util.concurrent.TimeoutException;
public class rabbitMQUtil {
	public  final static String SIMPLE_QUEUE_NAME="q_simpletest_01";
	public final static String WORK_QUEUE_NAME="q_worktest_01";
	//private final static String SIMPLE_QUEUE_NAME="q_simpletest_01";

	public static Connection getConnection() throws IOException, TimeoutException {
		//定义连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		//设置服务地址
		factory.setHost("localhost");
		//设置端口
		factory.setPort(5672);
		//设置账户信息--用户名：maijijun_admin，密码：maijijun，vhost:maijijuntest
		factory.setVirtualHost("maijijuntest");
		factory.setUsername("maijijun_admin");
		factory.setPassword("maijijun");
		//获取连接
		Connection connection = factory.newConnection();
		return connection;
	}

	//simple send
	@Test
	public void simpleSend() throws IOException, TimeoutException {
		//获取到连接以及mq通道
		Connection connection= getConnection();
		//从连接中创建通道
		Channel channel = connection.createChannel();
		//声明（创建）队列
		channel.queueDeclare(SIMPLE_QUEUE_NAME,false,false,false,null);
		//消息内容
		String message = "Hello World!!!,你好！！！";
		channel.basicPublish("",SIMPLE_QUEUE_NAME,null,message.getBytes());
		System.out.println(" [X] Sent '"+message +"'");
		//关闭通道和连接
		channel.close();
		connection.close();
	}

	//simple recv
	@Test
	public void simpleRecv() throws IOException, TimeoutException {
		//获取到连接以及mq通道
		Connection connection = getConnection();
		//从连接中创建通道
		Channel channel = connection.createChannel();
		//声明队列
		channel.queueDeclare(SIMPLE_QUEUE_NAME,false,false,false,null);
		//定义队列的消费者
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String msg = new String(body,"utf-8");
				System.out.println("接收到消息--"+ msg);
			}
		};
		//监听队列
		channel.basicConsume(SIMPLE_QUEUE_NAME,true,consumer);
	}





}


