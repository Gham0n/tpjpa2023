package dao;
import business.Patient;

public class PatientDAO extends AbstractJpaDao<Long, Patient> {
    
    public PatientDAO(){
        super(Patient.class);
    }

}
