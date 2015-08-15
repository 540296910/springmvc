package com.maolei.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maolei.springmvc.mapping.Actor;
import com.maolei.springmvc.service.ActorService;

@Controller  
@RequestMapping("/user")  
public class ActorController {  
    @Resource  
    private ActorService actorService;  
      
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        Actor user = this.actorService.getActorById(userId);  
        System.out.println(user.getFirst_name());
        model.addAttribute("user", user);  
        return "actor";  
    }  
}  