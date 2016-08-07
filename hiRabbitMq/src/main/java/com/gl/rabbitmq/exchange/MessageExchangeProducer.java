package com.gl.rabbitmq.exchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessageExchangeProducer {
	public static final String EXCHANGE_NAME = "test-exchange-1";
	public static final String ROUTE_KEY = "hlo";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		
		
		String message = "exchange messages : hello";
		channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY, null, message.getBytes());
		
		channel.close();
		connection.close();
	}

}
