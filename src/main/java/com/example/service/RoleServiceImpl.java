package com.example.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Role;
import com.example.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Role> getAll() {
		return roleRepository.getAll();
	}

	@Override
	public List<Role> getById(Integer id) {
		return roleRepository.getById(id);
	}

	@Override
	public void deleteById(Integer id) {
		roleRepository.deleteById(id);
		return;
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Role findById(Integer id) {
		return roleRepository.findById(id);
	}

	@Override
	public void update(Role role) {
		roleRepository.update(role);
		return;
	}

}
