package tp3.taa.dao;

import java.sql.Timestamp;

import tp3.taa.business.Medecin;
import tp3.taa.business.Patient;
import tp3.taa.business.RDV;
import tp3.taa.business.intitule.Intitule;
import tp3.taa.business.intitule.Urgence;

public class test {

    public static void main(String[] args) {

        PatientDAO Pdao;
        Patient p = new Patient();
        p.setName("Walid Abdou");
        Pdao.save(p);

        MedecinDAO Mdao;
        Medecin m = new Medecin();
        m.setName("Paul POT");
        Mdao.save(m);

        RDVDAO rdao;
        RDV r = new RDV();
        r.setMedecin(m);
        r.setPatient(p);
        r.setTimestamp(Timestamp.valueOf("2000-09-08 22:00:00.000"));
        Urgence u = new Urgence();
        Intitule i = u;
        i.setName("C'est la merde");
        r.setintitule(i);
        rdao.save(r);

        System.out.println(".. done");

    }

}
