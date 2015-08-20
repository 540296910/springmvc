package com.maolei.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.maolei.springmvc.pojo.Actor;
@Repository
public interface ActorDao {
    int delete(int id);
    int insert(Actor actor);
    Actor get(int id);
    List<Actor> list();
    int update(Actor actor);
}