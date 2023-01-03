package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Categorie;
import ma.eheio.gestion_location.models.Fournisseur;
import ma.eheio.gestion_location.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;
    @GetMapping("/Fournisseur")
    public String getAll(Model model)
    {
        List<Fournisseur> fournisseurs= fournisseurService.getAll();
        model.addAttribute("fournisseurs",fournisseurs);
        return "ListeFournisseur";
    }
    @GetMapping("/CreateFournisseurs")
    public String save()
    {
        return "CreateFournisseurs";
    }
    @PostMapping("/CreateFournisseurs")
    public String save(Fournisseur f)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        f.setCreatedDate(date);
        f.setLastModifiedDate(date);
        fournisseurService.save(f);
        return "redirect:ListeFournisseur";
    }
    @GetMapping("/EditeFournisseur")
    public String edite(Model model,int id)
    {
        Fournisseur fournisseur = fournisseurService.getById(id);
        model.addAttribute("fournisseur",fournisseur);
        return "editeFournisseur";
    }
    @PostMapping("/EditeFournisseur")
    public String edite(Fournisseur f)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        f.setLastModifiedDate(date);
        fournisseurService.save(f);
        return "redirect:ListeFournisseur";
    }

}
