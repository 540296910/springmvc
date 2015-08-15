package com.maolei.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.maolei.springmvc.dao.ActorDao;
import com.maolei.springmvc.mapping.Actor;
import com.maolei.springmvc.service.ActorService;
@Service("actorService")
public class ActorServiceImpl implements ActorService {
	@Resource
	private ActorDao actorDao;

	public Actor getActorById(int actorId) {
		// TODO Auto-generated method stub
		return this.actorDao.selectByPrimaryKey(actorId);
	}
	

}
