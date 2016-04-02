package com.timebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.timebank.service.UserService;


@Controller
@RequestMapping ("/users")
public class UsersController {

    @Autowired
    UserService userService;

    @RequestMapping (method = RequestMethod.GET)
    public String viewUsers (ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getUsers());
        return "users";
    }

    @RequestMapping (method = RequestMethod.POST)
    public String deleteUsers (@RequestParam int id, ModelMap modelMap) {
        System.out.println(id);
        userService.deleteUser(id);
        modelMap.addAttribute("users", userService.getUsers());
        return "users";
    }

}
