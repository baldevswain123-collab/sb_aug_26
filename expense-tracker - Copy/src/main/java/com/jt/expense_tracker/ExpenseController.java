package com.jt.expense_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
  private final JdbcTemplate jdbcTemplate;
  private final ExpenseRepository expenseRepository;
  private static final String EXPENSES_TABLE = "expenses";



  @GetMapping("/expenses")
  public List<Expense> getExpenses() {
    //String sql = "SELECT * FROM %s".formatted(EXPENSES_TABLE);
    //return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));

    // var savedExpenses = expenseRepository.findAll();
    // return savedExpenses;

    // return expenseRepository.findAll(); 

    return expenseService.getExpenses();


  }

  @GetMapping("/expenses/{id}")
  public Expense getExpenseById(@PathVariable int id) {
  //   var sql = "SELECT * FROM %s WHERE id=?".formatted(EXPENSES_TABLE);
  //   Expense expense = jdbcTemplate.queryForObject
  //                         (sql, new BeanPropertyRowMapper<>(Expense.class), id);
  //   return expense;

    //   Optional<Expense> optExp = expenseRepository.findById(id);

    //   // if(optExp.isPresent()){
    //   //   Expense expense = optExp.get();
    //   // }

    // //Expense expense = optExp.orElseThrow();
    // Expense expense = optExp.orElseThrow(() -> new RuntimeException("Unable to find Expense with id :- +id"));
    // return expense;

    // return expenseRepository.findById(id).orElseThrow(() ->
    //               new RuntimeException("Unable to find Expense with id :- "+id));

    return expenseService.getExpenseById(id);
   }

  @PostMapping("/expenses")
  @ResponseStatus (value = HttpStatus.CREATED)
  public Expense createExpense(@RequestBody Expense expense) {
    // var sql = "INSERT INTO %s (title, category, price, date) VALUES (?, ?, ?, ?)"
    //                                                     .formatted(EXPENSES_TABLE);
    // jdbcTemplate.update(sql, expense.getTitle(), expense.getCategory(), 
    //                                 expense.getPrice(), expense.getDate());
    // return expense;

  //  Expense savedExpense = expenseRepository.save(expense);
  //  return savedExpense;

      // return expenseRepository.save(expense);

      return expenseService.addExpense(expense);
  }

  @DeleteMapping("/expenses/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteExpense(@PathVariable int id) {
    // String sql = "DELETE FROM %s WHERE id =?".formatted(EXPENSES_TABLE);
    // jdbcTemplate.update(sql, id);

  //  Expense toBeDeletedExpense = getExpenseById(id);
  //  expenseRepository.delete(toBeDeletedExpense);

    // getExpenseById(id);
    // expenseRepository.deleteById(id);

    expenseService.deleteExpenseById(id);


  }

  @PutMapping("/expenses")
  @ResponseStatus (code = HttpStatus.ACCEPTED)
  public Expense updateExpense(@RequestBody Expense expense) {
    // var sql = "UPDATE %s SET title=?, category=?, price=?, date=? WHERE id =?".formatted(EXPENSES_TABLE);
    // jdbcTemplate.update(sql, expense.getTitle(), expense.getCategory(), expense.getPrice(), expense.getDate(), expense.getId());
    // Expense updatedExpense = getExpenseById(expense.getId());
    // return updatedExpense;

    // getExpenseById(expense.getId());
    // return expenseRepository.save(expense);

    return  expenseService.updateExpense(expense);
  }
}