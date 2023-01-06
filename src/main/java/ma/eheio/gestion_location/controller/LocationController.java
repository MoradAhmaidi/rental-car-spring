package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Client;
import ma.eheio.gestion_location.models.Location;
import ma.eheio.gestion_location.models.Voiture;
import ma.eheio.gestion_location.services.LocationService;
import ma.eheio.gestion_location.services.ClientService;
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
public class LocationController {
    @Autowired
    private LocationService locationService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private VoitureService voitureService;
    @GetMapping("/Location")
    public String getAll(Model model)
    {
        List<Location> locations= locationService.getAll();
        model.addAttribute("locations",locations);
        return "ListeLocation";
    }
    @GetMapping("/CreateLocation")
    public String save(Model model)
    {
        List<Client> clients=clientService.getAll();
        List<Voiture> voitures=voitureService.getAll();
        model.addAttribute("voitures",voitures);
        model.addAttribute("clients",clients);

        return "CreateLocation";
    }
    @PostMapping("/CreateLocation")
    public String save(Location l)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        l.setCreatedDate(date);
        l.setLastModifiedDate(date);
        locationService.save(l);
        return "redirect:Location";
    }
    @GetMapping("/EditeLocation")
    public String edite(Model model,int id)
    {
        Location location = locationService.getById(id);
        List<Client> clients=clientService.getAll();
        List<Voiture> voitures=voitureService.getAll();
        model.addAttribute("voitures",voitures);
        model.addAttribute("clients",clients);
        model.addAttribute("location",location);
        return "EditeLocation";
    }
    @PostMapping("/EditeLocation")
    public String edite(Location m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setLastModifiedDate(date);
        locationService.update(m);
        return "redirect:Location";
    }
    @GetMapping("/DeleteLocation")
    public String delete(int id)
    {
        locationService.delete(id);
        return "redirect:Location";
    }
}
