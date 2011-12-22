package com.mdb.send;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Session Bean implementation class Messanger
 */
@Stateless (mappedName = "jms/messanger")
public class Messanger implements MessangerRemote {

	private static Logger LOGGER = Logger.getLogger(Messanger.class.getName());	

	@Resource (mappedName = "jms/connectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "jms/myQueue")
	private Queue myQueue;

	/**
	 * Default constructor. 
	 */
	public Messanger() {

	}

	@Override
	public void sendMessage(String text) throws JMSException {
		LOGGER.info("preparing to send message");
		Connection connection = null;
		Session session = null;

		connection = connectionFactory.createConnection();

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		LOGGER.info("preparing session " + session);
		
		MessageProducer producer = session.createProducer(myQueue);	
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		TextMessage message = session.createTextMessage(text);

		producer.send(message);
		LOGGER.info("message sent successfully");
		
		if (session != null) session.close();
		if (connection != null) connection.close();

	}

	@Override
	public String receiveMessage() throws JMSException {
		 Connection connection = null;
	        Session session = null;
	        MessageConsumer consumer = null;
	        try {
	            connection = connectionFactory.createConnection();
	            connection.start();

	            // Create a Session
	            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	            // Create a MessageConsumer from the Session to the Topic or Queue
	            consumer = session.createConsumer(myQueue);

	            // Wait for a message
	            TextMessage message = (TextMessage) consumer.receive(1000);

	            return message.getText();
	        } finally {
	            if (consumer != null) consumer.close();
	            if (session != null) session.close();
	            if (connection != null) connection.close();
	        }
	}

}
