package ma.eheio.gestion_location.controller;

import ma.eheio.gestion_location.models.Game;
import ma.eheio.gestion_location.services.GameService;
import ma.eheio.gestion_location.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private ModelService modelService;
    @GetMapping("/Game")
    public String getAll(Model model)
    {
        List<Game> games= gameService.getAll();
        model.addAttribute("games",games);
        return "ListeGame";
    }
    @GetMapping("/CreateGame")
    public String save(Model model)
    {
        List<ma.eheio.gestion_location.models.Model> models=modelService.getAll();
        model.addAttribute("models",models);

        return "CreateGame";
    }
    @PostMapping("/CreateGame")
    public String save(Game m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setCreatedDate(date);
        m.setLastModifiedDate(date);
        gameService.save(m);
        return "redirect:Game";
    }
    @GetMapping("/EditeGame")
    public String edite(Model model,int id)
    {
        Game Game = gameService.getById(id);
        List<ma.eheio.gestion_location.models.Model> models=modelService.getAll();
        model.addAttribute("models",models);
        model.addAttribute("Game",Game);
        return "EditeGame";
    }
    @PostMapping("/EditeGame")
    public String edite(Game m)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        m.setLastModifiedDate(date);
        gameService.update(m);
        return "redirect:Game";
    }
    @GetMapping("/DeleteGame")
    public String delete(int id)
    {
        gameService.delete(id);
        return "redirect:Game";
    }
}
