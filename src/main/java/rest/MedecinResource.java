package rest;

import java.util.ArrayList;
import java.util.List;

import business.Medecin;
import business.MedecinDTO;
import business.RDV;
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
  public MedecinDTO getMedecinById(@PathParam("medecinId") Long medecinId) {
    Medecin m = Mdao.findOne(medecinId);

    return medecinIntoDto(m);
  }

  @GET
  @Path("/")
  public List<MedecinDTO> getMedecin() {

    List<Medecin> listMedecin = Mdao.findAll();
    List<MedecinDTO> listMedecinDTO = new ArrayList<MedecinDTO>();

    for (Medecin m : listMedecin) {
      listMedecinDTO.add(medecinIntoDto(m));
    }

    return listMedecinDTO;

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

  public MedecinDTO medecinIntoDto(Medecin m) {

    MedecinDTO dto = new MedecinDTO(m.getName());
    dto.setId(m.getId());
    List<RDV> listRdv = m.getListRDV();
    List<Long> rdvIds = new ArrayList<>();

    for (RDV r : listRdv) {
      rdvIds.add(r.getId());

    }
    dto.setListRDV(rdvIds);

    return dto;

  }

}