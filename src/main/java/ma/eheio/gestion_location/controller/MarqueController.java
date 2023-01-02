package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Marque;
import ma.eheio.gestion_location.repositories.MarqueRepository;
import ma.eheio.gestion_location.services.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MarqueController {
    @Autowired
    private MarqueService marqueService;
    @GetMapping("/Marque")
    public String getAll(Model model)
    {
        List<Marque> marques= marqueService.getAll();
        model.addAttribute("marques",marques);
        return "Marque";
    }
}
