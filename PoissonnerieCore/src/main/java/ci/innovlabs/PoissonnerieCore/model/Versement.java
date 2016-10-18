package ci.innovlabs.PoissonnerieCore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="versement")
public class Versement {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private long montant;
	
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client client;
	
	public Versement() {}

	public Versement(Long id, Date date, long montant, Client client) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.client = client;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public long getMontant() {
		return montant;
	}

	public void setMontant(long montant) {
		this.montant = montant;
	}

}
