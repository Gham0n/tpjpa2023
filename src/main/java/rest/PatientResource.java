package rest;

import java.util.List;

import org.hibernate.annotations.Parameter;

import business.Patient;
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
  public Patient getPatientById(@PathParam("patientId") Long patientId) {
    return Pdao.findOne(patientId);
  }

  @GET
  @Path("/")
  public List<Patient> getPatient() {

    return Pdao.findAll();
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
}