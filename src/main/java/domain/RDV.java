package domain;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class RDV {
    private Long id;

	private String intitule;

    private Patient patient;

    private Medecin medecin;

    private Date date ;

	public RDV() {
		super();
	}

	public RDV(String intitule, Patient patient, Medecin  medecin) {
		this.intitule = intitule;
        this.medecin = medecin;
        this.patient = patient;
        // this.date = date; 
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;    }

	public String getintitule() {
		return intitule;
	}

	public void setintitule(String intitule) {
		this.intitule = intitule;
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

	public void setMedecin( Medecin medecin) {
		this.medecin = medecin;
	}
}

