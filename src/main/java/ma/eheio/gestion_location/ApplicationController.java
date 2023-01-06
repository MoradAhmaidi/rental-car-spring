package ma.eheio.gestion_location;

import ma.eheio.gestion_location.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApplicationController {

    @Autowired
    private StatistiqueService statistiqueService;
    @GetMapping("/")
    public String index()
    {
        return "redirect:index";
    }
    @GetMapping("/index")
    public String goHome(Model model)
    {

        model.addAttribute("voiture",statistiqueService.getVoiture());
        model.addAttribute("client",statistiqueService.getClient());
        model.addAttribute("fournisseur",statistiqueService.getFournisseur());
        model.addAttribute("location",statistiqueService.getLocation());
        model.addAttribute("reservation",statistiqueService.getReservation());

        return "index";
    }

}
