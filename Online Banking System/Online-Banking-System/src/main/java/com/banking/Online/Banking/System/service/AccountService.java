package com.banking.Online.Banking.System.service;

import java.util.List;
import java.util.Optional;
import com.banking.Online.Banking.System.entity.Account;

public interface AccountService {
	
	
    public List<Account> getAllAccounts() ;
       

    public Optional<Account> getAccountById(Long id);

    public Account createAccount(Account account);

    public void deleteAccount(Long id);

    public Account updateAccount(Long id, Account updatedAccount);
    
    public double getBalance(Long id);
       
}
