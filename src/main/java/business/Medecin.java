package tp3.taa.business;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Medecin implements Serializable {
	private String name;

	private Long id;

	private List<RDV> listRdv;

	public Medecin() {
	}

	public Medecin(String name) {
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

	@OneToMany(mappedBy = "medecin", cascade = CascadeType.PERSIST)
	public List<RDV> getListRDV() {
		return listRdv;
	}

	public void setListRDV(List<RDV> listRdv) {
		this.listRdv = listRdv;
	}

	@Override
	public String toString() {
		return "Medecin [id=" + id + ", name=" + name + "]";
	}

}
