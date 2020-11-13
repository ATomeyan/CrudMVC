package com.bdg.crudmvc.controller;

import com.bdg.crudmvc.model.User;
import com.bdg.crudmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userLists", userList);

        return "index";
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);

        return "redirect:/";
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping(path = "/updateUser/{id}", method = RequestMethod.POST)
    public String updateUser(User user) {
        userService.updateUser(user);

        return "redirect:/";
    }

    @RequestMapping(path = "/updateUser")
    public String updateUser(Model model, Optional<Integer> id) {
        if (id.isPresent()) {
            User user = userService.getUser(id.get());
            model.addAttribute("user", user);
        }else {
            model.addAttribute("user", new User());
        }
        return "updateUser";
    }

    @GetMapping(path = "/remove/{id}")
    public String deleteById(@PathVariable(value = "id") int id) {
        this.userService.deleteById(id);
        return "redirect:/";
    }
}