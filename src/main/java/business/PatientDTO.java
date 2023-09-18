package business;

import java.io.Serializable;
import java.util.List;

public class PatientDTO implements Serializable {
	private Long id;

	private String name;

	private List<Long> listRdvId;

	public PatientDTO() {
	}

	public PatientDTO(String name) {
		this.name = name;
	}

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

	public List<Long> getListRDVid() {
		return listRdvId;
	}

	public void setListRDVid(List<Long> listRdvId) {
		this.listRdvId = listRdvId;
	}


}