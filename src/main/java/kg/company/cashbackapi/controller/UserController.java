package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.User;
import kg.company.cashbackapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) throws Exception {
        return userService.findById(id);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public User putUser(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
        return userService.putById(id, user);
    }

    @PostMapping()
    public User postUser(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }

}
