package rest;

import java.util.List;

import business.Medecin;
import dao.MedecinDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/medecin")
@Produces({ "application/json" })
public class MedecinResource {

  MedecinDAO Mdao = new MedecinDAO();

  @GET
  @Path("/{medecinId}")
  public Medecin getMedecinById(@PathParam("medecinId") Long medecinId) {
    return Mdao.findOne(medecinId);
  }

  @GET
  @Path("/")
  public List<Medecin> getMedecin() {

    return Mdao.findAll();
  }

  @POST
  @Path("/addMedecin")
  @Consumes("application/json")
  public Response addMedecin(
      Medecin medecin) {
    // add Medecin

    Mdao.save(medecin);

    return Response.ok().entity("SUCCESS").build();
  }
}