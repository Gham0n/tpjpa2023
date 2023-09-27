package tp3.taa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tp3.taa.business.MedecinDTO;
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

  @PostMapping("/addPatient")
  @ResponseBody
  public String addPatient(@RequestBody PatientDTO patient ) {
    String patientId = "";
    try {
      Patient p = new Patient(patient.getName());
      Pdao.save(p);

      patientId = String.valueOf(p.getId());

    } catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }

    return "Patient succesfully created with id = " + patientId;
  }

  @RequestMapping("/delete/{patientId}")
  @ResponseBody
  public String deletePatientById(@PathVariable("patientId") Long patientId) {
    String name = Pdao.getReferenceById(patientId).getName();
    try {

      Pdao.deleteById(patientId);

    } catch (Exception ex) {

      return "Error deleting the user:" + ex.toString();

    }
    return "Patient" + name + "succesfully deleted!";
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