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

  public List<Role> getById(Integer id);

}
