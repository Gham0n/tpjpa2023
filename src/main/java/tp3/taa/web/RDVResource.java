package tp3.taa.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tp3.taa.business.RDV;
import tp3.taa.business.RDVDTO;
import tp3.taa.dao.RDVDAO;

@RestController
@RequestMapping("/rdv")
public class RDVResource {

  @Autowired
  RDVDAO Rdao;

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

  @RequestMapping("/addrdv")
  @ResponseBody
  public String addRDV(RDV rdv) {

    Rdao.save(rdv);

    return "Rdv succesfully created with id = " + medecin.getId();
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