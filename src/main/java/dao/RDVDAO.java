package dao;
import business.RDV;

public class RDVDAO extends AbstractJpaDao<Long, RDV> {
    
    public RDVDAO(){
        super(RDV.class);
    }

}
