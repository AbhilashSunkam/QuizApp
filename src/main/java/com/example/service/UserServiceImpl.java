package com.example.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Users;
import com.example.repository.UsersRepository;

/**
 * User service implementation
 * 
 * @author abhilashsunkam
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Users> getAll() {
		return usersRepository.getAll();
	}

	@Override
	public List<Users> getById(Integer id) {
		return usersRepository.getById(id);
	}

	@Override
	public void deleteById(Integer id) {
		usersRepository.deleteById(id);
		return;
	}

	@Override
	public void save(Users user) {
		usersRepository.save(user);
	}

	@Override
	public Users findById(Integer id) {
		return usersRepository.findById(id);
	}

	@Override
	public void update(Users user) {
		usersRepository.update(user);
		return;
	}

}
