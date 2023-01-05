package ma.eheio.gestion_location;

import ma.eheio.gestion_location.models.Utilisateur;
import ma.eheio.gestion_location.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ApplicationController {
    @Autowired
    private UtilisateurService utilisateurService;
    @GetMapping("/")
    public String goIndex()
    {
        return "redirect:index";
    }
    @GetMapping("/index")
    public String goHome(Model model, HttpSession httpSession)
    {
        System.out.println("index");
        if(httpSession.getAttribute("login")!=null && httpSession.getAttribute("password")!=null )
        {
            Utilisateur utilisateur=utilisateurService.login(httpSession.getAttribute("login").toString()
                    ,httpSession.getAttribute("password").toString());
            model.addAttribute("user",utilisateur);
            System.out.println("index sucss");
            return "index";
        }
        System.out.println("index fild");
        return "redirect:login";
    }
    @GetMapping("/login")
    public String gologin()
    {
        System.out.println("login Get");
        return "Login";
    }
    @PostMapping("/login")
    public String gologin(@RequestParam("login") String login, @RequestParam("password") String password, HttpSession httpSession)
    {
        System.out.println("login post");
       Utilisateur utilisateur= utilisateurService.login(login,password);
       if (utilisateur!=null)
       {
           httpSession.setAttribute("login",utilisateur.getLogin());
           httpSession.setAttribute("password",utilisateur.getMotDePass());
           return "redirect:index";
       }
        return "Login";
    }
    @GetMapping("/logout")
    public String gologout(HttpSession httpSession)
    {
        httpSession.invalidate();
        return "login";
    }

}
