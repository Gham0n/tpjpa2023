package business.intitule;

import jakarta.persistence.Entity;

@Entity
public class Urgence extends Intitule {
    

    public Urgence() {}

    public Urgence(String nom) {
        super();
        super.setName(nom);
    }

}
