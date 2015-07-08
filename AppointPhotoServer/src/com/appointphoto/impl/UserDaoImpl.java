package com.appointphoto.impl;

import java.util.List;

import javax.persistence.criteria.From;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.appointphoto.dao.UserDao;
import com.appointphoto.model.User;



public class UserDaoImpl implements UserDao {
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	



	@Override
	public boolean checkUserExistsWithName(String username) {
		List<User>users=(List<User>)hibernateTemplate.find("from User u where u.name='"+ username +"'");
		if (users!=null && users.size()!=0) {
			return true;
		}
		return false;
	}

	@Override
	public void add(User u) {
		hibernateTemplate.save(u);
		
	}

	@Override
	public User getUserWithName(String name) {
		List<User>users=(List<User>)hibernateTemplate.find("from User u where u.name='"+ name +"'");
		if (users!=null && users.size()!=0) {
			return users.get(0);
		}	
		else {
			return null;
		}
	}
}
