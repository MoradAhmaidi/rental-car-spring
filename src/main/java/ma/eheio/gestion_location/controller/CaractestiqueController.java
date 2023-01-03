package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Caracteristique;
import ma.eheio.gestion_location.services.CaracteristiquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CaractestiqueController {
    @Autowired
    private CaracteristiquesService caracteristiquesService;

    @GetMapping("/Option")
    public String getAll(Model model, @RequestParam(name = "page",defaultValue = "0")int p,@RequestParam(name = "size",defaultValue = "20")int s)
    {
        Page<Caracteristique> caractestiques= caracteristiquesService.getAll(p,s);
        int [] pages=new int[caractestiques.getTotalPages()];
        model.addAttribute("options",caractestiques);
        model.addAttribute("pages",pages);
        model.addAttribute("size",s);

        return "ListeOption";
    }
    @GetMapping("/CreateOption")
    public String save()
    {
        return "CreateOption";
    }
    @PostMapping("/CreateOption")
    public String save(Caracteristique c)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        c.setCreatedDate(date);
        c.setLastModifiedDate(date);
        caracteristiquesService.save(c);
        return "redirect:ListeOption";
    }
    @GetMapping("/EditeOption")
    public String edite(Model model,int id)
    {
        Caracteristique categorie = caracteristiquesService.getById(id);
        model.addAttribute("option",categorie);
        return "editeOption";
    }
    @PostMapping("/EditeOption")
    public String edite(Caracteristique c)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        c.setLastModifiedDate(date);
        caracteristiquesService.update(c);
        return "redirect:ListeOption";
    }


}
