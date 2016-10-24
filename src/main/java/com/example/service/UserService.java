package com.example.service;

import java.util.List;

import com.example.models.Users;

public interface UserService {

	public List<Users> getAll();

	public List<Users> getById(Integer id);

	public void deleteById(Integer id);

	public void save(Users users);

	public Users findById(Integer id);

	public void update(Users user);
}
