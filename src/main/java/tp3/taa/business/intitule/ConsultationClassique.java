package tp3.taa.business.intitule;

import jakarta.persistence.Entity;

@Entity
public class ConsultationClassique extends Intitule {

    public ConsultationClassique() {
    }

    public ConsultationClassique(String nom) {
        super();
        super.setName(nom);
    }

}
