package tp3.taa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tp3.taa.business.Medecin;
import tp3.taa.business.MedecinDTO;
import tp3.taa.business.RDV;
import  tp3.taa.dao.MedecinDAO;

@RestController
@RequestMapping("/medecin")
public class MedecinResource {

  @Autowired
  MedecinDAO Mdao;

  @ResponseBody
  @GetMapping("/{medecinId}")
  public MedecinDTO getMedecinById(@PathVariable("medecinId") Long medecinId) {
    Medecin m = Mdao.getReferenceById(medecinId);

    return medecinIntoDto(m);
  }

  @RequestMapping("/")
  @ResponseBody
  public List<MedecinDTO> getmedecin() {

    List<Medecin> listP = Mdao.findAll();

    List<MedecinDTO> listDTO = new ArrayList<MedecinDTO>();

    for (Medecin p : listP) {
      listDTO.add(medecinIntoDto(p));
    }
    return listDTO;
  }

  @RequestMapping("/addMedecin")
  @ResponseBody
  public String addmedecin(Medecin medecin) {

    Mdao.save(medecin);

    return "medecin succesfully created with id = " + medecin.getId();
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