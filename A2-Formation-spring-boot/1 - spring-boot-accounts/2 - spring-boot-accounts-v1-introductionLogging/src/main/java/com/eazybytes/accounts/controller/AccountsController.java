/**
 * 
 */
package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.service.AccountsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.repository.AccountsRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Eazy Bytes
 *
 */

@RestController
public class AccountsController {

	@Autowired
	private AccountsService accountsService;

	@Operation(summary = "get account by id")
	@GetMapping("/myAccount/{id}")
	public Accounts getAccountDetails(@PathVariable("id") Long id) {
		return accountsService.getAccountsById(id);
	}

	@Operation(summary = "get all accounts")
	@GetMapping("/accounts")
	public List<Accounts> getAllAccounts() {
		return accountsService.getAllAccounts();
	}

	@Operation(summary = "create a new account")
	@PostMapping("/newAccount")
	public String newAccount(@RequestBody Accounts accounts) {
		return accountsService.save(accounts);
	}

	@Operation(summary = "update an account by id")
	@PutMapping("/update/{id}")
	public String updateAccount(@PathVariable("id") Long id, @RequestBody Accounts updateAccounts) {
		return accountsService.updateAccount(id, updateAccounts);
	}

	

	@PostMapping("/newAccounts")
	public List<String> newAccounts(@RequestBody List<Accounts> accountsList) {
		return accountsService.saveAll(accountsList);
	}


	
	@DeleteMapping("/deleteAccount/{id}")
	public String deleteAccount(@PathVariable("id") Long id) {
		return accountsService.deleteAccount(id);
	}

	@DeleteMapping("/deleteAccounts")
	public String deleteAccounts(@RequestBody List<Long> accountIds) {
		return accountsService.deleteAllByIds(accountIds);
	}

	@Operation(summary = "SVP Utilisez cette méthode pour supprimer tous !")
	@DeleteMapping("/deleteAllAccounts")
	public String deleteAllAccounts() {
		return accountsService.deleteAllAccounts();
	}

}
