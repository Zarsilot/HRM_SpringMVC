package com.icss.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;

import com.icss.service.IAlertService;

/**
 * 
 * @author wanchao
 *
 */
public class AlertServiceImpl implements IAlertService{

	private JmsOperations jmsOperations;
	
	@Autowired
	public AlertServiceImpl(JmsOperations jmsOperations) {
		super();
		this.jmsOperations = jmsOperations;
	}

	@Override
	public void sendAlert() {
		//指定目的地
		jmsOperations.send("HRM.queue", new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
				//创建消息
				return session.createObjectMessage("success!");
			}

		
			
		});
	}
	
}
