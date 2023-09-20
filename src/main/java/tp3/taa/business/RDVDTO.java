package tp3.taa.business;

import java.io.Serializable;
import java.sql.Timestamp;

public class RDVDTO implements Serializable {
    private Long id;
    private Long intituleId;
    private Long patientId;
    private Long medecinId;
    private Timestamp timestamp;

    public RDVDTO() {
        super();
    }

    public RDVDTO(Long intitule, Long patientId, Long medecinId, Timestamp timestamp) {
        this.intituleId = intitule;
        this.patientId = patientId;
        this.medecinId = medecinId;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIntitule() {
        return intituleId;
    }

    public void setIntitule(Long intitule) {
        this.intituleId = intitule;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getMedecinId() {
        return medecinId;
    }

    public void setMedecinId(Long medecinId) {
        this.medecinId = medecinId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
