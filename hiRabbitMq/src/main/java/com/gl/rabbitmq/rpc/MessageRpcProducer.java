package com.gl.rabbitmq.rpc;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MessageRpcProducer {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory f = new ConnectionFactory();
		f.setHost("localhost");
		
		Connection c = f.newConnection();
		Channel ch = c.createChannel();
		
		String msg = "ping";
		
		Queue.DeclareOk result = ch.queueDeclare();
		
		String replyTo = result.getQueue();
		
		BasicProperties props =new BasicProperties.Builder().replyTo(replyTo).build() ;
		
		ch.basicPublish("rpc", "ping",props , msg.getBytes());
		
		ch.basicConsume(replyTo, new DefaultConsumer(ch){

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				System.out.println("replied:"+new String(body,"utf-8"));
			}
			
		});
		
	}

}
