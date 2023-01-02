package ma.eheio.gestion_location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilisateurController {
    @GetMapping("/Utilisateur")
    public String getAll()
    {
        return "Utilisateur";
    }
}
