package mk.ukim.finki.emt.user.rest;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.user.domain.model.User;
import mk.ukim.finki.emt.user.domain.model.UserId;
import mk.ukim.finki.emt.user.services.IUserService;
import mk.ukim.finki.emt.user.services.forms.UserForm;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserResource {
    private final IUserService userService;

    @GetMapping
    public List<User> listAll() {
        return userService.listAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") UserId id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserForm client, HttpServletResponse response) throws IOException {
        userService.createClient(client);
        response.sendRedirect("/api/users");
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") UserId clientId, @RequestBody UserForm client, HttpServletResponse response) throws IOException {
        userService.updateClient(clientId, client);
        response.sendRedirect("/api/users");
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") UserId clientId, HttpServletResponse response) throws IOException {
        userService.deleteClient(clientId);
        response.sendRedirect("/api/users");
    }
}