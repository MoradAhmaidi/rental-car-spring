package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Fournisseur;
import ma.eheio.gestion_location.models.Game;
import ma.eheio.gestion_location.models.Maintenance;
import ma.eheio.gestion_location.models.Voiture;
import ma.eheio.gestion_location.services.FournisseurService;
import ma.eheio.gestion_location.services.GameService;
import ma.eheio.gestion_location.services.MaintenanceService;
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
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenancService;
    @Autowired
    private VoitureService voitureService;
    @Autowired
    private FournisseurService fournisseurService;
    @GetMapping("/Maintenance")
    public String getAll(Model model)
    {
        List<Maintenance> maintenances= maintenancService.getAll();
        model.addAttribute("maintenances",maintenances);
        return "ListeMaintenance";
    }
    @GetMapping("/CreateMaintenance")
    public String save(Model model)
    {
        List<Voiture> voitures= voitureService.getAll();
        List<Fournisseur> fournisseurs= fournisseurService.getAll();
        model.addAttribute("voitures",voitures);
        model.addAttribute("fournisseurs",fournisseurs);
        return "CreateMaintenance";
    }
    @PostMapping("/CreateMaintenance")
    public String save(Maintenance m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setCreatedDate(date);
        m.setLastModifiedDate(date);
        maintenancService.save(m);
        return "redirect:Maintenance";
    }
    @GetMapping("/EditeMaintenance")
    public String edite(Model model,int id)
    {
        List<Voiture> voitures= voitureService.getAll();
        List<Fournisseur> fournisseurs= fournisseurService.getAll();
        model.addAttribute("voitures",voitures);
        model.addAttribute("fournisseurs",fournisseurs);
        return "EditeMaintenance";
    }
    @PostMapping("/EditeMaintenance")
    public String edite(Maintenance m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setLastModifiedDate(date);
        maintenancService.update(m);
        return "redirect:Maintenance";
    }
    @GetMapping("/DeleteMaintenance")
    public String delete(int id)
    {
        maintenancService.delete(id);
        return "redirect:Maintenance";
    }
}
