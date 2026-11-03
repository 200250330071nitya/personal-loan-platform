package com.bank.loanservice.service;

import com.bank.loanservice.client.CustomerClient;
import com.bank.loanservice.client.DocumentClient;
import com.bank.loanservice.client.NotificationClient;
import com.bank.loanservice.dto.LoanRequest;
import com.bank.loanservice.dto.LoanResponse;
import com.bank.loanservice.entity.LoanApplication;
import com.bank.loanservice.repository.LoanRepository;

import org.springframework.stereotype.Service;

@Service
public class LoanApplicationService {

    private final LoanRepository repository;

    private final CustomerClient customerClient;

    private final DocumentClient documentClient;

    private final NotificationClient notificationClient;

    public LoanApplicationService(
            LoanRepository repository,
            CustomerClient customerClient,
            DocumentClient documentClient,
            NotificationClient notificationClient) {

        this.repository = repository;
        this.customerClient = customerClient;
        this.documentClient = documentClient;
        this.notificationClient = notificationClient;
    }

    public LoanResponse applyLoan(
            LoanRequest request) {

        boolean customerValid =
                customerClient.verifyCustomer(
                        request.getCustomerId());

        if (!customerValid) {

            return new LoanResponse(
                    null,
                    "REJECTED",
                    "Customer Not Found");
        }

        boolean docsUploaded =
                documentClient.verifyDocuments(
                        request.getCustomerId());

        if (!docsUploaded) {

            return new LoanResponse(
                    null,
                    "REJECTED",
                    "Documents Missing");
        }

        LoanApplication loan =
                new LoanApplication();

        loan.setCustomerId(
                request.getCustomerId());

        loan.setAmount(
                request.getAmount());

        loan.setTenure(
                request.getTenure());

        if (request.getAmount() <= 500000) {

            loan.setStatus("APPROVED");
        } else {

            loan.setStatus("PENDING");
        }

        LoanApplication saved =
                repository.save(loan);

        notificationClient.sendNotification(
                request.getCustomerId(),
                loan.getStatus());

        return new LoanResponse(
                saved.getId(),
                saved.getStatus(),
                "Loan Application Submitted");
    }
}
