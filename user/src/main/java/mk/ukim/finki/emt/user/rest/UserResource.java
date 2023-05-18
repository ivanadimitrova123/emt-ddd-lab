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
    public void createUser(@RequestBody UserForm user, HttpServletResponse response) throws IOException {
        userService.createUser(user);
        response.sendRedirect("/api/users");
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") UserId userId, @RequestBody UserForm user, HttpServletResponse response) throws IOException {
        userService.updateUser(userId, user);
        response.sendRedirect("/api/users");
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") UserId userId, HttpServletResponse response) throws IOException {
        userService.deleteUser(userId);
        response.sendRedirect("/api/users");
    }
}