package rest;

import java.util.ArrayList;
import java.util.List;

import business.Patient;
import business.PatientDTO;
import business.RDV;
import dao.PatientDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/patient")
@Produces({ "application/json" })
public class PatientResource {

  PatientDAO Pdao = new PatientDAO();

  @GET
  @Path("/{patientId}")
  public PatientDTO getPatientById(@PathParam("patientId") Long patientId) {
    
     Patient p = Pdao.findOne(patientId);

     return patientIntoDTO(p);
     
  }

  @GET
  @Path("/")
  public List<PatientDTO> getPatient() {

    List<Patient> listP = Pdao.findAll();

    List<PatientDTO> listDTO = new ArrayList<PatientDTO>();


    for (Patient p : listP){
      listDTO.add(patientIntoDTO(p));
    }
    return listDTO;
  }

  @POST
  @Path("/addPatient")
  @Consumes("application/json")
  public Response addPatient(
      Patient patient) {
    // add Patient

    Pdao.save(patient);

    return Response.ok().entity("SUCCESS").build();
  }

  public PatientDTO patientIntoDTO( Patient p){

    String name = p.getName();
    PatientDTO dto = new PatientDTO(name);
    
    Long i = p.getId();
    List<RDV> listRdv =  p.getListRDV();
    List<Long> rdvId =  new ArrayList<>();


    for (RDV rdv : listRdv){

      rdvId.add(rdv.getId());

    }
     dto.setListRDVid(rdvId);
     dto.setId(i);
     dto.getListRDVid();
    
    return dto ;
  }
}