package es.codeurjc.Flyventas.controller;
import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@Controller
public class FlyventasErrorController implements ErrorController {

    @Autowired
    private UserServices userServices;

    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if(principal != null) {
            Optional<User> currentuser = userServices.findUserByEmail(principal.getName());
            model.addAttribute("id", currentuser.get().getId());
            model.addAttribute("logged", true);
            model.addAttribute("username", principal.getName());
            model.addAttribute("admin", request.isUserInRole("ADMIN"));
        } else {
            model.addAttribute("logged", false);
        }
    }


    @RequestMapping("/error")
    public String handleError() {
        return "errorpage";
    }
}