package chatapp.components;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.jms.Topic;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.annotation.Resource;


import java.util.logging.Level;
import java.util.logging.Logger;



@Stateless
public class StatusBroadcaster implements Serializable{
	
	@Resource(mappedName = "StatusConnectionFactory")
	ConnectionFactory jmsStatusConnectionFactory;

	@Resource(mappedName = "jms/ParticipantStatusBroadcast")
	Topic	participantStatusBroadcaster;

	public String postUpdate(String who, String status){
		try{
			Connection connection = jmsStatusConnectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(participantStatusBroadcaster);
			TextMessage message = session.createTextMessage(who + " is now " + status);
			producer.send(message);

			producer.close();
			session.close();
			connection.close();
		}catch (JMSException ex){
			LOG.log(Level.SEVERE, null, ex);
		}

		return (who + "is now " + status) ;
	}
	private static final Logger LOG = Logger.getLogger(StatusBroadcaster.class.getName());

}