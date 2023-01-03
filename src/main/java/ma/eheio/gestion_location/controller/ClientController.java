package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Categorie;
import ma.eheio.gestion_location.models.Client;
import ma.eheio.gestion_location.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        return "ListeClient";
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
        return "redirect:ListeClient";
    }

    @GetMapping("/EditeClient")
    public String edite(Model model,int id)
    {
        Client client = clientService.getById(id);
        model.addAttribute("Client",client);
        return "editeClient";
    }
    @PostMapping("/EditeClient")
    public String edite(Client c)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        c.setLastModifiedDate(date);
        clientService.save(c);
        return "redirect:ListeClient";
    }
}
