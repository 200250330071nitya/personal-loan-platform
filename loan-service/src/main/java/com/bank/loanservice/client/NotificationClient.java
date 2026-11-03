package com.bank.loanservice.client;

import org.springframework.stereotype.Component;

@Component
public class NotificationClient {

    public void sendNotification(Long customerId,
                                 String status) {

        System.out.println(
                "Sending notification to customer "
                + customerId +
                " Status : " + status
        );
    }
}
