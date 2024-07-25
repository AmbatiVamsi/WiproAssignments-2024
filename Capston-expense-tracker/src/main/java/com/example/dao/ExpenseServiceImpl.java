package com.example.dao;

import com.example.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserUserId(userId);
    }

    @Override
    public List<Expense> getExpensesByUserIdAndDateRange(Long userId, LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByUserUserIdAndDateBetween(userId, startDate, endDate);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        if (expenseRepository.existsById(id)) {
            expense.setExpenseId(id);
            return expenseRepository.save(expense);
        }
        return null;
    }

    @Override
    public void deleteExpense(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        }
    }
}
