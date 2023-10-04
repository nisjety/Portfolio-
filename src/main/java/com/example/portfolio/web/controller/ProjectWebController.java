package com.example.portfolio.web.controller;

import com.example.portfolio.api.model.Project;
import com.example.portfolio.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectWebController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public String showProjects(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "projects"; // This corresponds to the Thymeleaf template name
    }
}
