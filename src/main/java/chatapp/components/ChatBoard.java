package chatapp.components;

import chatapp.model.ChatMessage;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import java.util.List;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import java.util.logging.Level;
import java.util.logging.Logger;



//@Named
@Singleton
@Stateless

public class ChatBoard {
	@PersistenceContext(unitName= "chatboardpu")
  	EntityManager em;

	private static final Logger LOG = Logger.getLogger(ChatBoard.class.getName());

	public List<ChatMessage> getMessages(){
		LOG.log(Level.SEVERE, "Demandant la liste de message");
		return em.createQuery("Select t from ChatMessage t",ChatMessage.class).getResultList();
		
	}

	public void addMessage(ChatMessage message){
		em.persist(message);
	}
}