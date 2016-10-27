package com.example.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.models.Quizzes;
import com.example.models.Role;
import com.example.models.Users;
import com.example.service.RoleService;
import com.example.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestComponent
@ContextConfiguration(classes = {TestDatabaseConfig.class})
public class UserRoleServiceTest {
  
    @Autowired
    UserService userService;
    
    @Autowired
    RoleService roleService;
    
    @Test
    public void getUserTest() {
      List<Users> users = userService.getById(12);
      for(Users user : users) {
        assertNotNull(user);
        assertEquals("pqr@practo.com", user.getEmail());
        assertEquals(1 , user.getScore());
        assertEquals(2, user.getRole());
        assertEquals(2, user.getQuizzes());
      }
    }
    
    @Test(expected = ObjectRetrievalFailureException.class)
    public void deleteUserTest() {
      userService.deleteById(13);
      List<Users> users = userService.getById(13);
      for(Users user : users) {
        assertNull(user);
      }
    }
    
    @Test
    public void getAllUserTest() {
      List<Users> users = userService.getAll();
      int size = users.size();
      Users newuser = new Users();
      Quizzes quiz = new Quizzes();
      quiz.setId(2);
      Role role = new Role();
      role.setId(2);
      newuser.setEmail("abc@practo.com");
      newuser.setScore(0);
      newuser.setRole(role);
      newuser.setQuizzes(quiz);
      userService.save(newuser);
      List<Users> updatedusers = userService.getAll();
      int newsize = updatedusers.size();
      assertEquals(size+1, newsize);
    }
    
    @Test
    public void getRoleByIdTest() {
      List<Role> roles = roleService.getById(3);
      for(Role role : roles) {
        assertEquals("user", role.getRoleName());
      }
    }
    
    
}
