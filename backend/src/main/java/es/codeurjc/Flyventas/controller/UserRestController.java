package es.codeurjc.Flyventas.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.UserRepository;

import es.codeurjc.Flyventas.security.jwt.UserLoginService;
import es.codeurjc.Flyventas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userService;

    @Autowired
    private UserLoginService userLoginService;


    @GetMapping("/{id}")
    public ResponseEntity<User> getProfile(@PathVariable long id) {

        User user = userService.findUserById(id).orElseThrow();

        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editProfile(@PathVariable long id, @RequestBody User updatedUser) throws SQLException {

        //User user = userService.findUserById(id).orElseThrow();

        if (userService.exist(id)) {

            User user = userService.findUserById(id).orElseThrow();
            userService.save(updatedUser);

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createProfile(@RequestBody User user) {

        userService.save(user);

        return user;
    }

    @GetMapping("/me")
    public ResponseEntity<User> me(HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        if(principal != null) {
            return ResponseEntity.ok(userRepository.findUserByEmail(principal.getName()).orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProfile(@PathVariable long id) {

        try {
            userService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllUsers() {

        List<User> users = userService.findAll();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
