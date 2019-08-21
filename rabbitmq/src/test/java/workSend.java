import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.maijijun.demo.rabbitMQUtil.*;

public class workSend {
	@Test
	public void workSend() throws IOException, TimeoutException, InterruptedException {
		Thread.sleep(4000);
		//获取连接以及mq通道
		Connection connection = getConnection();
		//从连接中创建通道
		Channel channel = connection.createChannel();
		//声明队列
		channel.queueDeclare(WORK_QUEUE_NAME,false,false,false,null);
		//发送50条消息
		// 每个消费者发送确认收到消息之前,消息队列不发送下一个消息到消费者,一次只处理一个消息
		// 限制发送给同一个消费者不超过1条消息
		channel.basicQos(1);
		for (int i = 0; i < 50; i++) {
			//消息内容
			String msg = "Work Queue :"+ i;
			//发送消息
			channel.basicPublish("",WORK_QUEUE_NAME,null,msg.getBytes());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Send success!!!");
		channel.close();
		connection.close();
	}

}
