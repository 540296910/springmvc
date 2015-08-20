package com.maolei.springmvc.service;


import java.util.List;

import com.maolei.springmvc.pojo.Actor;
public interface ActorService {
	 int delete(int id);
	    int insert(Actor actor);
	    Actor get(int id);
	    List<Actor> list();
	    int update(Actor actor);
}
