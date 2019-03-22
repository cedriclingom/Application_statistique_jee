package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name="utilisateur")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Prenom")
	private String firstName;

	@Column(name="Nom")
	private String lastName;

	@Column(name="Email")
	private String email;

	@Column(name="MotdePasse")
	private String textPassword;
	
	@Column(name="Active")
	private String active;
	
	
	

	
	
	
	public User() {
	}	
	
	public User(String email, String textPassword, String lastName, String firstName, String active) {
		super();
		this.email = email;
		this.textPassword = textPassword;
		this.lastName = lastName;
		this.firstName = firstName;
		this.active = active;
	}






	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTextPassword() {
		return this.textPassword;
	}

	public void setTextPassword(String textPassword) {
		this.textPassword = textPassword;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	

}