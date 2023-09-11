package dao;

import business.intitule.Intitule;

public class IntituleDAO  extends AbstractJpaDao<Long, Intitule>{

    public IntituleDAO(){
        super(Intitule.class);
    }
    
}
