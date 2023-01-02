package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Categorie;
import ma.eheio.gestion_location.models.Marque;
import ma.eheio.gestion_location.repositories.CategorieRepository;
import ma.eheio.gestion_location.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/Categorie")
    public String getAll(Model model)
    {
        List<Categorie> categories= categorieService.getAll();
        model.addAttribute("categories",categories);
        return "Categorie";
    }
    @GetMapping("/CreateCategorie")
    public String save()
    {
        return "CreateCategorie";
    }
    @PostMapping("/CreateCategorie")
    public String save(Categorie c)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        c.setCreatedDate(date);
        c.setLastModifiedDate(date);
        categorieService.save(c);
        return "redirect:Categorie";
    }

}
