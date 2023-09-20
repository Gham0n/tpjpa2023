package tp3.taa.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tp3.taa.business.Medecin;
import tp3.taa.business.Patient;
import tp3.taa.business.RDV;
import tp3.taa.business.RDVDTO;
import tp3.taa.business.intitule.ConsultationClassique;
import tp3.taa.business.intitule.Intitule;
import tp3.taa.business.intitule.Ordonnance;
import tp3.taa.business.intitule.Urgence;
import tp3.taa.dao.IntituleDAO;
import tp3.taa.dao.MedecinDAO;
import tp3.taa.dao.PatientDAO;
import tp3.taa.dao.RDVDAO;

@RestController
@RequestMapping("/rdv")
public class RDVResource {

  @Autowired
  RDVDAO Rdao;

  @Autowired
  PatientDAO Pdao;

  @Autowired
  MedecinDAO Mdao;

  @Autowired
  IntituleDAO Idao;

  @RequestMapping("/{rdvId}")
  @ResponseBody
  public RDVDTO getRdvById(@PathVariable("rdvId") Long rdvId) {

    RDV r = Rdao.getReferenceById(rdvId);

    return rdvIntoDto(r);
  }

  @RequestMapping("/")
  @ResponseBody
  public List<RDVDTO> getRDV() {

    List<RDV> listRdv = Rdao.findAll();
    List<RDVDTO> listRdvdto = new ArrayList<RDVDTO>();

    for (RDV r : listRdv) {
      listRdvdto.add(rdvIntoDto(r));
    }
    return listRdvdto;
  }

  @PostMapping("/addrdv")
  @ResponseBody
  public String addRDV(@RequestBody RDVDTO rdto) {
    String rdvidString = "";
    try {

      Patient p = Pdao.getReferenceById(rdto.getPatientId());
      Medecin m = Mdao.getReferenceById(rdto.getMedecinId());
      Intitule i = Idao.getReferenceById(rdto.getIntitule());
      Timestamp t = rdto.getTimestamp();

      RDV rdv = new RDV();
      rdv.setPatient(p);
      rdv.setMedecin(m);
      rdv.setintitule(i);
      rdv.setTimestamp(t);

      rdvidString = String.valueOf(rdv.getId());
      

      Rdao.save(rdv);

    } catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }

    return "RDV succesfully created with id = " + rdvidString;
  }

  public RDVDTO rdvIntoDto(RDV r) {
    Long i = r.getintitule().getId();
    Long p = r.getPatient().getId();
    Long m = r.getMedecin().getId();

    Timestamp t = r.getTimestamp();

    RDVDTO dto = new RDVDTO(i, p, m, t);
    dto.setId(r.getId());
    return dto;

  }

  @PostMapping("/intitule")
  @ResponseBody
  public String addInt() {

    try {

      Intitule u = new Urgence("J'ai mal");
      Intitule o = new Ordonnance("Certificat medical");
      Intitule c = new ConsultationClassique("Mal à la gorge");

      Idao.save(u);
      // Idao.save(o);
      // Idao.save(c);

    } catch (

    Exception ex) {
      return "Error creating the intitule: " + ex.toString();
    }

    return "Intitule created successfully";
  }

}