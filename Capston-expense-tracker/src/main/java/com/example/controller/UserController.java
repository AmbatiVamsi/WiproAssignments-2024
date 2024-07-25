package com.example.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserService;
import com.example.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
        User user = userService.getUserByName(name);
        return (user != null) ? ResponseEntity.ok(user)
                              : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        User user = userService.getUserByEmail(email);
        return (user != null) ? ResponseEntity.ok(user)
                              : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return (updatedUser != null) ? ResponseEntity.ok(updatedUser)
                                     : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.ok("User with ID: " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID: " + id + " not found");
        }
    }
}

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.dao.ExpenseDAO;
//import com.example.dao.UserDAO;
//import com.example.entity.User;
//
//@RestController
//public class UserController {
//
//	@Autowired
//	UserDAO usrDao;
//	
//	@Autowired
//	ExpenseDAO expDao;
//	
//	//https://localhost:8085/getParticipants
////	@GetMapping("getUsers")
////	public List<User> getUsers() {
////		return expDao.Users();
////	}
//	
//	@GetMapping("getUserById/{id}")
//	public User getUserById(@PathVariable("id") long id) {
//		return usrDao.getUserById(id);
//	}
//	
//	@GetMapping("getUserByName/{name}")
//	public User getUserByName(@PathVariable("name") String name) {
//		return usrDao.getUserByName(name);
//	}
//	
//	@PostMapping("addUser")
//	public User addUser(@RequestBody User usr) {
//		return usrDao.addUser(usr);
//	}
//
//	@PutMapping("updateUser")
//	public User updateUser(@RequestBody User usr) {
//		return usrDao.updateUser(usr);
//	}
//	
//	@DeleteMapping("deleteUserById/{id}")
//	public String deleteUserById(@PathVariable("id") long id) {
//		usrDao.deleteUserById(id);
//		return "Participant with userId: " + id + ", Deleted Successfully";
//	}
//	
////	@GetMapping("patLogin/{emailId}/{password}")
////	public Participant patLogin(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {
////		return patDao.patLogin(emailId, password);
////	}
//	
//}
//


