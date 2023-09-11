package rest;

import org.hibernate.annotations.Parameter;

import business.Patient;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/patient")
@Produces({"application/json"})
public class PatientResource {

  @GET
  @Path("/{patientId}")
  public Patient getPatientById(@PathParam("PatientId") Long patientId)  {
      System.out.println("9A MARCHE !!!");
      return new Patient();
  }

  
  @POST
  @Consumes("application/json")
  public Response addPatient(
      Patient patient) {
    // add Patient
    return Response.ok().entity("SUCCESS").build();
  }
}