package com.timebank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.timebank.model.Project;
import com.timebank.model.User;
import com.timebank.service.ProjectService;

@Controller
@RequestMapping ("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String viewCreateProject (ModelMap modelMap) {
        modelMap.addAttribute("project", new Project());
        System.out.print("ajunge aici");
        return "createProject";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String createProject (@Valid Project project, BindingResult result, ModelMap modelMap) {
         
		projectService.addProject(project);
		System.out.print(project.toString());
        return "result";
    }

}
