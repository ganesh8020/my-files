package com.banking.Online.Banking.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.Online.Banking.System.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}