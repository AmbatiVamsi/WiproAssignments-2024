//package com.example.dao;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.example.entity.User;
//
//
//@Service
//public class UserDAO {
//
//	@Autowired
//	UserRepository usrRepo;
//
//	public List<User> Users() {
//		return usrRepo.findAll();
//		
//	}
//	
//	public User getUserById(long id) {
//		return usrRepo.findById((long) id).orElse(null);
//	}
//
//	public User getUserByName(String name) {
//		return usrRepo.findbyName(name);
//	}
//	
//	public User addUser(User usr) {
//		return usrRepo.save(usr);
//	}
//
//	public User updateUser(User usr) {
//		return usrRepo.save(usr);
//	}
//
//	public void deleteUserById(long id) {
//		usrRepo.deleteById((long) id);
//	}
//
////	public Participant patLogin(String emailId, String password) {
////		return patRepo.patLogin(emailId, password);
////	}
//
//	
//	
//}
//
//
//
//
