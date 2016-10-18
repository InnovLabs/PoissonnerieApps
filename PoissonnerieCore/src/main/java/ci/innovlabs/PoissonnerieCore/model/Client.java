package ci.innovlabs.PoissonnerieCore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
    @GeneratedValue
	private Long id;
	private String nom;
	private String phone;
	
	public Client() {}

	public Client(Long id, String nom, String phone) {
		this.id = id;
		this.nom = nom;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
