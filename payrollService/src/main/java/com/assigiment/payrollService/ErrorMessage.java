package com.assigiment.payrollService;

import java.util.Date;

public class ErrorMessage {

    private String message;
    private Date date;

    public ErrorMessage(Date date, String message) {
        this.message = message;
        this.date = date;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
