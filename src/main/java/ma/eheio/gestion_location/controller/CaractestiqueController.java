package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Caractestique;
import ma.eheio.gestion_location.services.CaractestiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CaractestiqueController {
    @Autowired
    private CaractestiqueService caractestiqueService;

    @GetMapping("/Option")
    public String getAll(Model model, @RequestParam(name = "page",defaultValue = "0")int p,@RequestParam(name = "size",defaultValue = "20")int s)
    {
        Page<Caractestique> caractestiques=caractestiqueService.getAll(p,s);
        int [] pages=new int[caractestiques.getTotalPages()];
        model.addAttribute("caractestiques",caractestiques);
        model.addAttribute("pages",pages);
        model.addAttribute("size",s);

        return "Option";
    }
    @GetMapping("/CreateOption")
    public String save()
    {
        return "CreateOption";
    }
    @PostMapping("/CreateOption")
    public String save(Caractestique c)
    {
        caractestiqueService.save(c);
        return "redirect:Option";
    }


}
