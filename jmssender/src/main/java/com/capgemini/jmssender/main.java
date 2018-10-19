package com.capgemini.jmssender;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;




public class main {


	
	/*if(args.length == 0) {
		System.out.println("Must supply a message");
		System.out.println("From gradle run with : gradle - pargs= \"HelloWorld\"run");
		return;
	}
	else {
		System.out.println(args[0]);
	}
	ConnectionFactory connectionFactory;
	Connection connection = null;
	
	try {
		InitialContext intialContext = new InitialContext();
		Queue queue = (Queue) intialContext.lookup("JSTopic");
		connectionFactory =  
				(ConnectionFactory) intialContext.lookup("jms/__defaultConnectionFactory");
		
		connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		MessageProducer messageProducer = session.createProducer(queue);
		TextMessage textMessage = session.createTextMessage("hello Spandhana");
		messageProducer.send(textMessage);
		System.out.println("Message Produced");
		
		
	} catch (NamingException e) {
		e.printStackTrace();
	} catch (JMSException e) {
		e.printStackTrace();
	}finally {
		if (connection != null) try {
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}

}*/
	public static void main(String[] args) {

		/*
		 * if(args.length ==0) {
		 * 
		 * System.out.println("From gradle run with: gradle -Pargs=\"Hello World\" run"
		 * ); return; } else { System.out.println(args[0]); }
		 */
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Queue queue = null;
		//System.out.println("Must supply a message");
		try {
			InitialContext initialContext = new InitialContext();
			queue = (Queue) initialContext.lookup("JSTopic");

			connectionFactory = (ConnectionFactory) initialContext.lookup("jms/__defaultConnectionFactory");
		/*	connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage textMessage = session.createTextMessage("hy5thy");
			messageProducer.send(textMessage);
			System.out.println("Message Produced");
*/
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		try(JMSContext context = connectionFactory.createContext()){
			TextMessage message = context.createTextMessage("shubham");
			context.createProducer().send(queue, message);
			System.out.println("Message Produced");
		}
		/*catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
		}*/
	
}
}