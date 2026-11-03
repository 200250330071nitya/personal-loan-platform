package com.bank.loanservice.controller;

import com.bank.loanservice.dto.LoanRequest;
import com.bank.loanservice.dto.LoanResponse;
import com.bank.loanservice.service.LoanApplicationService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanApplicationService service;

    public LoanController(
            LoanApplicationService service) {

        this.service = service;
    }

    @PostMapping("/apply")
    public LoanResponse applyLoan(
            @RequestBody LoanRequest request) {

        return service.applyLoan(request);
    }
}
