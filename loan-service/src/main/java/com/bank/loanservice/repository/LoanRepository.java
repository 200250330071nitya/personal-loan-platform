package com.bank.loanservice.repository;

import com.bank.loanservice.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository
        extends JpaRepository<LoanApplication, Long> {

}
