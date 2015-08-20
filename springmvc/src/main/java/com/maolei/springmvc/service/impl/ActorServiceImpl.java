package com.maolei.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.maolei.springmvc.dao.ActorDao;
import com.maolei.springmvc.pojo.Actor;
import com.maolei.springmvc.service.ActorService;
@Service("actorService")
public class ActorServiceImpl implements ActorService {
	@Resource
	private ActorDao actorDao;

	public Actor get(int id) {
		// TODO Auto-generated method stub
		return this.actorDao.get(id);
	}

	public List<Actor> list() {
		// TODO Auto-generated method stub
		return this.actorDao.list();
	}

	public int update(Actor actor) {
		// TODO Auto-generated method stub
		return this.actorDao.update(actor);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return this.actorDao.delete(id);
	}

	public int insert(Actor actor) {
		// TODO Auto-generated method stub
		return this.actorDao.insert(actor);
	}

	

}
