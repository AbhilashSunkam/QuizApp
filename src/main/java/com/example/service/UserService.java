package com.example.service;

import java.util.List;

import com.example.models.Users;

/**
 * User service interface
 * 
 * @author abhilashsunkam
 *
 */
public interface UserService {

  public List<Users> getAll();

  public List<Users> getById(Integer id);

  public void deleteById(Integer id);

  public void save(Users users);
}
