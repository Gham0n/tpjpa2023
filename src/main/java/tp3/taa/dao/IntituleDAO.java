package tp3.taa.dao;

import tp3.taa.business.intitule.Intitule;

public class IntituleDAO extends JpaRepository<Intitule, Long> {

    public IntituleDAO() {
        super(Intitule.class);
    }

}
