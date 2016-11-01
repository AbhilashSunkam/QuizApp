package com.example.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Role;
import com.example.repository.RoleRepository;

/**
 * Role service implementation
 * 
 * @author abhilashsunkam
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleRepository roleRepository;

  @Override
  public List<Role> getById(Integer id) {
    return roleRepository.getById(id);
  }


}
