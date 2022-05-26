package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.store.entity.Account;
import poly.store.service.AccountService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts2s")
public class AccountRestController2 {
	@Autowired
	AccountService accountService;
	
	@GetMapping("{username}")
	public Account getOne(@PathVariable("username")String username) {
		return accountService.findById(username);
	}
	@GetMapping()
	public List<Account> getAll() {
		return accountService.findAll();
	}
	
	@PostMapping()
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}
	@PutMapping("{username}")
	public Account update(@PathVariable("username")String username,@RequestBody Account account) {
		return accountService.update(account);
	}
	@DeleteMapping("{username}")
	public void delete(@PathVariable("username")String username) {
		accountService.delete(username);
	}
	
}
