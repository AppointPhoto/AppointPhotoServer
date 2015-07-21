package com.appointphoto.impl;

import java.util.List;

import javax.persistence.criteria.From;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.appointphoto.dao.CheckUserDao;
import com.appointphoto.dao.UserDao;
import com.appointphoto.dao.UserPicturesDao;
import com.appointphoto.model.CheckUser;
import com.appointphoto.model.User;
import com.appointphoto.model.UserPictures;



public class CheckUserDaoImpl implements CheckUserDao {
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void add(CheckUser checkUser) {
		hibernateTemplate.save(checkUser);
	}	

	
}
