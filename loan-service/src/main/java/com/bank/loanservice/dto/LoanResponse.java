package com.bank.loanservice.dto;

public class LoanResponse {

    private Long loanId;

    private String status;

    private String message;

    public LoanResponse() {
    }

    public LoanResponse(Long loanId,
                        String status,
                        String message) {

        this.loanId = loanId;
        this.status = status;
        this.message = message;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
