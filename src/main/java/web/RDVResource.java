package tp3.taa.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import tp3.taa.business.RDV;
import tp3.taa.business.RDVDTO;
import tp3.taa.dao.RDVDAO;

@Controller
public class RDVResource {

  @Autowired
  RDVDAO Rdao;

  @RequestMapping("/rdv")
  @ResponseBody
  public RDVDTO getRdvById(@PathParam("rdvId") Long rdvId) {

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

  @RequestMapping("/addrdv")
  @ResponseBody
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