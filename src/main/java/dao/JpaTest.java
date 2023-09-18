package dao;

import java.sql.Timestamp;

import business.Medecin;
import business.Patient;
import business.RDV;
import business.intitule.Intitule;
import business.intitule.Urgence;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			PatientDAO Pdao = new PatientDAO();
			Patient p = new Patient();
			p.setName("Walid Abdou");
			Pdao.save(p);

			MedecinDAO Mdao = new MedecinDAO();
			Medecin m = new Medecin();
			m.setName("Paul POT");
			Mdao.save(m);

			RDVDAO rdao = new RDVDAO();
			RDV r = new RDV();
			r.setMedecin(m);
			r.setPatient(p);
			r.setTimestamp(Timestamp.valueOf("2000-09-08 22:00:00.000"));
			Urgence u = new Urgence();
			Intitule i = u;
			i.setName("C'est la merde");
			r.setintitule(i);
			rdao.save(r);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(".. done");
	}

}
