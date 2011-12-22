package com.mdb.listen;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MyMDB
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		) }, 
		mappedName = "jms/myQueue")
public class MyMDB implements MessageListener {
	private static Logger LOGGER = Logger.getLogger(MyMDB.class.getName());
	
    /**
     * Default constructor. 
     */
    public MyMDB() {
    	LOGGER.info("MyMDB Constructor");
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	 LOGGER.info("Fetching Text Message");
    	try {
            TextMessage textMessage = (TextMessage) message;
            String msg = textMessage.getText();
            LOGGER.info("msg is received msg is :: " + msg);
    	 } catch (JMSException e) {
             throw new IllegalStateException(e);
         }
        
    }

}
