package com.gl.rabbitmq.rpc;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MessageRpcConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		
		
		ConnectionFactory f = new ConnectionFactory();
		f.setHost("localhost");
		
		Connection c = f.newConnection();
		Channel ch = c.createChannel();
		
		ch.exchangeDeclare("rpc", "direct", false);
		ch.queueDeclare("ping", false,false,false,null);
		
		ch.queueBind("ping", "rpc", "ping");
		
		ch.basicConsume("ping", new DefaultConsumer(ch){

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				System.out.println("received:"+new String(body,"utf-8"));
				getChannel().basicAck(envelope.getDeliveryTag(), false);
				String replyMsg = "pong";
				getChannel().basicPublish("", properties.getReplyTo(), null, replyMsg.getBytes() );
			}
			
		});
	}

}
