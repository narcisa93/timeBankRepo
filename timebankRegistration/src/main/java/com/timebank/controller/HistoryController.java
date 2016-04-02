package com.timebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.timebank.model.User;
import com.timebank.service.UserService;


@Controller
@RequestMapping ("/history")
public class HistoryController {

    @Autowired
    UserService userService;

    @RequestMapping (method = RequestMethod.GET)
    public String history (ModelMap modelMap, @RequestParam int id) {
        User user = userService.getUser(id);
        modelMap.addAttribute("histories", user.getHistory());
        return "history";
    }

}
