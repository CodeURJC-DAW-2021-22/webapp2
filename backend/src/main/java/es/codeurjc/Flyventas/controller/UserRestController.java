package es.codeurjc.Flyventas.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.UserRepository;
import es.codeurjc.Flyventas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getProfile(@PathVariable long id) {

        User user = userService.findUserById(id).orElseThrow();

        if(user != null) {
            return ResponseEntity.ok(userRepository.findById(id).orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}