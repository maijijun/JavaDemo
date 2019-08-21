package com.maijijun.demo;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.maijijun.demo.rabbitMQUtil.*;

public class workRecv_1 {

	@Test
	public void workRecv_1() throws IOException, TimeoutException {
		//获取连接以及mq通道
		Connection connection = getConnection();
		//从连接中创建通道
		Channel channel = connection.createChannel();
		//声明队列
		channel.queueDeclare(WORK_QUEUE_NAME,false,false,false,null);
		// 保证一次只分发一条消息
		channel.basicQos(1);
		//定义队里的消费者
		DefaultConsumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String msg = new String (body,"utf-8");
				System.out.println("workRecv1:"+msg);
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		//监听队列
		channel.basicConsume(WORK_QUEUE_NAME,true,consumer);
	}
}
