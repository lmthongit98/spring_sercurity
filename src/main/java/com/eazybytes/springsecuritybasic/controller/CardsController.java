package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.model.Cards;
import com.eazybytes.springsecuritybasic.model.Customer;
import com.eazybytes.springsecuritybasic.repository.CardsRepository;
import com.eazybytes.springsecuritybasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        Customer customer = customerRepository.findByEmail(email).orElseThrow();
        return cardsRepository.findByCustomerId(customer.getId());
    }

}