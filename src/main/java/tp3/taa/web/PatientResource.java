package tp3.taa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tp3.taa.business.Patient;
import tp3.taa.business.PatientDTO;
import tp3.taa.business.RDV;
import tp3.taa.dao.PatientDAO;

@RestController
@RequestMapping("/patient")
public class PatientResource {

  @Autowired
  PatientDAO Pdao;

  @RequestMapping("/{patientId}")
  @ResponseBody
  public PatientDTO getPatientById(@PathVariable("patientId") Long patientId) {

    Patient p = Pdao.getReferenceById(patientId);

    return patientIntoDTO(p);

  }

  @RequestMapping("/")
  @ResponseBody
  public List<PatientDTO> getPatient() {

    List<Patient> listP = Pdao.findAll();

    List<PatientDTO> listDTO = new ArrayList<PatientDTO>();

    for (Patient p : listP) {
      listDTO.add(patientIntoDTO(p));
    }
    return listDTO;
  }

  @RequestMapping("/addPatient")
  @ResponseBody
  public String addPatient(Patient patient) {

    Pdao.save(patient);

    return "User succesfully created with id = " + patient.getId();
  }

  public PatientDTO patientIntoDTO(Patient p) {

    String name = p.getName();
    PatientDTO dto = new PatientDTO(name);

    Long i = p.getId();
    List<RDV> listRdv = p.getListRDV();
    List<Long> rdvId = new ArrayList<>();

    for (RDV rdv : listRdv) {

      rdvId.add(rdv.getId());

    }
    dto.setListRDVid(rdvId);
    dto.setId(i);
    dto.getListRDVid();

    return dto;
  }

}