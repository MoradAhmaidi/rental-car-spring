package ma.eheio.gestion_location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FournisseurController {
    @GetMapping("/Fournisseur")
    public String getAll() {
        return "Fournisseur";
    }
}
