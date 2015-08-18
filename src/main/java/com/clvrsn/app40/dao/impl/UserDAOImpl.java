package com.clvrsn.app40.dao.impl;

import org.springframework.stereotype.Repository;

import com.clvrsn.app40.dao.UserDAO;
import com.clvrsn.app40.entities.User;

@Repository
public class UserDAOImpl implements UserDAO{

	public User findById(Integer id){
		
		User u = new User();
		u.setName("William Shakespeare");
		u.setId(0);
		u.setEmail("william.shakespeare@bol.com.br");
		
		return u;
	}
}
