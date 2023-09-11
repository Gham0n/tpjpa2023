package business;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient implements Serializable{
    private Long id;

	private String name;

    private List<RDV> listRdv;

	public Patient() {
	}

	public Patient(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
	public List<RDV> getListRDV() {
		return listRdv;
	}

    public void setListRDV(List<RDV> listRdv){
        this.listRdv = listRdv;
    }

    // public void addRDV(RDV rdv){
    //     listRdv.add(rdv);
    //     Medecin.addRDV(rdv);
    // }

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + "]";
	}

}