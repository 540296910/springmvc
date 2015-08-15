package com.maolei.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.maolei.springmvc.mapping.Actor;
@Repository
public interface ActorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Actor record);

    int insertSelective(Actor record);

    Actor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Actor record);

    int updateByPrimaryKey(Actor record);
}