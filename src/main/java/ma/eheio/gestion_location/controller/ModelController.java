package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Categorie;
import ma.eheio.gestion_location.models.Marque;
import ma.eheio.gestion_location.models.Model;
import ma.eheio.gestion_location.services.CategorieService;
import ma.eheio.gestion_location.services.MarqueService;
import ma.eheio.gestion_location.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ModelController {
    @Autowired
    private ModelService  modelService;
    @Autowired
    private MarqueService marqueService;
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/Model")
    public String getAll(org.springframework.ui.Model mode)
    {
        List<Model> models= modelService.getAll();

        mode.addAttribute("models",models);


        return "ListeModel";
    }
    @GetMapping("/CreateModel")
    public String save(org.springframework.ui.Model mode)
    {
        List<Marque> marques=marqueService.getAll();
        List<Categorie> categories=categorieService.getAll();

        mode.addAttribute("marques",marques);
        mode.addAttribute("categories",categories);
        return "CreateModel";
    }
    @PostMapping("/CreateModel")
    public String save(Model c)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        c.setCreatedDate(date);
        c.setLastModifiedDate(date);
        modelService.save(c);
        return "redirect:Model";
    }
    @GetMapping("/EditeModel")
    public String edite(org.springframework.ui.Model mode, int id)
    {
        Model model = modelService.getById(id);
        List<Marque> marques=marqueService.getAll();
        List<Categorie> categories=categorieService.getAll();

        mode.addAttribute("model",model);
        mode.addAttribute("marques",marques);
        mode.addAttribute("categories",categories);

        return "EditeModel";
    }
    @PostMapping("/EditeModel")
    public String edite(Model c)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        c.setLastModifiedDate(date);
        modelService.update(c);
        return "redirect:Model";
    }
    @GetMapping("/DeleteModel")
    public String delete(int id)
    {
        modelService.delete(id);
        return "redirect:Model";
    }
}
