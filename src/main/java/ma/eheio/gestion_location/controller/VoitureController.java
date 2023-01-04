package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Game;
import ma.eheio.gestion_location.models.Voiture;
import ma.eheio.gestion_location.services.GameService;
import ma.eheio.gestion_location.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class VoitureController {
    @Autowired
    private VoitureService voitureService;
    @Autowired
    private GameService gameService;
    @GetMapping("/Voiture")
    public String getAll(Model model)
    {
        List<Voiture> voitures= voitureService.getAll();
        model.addAttribute("voitures",voitures);
        return "ListeVoiture";
    }
    @GetMapping("/CreateVoiture")
    public String save(Model model)
    {
        List<Game> games= gameService.getAll();
        model.addAttribute("games",games);
        return "CreateVoiture";
    }
    @PostMapping("/CreateVoiture")
    public String save(Voiture m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setCreatedDate(date);
        m.setLastModifiedDate(date);
        voitureService.save(m);
        return "redirect:Voiture";
    }
    @GetMapping("/EditeVoiture")
    public String edite(Model model,int id)
    {
        Voiture voiture = voitureService.getById(id);
        List<Game> games= gameService.getAll();
        model.addAttribute("games",games);
        model.addAttribute("voiture",voiture);
        return "EditeVoiture";
    }
    @PostMapping("/EditeVoiture")
    public String edite(Voiture m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setLastModifiedDate(date);
        voitureService.update(m);
        return "redirect:Voiture";
    }
    @GetMapping("/DeleteVoiture")
    public String delete(int id)
    {
        voitureService.delete(id);
        return "redirect:Voiture";
    }
}
