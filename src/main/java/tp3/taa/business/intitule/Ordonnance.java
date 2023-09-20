package tp3.taa.business.intitule;

import jakarta.persistence.Entity;

@Entity
public class Ordonnance extends Intitule{

    public Ordonnance() {}

    public Ordonnance(String nom) {
        super();
        super.setName(nom);
    }
    
}
