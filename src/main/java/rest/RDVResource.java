package rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import business.RDVDTO;
import business.IntituleDTO;
import business.RDV;
import dao.RDVDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/rdv")
@Produces({ "application/json" })
public class RDVResource {

  RDVDAO Rdao = new RDVDAO();

  @GET
  @Path("/{rdvId}")
  public RDVDTO getPatientById(@PathParam("rdvId") Long rdvId) {

    RDV r = Rdao.findOne(rdvId);

    return rdvIntoDto(r);
  }

  @GET
  @Path("/")
  public List<RDVDTO> getRDV() {

    List<RDV> listRdv = Rdao.findAll();

    List<RDVDTO> listRdvdto = new ArrayList<RDVDTO>();

    for (RDV r : listRdv) {

      listRdvdto.add(rdvIntoDto(r));

    }

    return listRdvdto;
  }

  @POST
  @Path("/addPatient")
  @Consumes("application/json")
  public Response addRDV(
      RDV rdv) {

    Rdao.save(rdv);

    return Response.ok().entity("SUCCESS").build();
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

}