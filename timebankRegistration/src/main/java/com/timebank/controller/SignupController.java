package com.timebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.timebank.model.User;
import com.timebank.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class SignupController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String viewSignup (ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String afterSignup (@Valid User user, BindingResult result, ModelMap modelMap) {
        if(result.hasErrors()) {
            return "signup";
        }
        List<User> users = userService.getUsers();
        for(User singleUser : users) {
            if(singleUser.getEmail().equals(user.getEmail())) {
                modelMap.addAttribute("resultMessage", "There is already a registered user with the same email id!");
                return "result";
            }
        }

        userService.addUser(user);
        modelMap.addAttribute("resultMessage", "Congratulations " + user.getFullName() + "! You are Successfully Signed up.");
        return "result";
    }

}
