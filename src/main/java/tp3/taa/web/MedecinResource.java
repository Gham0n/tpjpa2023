package tp3.taa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tp3.taa.business.Medecin;
import tp3.taa.business.MedecinDTO;
import tp3.taa.business.Medecin;
import tp3.taa.business.RDV;
import tp3.taa.dao.MedecinDAO;

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

  @PostMapping("/addMedecin")
  @ResponseBody
  public String addMedecin(@RequestBody MedecinDTO med) {
    String MedecinId = "";
    try {
      Medecin p = new Medecin(med.getName());
      Mdao.save(p);
      MedecinId = String.valueOf(p.getId());
    } catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }

    return "Medecin succesfully created with id = " + MedecinId;
  }

  @GetMapping("/delete/{medecinId}")
  @ResponseBody
  public String deleteMedecinById(@PathVariable("medecinId") Long medecinId) {
    String name = Mdao.getReferenceById(medecinId).getName();
    try {

      Mdao.deleteById(medecinId);

    } catch (Exception ex) {

      return "Error deleting the user:" + ex.toString();

    }
    return "Medecin " + name + " succesfully deleted!";
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