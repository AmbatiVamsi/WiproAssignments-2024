package com.example.dao;
import com.example.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserUserId(Long userId);
    List<Expense> findByUserUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import com.example.entity.Expense;
//
//
//@Repository
//public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
//
////	@Query("from Expense where name = :ename")
////	Expense findByName(@Param("ename") String name);
//
//}