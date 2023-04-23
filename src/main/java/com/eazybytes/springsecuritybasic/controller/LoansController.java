package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Customer;
import com.eazybytes.springsecuritybasic.model.Loans;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import com.eazybytes.springsecuritybasic.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanRepository loanRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        Customer customer = customerRepository.findByEmail(email).orElseThrow();
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
    }
}
