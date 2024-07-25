package com.example.dao;
import com.example.entity.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Optional<Expense> getExpenseById(Long id);
    List<Expense> getExpensesByUserId(Long userId);
    List<Expense> getExpensesByUserIdAndDateRange(Long userId, LocalDate startDate, LocalDate endDate);
    Expense createExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
    void deleteExpense(Long id);
}

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import com.example.entity.Expense;
//import com.example.entity.User;
//
//@Service
//public class ExpenseDAO {
//
//	@Autowired
//	ExpenseRepository expRepo;
//
//	public List<Expense> getExpenses() {
//		return expRepo.findAll();
//	}
//
//	public Expense getExpenseById(long expenseId) {
//		return expRepo.findById((int) expenseId).orElse(null);
//	}
//
////	public expenseId getexpenseIdByName(String name) {
////		return expRepo.findByName(name);
////	}
//		
//	public Expense addExpense(Expense exp) {
//		return expRepo.save(exp);
//	}
//
//	public Expense updateExpense(Expense exp) {
//		return expRepo.save(exp);
//	}
//
//	public void deleteExpenseById(int evtId) {
//		expRepo.deleteById(evtId);
//	}
//
//	public List<Expense> Users() {
//		// TODO Auto-generated method stub
//		return expRepo.findAll();
//	}
//
//	public void deleteExpenseById(long expenseId) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
//
