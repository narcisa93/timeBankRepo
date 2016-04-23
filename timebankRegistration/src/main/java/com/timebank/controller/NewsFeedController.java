package com.timebank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.timebank.model.Project;
import com.timebank.model.User;
import com.timebank.service.ProjectService;

@Controller
@RequestMapping ("/newsFeed")
public class NewsFeedController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping (method = RequestMethod.GET)
    public String displayPosts (ModelMap modelMap) {
        modelMap.addAttribute("projects", projectService.getProjects());
        return "newsFeed";
    }
}
