package dao;
import business.RDV;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public class RDVDAO extends JpaRepository<RDV, Long> {
    
    public RDVDAO(){
        super(RDV.class);
    }

}
