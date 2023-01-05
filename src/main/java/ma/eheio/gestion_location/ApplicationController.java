package ma.eheio.gestion_location;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping("/index")

    {
<<<<<<< .mine        if(httpSession.getAttribute("login")!=null && httpSession.getAttribute("password")!=null )
        {
            return "index";
        }
        return "redirect:login";
=======        return "index";
>>>>>>> .theirs    }
<<<<<<< .mine    @GetMapping("/login")
    public String gologin()
    {
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
=======>>>>>>> .theirs
}
