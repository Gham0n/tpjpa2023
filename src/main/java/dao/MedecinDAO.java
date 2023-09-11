package dao;
import business.Medecin;

public class MedecinDAO extends AbstractJpaDao<Long, Medecin> {
    
    public MedecinDAO(){
        super(Medecin.class);
    }

}
