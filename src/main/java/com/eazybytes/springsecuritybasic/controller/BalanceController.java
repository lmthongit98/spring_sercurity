package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.AccountTransactions;
import com.eazybytes.springsecuritybasic.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        return accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(id);
    }
}
