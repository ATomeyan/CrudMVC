package com.bdg.crudmvc.controller;

import com.bdg.crudmvc.model.User;
import com.bdg.crudmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userLists", userList);

        return "user_list";
    }

    @GetMapping(path = "/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);

        return "redirect:/";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editUser(Model model, @PathVariable("id") Optional<Integer> id){

        if (id.isPresent()){
            User user = userService.getUser(id.get());
            model.addAttribute("user", user);
        }
        else {
            model.addAttribute("user", new User());
        }

        return "updateUserList";
    }

    @RequestMapping(path = "/updateUser", method = {RequestMethod.PUT, RequestMethod.POST})
    public String updateUser(int id, User user, Model model) {
        User users = userService.updateUser(user, id);
        model.addAttribute("user", users);

        return "updateUserList";
    }

    @GetMapping(path = "/remove/{id}")
    public String deleteById(@PathVariable(value = "id") int id) {
        this.userService.deleteById(id);
        return "redirect:/";
    }
}