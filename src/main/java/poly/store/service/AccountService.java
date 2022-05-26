package poly.store.service;

import java.util.List;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import poly.store.entity.Account;

public interface AccountService {
	
	Account findById(String username);
	List<Account> getAdministrators();
	List<Account> findAll();
	Account create(Account account);
	Account update(Account account);
	void delete(String username);
	Long getTotalAccount();
	List<Object[]> top10Customer();



}
