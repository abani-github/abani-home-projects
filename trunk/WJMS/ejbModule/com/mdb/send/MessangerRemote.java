package com.mdb.send;
import javax.ejb.Remote;
import javax.jms.JMSException;

@Remote
public interface MessangerRemote {
	 void sendMessage(String text) throws JMSException;
	 public String receiveMessage() throws JMSException;
}
