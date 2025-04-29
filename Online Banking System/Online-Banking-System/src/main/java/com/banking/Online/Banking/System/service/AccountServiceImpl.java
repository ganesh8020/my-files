package com.banking.Online.Banking.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.banking.Online.Banking.System.entity.Account;
import com.banking.Online.Banking.System.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public Account updateAccount(Long id, Account updatedAccount) {
        return accountRepository.findById(id).map(account -> {
            account.setAccountHolderName(updatedAccount.getAccountHolderName());
            account.setAccountType(updatedAccount.getAccountType());
            account.setBalance(updatedAccount.getBalance());
            return accountRepository.save(account);
        }).orElseGet(() -> {
            updatedAccount.setId(id);
            return accountRepository.save(updatedAccount);
        });
    }

	@Override
	 @GetMapping("/{id}/balance")
	 public double getBalance(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            return account.get().getBalance();
        } else {
            throw new RuntimeException("Account not found with ID: " + accountId);
        }
    }
}