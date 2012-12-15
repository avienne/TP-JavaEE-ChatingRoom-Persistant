package chatapp.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class ChatMessage implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id; 

	@Column
	private String participant; 
	@Column
	private @Temporal(TemporalType.DATE) Date date; 
	@Column
	private String content;

	public ChatMessage(){}
	public ChatMessage(String participant, Date date, String content){
		this.participant = participant;
		this.date = date;
		this.content = content;

	} 

	public String getParticipant(){
		return this.participant;
	}
	public Date getDate(){
		return this.date;
	}
	public String getContent(){
		return this.content;
	}


}