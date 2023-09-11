package dao;
import java.sql.Timestamp;
import java.util.List;

import business.Medecin;
import business.Patient;
import business.RDV;
import business.intitule.ConsultationClassique;
import business.intitule.Intitule;
import business.intitule.Ordonnance;
import business.intitule.Urgence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {
	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			//  test.createPatient();
			// test.createMedecin();
			// test.createRDV();

			test.createPatientDAO();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listPatient();
		test.listMedecin();
		test.listRDV();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

	private void createPatientDAO(){
			PatientDAO Pdao = new PatientDAO();
			Patient p = new Patient("Patrick");
			Pdao.save(p);

	}
	private void createPatient() {
		int numOfPatients = manager.createQuery("Select a From Patient a", Patient.class).getResultList().size();
		if (numOfPatients == 0) {	
			manager.persist(new Patient("Jakab Gipsz"));
			manager.persist(new Patient("Captain Nemo"));
		}
	}
	private void listPatient() {
		List<Patient> resultList = manager.createQuery("Select a From Patient a", Patient.class).getResultList();
		System.out.println("num of patients:" + resultList.size());
		for (Patient next : resultList) {
			System.out.println("next Patient: " + next);
		}
	}

	private void createMedecin() {
		int numOfMedecins = manager.createQuery("Select a From Medecin a", Medecin.class).getResultList().size();
		if (numOfMedecins == 0) {	
			manager.persist(new Medecin("Jean Neige"));
			manager.persist(new Medecin("John Snow"));
		}
	}
	private void listMedecin() {
		List<Medecin> resultList = manager.createQuery("Select a From Medecin a", Medecin.class).getResultList();
		System.out.println("num of medecins:" + resultList.size());
		for (Medecin next : resultList) {
			System.out.println("next Medecin: " + next);
		}
	}

	private void createRDV() {
		int numOfRDV = manager.createQuery("Select a From RDV a", RDV.class).getResultList().size();
		List<Medecin> listMedecin = manager.createQuery("Select a From Medecin a", Medecin.class).getResultList();
		List<Patient>  listPatient = manager.createQuery("Select a From Patient a", Patient.class).getResultList();

		manager.persist(new Urgence("Cas d'urgence"));
        manager.persist(new Ordonnance("Prescription médicale"));
        manager.persist(new ConsultationClassique("Rendez-vous de consultation"));

		List<Intitule> listIntitules = manager.createQuery("Select a From Intitule a", Intitule.class).getResultList();

		if (numOfRDV == 0) {		
			manager.persist(new RDV(listIntitules.get(0), listPatient.get(0), listMedecin.get(0), Timestamp.valueOf("2017-11-15 15:30:14.332")));
			manager.persist(new RDV(listIntitules.get(1), listPatient.get(1), listMedecin.get(1), Timestamp.valueOf("2023-08-09 15:30:14.332")));
		}
	}
	private void listRDV() {
		List<RDV> resultList = manager.createQuery("Select a From RDV a", RDV.class).getResultList();
		System.out.println("num of RDVs:" + resultList.size());
		for (RDV next : resultList) {
			System.out.println("next RDV: " + next.getintitule().getClass().getName() + ", Patient : " + next.getPatient().getName() + ", Medecin : " + next.getMedecin().getName());
		}
	}
}
