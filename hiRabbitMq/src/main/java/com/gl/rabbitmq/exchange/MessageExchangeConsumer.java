package com.gl.rabbitmq.exchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MessageExchangeConsumer {
	public static final String QUEUE_NAME = "test-exchange-1";

	public static void main(String[] args) throws IOException, TimeoutException {
		System.out.println(Runtime.getRuntime().toString());
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(MessageExchangeProducer.EXCHANGE_NAME, "direct");
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		channel.queueBind(QUEUE_NAME, MessageExchangeProducer.EXCHANGE_NAME, MessageExchangeProducer.ROUTE_KEY);
		
		channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel){

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			}
			
		});
	}

}
