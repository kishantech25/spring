package com.kishan.JobApp.controller;

import com.kishan.JobApp.model.JobPost;
import com.kishan.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/","/home"})
    public String home(){
        System.out.println("Home Page");
      return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(@ModelAttribute JobPost jobPost){
        jobService.addjob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model){
       model.addAttribute("jobPosts",jobService.getAllJobs());
       return "viewalljob";
    }

}


