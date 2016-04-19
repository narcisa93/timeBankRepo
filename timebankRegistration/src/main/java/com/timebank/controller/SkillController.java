package com.timebank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.timebank.model.Project;
import com.timebank.model.Skill;
import com.timebank.service.ProjectService;
import com.timebank.service.SkillService;

@Controller
@RequestMapping("/skills")
public class SkillController {
	@Autowired
	SkillService skillService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String viewAddSkills (ModelMap modelMap) {
        modelMap.addAttribute("skills", new Skill());
        System.out.print("ajunge aici");
        return "skills";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String addSkills (@Valid Skill skill, BindingResult result, ModelMap modelMap) {
         skillService.addSkills(skill);
		System.out.print(skill.toString());
        return "profile";
    }
}
