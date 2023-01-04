package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Fournisseur;
import ma.eheio.gestion_location.models.Utilisateur;
import ma.eheio.gestion_location.services.FournisseurService;
import ma.eheio.gestion_location.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/Utilisateur")
    public String getAll(Model model) {
        List<Utilisateur> utilisateurs = utilisateurService.getAll();
        model.addAttribute("utilisateurs", utilisateurs);
        return "ListeUtilisateur";
    }

    @GetMapping("/CreateUtilisateur")
    public String save() {
        return "CreateUtilisateur";
    }

    @PostMapping("/CreateUtilisateur")
    public String save(Utilisateur u) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        u.setCreatedDate(date);
        u.setLastModifiedDate(date);
        utilisateurService.save(u);
        return "redirect:Utilisateur";
    }

    @GetMapping("/EditeUtilisateur")
    public String edite(Model model, int id) {
        Utilisateur utilisateur = utilisateurService.getById(id);
        model.addAttribute("utilisateur", utilisateur);
        return "editeUtilisateur";
    }

    @PostMapping("/EditeUtilisateur")
    public String edite(Utilisateur u) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        u.setLastModifiedDate(date);
        utilisateurService.save(u);
        return "redirect:Utilisateur";
    }
    @GetMapping("/DeleteUtilisateur")
    public String delete(int id)
    {
        utilisateurService.delete(id);
        return "redirect:Utilisateur";
    }
}
