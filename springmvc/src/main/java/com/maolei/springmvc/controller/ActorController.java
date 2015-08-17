package com.maolei.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maolei.springmvc.pojo.Actor;
import com.maolei.springmvc.service.ActorService;

@Controller  
@RequestMapping("/actor")  
public class ActorController {  
    @Resource  
    private ActorService actorService;  
      
    @RequestMapping("/showActor")  
    public String toIndex(HttpServletRequest request,Model model){  
        int actorId = Integer.parseInt(request.getParameter("id"));  
        Actor user = this.actorService.getActorById(actorId);  
        System.out.println(user.getFirst_name());
        model.addAttribute("user", user);  
        return "actor";  
    }  
}  