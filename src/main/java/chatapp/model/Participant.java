package chatapp.model;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped

public class Participant implements Serializable{

	private String nom = "N/A";
	private String email = "N/A";

	public Participant (){
		super();
	} 
	public Participant(String nom, String email){
		this.nom = nom;
		this.email = email;
	}
	public void setName(String name){
		this.nom = name;
	}
	public void setEmail(String email){
		this.email = email;
	}

	public String getName(){
		return this.nom;
	}

}