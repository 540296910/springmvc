package com.maolei.springmvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maolei.springmvc.pojo.Actor;
import com.maolei.springmvc.service.ActorService;

@RestController
public class ActorController {  
    @Resource  
    private ActorService actorService;  
    /*
    @RequestMapping("/showActor")  
    public String toIndex(HttpServletRequest request,Model model){  
        int actorId = Integer.parseInt(request.getParameter("id"));  
        Actor user = this.actorService.getActorById(actorId);  
        System.out.println(user.getFirst_name());
        model.addAttribute("user", user);  
        return "actor";  
    }  */
    @RequestMapping(value = "/actor/{id}", method = RequestMethod.GET)
    public Actor get(@PathVariable int id, HttpServletRequest request,
    		            HttpServletResponse response){
         Actor actor = this.actorService.get(id);  
         return actor;
    }
    @RequestMapping(value = "/actor/list", method = RequestMethod.GET)
    public List<Actor> get(){
         List<Actor> actor = this.actorService.list();  
         return actor;
    }
}  