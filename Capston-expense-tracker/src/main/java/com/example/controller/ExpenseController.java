package com.example.controller;
import com.example.dao.ExpenseService;
import com.example.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//http://localhost:8084/swagger-ui/index.html
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") Long id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        return expense.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getExpensesByUserId(@PathVariable("userId") Long userId) {
        return expenseService.getExpensesByUserId(userId);
    }

    @GetMapping("/user/{userId}/period")
    public List<Expense> getExpensesByUserIdAndDateRange(@PathVariable("userId") Long userId,
                                                         @RequestParam("startDate") String startDateStr,
                                                         @RequestParam("endDate") String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        return expenseService.getExpensesByUserIdAndDateRange(userId, startDate, endDate);
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense createdExpense = expenseService.createExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody Expense expense) {
        Expense updatedExpense = expenseService.updateExpense(id, expense);
        return (updatedExpense != null) ? ResponseEntity.ok(updatedExpense)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable("id") Long id) {
        if (expenseService.getExpenseById(id).isPresent()) {
            expenseService.deleteExpense(id);
            return ResponseEntity.ok("Expense with ID: " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense with ID: " + id + " not found");
        }
    }
}

//http://localhost:8084/swagger-ui/index.html
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
//import com.example.entity.Expense;
//
//
//@RestController
//public class ExpenseController {
//
//	
//	@Autowired
//	ExpenseDAO expDAO;
//	
//	@GetMapping("getExpenses")
//	public List<Expense> getExpenses() {
//		return expDAO.getExpenses();
//	}
//	
//	@GetMapping("getExpenseById/{expenseId}")
//	public Expense getExpenseById(@PathVariable("expenseId") long expenseId) {
//		return expDAO.getExpenseById(expenseId);
//	}
//	
//	
//	@PostMapping("addExpense")
//	public Expense addExpense(@RequestBody Expense exp) {
//		return expDAO.addExpense(exp);
//	}
//	
//	@PutMapping("updateExpense")
//	public Expense updateEvent(@RequestBody Expense exp) {
//		return expDAO.updateExpense(exp);
//	}
//	
//	@DeleteMapping("deleteExpenseById/{expenseId}")
//	public String deleteExpenseById(@PathVariable("expenseId") long expenseId) {
//		expDAO.deleteExpenseById(expenseId);
//		return "expense with expenseId: " + expenseId + ", Deleted Successfully";
//	}
//	
////	@GetMapping("getExpenseByName/{ExpenseName}")
////	public Expense getExpenseByName(@PathVariable("ExpenseName") String ExpenseName) {
////		return evtDAO.getExpenseByName(ExpenseName);
////	}
//	
//	
//}
