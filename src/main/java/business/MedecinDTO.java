package business;

import java.io.Serializable;
import java.util.List;

public class MedecinDTO implements Serializable {
    private String name;

    private Long id;

    private List<Long> listRdv;

    public MedecinDTO() {
    }

    public MedecinDTO(String name) {
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

    public List<Long> getListRDV() {
        return listRdv;
    }

    public void setListRDV(List<Long> listRdv) {
        this.listRdv = listRdv;
    }

    public String toString() {
        return "Medecin [id=" + id + ", name=" + name + "]";
    }

}
