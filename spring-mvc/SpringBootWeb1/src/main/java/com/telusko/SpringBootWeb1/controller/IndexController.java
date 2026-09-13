package com.telusko.SpringBootWeb1.controller;

import com.telusko.SpringBootWeb1.model.Alien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

      @GetMapping("/")
      public String home(){
          System.out.println("index method called");
          return "index";
      }

      @PostMapping("/add")
      public String add(@ModelAttribute("alien") Alien Alien){
          System.out.println("In Alien");
//          alien.setAid(aid);
//          alien.setAname(aname);
//          mv.addObject("alien",alien);
//          System.out.println("added Object");
//          mv.setViewName("result");
//          System.out.println("set View Name");
          return "result";
      }

}
