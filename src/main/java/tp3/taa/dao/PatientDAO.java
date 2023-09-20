package tp3.taa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp3.taa.business.Patient;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Long> {

}
