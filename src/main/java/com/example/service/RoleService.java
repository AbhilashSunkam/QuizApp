package com.example.service;

import java.util.List;

import com.example.models.Role;

/**
 * Role service interface
 * 
 * @author abhilashsunkam
 *
 */
public interface RoleService {

  public List<Role> getAll();

  public List<Role> getById(Integer id);

  public void deleteById(Integer id);

  public void save(Role role);

  public Role findById(Integer id);

  public void update(Role role);
}
