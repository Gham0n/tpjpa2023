package tp3.taa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tp3.taa.business.Patient;

public interface PatientDAO extends JpaRepository<Patient, Long> {

}
