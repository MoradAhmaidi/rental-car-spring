package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Caracteristique;
import ma.eheio.gestion_location.models.Marque;
import ma.eheio.gestion_location.services.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        return "ListeMarque";
    }
    @GetMapping("/CreateMarque")
    public String save()
    {
        return "CreateMarque";
    }
    @PostMapping("/CreateMarque")
    public String save(Marque m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setCreatedDate(date);
        m.setLastModifiedDate(date);
        marqueService.save(m);
        return "redirect:ListeMarque";
    }
    @GetMapping("/EditeMarque")
    public String edite(Model model,int id)
    {
        Marque marque = marqueService.getById(id);
        model.addAttribute("marque",marque);
        return "editeMarque";
    }
    @PostMapping("/EditeMarque")
    public String edite(Marque m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setLastModifiedDate(date);
        marqueService.update(m);
        return "redirect:ListeMarque";
    }
}
