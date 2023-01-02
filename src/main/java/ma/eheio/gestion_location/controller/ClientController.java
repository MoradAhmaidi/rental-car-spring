package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Categorie;
import ma.eheio.gestion_location.models.Client;
import ma.eheio.gestion_location.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/Client")
    public String getAll(Model model)
    {
        List<Client> clients= clientService.getAll();
        model.addAttribute("clients",clients);
        return "Client";
    }
    @GetMapping("/CreateClient")
    public String save()
    {
        return "CreateClient";
    }
    @PostMapping("/CreateClient")
    public String save(Client c)
    {
        clientService.save(c);
        return "redirect:Client";
    }
}
