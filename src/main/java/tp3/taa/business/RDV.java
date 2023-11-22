package tp3.taa.business;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import tp3.taa.business.intitule.Intitule;

@Entity
public class RDV implements Serializable {
	private Long id;

	private Intitule intitule;

	private Patient patient;

	private Medecin medecin;

	private Timestamp timestamp;

	public RDV() {
		super();
	}

	public RDV(Intitule intitule, Patient patient, Medecin medecin, Timestamp timestamp) {
		this.intitule = intitule;
		this.medecin = medecin;
		this.patient = patient;
		this.timestamp = timestamp;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	public Intitule getintitule() {
		return intitule;
	}

	public void setintitule(Intitule intitule) {
		this.intitule = intitule;
	}

	@Basic
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne
	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
}
